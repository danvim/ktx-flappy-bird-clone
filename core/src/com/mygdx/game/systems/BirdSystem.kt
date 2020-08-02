package com.mygdx.game.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.math.MathUtils
import com.mygdx.game.Constants
import com.mygdx.game.GameScreen
import com.mygdx.game.components.BirdComponent
import com.mygdx.game.components.GapComponent
import com.mygdx.game.components.TransformComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor
import kotlin.math.atan

class BirdSystem(gameScreen: GameScreen): IteratingSystem(allOf(BirdComponent::class, TransformComponent::class).get()) {
    private val transformMap = mapperFor<TransformComponent>()
    private val birdMap = mapperFor<BirdComponent>()
    private val world by lazy { gameScreen.world }

    override fun processEntity(birdEntity: Entity?, deltaTime: Float) {
        if (birdEntity != null) {
            val bird = birdMap[birdEntity]
            val birdTransform = transformMap[birdEntity]!!

            // Process rotation
            val velocity = bird.velocity
            val oldRot = bird.oldRot
            velocity.y -= Constants.GRAVITY * deltaTime
            birdTransform.pos.y += velocity.y

            if (!oldRot.isNaN()) {
                val targetRot = atan(0.5f * velocity.y) * MathUtils.radiansToDegrees
                birdTransform.rot = (targetRot - oldRot) * 0.7f + oldRot
            }

            bird.oldRot = birdTransform.rot

            // Check for death
            val gaps = engine.getEntitiesFor(allOf(GapComponent::class, TransformComponent::class).get())
            for (gapEntity in gaps) {
                val gapTransform = transformMap[gapEntity]
                // assuming pipe width is always greater than bird width
                if (birdTransform.pos.x + birdTransform.size.x > gapTransform.pos.x && birdTransform.pos.x < gapTransform.pos.x + gapTransform.size.x) {
                    // then bird must fit inside gap space
                    if (birdTransform.pos.y + birdTransform.size.y > gapTransform.pos.y + gapTransform.size.y || birdTransform.pos.y < gapTransform.pos.y) {
                        die()
                        break
                    }
                }
            }
        }
    }

    fun flap() {
        engine.getEntitiesFor(allOf(BirdComponent::class, TransformComponent::class).get()).forEach {
            birdMap[it].velocity.y = Constants.BIRD_FLAP_VELOCITY_Y
        }
    }

    private fun die() {
        world.isDead = true
    }
}