package workshop.solution

import org.junit.Test
import kotlin.test.assertEquals

class Solution7 {

    @Test
    fun test1() {
        //refactor to simpler code
        val list = listOf(1, 2, null, null, 3, 4)
                .filterNotNull()


        assertEquals(listOf(1, 2, 3, 4), list)
    }

    @Test
    fun test2() {
        //refactor to simpler code
        val dict = mapOf(1 to "1", 3 to "3")
        val list = listOf(1, 2, 3, 4, 5).mapNotNull { dict[it] }


        assertEquals(listOf("1", "3"), list)
    }

    @Test
    fun test3() {
        var x = 0
        //make test passing
        val result = listOf(1, 2, 3, 4, 5, 6)
                .asSequence()
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
        val (evens, odds) = list.partition { it % 2 == 0 }

        assertEquals(listOf(2, 4, 6), evens)
        assertEquals(listOf(1, 3, 5), odds)
    }

    @Test
    fun test5() {
        //refactor to simpler code
        val list = listOf(1, 2, 3, 4, 5, 6)
        val restToValue: Map<Int, Int> = list.associateBy { it % 3 }

        assertEquals(mapOf(1 to 4, 2 to 5, 0 to 6), restToValue)
    }

    @Test
    fun test6() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val restToValues: Map<Int, List<Int>> = list.groupBy { it % 3 }
        assertEquals(mapOf(1 to listOf(1, 4), 2 to listOf(2, 5), 0 to listOf(3, 6)), restToValues)
    }

    @Test
    fun test7() {
        //refactor to simpler code
        val list = listOf<Number>(1, 2.0, 3, 4.0, 5, 6.0)
        val integers: List<Int> = list.filterIsInstance<Int>()


        assertEquals(listOf(1, 3, 5), integers)
    }

    @Test
    fun test8() {
        //refactor to simpler code
        val data: Map<String, Int> = mapOf("a" to 1, "b" to 2)
        val result: Map<String, Int> = data.mapValues { (_, value) -> value * 10 }

        assertEquals(mapOf("a" to 10, "b" to 20), result)
    }

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun test9() {
        //use builder
        val input: Map<String, Int> = mapOf("a" to 1, "b" to 2)
        val result: Map<String, Int> = buildMap {
            putAll(input)
            put("c", 3)
            put("d", 4)
        }
        assertEquals(mapOf("a" to 1, "b" to 2, "c" to 3, "d" to 4), result)
    }
}
