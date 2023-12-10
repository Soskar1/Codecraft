speed = 1

def moveRight():
	worldBorders = world.getWorldBorders()
	if player.position.x + speed < worldBorders.x:
		player.position.x += speed

def moveUp():
	if player.position.y - speed > 0:
		player.position.y -= speed

def moveLeft():
	if player.position.x - speed > 0:
		player.position.x -= speed

def moveDown():
	worldBorders = world.getWorldBorders()
	if player.position.y + speed < worldBorders.y:
		player.position.y += speed

def destroyBlock():
	mousePosition = Mouse.getWorldPosition()
	world.destroyBlock(mousePosition)

def placeRock():
	mousePosition = Mouse.getWorldPosition()
	world.placeBlock(BlockType.ROCK, mousePosition)

setAction(KeyCode.D, moveRight)
setAction(KeyCode.W, moveUp)
setAction(KeyCode.A, moveLeft)
setAction(KeyCode.S, moveDown)
setAction(KeyCode.LEFT_MOUSE_CLICK, placeRock)
setAction(KeyCode.RIGHT_MOUSE_CLICK, destroyBlock)

for x in range(0, 5):
	for y in range(0, 5):
		world.placeBlock(BlockType.WOOD, x, y)
