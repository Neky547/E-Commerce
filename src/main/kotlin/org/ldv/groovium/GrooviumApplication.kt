package org.ldv.groovium

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrooviumApplication

fun main(args: Array<String>) {
    runApplication<GrooviumApplication>(*args)
}
