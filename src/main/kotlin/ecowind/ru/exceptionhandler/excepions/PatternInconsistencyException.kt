package ecowind.ru.exceptionhandler.excepions

import org.springframework.http.HttpStatus

class PatternInconsistencyException(override val message: String) :
    BaseException(message = message, status = HttpStatus.BAD_REQUEST)