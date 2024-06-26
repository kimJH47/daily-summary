package core.dailysummary.mail.domain

import org.springframework.mail.SimpleMailMessage
import java.util.*

class VerificationMailSpec(
    private val email: String,
    private val verifiedCode: UUID
) : MailSpec {
    override fun toSimpleMessage(): SimpleMailMessage {
        return SimpleMailMessage().apply {
            setTo(email)
            from = "daily-summary"
            text = verifiedCode.toString()
            subject = "인증을 완료해 주세요"
        }
    }
}