package com.mygdx.game.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.mygdx.game.Assets
import com.mygdx.game.Constants
import com.mygdx.game.GameScreen
import com.mygdx.game.components.GapComponent
import com.mygdx.game.components.TransformComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor

class ScoreSystem(gameScreen: GameScreen): IteratingSystem(allOf(GapComponent::class, TransformComponent::class).get()) {
    private val transformMap = mapperFor<TransformComponent>()
    private val gapMap = mapperFor<GapComponent>()
    private val world by lazy { gameScreen.world }

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        if (entity != null) {
            val transform = transformMap[entity]!!
            val gap = gapMap[entity]!!
            if (transform.pos.x + Assets.Sprites.PIPE.texture.originalWidth / 2 <= Constants.BIRD_X + Assets.Sprites.PIPE.texture.originalWidth / 2) {
                // gain score
                gap.tallyScore(world)
            }
        }
    }
}