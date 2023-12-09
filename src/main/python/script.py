def moveRight():
	player.position.x += player.speed

def moveUp():
	player.position.y -= player.speed

def moveLeft():
	player.position.x -= player.speed

def moveDown():
	player.position.y += player.speed

setAction(KeyCode.D, moveRight)
setAction(KeyCode.W, moveUp)
setAction(KeyCode.A, moveLeft)
setAction(KeyCode.S, moveDown)

x = 4
print(x)
