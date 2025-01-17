package com.listier.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
sealed class Shape(open val name: String = "")

@Serializable
@SerialName("circle")
data class Circle(val radius: Double) : Shape()

@Serializable
@SerialName("rectangle")
data class Rectangle(val width: Double, val height: Double, val names: List<String>) : Shape()

@Serializable
class ShapesDatabase(
  val shapes: List<Shape> = emptyList()
)
