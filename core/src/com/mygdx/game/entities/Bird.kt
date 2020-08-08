package com.mygdx.game.entities

import com.badlogic.ashley.core.PooledEngine
import com.mygdx.game.Assets
import com.mygdx.game.Constants
import com.mygdx.game.components.BirdComponent
import com.mygdx.game.components.DrawableComponent
import com.mygdx.game.components.TransformComponent
import ktx.ashley.entity
import ktx.ashley.with

object Bird {
    fun new(engine: PooledEngine) {
        val textureRegion = Assets.Sprites.BIRD.texture

        engine.entity {
            with<BirdComponent>()
            with<TransformComponent> {
                pos.set(Constants.BIRD_X, (Constants.WORLD_HEIGHT - textureRegion.originalHeight) / 2, -2f)
                size.set(textureRegion.originalWidth.toFloat(), textureRegion.originalHeight.toFloat())
                origin.set(textureRegion.originalWidth.toFloat() / 2, textureRegion.originalHeight.toFloat() / 2)
            }
            with<DrawableComponent> {
                set(textureRegion)
            }
        }
    }
}