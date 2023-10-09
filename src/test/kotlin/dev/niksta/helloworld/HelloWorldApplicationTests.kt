package dev.niksta.helloworld

import dev.niksta.helloworld.model.Greeting
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus


@SpringBootTest(
    classes = [HelloWorldApplication::class, SslTestRestTemplate::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class HelloWorldApplicationTests {

    @Autowired
    lateinit var sslRestTemplateWrapper: SslTestRestTemplate

    @Test
    fun shouldReturn200WhenSendingRequestToControllerWithoutRequestParam() {
        val result = sslRestTemplateWrapper.testRestTemplate.getForEntity("/hello-world", Greeting::class.java);

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
        assertEquals("Hello, Stranger!", result.body!!.content)
    }

    @Test
    fun shouldReturn200WhenSendingRequestToControllerWithRequestParam() {
        val result = sslRestTemplateWrapper.testRestTemplate.getForEntity("/hello-world?name=Nikola", Greeting::class.java);

        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
        assertEquals("Hello, Nikola!", result.body!!.content)
    }
}