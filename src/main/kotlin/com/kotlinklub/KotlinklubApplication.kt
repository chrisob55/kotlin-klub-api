package com.kotlinklub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class KotlinklubApplication

fun main(args: Array<String>) {
	runApplication<KotlinklubApplication>(*args)
}
