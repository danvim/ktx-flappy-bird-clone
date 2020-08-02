package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool
import com.mygdx.game.World

class GapComponent: Component, Pool.Poolable {
    private var isValid = true

    override fun reset() {
        isValid = true
    }

    fun tallyScore(world: World) {
        if (isValid) {
            isValid = false
            world.score++
        }
    }
}