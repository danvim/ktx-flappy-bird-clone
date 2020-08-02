package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool
import com.mygdx.game.utils.Drawable
import com.mygdx.game.utils.Drawable.*

data class DrawableComponent(
        var drawable: Drawable = None
): Component, Pool.Poolable {
    override fun reset() {
        drawable = None
    }

    fun <T> set(t: T) {
        drawable = Companion.of(t)
    }
}