package com.davidb.langchain4j.kotlin.test.config

import dev.langchain4j.memory.chat.ChatMemoryProvider
import dev.langchain4j.memory.chat.MessageWindowChatMemory
import dev.langchain4j.model.chat.ChatLanguageModel
import dev.langchain4j.model.vertexai.VertexAiGeminiChatModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan
class Langchain4JServiceConfig {

    @Autowired
    private lateinit var appConfiguration: AppConfiguration


    @Bean
    fun vertexAIModel(): ChatLanguageModel {
        return VertexAiGeminiChatModel
            .builder()
            .modelName("gemini-1.5-flash-002")
            .project("my-test-project")
            .location("europe-west2")
            .build()
    }

    @Bean
    fun chatMemoryProvider(): ChatMemoryProvider = ChatMemoryProvider { memoryId ->
        MessageWindowChatMemory.builder()
            .id(memoryId)
            .maxMessages(30)
            .build()
    }

}