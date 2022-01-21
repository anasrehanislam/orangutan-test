package com.orangebuddies.orangutan.exception

class AlreadyFoundException : RuntimeException {
    constructor(message: String) : super(message) {}
    constructor(message: String, cause: Throwable) : super(message, cause) {}
}
