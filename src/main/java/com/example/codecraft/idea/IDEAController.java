package com.example.codecraft.idea;

import com.example.codecraft.Settings;
import com.example.codecraft.game.Codecraft;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class IDEAController implements Initializable {
    @FXML private TextArea codeTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void runGame() throws IOException {
        saveContent();

        Thread gameThread = new Thread(new Codecraft());
        gameThread.start();
    }

    private void loadContent() throws IOException {
        Files.createDirectories(Paths.get(Settings.pythonSourceDirectory));
        File pythonScript = new File(Settings.fullPythonSourcePath);

        if (pythonScript.isFile()) {
            BufferedReader reader = new BufferedReader(new FileReader(pythonScript));

            String line;
            String newLine = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null)
                codeTextArea.appendText(line + newLine);

            reader.close();
        } else {
            pythonScript.createNewFile();
        }
    }

    private void saveContent() throws IOException {
        File pythonScript = new File(Settings.fullPythonSourcePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(pythonScript));
        writer.write(codeTextArea.getText());
        writer.close();
    }
}