package io.botscripter.helloworld

import io.botscripter.helloworld.model.Greeting
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = [HelloWorldApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
internal class HelloWorldApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun shouldReturn200WhenSendingRequestToControllerWithoutRequestParam() {
        val result = restTemplate.getForEntity("/hello-world", Greeting::class.java);

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)
        assertEquals("Hello, Stranger!", result.body?.content)
    }

    @Test
    fun shouldReturn200WhenSendingRequestToControllerWithRequestParam() {
        val result = restTemplate.getForEntity("/hello-world?name=botscripter", Greeting::class.java);

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result?.statusCode)
        assertEquals("Hello, botscripter!", result.body?.content)
    }
}