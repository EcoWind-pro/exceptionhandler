package ecowind.ru.exceptionhandler.excepions

import org.springframework.http.HttpStatus

class NotUniqueException(message: String) :
    BaseException(message = message, status = HttpStatus.FORBIDDEN)