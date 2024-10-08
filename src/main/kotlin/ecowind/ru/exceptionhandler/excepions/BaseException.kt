package ecowind.ru.exceptionhandler.excepions

import org.springframework.http.HttpStatus

open class BaseException(
    override val message: String,
    val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR
) : RuntimeException(message)