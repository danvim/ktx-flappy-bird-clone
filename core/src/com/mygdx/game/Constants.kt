package com.mygdx.game

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx

object Constants {
    const val WORLD_WIDTH = 120f
    val WORLD_HEIGHT by lazy {
        if (Gdx.app.type == Application.ApplicationType.Android) {
            WORLD_WIDTH / Gdx.graphics.width * Gdx.graphics.height
        } else 240f
    }

    // Physics
    const val GRAVITY = 9.81f
    const val BIRD_INITIAL_VELOCITY_Y = 2f
    const val BIRD_FLAP_VELOCITY_Y = 3.25f
    const val BIRD_X = 5f

    // Texture Regions
    const val PIPE_EDGE_TOP = 14
    const val GROUND_EDGE_TOP = 10
    const val GROUND_WIDTH = 8f

    // Ground
    val GROUND_HEIGHT = WORLD_HEIGHT / 4
    const val WORLD_GROUND_COUNT = WORLD_WIDTH.toInt() / GROUND_WIDTH.toInt() + 2
    const val GROUND_CYCLE_WIDTH = WORLD_GROUND_COUNT * GROUND_WIDTH
    val BIRD_DEATH_HEIGHT = GROUND_HEIGHT

    // Layouts
    const val PIPE_GAP = 50f
    const val PIPE_SCREEN_MARGIN = 25
    const val PIPE_SPAWN_INTERVAL = 2f
    const val PIPE_MOVE_SPEED = 50f
}