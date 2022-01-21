package com.orangebuddies.orangutan.exception

import org.springframework.http.HttpStatus
import java.time.ZonedDateTime

class ExceptionDetails(val message: String?, val status: HttpStatus, val timestamp: ZonedDateTime)