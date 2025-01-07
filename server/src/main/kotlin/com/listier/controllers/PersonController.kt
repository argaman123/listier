package com.listier.controllers

import com.listier.models.Person
import com.listier.services.PersonService
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/persons")
class PersonController(private val personService: PersonService) {

  @GetMapping
  fun getAllPersons(): List<Person> = personService.getAll()

  @GetMapping("/{id}")
  fun getPersonById(@PathVariable id: Long): ResponseEntity<Person> {
    val person = personService.getById(id)
    return if (person != null) ResponseEntity.ok(person) else ResponseEntity.notFound().build()
  }

  @PostMapping
  fun addPerson(@Valid @RequestBody request: PersonRequest): Person {
    return personService.addPerson(request.name, request.age)
  }

  @PutMapping("/{id}")
  fun updatePerson(@PathVariable id: Long, @RequestBody request: PersonRequest): ResponseEntity<Person> {
    val updatedPerson = personService.updatePerson(id, request.name, request.age)
    return if (updatedPerson != null) ResponseEntity.ok(updatedPerson) else ResponseEntity.notFound().build()
  }

  @DeleteMapping("/{id}")
  fun deletePerson(@PathVariable id: Long): ResponseEntity<Unit> {
    return if (personService.deletePerson(id)) ResponseEntity.noContent().build()
    else ResponseEntity.notFound().build()
  }

  data class PersonRequest(
    @field:NotEmpty(message = "Name must not be blank")
    @field:Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    val name: String,

    @field:Min(value = 0, message = "Age must be greater than or equal to 0")
    val age: Int
  )
}
