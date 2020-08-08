package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool

data class ScrollComponent(
        var willCycle: Boolean = false,
        var cycleWidth: Float = 0f
) : Component, Pool.Poolable {
    override fun reset() {
        willCycle = false
        cycleWidth = 0f
    }
}