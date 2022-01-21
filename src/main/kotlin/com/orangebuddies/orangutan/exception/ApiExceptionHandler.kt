package com.orangebuddies.orangutan.exception

import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.ZoneId
import java.time.ZonedDateTime


@ControllerAdvice
class ApiExceptionHandler {

    // Handle custom class NotFoundException
    @ExceptionHandler(value = [NotFoundException::class])
    open fun handleNotFoundExcepton(exception: NotFoundException): ResponseEntity<Any> {
        val httpStatus = HttpStatus.NOT_FOUND
        val exceptionDetails: ExceptionDetails = ExceptionDetails(
                exception.message,
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        )
        return ResponseEntity<Any>(exceptionDetails, httpStatus)
    }

    // Handle custom class AlreadyFoundException
    @ExceptionHandler(value = [AlreadyFoundException::class])
    fun handleAlreadyFoundException(exception: AlreadyFoundException): ResponseEntity<Any> {
        val httpStatus = HttpStatus.BAD_REQUEST
        val exceptionDetails = ExceptionDetails(
                exception.message,
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        )
        return ResponseEntity(exceptionDetails, httpStatus)
    }

    // Handle custom class EmptyValueException
    @ExceptionHandler(value = [EmptyValueException::class])
    fun handleEmptyValueException(exception: EmptyValueException): ResponseEntity<Any?>? {
        val httpStatus = HttpStatus.BAD_REQUEST
        val exceptionDetails = ExceptionDetails(
                exception.message,  //"No value found in database",
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        )
        return ResponseEntity(exceptionDetails, httpStatus)
    }

    // Handle Global class exception
    @ExceptionHandler(value = [NoSuchElementException::class])
    fun handleNoSuchElementException(exception: NoSuchElementException): ResponseEntity<Any?>? {
        val httpStatus = HttpStatus.NOT_FOUND
        val exceptionDetails = ExceptionDetails(
                exception.message,
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        )
        return ResponseEntity(exceptionDetails, httpStatus)
    }

    // Handle Global class exception
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun handleConstraintViolationException(exception: ConstraintViolationException?): ResponseEntity<Any?>? {
        val httpStatus = HttpStatus.BAD_REQUEST
        val exceptionDetails = ExceptionDetails(
                "Unique constrain exception",
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        )
        return ResponseEntity(exceptionDetails, httpStatus)
    }

    // Handle Global class exception
    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException?): ResponseEntity<Any?>? {
        val httpStatus = HttpStatus.BAD_REQUEST
        val exceptionDetails: ExceptionDetails = ExceptionDetails(
                "Invalid json format",
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        )
        return ResponseEntity(exceptionDetails, httpStatus)
    }

}

