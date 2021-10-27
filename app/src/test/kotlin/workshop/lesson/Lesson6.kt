package workshop.lesson

import org.junit.Test
import kotlin.test.assertEquals

//kotlin library extension fuctions


class Lesson6 {

    @Test
    fun test1() {
        assertEquals(100, log())
    }

    //rewrite code with one liner
    private fun log(): Int {
        val result = computation()
        println(result)
        return result
    }

    private fun computation(): Int = 100

    @Test
    fun test2() {
        //rewrite without shadowing it and explicit parameters
        val list = listOf<Int?>(1, null, 2, null)
        val result = list.map {
            it?.let {
                it + 1
            }
        }

        assertEquals(listOf(2, null, 3, null), result)
    }

    @Test
    fun test3() {
        //rewrite without using value triple 3 times
        val triple = Triple(1, 2, 3)

        assertEquals(1, triple.first)
        assertEquals(2, triple.second)
        assertEquals(3, triple.third)
    }

    @Test
    fun test4() {
        //rewrite without shadowing it and explicit parameters
        val list = listOf<Int?>(1, null, 2, null)
        val result = list.map {
            it?.also {
                println(it)
            }
        }

        assertEquals(listOf(1, null, 2, null), result)
    }
}
