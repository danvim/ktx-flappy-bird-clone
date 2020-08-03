package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.utils.Pool
import com.mygdx.game.utils.Drawable
import com.mygdx.game.utils.Drawable.Companion
import com.mygdx.game.utils.Drawable.None

data class DrawableComponent(
        var drawable: Drawable = None,
        var debugColor: Color = Color.RED
): Component, Pool.Poolable {
    override fun reset() {
        drawable = None
        debugColor = Color.RED
    }

    fun <T> set(t: T) {
        drawable = Companion.of(t)
    }
}