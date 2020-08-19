import org.junit.Assert.assertEquals
import org.junit.Test
import util.SystemIOTest

class HelloTest : SystemIOTest() {

    @Test
    fun `Exact Hello`() {
        Hello.main(arrayOf())
        assertEquals("Hello", output.toString())
    }
}