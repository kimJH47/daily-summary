package core.dailysummary.subscription.dto

data class SubscriptionRequest(
    val email: String?,
    val time: Int?,
    val news: List<NewsSubscriptionDto>?
)

