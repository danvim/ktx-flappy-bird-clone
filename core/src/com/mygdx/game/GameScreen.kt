package com.mygdx.game

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.mygdx.game.systems.*
import ktx.app.KtxScreen
import ktx.graphics.use

class GameScreen(val game: Game) : KtxScreen {
    private val gameScreen = this
    private val engine = PooledEngine().apply {
        addSystem(BirdSystem(gameScreen))
        addSystem(PipeSpawnSystem())
        addSystem(ScrollSystem(gameScreen))
        addSystem(ScoreSystem(gameScreen))
        addSystem(RenderingSystem(game))
    }
    val world = World(game, engine)

    override fun show() {
        world.reset()
    }

    override fun render(delta: Float) {
        world.update(delta)
        update(delta)
        drawUI()
    }

    private fun update(delta: Float) = engine.update(delta)

    private fun drawUI() {
        val glyphLayout = GlyphLayout(game.font, "${world.score}")
        game.batch.use {
            game.font.draw(game.batch, glyphLayout, (Constants.WORLD_WIDTH - glyphLayout.width) / 2, Constants.WORLD_HEIGHT - 5f)
        }
    }
}