package workshop.lesson

import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.math.absoluteValue
import kotlin.test.assertEquals
import workshop.data.xml.Mapper

//types
class Lesson4 {

    @Test
    fun test1() {
        //take advantage of smart cast
        val x: Any = 1
        if (x is Int) {
            val casted = x as Int
            assertEquals(1, casted)
        }
    }

    @Test
    fun test2() {
        //use safe cast
        val x: Any = 1
        val casted: String = x as String

        assertEquals("1", casted)

    }

    @Test
    fun test3() {
        //get rid of else branch
        val result = try {
            throw TimeoutException(500)
        } catch (e: HttpException) {
            when (e) {
                is TimeoutException -> e.timeout
                is InternalServerErrorException -> -1
                else -> -2
            }
        }
        assertEquals(500, result)
    }

    @Test
    fun test4() {
        //Bonus, WTF pattern
        val x = 3
        val result = when (x == 3) {
            true -> true
            false -> false
        }
        assertTrue(result)
    }

    @Test
    fun test5() {
        //do not use qualifier name
        val xmlMapper = Mapper("abc")
        val jsonMapper = workshop.data.json.Mapper(100)
    }

    @Test
    fun test6() {
        // do not use safe operator ".?"
        val number: Int? = getValue()
        if (number == null) {
            throwException()
        }
        assertEquals(6, number?.absoluteValue)
    }

    fun getValue() : Int? = 6

    fun throwException(): Unit {
        throw RuntimeException()
    }

}

open class HttpException : RuntimeException()

data class TimeoutException(val timeout: Long) : HttpException()
class InternalServerErrorException : HttpException()
