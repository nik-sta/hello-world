package dev.niksta.helloworld

import org.apache.hc.client5.http.classic.HttpClient
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactoryBuilder
import org.springframework.boot.ssl.SslBundle
import org.springframework.boot.ssl.SslBundles
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Component
import javax.net.ssl.SSLContext

private const val BUNDLE_NAME = "client"

@Component
class SslTestRestTemplate(
    val testRestTemplate: TestRestTemplate,
    sslBundles: SslBundles
) {
    init {
        val sslBundle: SslBundle = sslBundles.getBundle(BUNDLE_NAME)
        val sslContext: SSLContext = sslBundle.createSslContext()

        val httpClient: HttpClient = HttpClients.custom().setConnectionManager(
            PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(
                    SSLConnectionSocketFactoryBuilder.create()
                        .setSslContext(sslContext).build()
                )
                .build()
        ).build()

        testRestTemplate.restTemplate.requestFactory = HttpComponentsClientHttpRequestFactory(httpClient)
    }
}