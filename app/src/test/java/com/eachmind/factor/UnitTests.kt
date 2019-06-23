package com.eachmind.factor

import org.junit.Test

import org.junit.Assert.*
import java.lang.IllegalArgumentException
import kotlin.system.measureTimeMillis

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTests {

    @Test
    fun testWorstCaseFactor() {
        testFactor(1411021774, printToConsole = true)
    }

    @Test
    fun testRandomNumberFactor() {
        testFactor(printToConsole = true)
    }

    @Test
    fun testPreDefinedFactors() {
        val validFactors = listOf(2, 3, 5, 7)
        val factors = factor(210)
        assertEquals(factors, validFactors)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testNonFactorableNumber() {
        testFactor(0, false)
    }

    @Test
    fun testFactorStability() {
        for (i in 0..100) {
            testFactor(printToConsole = false)
        }
    }

    @Test
    fun testFactorProductivity() {
        val duration = measureTimeMillis {
            for (i in 0..1000) {
                testFactor(printToConsole = false)
            }
        }
        println("1K factorizations completed in: $duration ms")
    }

    private fun testFactor(n: Int = (2..Int.MAX_VALUE).random(), printToConsole: Boolean) {
        var factorList: List<Int> = emptyList()
        if (printToConsole) {
            val duration = measureTimeMillis {
                factorList = factor(n)
            }
            println("number is: $n, factors are: $factorList")
            println("factorization completed in: $duration ms")
        } else {
            factorList = factor(n)
        }
        checkIsTestValid(n, factorList)
    }

    private fun checkIsTestValid(n: Int, factorList: List<Int>) {
        var factorableNum = n
        for (i in 0 until factorList.size) {
            factorableNum /= factorList[i]
        }
        assertEquals(factorableNum, 1)
    }

}
