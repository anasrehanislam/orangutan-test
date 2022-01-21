package com.orangebuddies.orangutan.exception
// Custom Exception class
class NotFoundException : RuntimeException {
    constructor(message: String) : super(message) {}
    //constructor(message: String, cause: Throwable) : super(message, cause) {}
}