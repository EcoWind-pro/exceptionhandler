package ecowind.ru.exceptionhandler.excepions

import org.springframework.http.HttpStatus

class ContentNotFoundException(override val message: String) :
    BaseException(message = message, status = HttpStatus.NO_CONTENT)