class PhoneFinder {

    fun decode(inputString: String): String {
        if (!isValidInput(inputString)) {
            throw IllegalArgumentException()
        }

        return inputString
                .toUpperCase()
                .map { c: Char -> mapChar(c) }
                .joinToString(separator = "")
    }

    private fun mapChar(c: Char): Char {
        return when (c) {
            'A', 'B', 'C' -> '2'
            'D', 'E', 'F' -> '3'
            'G', 'H', 'I' -> '4'
            'J', 'K', 'L' -> '5'
            'M', 'N', 'O' -> '6'
            'P', 'Q', 'R', 'S' -> '7'
            'T', 'U', 'V' -> '8'
            'W', 'X', 'Y', 'Z' -> '9'
            else -> c
        }
    }

    private fun isValidInput(inputString: String) =
            inputString.isNotEmpty()
                    && inputString.length <= 30
                    && inputString.matches("([01\\-a-zA-Z])+".toRegex())

}
