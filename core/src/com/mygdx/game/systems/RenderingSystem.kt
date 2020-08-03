package com.mygdx.game.systems

import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.SortedIteratingSystem
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.mygdx.game.Game
import com.mygdx.game.components.DrawableComponent
import com.mygdx.game.components.TransformComponent
import com.mygdx.game.utils.Drawable.NinePatch
import com.mygdx.game.utils.Drawable.TextureRegion
import ktx.ashley.allOf
import ktx.ashley.mapperFor
import ktx.graphics.use
import kotlin.math.sign

class RenderingSystem(
        private val game: Game
) : SortedIteratingSystem(allOf(
        TransformComponent::class,
        DrawableComponent::class
).get(), comparator) {
    private val batch = game.batch
    private val shape by lazy { ShapeRenderer() }

    override fun update(deltaTime: Float) {
        batch.use {
            super.update(deltaTime)
        }
    }

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        // Render
        val drawableComponent = drawableMap[entity]
        val drawable = drawableComponent.drawable
        val transform = transformMap[entity]
        val (pos, size, origin, rot, scale) = transform

        when (drawable) {
            is NinePatch -> drawable.ninePatch.draw(batch, pos.x, pos.y, origin.x, origin.y, size.x, size.y, scale.x, scale.y, rot)
            is TextureRegion -> batch.draw(drawable.textureRegion, pos.x, pos.y, origin.x, origin.y, size.x, size.y, scale.x, scale.y, rot)
        }

        // Debug
//        batch.end()
//        drawBox(transform.box, drawableComponent.debugColor)
//        batch.begin()
    }

    @Suppress("unused")
    private fun drawBox(rectangle: Rectangle, color: Color) {
        shape.projectionMatrix = game.viewport.camera.combined
        shape.use(ShapeRenderer.ShapeType.Line) {
            it.color = color
            it.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
        }
    }

    companion object {
        private val drawableMap = mapperFor<DrawableComponent>()
        private val transformMap = mapperFor<TransformComponent>()
        private val comparator = Comparator<Entity> { a, b ->
            sign(transformMap[b]!!.pos.z - transformMap[a]!!.pos.z).toInt()
        }
    }
}