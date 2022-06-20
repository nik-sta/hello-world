package io.botscripter.helloworld.model

import java.io.Serializable

data class Greeting(
    val id: Long = 0,
    val content: String? = null
) : Serializable