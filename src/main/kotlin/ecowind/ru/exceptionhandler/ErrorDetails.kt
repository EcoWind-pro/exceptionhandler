package ecowind.ru.exceptionhandler

import java.time.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class ErrorDetails(
    val timestamp: String = LocalDateTime.now().toString(),
    val message: String,
    val exceptionClass: String,
    val exceptionProducer: String
)
