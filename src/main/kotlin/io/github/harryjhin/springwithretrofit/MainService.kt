package io.github.harryjhin.springwithretrofit

import org.springframework.stereotype.Service

@Service
class MainService(
    private val mainClient: MainClient,
) {

    fun checkHealth(): Boolean {
        return mainClient.health()
            .execute()
            .isSuccessful
    }
}