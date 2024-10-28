package ecowind.ru.exceptionhandler.excepions

import org.springframework.http.HttpStatus

class ActionException(override val message: String, override val status: HttpStatus) :
    BaseException(message = message, status = status)
