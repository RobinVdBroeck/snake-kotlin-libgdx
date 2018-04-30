package be.robinvdb.snake.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import be.robinvdb.snake.Game

fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.vSyncEnabled = false
    LwjglApplication(Game(), config)
}