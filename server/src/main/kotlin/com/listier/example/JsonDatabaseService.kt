package com.listier.example

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class JsonDatabaseService(private val filePath: String) {

  private val json = Json { ignoreUnknownKeys = true; prettyPrint = true }

  fun loadShapes(): List<Shape> {
    val file = File(filePath)
    return if (file.exists()) {
      json.decodeFromString(file.readText())
    } else {
      emptyList()
    }
  }

  fun saveShapes(shapes: List<Shape>) {
    val file = File(filePath)
    file.writeText(json.encodeToString(shapes))
  }
}
