package core.dailysummary.subscription.application

import core.dailysummary.subscription.dto.NewsSubscriptionDto
import core.dailysummary.subscription.dto.event.SubscriptionEvent
import core.dailysummary.subscription.enitity.Subscription
import core.dailysummary.subscription.enitity.SubscriptionRepository
import core.dailysummary.user.entity.User
import core.dailysummary.user.entity.UserRepository
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SubscriptionService(
    private val subscriptionRepository: SubscriptionRepository,
    private val userRepository: UserRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    @Transactional
    fun subscribe(email: String, news: List<NewsSubscriptionDto>, time: Int) {
        val user = userRepository.save(User(email, LocalDateTime.now(), time))
        news.forEach {
            subscriptionRepository.save(Subscription(it.name, it.categories, user))
        }
        applicationEventPublisher.publishEvent(SubscriptionEvent(email, user.id, LocalDateTime.now()))
    }
}