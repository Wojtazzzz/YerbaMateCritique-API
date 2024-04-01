package com.example.yerbamatecritique.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.ErrorResponseException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.server.ResponseStatusException

@RestControllerAdvice
class DomainExceptionHandler {
    @ExceptionHandler(YerbaNotFound::class)
    fun handleException(ex: Exception?, request: WebRequest?): ErrorResponseException {
        if (ex is YerbaNotFound) {
            return ResponseStatusException(HttpStatus.NOT_FOUND, "Yerba not found.")
        }

        return ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}