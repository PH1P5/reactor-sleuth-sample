package de.idealo.homepage.dataprovider.config.logging

import brave.http.HttpTracing

import org.springframework.beans.factory.ObjectProvider

import org.springframework.boot.web.embedded.netty.NettyServerCustomizer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.netty.http.brave.ReactorNettyHttpTracing
import reactor.netty.http.server.HttpServer

@Configuration(proxyBeanMethods = true)
class NettyLogTracingConfiguration {
    @Bean
    fun traceNettyServerCustomizer(tracing: ObjectProvider<HttpTracing>): NettyServerCustomizer {
        return NettyServerCustomizer { server: HttpServer ->
            ReactorNettyHttpTracing.create(
                tracing.getObject()
            ).decorateHttpServer(server)
        }
    }
}
