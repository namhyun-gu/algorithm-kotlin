package util

import org.junit.Assert
import java.util.*

infix fun <T> T.shouldBe(expect: T) {
    Assert.assertEquals(expect, this)
}

infix fun <T> Array<T>.shouldBe(expect: Array<T>) {
    Assert.assertArrayEquals(expect, this)
}

infix fun IntArray.shouldBe(expect: Array<Int>) {
    Assert.assertArrayEquals(expect, this.toTypedArray())
}

infix fun IntArray.shouldBe(expect: IntArray) {
    Assert.assertArrayEquals(expect.toTypedArray(), this.toTypedArray())
}

private inline fun <reified T> String.toArray(map: (String) -> T): Array<T> {
    val tokenizer = StringTokenizer(removeSurrounding("[", "]"), ",")
    val items = mutableListOf<String>()
    while (tokenizer.hasMoreTokens()) {
        var token = tokenizer.nextToken().trim()
        if (token.startsWith("\"") and token.endsWith("\"")) {
            token = token.removeSurrounding("\"")
        }
        items.add(token)
    }
    return items.map { map(it) }.toTypedArray()
}

fun String.toArray(): Array<String> {
    return toArray(Transformers.DEFAULT)
}

fun String.toIntArray(): IntArray {
    return toArray(Transformers.INT).toIntArray()
}

fun String.toBooleanArray(): BooleanArray {
    return toArray(Transformers.BOOLEAN).toBooleanArray()
}

typealias Transformer<T> = (String) -> T

object Transformers {

    val DEFAULT: Transformer<String> = { it }

    val INT: Transformer<Int> = { it.toInt() }

    val BOOLEAN: Transformer<Boolean> = { it.toBoolean() }

}