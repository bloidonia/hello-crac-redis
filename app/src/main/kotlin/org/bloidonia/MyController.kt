package org.bloidonia

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller
class MyController(private val service: RedisService) {

    @Get("/{key}", produces = [MediaType.TEXT_PLAIN])
    fun get(key: String) = service.get(key)

    @Post("/{key}", consumes = [MediaType.TEXT_PLAIN], produces = [MediaType.TEXT_PLAIN])
    fun set(key: String, @Body value: String) = service.put(key, value)
}