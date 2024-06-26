package core.dailysummary.mail.config

import core.dailysummary.mail.domain.MailSender
import core.dailysummary.mail.infra.SpringMailSender
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*

@Configuration
class MailSenderConfig {
    @Value("\${spring.mail.host}")
    private val host: String? = null

    @Value("\${spring.mail.port}")
    private val port = 0

    @Value("\${spring.mail.username}")
    private val username: String? = null

    @Value("\${spring.mail.password}")
    private val password: String? = null

    @Value("\${spring.mail.properties.mail.smtp.starttls.enable}")
    private val starttlsEnable = true

    @Value("\${spring.mail.properties.mail.smtp.starttls.required}")
    private val starttlsRequired = true

    @Value("\${spring.mail.properties.mail.smtp.connectiontimeout}")
    private val connectionTimeout = 0

    @Value("\${spring.mail.properties.mail.smtp.timeout}")
    private val timeout = 0

    @Bean
    fun mailSender(): MailSender {
        return SpringMailSender(javaMailSender())
    }

    @Bean
    fun javaMailSender(): JavaMailSender {
        val javaMailSenderImpl = JavaMailSenderImpl()
        javaMailSenderImpl.host = host
        javaMailSenderImpl.port = port
        javaMailSenderImpl.username = username
        javaMailSenderImpl.password = password
        javaMailSenderImpl.javaMailProperties = properties()
        return javaMailSenderImpl
    }

    fun properties(): Properties {
        return Properties().apply {
            put("mail.smtp.starttls.enable", starttlsEnable)
            put("mail.smtp.starttls.required", starttlsRequired)
            put("mail.smtp.connectiontimeout", connectionTimeout)
            put("mail.smtp.timeout", timeout)
        }
    }
}