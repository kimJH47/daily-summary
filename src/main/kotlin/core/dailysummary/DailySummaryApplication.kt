package core.dailysummary

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DailySummaryApplication

fun main(args: Array<String>) {
    runApplication<DailySummaryApplication>(*args)
}
