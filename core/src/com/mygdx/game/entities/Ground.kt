package com.mygdx.game.entities

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.graphics.g2d.NinePatch
import com.mygdx.game.Assets
import com.mygdx.game.Constants
import com.mygdx.game.components.DrawableComponent
import com.mygdx.game.components.ScrollComponent
import com.mygdx.game.components.TransformComponent
import ktx.ashley.entity
import ktx.ashley.with

object Ground {
    /**
     * Create enough ground entities in the world
     */
    fun init(engine: PooledEngine) {
        for (i in 0 until Constants.WORLD_GROUND_COUNT) {
            engine.entity {
                with<TransformComponent> {
                    pos.set(i * Constants.GROUND_WIDTH, 0f, -2f)
                    // +0.1f to make seamless
                    size.set(Constants.GROUND_WIDTH + 0.1f, Constants.GROUND_HEIGHT)
                }
                with<ScrollComponent> {
                    willCycle = true
                    cycleWidth = Constants.GROUND_CYCLE_WIDTH
                }
                with<DrawableComponent> {
                    set(NinePatch(Assets.Sprites.GROUND.texture, Constants.GROUND_WIDTH.toInt() - 1, 0, Constants.GROUND_EDGE_TOP, 0))
                }
            }
        }
    }
}