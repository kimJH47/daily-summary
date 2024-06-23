package core.dailysummary.subscription.application

import core.dailysummary.subscription.dto.NewsSubscriptionDto
import org.springframework.stereotype.Service

@Service
class SubscriptionService {
    fun subscribe(email: String?, news: List<NewsSubscriptionDto>?, time: Int?) {
    }
}