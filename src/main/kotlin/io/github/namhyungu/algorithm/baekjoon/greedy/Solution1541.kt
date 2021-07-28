package io.github.namhyungu.algorithm.baekjoon.greedy

import java.util.*

fun solution1541(args: Array<String>) =
    with(Scanner(System.`in`)) {
        val input = next()
        val tokenizer = StringTokenizer(input, "+-", true)
        val numberQueue = LinkedList<Int>()
        val operatorQueue = LinkedList<String>()

        while (tokenizer.hasMoreTokens()) {
            val token = tokenizer.nextToken()
            if ((token == "+") or (token == "-")) {
                operatorQueue.add(token)
            } else {
                numberQueue.add(token.toInt())
            }
        }

        var answer = 0
        var beforeMinus = false
        answer += numberQueue.pop()
        while (operatorQueue.isNotEmpty()) {
            val operator = operatorQueue.pop()
            if (operator == "-") {
                beforeMinus = true
                answer -= numberQueue.pop()
            } else {
                if (beforeMinus) answer -= numberQueue.pop() else answer += numberQueue.pop()
            }
        }
        print(answer)
    }
