package com.listier.services

import com.listier.models.Person
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

@Service
class PersonService {
  private val persons = ConcurrentHashMap<Long, Person>()
  private val idGenerator = AtomicLong(1)

  fun getAll(): List<Person> = persons.values.toList()

  fun getById(id: Long): Person? = persons[id]

  fun addPerson(name: String, age: Int): Person {
    val id = idGenerator.getAndIncrement()
    val person = Person(id, name, age)
    persons[id] = person
    return person
  }

  fun updatePerson(id: Long, name: String, age: Int): Person? {
    val person = persons[id]
    if (person != null) {
      person.name = name
      person.age = age
    }
    return person
  }

  fun deletePerson(id: Long): Boolean = persons.remove(id) != null
}
