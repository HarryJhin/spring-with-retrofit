package io.github.harryjhin.springwithretrofit

import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class SpringWithRetrofitApplicationTests(
    @Autowired private val mockMvc: MockMvc,
) {

    @MockBean
    private lateinit var mainService: MainService

    @Test
    fun healthCheck() {
        mockMvc.perform(get("/health"))
            .andExpect(status().isOk)
    }

    @Test
    fun index() {
        `when`(mainService.checkHealth()).thenReturn(true)
        mockMvc.perform(get("/"))
            .andExpect(status().isOk)
    }
}
