package core.dailysummary.api

import com.fasterxml.jackson.databind.ObjectMapper
import core.dailysummary.api.spec.ApiTestSpec
import core.dailysummary.api.support.STRING
import core.dailysummary.api.support.andDocument
import core.dailysummary.api.support.docPost
import core.dailysummary.api.support.type
import core.dailysummary.auth.application.AuthService
import core.dailysummary.auth.dto.VerificationRequest
import io.mockk.every
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import java.util.*

class AuthControllerTest(
    private val mockMvc: MockMvc,
    private val authService: AuthService,
    private val objectMapper: ObjectMapper
) : ApiTestSpec(
    {
        describe("POST /api/v1/auth/email-verification") {
            context("유효한 요청이 오면") {
                it("HTTP 상태코드 200을 반환한다.") {
                    every { authService.verifyEmail(any()) } returns Unit
                    val request = VerificationRequest(UUID.randomUUID().toString())
                    mockMvc.docPost("/api/v1/auth/email-verification") {
                        contentType = MediaType.APPLICATION_JSON
                        content = objectMapper.writeValueAsString(request)
                    }.andExpect {
                        status { isOk() }
                    }.andDocument("이메일_인증_API") {
                        requestFields("code" type STRING means "이메일 인증 코드")
                    }
                }
            }
        }
    }
)