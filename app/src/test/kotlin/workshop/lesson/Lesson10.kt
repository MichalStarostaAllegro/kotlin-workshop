package workshop.lesson

import org.junit.Test

//Generics
class Lesson10 {

    @Test
    fun test1() {
        val integers: List<Int> = listOf(1, 2, 3)
        val numbers: List<Number> = listOf(1, 2, 3)

        logNumbers(integers)
        logNumbers(numbers)

        val mutableIntegers: MutableList<Int> = mutableListOf(1, 2, 3)
        val mutableDoubles: MutableList<Double> = mutableListOf(1.0, 2.0, 3.0)

        logMutableNumbers(mutableIntegers)
        logMutableNumbers(mutableDoubles)

        max<Int>(integers, NumberComparator)
    }

    object NumberComparator : Comparator<Number> {
        override fun compare(x: Number, y: Number): Int = x.toByte() - y.toByte()
    }

    fun logMutableNumbers(list: MutableList<out Number>) {
        list.forEach { println(it.toByte()) }
        //list.add(1.0)
    }

    fun logNumbers(list: List<Number>) {
        list.forEach { println(it.toDouble()) }
    }


    fun <T> max(list: List<T>, comparator: Comparator<in T>): T {
        return list.reduce { x, y -> if(comparator.compare(x, y) > 0) x else y }
    }
}

