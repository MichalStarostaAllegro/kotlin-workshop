package workshop.solution

import org.junit.Test
import kotlin.test.assertEquals

class Solution2 {

    data class Vector(val x: Int, val y: Int) {
        operator fun plus(another: Vector) = Vector(x + another.x, y + another.y)
    }

    @Test
    fun test1() {
        //refactor to operator overloading
        val v1 = Vector(1, 2)
        val v2 = Vector(3, 4)

        val result = v1 + v2

        assertEquals(Vector(4, 6), result)
    }
}
