package core.dailysummary.mail.domain

interface MailSender {
    fun send(mailSpec : MailSpec)
}