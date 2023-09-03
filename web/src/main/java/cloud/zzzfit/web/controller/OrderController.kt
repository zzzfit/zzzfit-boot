package cloud.zzzfit.web.controller

import cloud.zzzfit.web.service.OrderService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.MethodParameter
import org.springframework.core.convert.converter.Converter
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.context.request.WebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class Student
@Slf4j
@RestController
@RequestMapping("/order")
class OrderController {

    @Autowired
    lateinit var orderService: OrderService

//    @GetMapping
//    fun list(): List<Student> {
//        val student = Student()
////        student.setName("Peter")
////        student.setId(studentId)
//        return emptyList()
//    }

    @GetMapping(value = ["{id}"])
    fun get(@PathVariable id: Long): Student? {
        val student = Student()
//        student.setName("Peter")
//        student.setId(studentId)
        return student
    }

    @GetMapping("/")
    @Throws(CustomException::class)
    fun index() {
        throw CustomException()
    }
}


@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [IllegalArgumentException::class, IllegalStateException::class])
    protected fun handleConflict(
        ex: RuntimeException, request: WebRequest
    ): ResponseEntity<Any>? {
        val bodyOfResponse = "This should be application specific"
        return handleExceptionInternal(
            ex, bodyOfResponse,
            HttpHeaders(), HttpStatus.CONFLICT, request
        )
    }
}


@RestControllerAdvice
class ErrorHandler {
    @ExceptionHandler(CustomException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleCustomException(ce: CustomException): CustomException {
        return ce
    }
}

class CustomException : java.lang.RuntimeException() {
}


@Component
class StringToLocalDateTimeConverter : Converter<String, LocalDateTime> {
    override fun convert(source: String): LocalDateTime? {
        return LocalDateTime.parse(
            source, DateTimeFormatter.ISO_LOCAL_DATE_TIME
        )
    }
}

class HeaderVersionArgumentResolver: HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        TODO("Not yet implemented")
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {
        TODO("Not yet implemented")
    }

}

