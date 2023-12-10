speed = 1

def moveRight():
	player.position.x += speed

def moveUp():
	player.position.y -= speed

def moveLeft():
	player.position.x -= speed

def moveDown():
	player.position.y += speed

setAction(KeyCode.D, moveRight)
setAction(KeyCode.W, moveUp)
setAction(KeyCode.A, moveLeft)
setAction(KeyCode.S, moveDown)
