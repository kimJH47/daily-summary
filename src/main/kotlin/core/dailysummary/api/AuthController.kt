package core.dailysummary.api

import core.dailysummary.auth.application.AuthService
import core.dailysummary.auth.dto.VerificationRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/email-verification")
    fun emailVerification(@RequestBody request: VerificationRequest) {
        authService.verifyEmail(request.code)
    }
}