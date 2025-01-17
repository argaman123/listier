package com.listier

import com.listier.example.*
import kotlinx.serialization.json.Json
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import java.io.File


@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class ServerApplication

fun main(args: Array<String>) {
//  val json = Json { ignoreUnknownKeys = true } // Ignore unknown keys if needed
//  val dataStructure = json.decodeFromString<Database>(File("db.json").readText())
//  val a = 1

//  val json = Json { ignoreUnknownKeys = true } // Ignore unknown keys if needed
//  val dataStructure = json.decodeFromString<ShapesDatabase>(File("db2.json").readText())
//  val a = 1


//  val db = JsonDatabaseService("db.json")
//  val repo = ShapeRepository(db)
//  val shapes = repo.getAllShapes()
//  shapes.forEach {
//    when (it) {
//      is Circle -> println("circle ${it.name}: $it")
//      is Rectangle -> println("rectangle ${it.name}: $it")
//    }
//  }
  runApplication<ServerApplication>(*args)
}
