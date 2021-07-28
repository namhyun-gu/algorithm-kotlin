package io.github.namhyungu.algorithm.programmers.kakao.internship.v2020

import kotlin.math.abs

class PressKeypad {
    val keypad =
        mapOf(
            '1' to intArrayOf(0, 0),
            '2' to intArrayOf(1, 0),
            '3' to intArrayOf(2, 0),
            '4' to intArrayOf(0, 1),
            '5' to intArrayOf(1, 1),
            '6' to intArrayOf(2, 1),
            '7' to intArrayOf(0, 2),
            '8' to intArrayOf(1, 2),
            '9' to intArrayOf(2, 2),
            '*' to intArrayOf(0, 3),
            '0' to intArrayOf(1, 3),
            '#' to intArrayOf(2, 3)
        )

    fun solution(numbers: IntArray, hand: String): String {
        var leftHand = '*'
        var rightHand = '#'

        return numbers.map { (it + '0'.toInt()).toChar() }.fold("") { acc, it ->
            when (it) {
                '1', '4', '7' -> {
                    leftHand = it
                    acc + 'L'
                }
                '3', '6', '9' -> {
                    rightHand = it
                    acc + 'R'
                }
                else -> {
                    val left = calcDistance(leftHand, it)
                    val right = calcDistance(rightHand, it)
                    if (left == right) {
                        if (hand == "left") {
                            leftHand = it
                            acc + 'L'
                        } else {
                            rightHand = it
                            acc + 'R'
                        }
                    } else if (left < right) {
                        leftHand = it
                        acc + 'L'
                    } else {
                        rightHand = it
                        acc + 'R'
                    }
                }
            }
        }
    }

    fun calcDistance(a: Char, b: Char): Int {
        return abs(keypad.getValue(a)[0] - keypad.getValue(b)[0]) +
            abs(keypad.getValue(a)[1] - keypad.getValue(b)[1])
    }
}
