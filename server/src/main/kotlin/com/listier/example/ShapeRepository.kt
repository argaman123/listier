package com.listier.example

import org.springframework.context.annotation.Bean

class ShapeRepository(private val databaseService: JsonDatabaseService) {

  fun getAllShapes(): List<Shape> = databaseService.loadShapes()

  fun getAllRectangles(): List<Rectangle> {
    return databaseService.loadShapes().filterIsInstance<Rectangle>()
  }

  fun saveShape(shape: Shape) {
    val shapes = databaseService.loadShapes().toMutableList()
    shapes.add(shape)
    databaseService.saveShapes(shapes)
  }
}
