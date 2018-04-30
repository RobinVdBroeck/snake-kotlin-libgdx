package be.robinvdb.snake

enum class Direction(val value: Vector<Float>) {
    UP(Vector<Float>(0f,1f)),
    RIGHT(Vector<Float>(1f, 0f)),
    DOWN(Vector<Float>(0f, -1f)),
    LEFT(Vector<Float>(-1f, 0f))
}