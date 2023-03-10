package org.bloidonia

import io.lettuce.core.api.StatefulRedisConnection
import io.micronaut.runtime.context.scope.Refreshable
import jakarta.inject.Singleton

interface RedisService {

    fun get(key: String): String
    fun put(key: String, value: String): String
}

@Singleton
@Refreshable
class DefaultRedisService(private val redis: StatefulRedisConnection<String, String>): RedisService {

    override fun get(key: String) = redis.sync().get(key)
    override fun put(key: String, value: String) = redis.sync().set(key, value)
}