package be.robinvdb.snake

class Snake(val position: Vector<Float>, var direction: Direction, var speed: Float) {
    private val velocity: Vector<Float>
        get() = Vector(direction.value.x * speed, direction.value.y * speed)

    /**
     * Update the snake based on a delta time
     * @param dt Time since last update
     */
    fun update(dt: Float) {
        position.x += velocity.x * dt
        position.y += velocity.y * dt
    }
}