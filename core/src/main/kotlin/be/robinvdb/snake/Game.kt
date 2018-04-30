package be.robinvdb.snake

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Game : ApplicationAdapter() {
    private val snake = Snake(Vector(0f, 0f), Direction.UP, 50f)
    private val inputMap = InputMap()

    private lateinit var batch: SpriteBatch
    private lateinit var img: Texture

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
    }

    override fun render() {
        val dt = Gdx.graphics.deltaTime
        update(dt)

        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(img, snake.position.x, snake.position.y)
        batch.end()
    }

    private fun update(dt: Float) {
        // Poll for updates in the input
        inputMap.update()
        snake.direction = when {
            inputMap.pressed("up") -> Direction.UP
            inputMap.pressed("left") -> Direction.LEFT
            inputMap.pressed("down") -> Direction.DOWN
            inputMap.pressed("right") -> Direction.RIGHT
            else -> snake.direction
        }

        snake.update(dt)
    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }


}

