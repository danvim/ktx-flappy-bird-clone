package com.mygdx.game

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import ktx.assets.getValue
import ktx.assets.load

object Assets {
    val assetManager by lazy { AssetManager() }
    private val atlas by assetManager.load<TextureAtlas>("images/atlas.pack.atlas")

    enum class Sprites(textureName: String) {
        BIRD("bird"),
        PIPE("pipe"),
        GROUND("ground");

        val texture: TextureAtlas.AtlasRegion by lazy { atlas.findRegion(textureName) }
    }
}