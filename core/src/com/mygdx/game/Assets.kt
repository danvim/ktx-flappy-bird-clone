package com.mygdx.game

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import ktx.assets.getValue
import ktx.assets.load

object Assets {
    val assetManager by lazy { AssetManager() }
    val ATLAS_NAME = "images/altas.pack.atlas"
    val atlas by assetManager.load<TextureAtlas>(ATLAS_NAME)
    object Sprites {
        val BIRD = "bird"
        val PIPE = "pipe"
        val PIPE_EDGE_TOP = 14
    }
    val pipeTexture by lazy { atlas.findRegion(Sprites.PIPE) }
    val birdTexture by lazy { atlas.findRegion(Sprites.BIRD) }
}