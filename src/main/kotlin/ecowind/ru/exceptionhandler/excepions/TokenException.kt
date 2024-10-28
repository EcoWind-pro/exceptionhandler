package ecowind.ru.exceptionhandler.excepions

import org.springframework.http.HttpStatus

class TokenException(override val message: String) :
    BaseException(message = message, status = HttpStatus.FORBIDDEN)
