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

for x in range(0, 5):
	for y in range(0, 5):
		world.placeBlock(BlockType.WOOD, x, y)
