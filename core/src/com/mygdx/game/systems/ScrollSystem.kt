package com.mygdx.game.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.mygdx.game.Constants
import com.mygdx.game.GameScreen
import com.mygdx.game.components.ScrollComponent
import com.mygdx.game.components.TransformComponent
import ktx.ashley.allOf
import ktx.ashley.mapperFor

class ScrollSystem(gameScreen: GameScreen) : IteratingSystem(allOf(ScrollComponent::class, TransformComponent::class).get()) {
    private val transformMap = mapperFor<TransformComponent>()
    private val world by lazy { gameScreen.world }

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        // Move pipes leftwards
        if (entity != null && !world.isDead) {
            val transform = transformMap[entity]!!
            transform.pos.x -= deltaTime * Constants.PIPE_MOVE_SPEED

            if (transform.box.x + transform.box.width < 0f) {
                // off screen, remove entity
                engine.removeEntity(entity)
            }
        }
    }
}