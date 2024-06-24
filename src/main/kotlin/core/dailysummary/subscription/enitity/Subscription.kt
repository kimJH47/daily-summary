package core.dailysummary.subscription.enitity

import core.dailysummary.common.entity.ULIDPrimaryKeyEntity
import core.dailysummary.user.entity.User
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne

@Entity
class Subscription(
    news: String,
    categories: String,
    user: User
) : ULIDPrimaryKeyEntity() {
    var news = news
        protected set
    var categories = categories
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    var user = user
        protected set
}