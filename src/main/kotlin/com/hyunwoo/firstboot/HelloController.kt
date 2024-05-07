package com.hyunwoo.firstboot

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.LoggerFactory

data class Message(
    val message: String,
    val buildNumber: String
)
@RestController
class HelloController(
    @Value("\${hyunwoo.firstboot.buildNumber}") val buildNumber: String
) {
    val logger = LoggerFactory.getLogger(this::class.java)
    @GetMapping("/hello")
    fun hello(): Message {
        logger.trace("trace the line")
        logger.debug("debug the line")

        logger.info("info the line")
        logger.warn("warn the line")
        logger.error("error the Line")

        try {
            val x: Int = 1 / 0
        } catch (e: ArithmeticException) {
            logger.error("Error: failed to compute the x", e)
        }

        return Message("Hello JY :)", buildNumber)
    }
}