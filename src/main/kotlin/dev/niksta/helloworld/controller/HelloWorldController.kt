package dev.niksta.helloworld.controller

import dev.niksta.helloworld.model.Greeting
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import java.util.concurrent.atomic.AtomicLong

@Controller
class HelloWorldController {

    private val log = LoggerFactory.getLogger(javaClass)

    private val template = "Hello, %s!"
    private val counter = AtomicLong()

    @GetMapping("/hello-world")
    @ResponseBody
    fun sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") name: String): Greeting {
        log.info("/hello-world called with name: $name")
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }
}