package be.robinvdb.snake

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input

typealias Action = String
typealias Key = Int

/**
 * Handles mapping specific keys to actions.
 * Multiple keys can have multiple actions and vice versa.
 */
class InputMap {
    private val keyToAction = mutableMapOf<Key, MutableList<Action>>()
    private val actionStatus = mutableMapOf<Action, Boolean>()

    // Important to be placed behind the declarations above (otherwise we get nulls)
    init {
        mapKeyToAction(Input.Keys.W, "up")
        mapKeyToAction(Input.Keys.A, "left")
        mapKeyToAction(Input.Keys.S, "down")
        mapKeyToAction(Input.Keys.D, "right")
    }

    /**
     * Map a specific action to a key
     */
    private fun mapKeyToAction(key: Key, action: Action) {
        val list = keyToAction.getOrDefault(key, mutableListOf())
        list.add(action)
        keyToAction[key] = list
    }

    /**
     * Poll every key and update the action
     */
    fun update() {
        keyToAction.forEach { (key, actionList) ->
            val pressed = Gdx.input.isKeyPressed(key)
            actionList.forEach { action ->
                actionStatus[action] = pressed
            }
        }
    }

    /**
     * Check if a specific action is active. If the action is unkown, we return false
     */
    fun pressed(action: Action): Boolean {
        return actionStatus.getOrDefault(action, false)
    }
}