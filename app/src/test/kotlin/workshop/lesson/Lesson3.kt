package workshop.lesson

import org.junit.Test
import kotlin.test.assertEquals

// Tuples
class Lesson3 {

    @Test
    fun test1() {
        //rewrite code with dedicated kotlin syntax
        val pair = Pair(1, "one")

        assertEquals(1,pair.first)
        assertEquals("one",pair.second)
    }

    @Test
    fun test2() {
        //rewrite code with dedicated kotlin syntax
        val triple = Triple(1, "one", 1.00)
        val first = triple.first
        val second = triple.second
        val third = triple.third

        assertEquals(1,first)
        assertEquals("one",second)
        assertEquals(1.00,third)
    }

    @Test
    fun test3() {
        //rewrite code with dedicated kotlin syntax
        val dog = Dog("Rex", "Pug", 5)
        val name = dog.name
        val breed = dog.breed

        assertEquals("Rex",name)
        assertEquals("Pug",breed)
    }
    data class Dog(val name: String, val breed: String,  val age: Int)
}
