package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.Pool

data class TransformComponent(
        val pos: Vector3 = Vector3(0f, 0f, 0f),
        val size: Vector2 = Vector2(0f, 0f),
        val origin: Vector2 = Vector2(0f, 0f),
        var rot: Float = 0f,
        val scale: Vector2 = Vector2(1f, 1f)
): Component, Pool.Poolable {
    val box: Rectangle
        get() = Rectangle(pos.x, pos.y, size.x, size.y)

    override fun reset() {
        pos.set(0f, 0f, 0f)
        size.set(0f, 0f)
        origin.set(0f, 0f)
        rot = 0f
        scale.set(1f, 1f)
    }
}