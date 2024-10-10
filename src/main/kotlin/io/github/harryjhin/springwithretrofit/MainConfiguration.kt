package io.github.harryjhin.springwithretrofit

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class MainConfiguration(
    private val objectMapper: ObjectMapper,
) {

    @Bean
    fun mainClient(): MainClient {
        return Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()
            .create(MainClient::class.java)
    }
}