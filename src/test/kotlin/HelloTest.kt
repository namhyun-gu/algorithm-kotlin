import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class HelloTest {
    private val output = ByteArrayOutputStream()
    private val systemOutput = System.out

    @Before
    fun setupTest() {
        System.setOut(PrintStream(output))
    }

    @After
    fun flushTest() {
        System.setOut(systemOutput)
    }

    @Test
    fun `Exact Hello`() {
        Hello.main(arrayOf())
        assertEquals("Hello", output.toString())
    }
}