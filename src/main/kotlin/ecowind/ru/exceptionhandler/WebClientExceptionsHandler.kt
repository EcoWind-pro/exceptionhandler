package ecowind.ru.exceptionhandler

import ecowind.ru.exceptionhandler.excepions.ActionException
import ecowind.ru.utils.messages.ActionMessages
import kotlin.reflect.KClass
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.client.ClientResponse
import reactor.core.publisher.Mono

object WebClientExceptionsHandler {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass.name)

    fun <T : Any> exchangeCatchingErrors(response: ClientResponse, bodyClass: KClass<T>? = null): Mono<Any> {
        val uri = response.request().uri
        val method = response.request().method

        return when {
            response.statusCode().isError -> response.bodyToMono(ErrorDetails::class.java).flatMap { errorDetails ->
                Mono.error(
                    ActionException(
                        message = String.format(
                            ActionMessages.ACTION_NOT_COMPLETED_SF.message,
                            method,
                            uri,
                            errorDetails.message
                        ),
                        status = HttpStatus.valueOf(response.statusCode().value()),
                        errorDetails = errorDetails
                    )
                )
            }

            else -> {
                log.info(String.format(ActionMessages.ACTION_COMPLETED_SF.message, method, uri))

                if (bodyClass == null) Mono.just(response)
                else response.bodyToMono(bodyClass.java).flatMap { body -> Mono.just(body) }
            }
        }
    }
}
