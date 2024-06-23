package core.dailysummary.api

import core.dailysummary.subscription.application.SubscriptionService
import core.dailysummary.subscription.dto.SubscriptionRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1/subscriptions")
class SubscriptionController(
    private val subscriptionService: SubscriptionService
) {

    @PostMapping
    fun subscription(@RequestBody request: SubscriptionRequest): ResponseEntity<String> {
        subscriptionService.subscribe(request.email, request.news, request.time)
        return ResponseEntity.ok()
            .build()
    }
}