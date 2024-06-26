package core.dailysummary.mail.application

import core.dailysummary.mail.domain.MailSender
import core.dailysummary.mail.domain.VerificationMailSpec
import org.springframework.stereotype.Service

@Service
class MailService(
    private val mailSender: MailSender,
) {
    fun sendVerificationCode(verificationMailSpec: VerificationMailSpec) {
        mailSender.send(verificationMailSpec)
    }
}