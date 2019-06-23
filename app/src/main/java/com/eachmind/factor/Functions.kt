package com.eachmind.factor

import java.lang.IllegalArgumentException
import kotlin.math.sqrt

fun factor(n: Int): List<Int> {
    if (n <= 1) {
        throw IllegalArgumentException("factorable numbers cannot be smaller or equal 1")
    }
    if (isPrime(n)) {
        return listOf(n)
    }
    return factorFactorable(n)
}

private fun factorFactorable(n: Int): List<Int> {
    val factorsList = mutableListOf<Int>()
    var factorableNum = n
    for (i in 2..n / 2) {
        if (isPrime(i)) {
            while (factorableNum % i == 0) {
                factorableNum /= i
                factorsList.add(i)
            }
            if (factorableNum == 1) {
                return factorsList
            }
            if (isPrime(factorableNum)) {
                factorsList.add(factorableNum)
                return factorsList
            }
        }
    }
    return factorsList
}

private fun isPrime(n: Int): Boolean {
    if (n <= 1) {
        return false
    }
    for (i in 2..sqrt(n.toFloat()).toInt()) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}
