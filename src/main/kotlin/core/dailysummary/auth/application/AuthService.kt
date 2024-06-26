package core.dailysummary.auth.application

import core.dailysummary.user.entity.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthService(
    private val userRepository: UserRepository,
) {
    @Transactional
    fun verifyEmail(code: String) {
        val user = userRepository.findById(UUID.fromString(code))
            .orElseThrow { IllegalArgumentException("User with id $code doesn't exist") }
        user.verify()
    }
}