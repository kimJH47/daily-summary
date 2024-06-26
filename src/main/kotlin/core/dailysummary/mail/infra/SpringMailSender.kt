package core.dailysummary.mail.infra

import core.dailysummary.mail.domain.MailSender
import core.dailysummary.mail.domain.MailSpec
import org.springframework.mail.javamail.JavaMailSender

class SpringMailSender(
    private val javaMailSender: JavaMailSender,
) : MailSender {

    override fun send(mailSpec: MailSpec) {
        javaMailSender.send(mailSpec.toSimpleMessage())
    }
}