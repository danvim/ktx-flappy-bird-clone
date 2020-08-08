package com.mygdx.game.entities

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.graphics.g2d.NinePatch
import com.badlogic.gdx.math.MathUtils
import com.mygdx.game.Assets
import com.mygdx.game.Constants
import com.mygdx.game.components.DrawableComponent
import com.mygdx.game.components.GapComponent
import com.mygdx.game.components.ScrollComponent
import com.mygdx.game.components.TransformComponent
import ktx.ashley.entity
import ktx.ashley.with

object Pipe {
    private fun new(engine: PooledEngine, height: Float, isFlipped: Boolean) {
        val textureRegion = Assets.Sprites.PIPE.texture

        engine.entity {
            with<ScrollComponent>()
            with<TransformComponent> {
                pos.set(Constants.WORLD_WIDTH, if (isFlipped) Constants.WORLD_HEIGHT - height else 0f, 0f)
                size.set(textureRegion.originalWidth.toFloat(), height)
                origin.set(textureRegion.originalWidth.toFloat() / 2, height / 2)
                scale.set(1f, if (isFlipped) -1f else 1f)
            }
            with<DrawableComponent> {
                set(NinePatch(textureRegion, 0, 0, Constants.PIPE_EDGE_TOP, 0))
            }
        }
    }

    fun newRandomPair(engine: PooledEngine) {
        val halvedGap = Constants.PIPE_GAP.toInt() / 2
        newPair(engine, MathUtils.random(
                Constants.PIPE_SCREEN_MARGIN + Constants.GROUND_HEIGHT.toInt() + halvedGap,
                Constants.WORLD_HEIGHT.toInt() - Constants.PIPE_SCREEN_MARGIN - halvedGap
        ).toFloat(), Constants.PIPE_GAP)
    }

    private fun newPair(engine: PooledEngine, height: Float, gap: Float) {
        val halvedGap = gap / 2
        val bottomY = height - halvedGap
        val topY = Constants.WORLD_HEIGHT - height - halvedGap
        new(engine, bottomY, false)
        new(engine, topY, true)

        // new score entity
        engine.entity {
            with<GapComponent>()
            with<ScrollComponent>()
            with<DrawableComponent>()
            with<TransformComponent> {
                pos.set(Constants.WORLD_WIDTH, bottomY, 0f)
                size.set(Assets.Sprites.PIPE.texture.originalWidth.toFloat(), gap)
            }
        }
    }
}