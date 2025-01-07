package com.listier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class ServerApplication

fun main(args: Array<String>) {
  runApplication<ServerApplication>(*args)
}
