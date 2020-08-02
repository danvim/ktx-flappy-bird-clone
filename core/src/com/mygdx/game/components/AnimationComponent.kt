package com.mygdx.game.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.utils.Pool

data class AnimationComponent(
        val animations: Array<Animation<TextureRegion>>
): Component, Pool.Poolable {
    override fun reset() {
        animations.clear()
    }
}