package com.davidb.langchain4j.kotlin.test.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties
@Configuration
class AppConfiguration {

    val api = API()

    class API {
        var test = "http://acme.com"
    }


}
