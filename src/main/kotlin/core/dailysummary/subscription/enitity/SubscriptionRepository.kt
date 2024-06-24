package core.dailysummary.subscription.enitity

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface SubscriptionRepository : JpaRepository<Subscription, UUID> {
}