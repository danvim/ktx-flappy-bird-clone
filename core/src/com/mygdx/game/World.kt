package com.mygdx.game

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.mygdx.game.entities.Bird
import com.mygdx.game.systems.BirdSystem
import ktx.ashley.getSystem
import ktx.graphics.color
import ktx.graphics.use
import kotlin.math.max
import kotlin.properties.Delegates

class World(val game: Game, private val engine: PooledEngine) {
    var maxScore = 0
    var score by Delegates.observable(0) { _, _, new -> maxScore = max(new, maxScore) }
    var isDead = false

    private val shape by lazy { ShapeRenderer() }

    fun reset() {
        engine.removeAllEntities()

        score = 0
        isDead = false

        Bird.new(engine)
    }

    fun update(delta: Float) {
        if (!isDead) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
                engine.getSystem<BirdSystem>().flap()
            }
        } else {
            if (Gdx.input.isKeyJustPressed(Input.Keys.R) || Gdx.input.justTouched()) {
                // reset game
                reset()
            }
        }

        // Render
        shape.projectionMatrix = game.viewport.camera.combined

        shape.use(ShapeRenderer.ShapeType.Filled) {
            // Draw sky
            it.color = color(0.64f, 0.94f, 0.97f, 1f)
            it.rect(0f, 0f, Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT)
        }
    }
}