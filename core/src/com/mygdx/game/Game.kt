package com.mygdx.game

import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ScalingViewport
import ktx.app.KtxGame
import ktx.app.KtxScreen

class Game : KtxGame<KtxScreen>() {
    val viewport by lazy { ScalingViewport(Scaling.fit, Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT) }
    val batch by lazy { SpriteBatch() }
    val font by lazy { BitmapFont() }

    override fun create() {
        addScreen(MainMenuScreen(this))
        setScreen<MainMenuScreen>()
        Assets.assetManager.finishLoading()
        super.create()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render() {
        viewport.apply()
        batch.projectionMatrix = viewport.camera.combined
        super.render()
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
        super.dispose()
    }
}