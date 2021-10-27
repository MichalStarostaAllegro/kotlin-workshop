package workshop.solution

import org.junit.Test
import kotlin.test.assertEquals

//Inline
class Solution9 {

    @Test
    fun test2() {
        //do not use clazz
        val x: String = callConstructor()
        assertEquals("",x)
    }

    inline fun <reified T> callConstructor(): T {
        return T::class.java.getConstructor().newInstance()
    }

    @Test
    fun test3() {
        //do not use isIstance
        val list = listOf(1, 2, "abc", 5, "de")
        val string = list.findObjectOfType<String>()
        assertEquals("abc", string)
    }


    inline fun <reified T> List<Any>.findObjectOfType(): T? {
        forEach {
            if (it is T) {
                return it
            }
        }
        return null
    }
}


