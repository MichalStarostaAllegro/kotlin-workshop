package workshop.lesson

import org.junit.Test
import kotlin.test.assertEquals

//Lambdas
class Lesson8 {

    @Test
    fun test1() {
        //refactor to simpler code
        val result = call("a", {
            it.capitalize()
        })

        assertEquals("A", result)
    }

    fun <T> call(value: T, f: (T) -> T): T {
        return f(value)
    }

    @Test
    fun test2() {
        //make test pass
        val list = listOf(1, 2, 3)
        val result = sum(list)

        assertEquals(6, result)
    }

    private fun sum(list: List<Int>): Int = list
            .fold(0) { acc, it ->
                return acc + it
            }

    @Test
    fun test3() {
        //make test pass
        call("a") {
           // return
            "a"
        }
        assertEquals(2,1)
    }


    @Test
    fun test4() {
        //make test pass
        val list = listOf(1, 2, 3)
        val result = list.map {
            println("Some side effect")
            if (it % 2 == 0) {
                println("On odd side effect")
                it
            }
            println("On even side effect")
            null
        }

        assertEquals(listOf(null, 2, null), result)
    }
}
