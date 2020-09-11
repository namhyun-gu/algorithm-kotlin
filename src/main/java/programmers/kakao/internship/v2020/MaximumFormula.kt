package programmers.kakao.internship.v2020

import java.util.*
import kotlin.math.abs
import kotlin.math.max

class MaximumFormula {
    val operatorOrders = arrayOf(
            charArrayOf('+', '-', '*'),
            charArrayOf('+', '*', '-'),
            charArrayOf('-', '+', '*'),
            charArrayOf('-', '*', '+'),
            charArrayOf('*', '+', '-'),
            charArrayOf('*', '-', '+')
    )

    fun solution(expression: String): Long {
        val operands = mutableListOf<Long>()
        val operators = mutableListOf<Char>()
        val tokenizer = StringTokenizer(expression, "+-*", true)

        while (tokenizer.hasMoreTokens()) {
            val token = tokenizer.nextToken()
            if (token.contains("[+\\-*]".toRegex())) {
                operators.add(token[0])
            } else {
                operands.add(token.toLong())
            }
        }

        var maxResult = Long.MIN_VALUE
        for (order in operatorOrders) {
            val copiedOperands = mutableListOf(*operands.toTypedArray())
            val copiedOperators = mutableListOf(*operators.toTypedArray())

            for (operator in order) {
                var idx = copiedOperators.indexOf(operator)
                while (idx >= 0) {
                    val a = copiedOperands[idx]
                    val b = copiedOperands[idx + 1]
                    val result = when (operator) {
                        '+' -> a + b
                        '-' -> a - b
                        '*' -> a * b
                        else -> error("")
                    }

                    copiedOperands.removeAt(idx + 1)
                    copiedOperands.removeAt(idx)
                    copiedOperands.add(idx, result)
                    copiedOperators.removeAt(idx)

                    idx = copiedOperators.indexOf(operator)
                }
            }
            maxResult = max(maxResult, abs(copiedOperands[0]))
        }
        return maxResult
    }
}