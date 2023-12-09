package com.example.codecraft.idea;

import com.example.codecraft.Settings;
import com.example.codecraft.game.Codecraft;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IDEAController {
    @FXML private TextArea codeTextArea;

    public void runGame() throws IOException {
        saveContent();

        Thread gameThread = new Thread(new Codecraft());
        gameThread.start();
    }

    public void saveContent() throws IOException {
        Files.createDirectories(Paths.get(Settings.pythonSourceDirectory));

        File pythonScript = new File(Settings.fullPythonSourcePath);

        if (pythonScript.isFile() || pythonScript.createNewFile()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pythonScript));
            writer.write(codeTextArea.getText());
            writer.close();
        } else {
            throw new IOException("Can't write to a file!");
        }
    }
}