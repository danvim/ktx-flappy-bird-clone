package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool

class ScrollComponent: Component, Pool.Poolable {
    override fun reset() = Unit
}