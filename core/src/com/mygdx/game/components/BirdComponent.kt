package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Pool
import com.mygdx.game.Constants

class BirdComponent: Component, Pool.Poolable {
    val velocity = Vector2(0f, Constants.BIRD_INITIAL_VELOCITY_Y)
    var oldRot = Float.NaN

    override fun reset() {
        velocity.set(0f, Constants.BIRD_INITIAL_VELOCITY_Y)
        oldRot = Float.NaN
    }
}