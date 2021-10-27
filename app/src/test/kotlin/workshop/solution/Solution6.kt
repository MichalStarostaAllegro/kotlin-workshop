package workshop.solution

import org.junit.Test
import kotlin.test.assertEquals

class Solution6 {

    @Test
    fun test1() {
        assertEquals(log(), 100)
    }

    //rewrite code with one liner
    private fun log(): Int = computation().also {
        println(it)
    }

    private fun computation(): Int = 100

    @Test
    fun test2() {
        //rewrite without shadowing it and explicit parameters
        val list = listOf<Int?>(1, null, 2, null)
        val result = list.map {
            it?.run {
                this + 1
            }
        }

        assertEquals(listOf(2,null, 3, null), result)
    }

    @Test
    fun test3() {
        //rewrite without using value triple 3 times
        val triple = Triple(1, 2, 3)

        (triple).run {
            assertEquals(1, first)
            assertEquals(2, second)
            assertEquals(3, third)
        }

        with(triple) {
            assertEquals(1, first)
            assertEquals(2, second)
            assertEquals(3, third)
        }
    }

    @Test
    fun test4() {
        //rewrite without shadowing it and explicit parameters
        val list = listOf<Int?>(1, null, 2, null)
        val result = list.map {
            it?.apply {
                println(this)
            }
        }

        assertEquals(listOf(1, null, 2, null), result)
    }
}
