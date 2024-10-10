package io.github.harryjhin.springwithretrofit

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController(
    private val mainService: MainService,
) {
    @GetMapping
    fun index(): ResponseEntity<String> {
        val isHealth = mainService.checkHealth()

        return if (isHealth) {
            ResponseEntity.ok().body("ok")
        } else {
            ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("error")
        }
    }

    @GetMapping("/health")
    fun health(): ResponseEntity<Void> {
        return ResponseEntity.ok().build()
    }
}