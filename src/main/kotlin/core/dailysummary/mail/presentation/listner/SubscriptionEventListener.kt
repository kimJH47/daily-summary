package core.dailysummary.mail.presentation.listner

import core.dailysummary.mail.application.MailService
import core.dailysummary.mail.domain.VerificationMailSpec
import core.dailysummary.subscription.dto.event.SubscriptionEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class SubscriptionEventListener(
    private val mailService: MailService
) {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async("taskExecutor")
    fun sendVerificationCode(subscriptionEvent: SubscriptionEvent) {
        mailService.sendVerificationCode(VerificationMailSpec(subscriptionEvent.email, subscriptionEvent.uuid))
    }
}