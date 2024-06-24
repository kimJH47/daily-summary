package core.dailysummary.user.entity

import core.dailysummary.common.entity.ULIDPrimaryKeyEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(
    email: String,
    createdDate: LocalDateTime,
    sendTime: Int
) : ULIDPrimaryKeyEntity() {
    @Column(unique = true)
    var email: String = email
        protected set

    @Column
    var createdDate: LocalDateTime = createdDate
        protected set

    @Column
    var sendTime: Int = sendTime
        protected set

    @Column
    var verified : Boolean = false
        protected set
}