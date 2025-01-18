package com.listier

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.*

// Custom serializer for UUID
object UUIDSerializer : KSerializer<UUID> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

  override fun serialize(encoder: Encoder, value: UUID) {
    encoder.encodeString(value.toString())
  }

  override fun deserialize(decoder: Decoder): UUID {
    return UUID.fromString(decoder.decodeString())
  }
}

enum class ColumnTemplate(val type: String) {
  Text("text"),
  Select("select"),
}

@Serializable
sealed class Model(
  @Serializable(with = UUIDSerializer::class) val id: UUID = UUID.randomUUID()
)



@Serializable
sealed class Column(val name: String = "") : Model()

@Serializable
@SerialName("text")
class TextColumn : Column()

@Serializable
@SerialName("date")
class DateColumn : Column()

@Serializable
class SelectOption(val label: String, val color: String) : Model()

@Serializable
@SerialName("select")
class SelectColumn(val options: List<SelectOption>) : Column()

@Serializable
class Row : Model()

@Serializable
sealed class Cell(
  @Serializable(with = UUIDSerializer::class) val columnID: UUID = UUID.randomUUID(),
  @Serializable(with = UUIDSerializer::class) val rowID: UUID = UUID.randomUUID(),
) : Model()

@Serializable
@SerialName("text")
class TextCell(val content: String) : Cell()

@Serializable
@SerialName("select")
class SelectCell(val selected: List<String>) : Cell()

@Serializable
@SerialName("date")
class DateCell(val date: Long) : Cell()

@Serializable
class Database(
  val version: String = "0.0.0",
  val columns: List<Column> = emptyList(),
  val rows: List<Row> = emptyList(),
  val cells: List<Cell> = emptyList()
)
