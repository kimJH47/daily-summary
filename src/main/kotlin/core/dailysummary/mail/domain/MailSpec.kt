package core.dailysummary.mail.domain

import org.springframework.mail.SimpleMailMessage

interface MailSpec {
    fun toSimpleMessage(): SimpleMailMessage
}