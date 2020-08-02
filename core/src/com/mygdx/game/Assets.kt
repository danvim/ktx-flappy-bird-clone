package com.mygdx.game

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.TextureAtlas

object Assets {
    val assetManager by lazy { AssetManager().apply {
        load(ATLAS_NAME, TextureAtlas::class.java)
    } }
    val atlas by lazy { assetManager.get<TextureAtlas>(ATLAS_NAME) }
    val ATLAS_NAME = "images/altas.pack.atlas"
    object Sprites {
        val BIRD = "bird"
        val PIPE = "pipe"
        val PIPE_EDGE_TOP = 14
    }
    val pipeTexture by lazy { atlas.findRegion(Sprites.PIPE) }
    val birdTexture by lazy { atlas.findRegion(Sprites.BIRD) }
}