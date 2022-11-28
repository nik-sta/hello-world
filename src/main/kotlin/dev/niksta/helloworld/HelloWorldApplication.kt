package dev.niksta.helloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class HelloWorldApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<HelloWorldApplication>(*args)
        }
    }
}