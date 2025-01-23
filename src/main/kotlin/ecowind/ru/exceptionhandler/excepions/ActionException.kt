package ecowind.ru.exceptionhandler.excepions

import ecowind.ru.exceptionhandler.ErrorDetails
import org.springframework.http.HttpStatus

class ActionException(override val message: String, override val status: HttpStatus, val errorDetails: ErrorDetails) :
    BaseException(message = message, status = status)
