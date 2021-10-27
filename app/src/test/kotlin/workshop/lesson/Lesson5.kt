package workshop.lesson

import org.junit.Test
import kotlin.test.assertEquals

//properties
class Lesson5 {

    @Test
    fun test1() {
        //use property instead of method
        val person = Person("John", "Doe", 20)

        assertEquals("John Doe", person.getFullname())
    }

    @Test
    fun test2() {
        //use lazy initialization
        val person = Person("John", "Doe", 20)

        assertEquals(0, person.counter)
        assertEquals("J. D.", person.initials)
        assertEquals(1, person.counter)
    }


    data class Person(val name: String, val surname: String, val age: Int) {
        fun getFullname() = "$name $surname"
        val initials = calculateInitials()
        var counter = 0

        private fun calculateInitials(): String {
            counter++
            return "${name.first()}. ${surname.first()}."
        }
    }

    @Test
    fun test3() {
        //use kotlin delegation

        val dog = AngrySmallDog()
        assertEquals("eat", dog.eat())
        assertEquals("walk", dog.walk())
        assertEquals("bark and bite", dog.bark())
    }

    interface Dog {
        fun walk(): String
        fun bark(): String
        fun eat(): String
    }

    class SmallDog : Dog {
        override fun walk(): String {
            return "walk"
        }

        override fun bark(): String {
            return "bark"
        }

        override fun eat(): String {
            return "eat"
        }
    }

    class AngrySmallDog(private val smallDog: SmallDog = SmallDog()) : Dog {
        override fun walk(): String {
            return smallDog.walk()
        }

        override fun bark(): String {
            return smallDog.bark() + " and bite"
        }

        override fun eat(): String {
            return smallDog.eat()
        }

    }

}

