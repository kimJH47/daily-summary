package core.dailysummary.subscription.dto.event

import java.time.LocalDateTime
import java.util.*

data class SubscriptionEvent(
    val email : String,
    val uuid : UUID,
    val createdAt: LocalDateTime,
)