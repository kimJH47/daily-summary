package core.dailysummary.api

import com.fasterxml.jackson.databind.ObjectMapper
import core.dailysummary.api.spec.ApiTestSpec
import core.dailysummary.api.support.*
import core.dailysummary.subscription.application.SubscriptionService
import core.dailysummary.subscription.dto.NewsSubscriptionDto
import core.dailysummary.subscription.dto.SubscriptionRequest
import io.mockk.every
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc

class SubscriptionControllerTest(
    private val mockMvc: MockMvc,
    private val subscriptionService: SubscriptionService,
    private val objectMapper: ObjectMapper

) : ApiTestSpec({
    describe("POST /api/v1/subscriptions") {
        context("유효한 요청을 받으면") {
            it("HTTP 상태코드 200을 반환한다.")
            {
                every { subscriptionService.subscribe(any(),any(),any()) } returns Unit

                val request = SubscriptionRequest("kmr2644@gmail.com", 10, listOf(
                    NewsSubscriptionDto("동아일보","스포츠,경제"),
                    NewsSubscriptionDto("국민일보","정치"),
                ))

                mockMvc.docPost("/api/v1/subscriptions") {
                    contentType = MediaType.APPLICATION_JSON
                    content = objectMapper.writeValueAsString(request)
                }.andExpect {
                    status { isOk() }
                }.andDocument("구독_요청_API") {
                    requestFields(
                        "email" type STRING means "구독요청 이메일",
                        "time" type NUMBER means "뉴스발송 시간",
                        "news" type ARRAY means "구독신청 데이터",
                        "news[0].name" type STRING means "언론사 이름",
                        "news[0].categories" type STRING means ", 로 구분된 카테고리 목록"
                    )
                }
            }
        }
    }
})
