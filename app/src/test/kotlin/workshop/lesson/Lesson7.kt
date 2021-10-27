package workshop.lesson

import io.mockk.InternalPlatformDsl.toArray
import org.junit.Test
import kotlin.test.assertEquals

//Collections
class Lesson7 {

    @Test
    fun test1() {
        //refactor to simpler code
        val list = listOf(1, 2, null, null, 3, 4)
                .filter { it != null }


        assertEquals(listOf(1, 2, 3, 4), list)
    }

    @Test
    fun test2() {
        //refactor to simpler code
        val dict = mapOf(1 to "1", 3 to "3")
        val list = listOf(1, 2, 3, 4, 5)
                .map { dict[it] }
                .filter { it != null }


        assertEquals(listOf("1", "3"), list)
    }

    @Test
    fun test3() {
        var x = 0
        //make test passing
        val result = listOf(1, 2, 3, 4, 5, 6)
                .map { it.also { x += it } }
                .map { it * 2 }
                .first { it > 3 }

        assertEquals(4, result)
        assertEquals(3, x)
    }

    @Test
    fun test4() {
        //refactor to simpler code
        val list = listOf(1, 2, 3, 4, 5, 6)
        val evens = list.filter { it % 2 == 0 }
        val odds = list.filter { it % 2 == 1 }

        assertEquals(listOf(2, 4, 6), evens)
        assertEquals(listOf(1, 3, 5), odds)
    }

    @Test
    fun test5() {
        //refactor to simpler code
        val list = listOf(1, 2, 3, 4, 5, 6)
        val restToValue: Map<Int, Int> = list.map { it % 3 to it }
                .fold(emptyMap()) { acc, elem -> acc + (elem.first to elem.second) }


        assertEquals(mapOf(1 to 4, 2 to 5, 0 to 6), restToValue)
    }

    @Test
    fun test6() {
        //refactor to simpler code
        val list = listOf(1, 2, 3, 4, 5, 6)
        val restToValues: Map<Int, List<Int>> = list.map { it % 3 to it }
                .fold(emptyMap()) { acc, elem ->
                    val value: List<Int>? = acc[elem.first]
                    acc + (elem.first to (value?.let { it + elem.second } ?: listOf(elem.second)))
                }


        assertEquals(mapOf(1 to listOf(1, 4), 2 to listOf(2, 5), 0 to listOf(3, 6)), restToValues)
    }

    @Test
    fun test7() {
        //refactor to simpler code
        val list = listOf<Number>(1, 2.0, 3, 4.0, 5, 6.0)
        val integers: List<Int> = list.filter { it is Int }.map { it as Int }


        assertEquals(listOf(1, 3, 5), integers)
    }


    @Test
    fun test8() {
        //refactor to simpler code
        val data: Map<String, Int> = mapOf("a" to 1, "b" to 2)
        val list: List<Pair<String, Int>> = data.map { (key, value) -> key to (value * 10) }
        val result: Map<String, Int> = list.toMap()

        assertEquals(mapOf("a" to 10, "b" to 20), result)
    }

    @Test
    fun test9() {
        //use builder
        val input: Map<String, Int> = mapOf("a" to 1, "b" to 2)
        val array: Array<Pair<String, Int>> = input.toList().toTypedArray()
        val result :  Map<String, Int>  = mapOf(*array, "c" to 3, "d" to 4)

        assertEquals(mapOf("a" to 1, "b" to 2, "c" to 3, "d" to 4), result)
    }
}
