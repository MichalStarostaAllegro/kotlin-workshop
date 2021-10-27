package workshop.solution

import org.junit.Test
import java.math.BigDecimal
import kotlin.test.assertEquals


class Solution1 {

    @Test
    fun test1() {
        //rewrite code with extension function
        val animals = listOf(Animal("cat"), Animal("dog"))
        val cats = animals.filterCats()
        assertEquals(listOf(Animal("cat")), cats)
    }

    @Test
    fun test2() {
        //refactor code to reduce code duplication
        val s1: String? = null
        val s2: String = "1"
        val s3: String? = null
        val s4: String = "2"

        val i1 =  s1.toIntOrZero()
        val i2 =  s2.toIntOrZero()
        val i3 =  s3.toIntOrZero()
        val i4 =  s4.toIntOrZero()

        assertEquals(0, i1)
        assertEquals(1, i2)
        assertEquals(0, i3)
        assertEquals(2, i4)
    }
}

data class Animal(val type: String)

fun List<Animal>.filterCats(): List<Animal> {
    return filter { it.type == "cat" }
}

fun String?.toIntOrZero(): Int {
    return this?.toInt() ?: 0
}
