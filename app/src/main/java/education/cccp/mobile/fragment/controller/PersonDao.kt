package education.cccp.mobile.fragment.controller

import education.cccp.mobile.fragment.model.PersonEntity
import java.util.*

object PersonDao {
    private val PERSON_ENTITIES by lazy {
        mutableListOf(
            PersonEntity(
                id = 1,
                firstName = "John",
                lastName = "Doe",
                dob = Date()
            ),
            PersonEntity(
                id = 2,
                firstName = "Jane",
                lastName = "Doe",
                dob = Date()
            ),
            PersonEntity(
                id = 3,
                firstName = "Karl",
                lastName = "Cox",
                dob = Date()
            ),
            PersonEntity(
                id = 4,
                firstName = "Sidney",
                lastName = "Poitier",
                dob = Date()
            )
        )
    }
    val all: List<PersonEntity> get() = PERSON_ENTITIES

    fun findOneById(id: Int): PersonEntity? =
        all.firstOrNull { it.id == id }

    fun count(): Int = all.size
}