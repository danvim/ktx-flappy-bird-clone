package com.mygdx.game

import com.badlogic.gdx.Gdx
import ktx.app.KtxScreen
import ktx.graphics.center
import ktx.graphics.use

class MainMenuScreen(val game: Game): KtxScreen {
    private val batch = game.batch
    private val font = game.font

    override fun show() {
        game.viewport.camera.center()
    }

    override fun render(delta: Float) {
        batch.use {
            font.draw(batch, "Flappy", 0f, Constants.WORLD_HEIGHT / 2 + 30f)
            font.draw(batch, "Tap anywhere to begin!", 0f, Constants.WORLD_HEIGHT / 2)
        }

        if (Gdx.input.isTouched) {
            game.addScreen(GameScreen(game))
            game.setScreen<GameScreen>()
            game.removeScreen<MainMenuScreen>()
            dispose()
        }
    }
}