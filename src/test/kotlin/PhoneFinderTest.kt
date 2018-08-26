import org.junit.Assert
import org.junit.Test

class PhoneFinderTest {

    @Test(expected = IllegalArgumentException::class)
    fun shouldNotAcceptEmptyString() {
        val finder = PhoneFinder()
        finder.decode("")
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldNotAcceptStringLongerThan30Chars() {
        val finder = PhoneFinder()
        finder.decode("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldNotAcceptStringWithSpecialChars() {
        val finder = PhoneFinder()
        finder.decode("^çã#$")
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldNotAcceptStringWithNumbersOtherThanZeroAndOne() {
        val finder = PhoneFinder()
        finder.decode("2345")
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldNotAcceptStringThatDoesNotMatchRegex() {
        val finder = PhoneFinder()
        finder.decode("AAA 3")
    }

    @Test
    fun shouldAcceptStringWithZerosOnesAndDashesAmongstOtherLetters() {
        val finder = PhoneFinder()
        val result = finder.decode("AAA00-11-AA-1A")
        Assert.assertEquals("22200-11-22-12", result)
    }

    @Test
    fun shouldAcceptStringWithLowerCaseChars() {
        val finder = PhoneFinder()
        val result = finder.decode("aaa00-11-AA-1A")
        Assert.assertEquals("22200-11-22-12", result)
    }

    @Test
    fun shouldNotDecodeOnes() {
        val finder = PhoneFinder()
        val result = finder.decode("111")
        Assert.assertEquals("111", result)
    }

    @Test
    fun shouldNotDecodeZerosAndOnes() {
        val finder = PhoneFinder()
        val result = finder.decode("010110")
        Assert.assertEquals("010110", result)
    }

    @Test
    fun shouldNotDecodeDashes() {
        val finder = PhoneFinder()
        val result = finder.decode("------")
        Assert.assertEquals("------", result)
    }

    @Test
    fun shouldReturnNumberTwoWhenInputIsA() {
        val finder = PhoneFinder()
        val result = finder.decode("A")
        Assert.assertEquals("2", result)
    }

    @Test
    fun shouldReturnNumberTwoWhenInputIsABorC() {
        val finder = PhoneFinder()
        var result = finder.decode("A")
        Assert.assertEquals("2", result)
        result = finder.decode("B")
        Assert.assertEquals("2", result)
        result = finder.decode("C")
        Assert.assertEquals("2", result)
    }

    @Test
    fun shouldReturnNumberThreeWhenInputIsDEorF() {
        val finder = PhoneFinder()
        var result = finder.decode("D")
        Assert.assertEquals("3", result)
        result = finder.decode("E")
        Assert.assertEquals("3", result)
        result = finder.decode("F")
        Assert.assertEquals("3", result)
    }

    @Test
    fun shouldReturnNumberFourWhenInputIsGHorI() {
        val finder = PhoneFinder()
        var result = finder.decode("G")
        Assert.assertEquals("4", result)
        result = finder.decode("H")
        Assert.assertEquals("4", result)
        result = finder.decode("I")
        Assert.assertEquals("4", result)
    }

    @Test
    fun shouldReturnNumberFiveWhenInputIsJKorL() {
        val finder = PhoneFinder()
        var result = finder.decode("J")
        Assert.assertEquals("5", result)
        result = finder.decode("K")
        Assert.assertEquals("5", result)
        result = finder.decode("L")
        Assert.assertEquals("5", result)
    }

    @Test
    fun shouldReturnNumberSixWhenInputIsMNorO() {
        val finder = PhoneFinder()
        var result = finder.decode("M")
        Assert.assertEquals("6", result)
        result = finder.decode("N")
        Assert.assertEquals("6", result)
        result = finder.decode("O")
        Assert.assertEquals("6", result)
    }

    @Test
    fun shouldReturnNumberSevenWhenInputIsPQRorS() {
        val finder = PhoneFinder()
        var result = finder.decode("P")
        Assert.assertEquals("7", result)
        result = finder.decode("Q")
        Assert.assertEquals("7", result)
        result = finder.decode("R")
        Assert.assertEquals("7", result)
        result = finder.decode("S")
        Assert.assertEquals("7", result)
    }


    @Test
    fun shouldReturnNumberEightWhenInputIsTUorV() {
        val finder = PhoneFinder()
        var result = finder.decode("T")
        Assert.assertEquals("8", result)
        result = finder.decode("U")
        Assert.assertEquals("8", result)
        result = finder.decode("V")
        Assert.assertEquals("8", result)
    }

    @Test
    fun shouldReturnNumberNineWhenInputIsWXYorZ() {
        val finder = PhoneFinder()
        var result = finder.decode("W")
        Assert.assertEquals("9", result)
        result = finder.decode("X")
        Assert.assertEquals("9", result)
        result = finder.decode("Y")
        Assert.assertEquals("9", result)
        result = finder.decode("Z")
        Assert.assertEquals("9", result)
    }

    @Test
    fun shouldReturnNumberTwentyTwoWhenInputIsAA() {
        val finder = PhoneFinder()
        val result = finder.decode("AA")
        Assert.assertEquals("22", result)
    }

    @Test
    fun shouldReturnCorrectResultForAllAcceptedChars() {
        val finder = PhoneFinder()
        val result = finder.decode("ABCDEFGHIJKLMNOPQRSTUVWXYZ01-")
        Assert.assertEquals("2223334445556667777888999901-", result)
    }

}
