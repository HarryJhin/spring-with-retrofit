package io.github.harryjhin.springwithretrofit

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class MainConfiguration {

    @Bean
    fun mainClient(
        objectMapper: ObjectMapper,
        @Value("\${server.port}") port: Int,
    ): MainClient = Retrofit.Builder()
        .baseUrl("http://localhost:$port")
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .build()
        .create(MainClient::class.java)
}
