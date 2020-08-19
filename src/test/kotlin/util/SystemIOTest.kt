package util

import org.junit.After
import org.junit.Assert
import org.junit.Before
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

open class SystemIOTest {
    private val systemInput = System.`in`
    private val systemOutput = System.out

    protected val output = ByteArrayOutputStream()

    @Before
    fun setupTest() {
        System.setOut(PrintStream(output))
    }

    @After
    fun flushTest() {
        System.setIn(systemInput)
        System.setOut(systemOutput)
    }

    fun setInput(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }

    fun test(input: String, expected: String, action: () -> Unit) {
        setInput(input)
        action()

        val output = output.toString()
        Assert.assertEquals(adjustFormat(expected, output), output)
    }

    private fun adjustFormat(expected: String, actual: String): String {
        var adjusted = expected
        if (actual.indexOf("\r\n") > 0) { // actual use CRLF
            adjusted = adjusted.replace("\n", "\r\n")
            if (actual.endsWith("\r\n") and !expected.endsWith("\r\n")) {
                adjusted += "\r\n"
            }
        } else { // actual use LF
            if (actual.endsWith("\n") and !expected.endsWith("\n")) {
                adjusted += "\n"
            }
        }
        return adjusted
    }
}