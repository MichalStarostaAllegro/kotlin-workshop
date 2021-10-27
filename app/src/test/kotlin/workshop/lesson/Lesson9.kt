package workshop.lesson

import org.junit.Test
import kotlin.test.assertEquals

//Reified
class Lesson9 {


    @Test
    fun test1() {
        //do not use clazz
        val x = callConstructor(String::class.java)
        assertEquals("",x)
    }

    fun <T> callConstructor(clazz: Class<T>): T {
        return clazz.getConstructor().newInstance()
    }

    @Test
    fun test2() {
        //do not use isIstance
        val list = listOf(1, 2, "abc", 5, "de")
        val string = list.findObjectOfType(String::class.java)
        assertEquals("abc", string)
    }


    fun <T> List<Any>.findObjectOfType(clazz: Class<T>): T? {
        forEach {
            if (clazz.isInstance(it)) {
                return it as T
            }
        }
        return null
    }

}


