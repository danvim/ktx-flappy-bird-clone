package com.mygdx.game

object Constants {
    const val WORLD_WIDTH = 120f
    const val WORLD_HEIGHT = 200f

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
    const val GROUND_HEIGHT = WORLD_HEIGHT / 4
    const val WORLD_GROUND_COUNT = WORLD_WIDTH.toInt() / GROUND_WIDTH.toInt() + 2
    const val GROUND_CYCLE_WIDTH = WORLD_GROUND_COUNT * GROUND_WIDTH

    // Layouts
    const val PIPE_GAP = 50f
    const val PIPE_SCREEN_MARGIN = 25
    const val PIPE_SPAWN_INTERVAL = 2f
    const val PIPE_MOVE_SPEED = 50f
}