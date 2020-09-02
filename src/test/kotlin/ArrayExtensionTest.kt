import org.junit.Test
import util.shouldBe
import util.toArray
import util.toBooleanArray
import util.toIntArray

class ArrayExtensionTest {

    @Test
    fun `Test toArray`() {
        "[1, 2, 3]".toArray() shouldBe arrayOf("1", "2", "3")
        "[\"1\", \"2\", \"3\"]".toArray() shouldBe arrayOf("1", "2", "3")
    }

    @Test
    fun `Test toIntArray`() {
        "[1, 2, 3]".toIntArray() shouldBe arrayOf(1, 2, 3)
        "[\"1\", \"2\", \"3\"]".toIntArray() shouldBe arrayOf(1, 2, 3)
    }

    @Test
    fun `Test toBooleanArray`() {
        "[true, false, true]".toBooleanArray() shouldBe arrayOf(true, false, true)
        "[\"true\", \"false\", \"true\"]".toBooleanArray() shouldBe arrayOf(true, false, true)
    }
}