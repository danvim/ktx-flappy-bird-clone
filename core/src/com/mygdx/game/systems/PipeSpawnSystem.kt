package com.mygdx.game.systems

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.ashley.systems.IntervalSystem
import com.mygdx.game.Constants
import com.mygdx.game.entities.Pipe

class PipeSpawnSystem: IntervalSystem(Constants.PIPE_SPAWN_INTERVAL) {
    override fun updateInterval() {
        Pipe.newRandomPair(engine as PooledEngine)
    }
}