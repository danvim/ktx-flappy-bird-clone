package com.mygdx.game.utils

import com.badlogic.gdx.graphics.g2d.NinePatch as GDXNinePatch
import com.badlogic.gdx.graphics.g2d.TextureRegion as GDXTextureRegion

sealed class Drawable {
    data class NinePatch(val ninePatch: GDXNinePatch): Drawable()
    data class TextureRegion(val textureRegion: GDXTextureRegion): Drawable()
    object None: Drawable()

    companion object {
        fun <T> of(t: T): Drawable {
            return when (t) {
                is GDXNinePatch -> NinePatch(t)
                is GDXTextureRegion -> TextureRegion(t)
                else -> None
            }
        }
    }
}