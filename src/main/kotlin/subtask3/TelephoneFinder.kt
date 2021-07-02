package subtask3

class TelephoneFinder {

/*    var phoneKeypad: Array<IntArray> = arrayOf(
                                        intArrayOf(1, 2, 3),
                                        intArrayOf(4, 5, 6),
                                        intArrayOf(7, 8, 9),
                                        intArrayOf(-1, 0, -1))*/

    var numberNeighbours: Array<CharArray> = arrayOf(
                                            charArrayOf('8'),
                                            charArrayOf('2', '4'),
                                            charArrayOf('1', '3', '5'),
                                            charArrayOf('2', '6'),
                                            charArrayOf('1', '5', '7'),
                                            charArrayOf('2', '4', '6', '8'),
                                            charArrayOf('3', '5', '9'),
                                            charArrayOf('4', '8'),
                                            charArrayOf('0', '5', '7', '9'),
                                            charArrayOf('6', '8'))


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.contains(Regex("[^0-9]")))
            return null

        val numbers: MutableList<String> = mutableListOf()
        for ((index, char) in number.withIndex()) {
            for (neighbour in numberNeighbours[char.toInt() - '0'.toInt()]) {
                val tmp = number.toCharArray()
                tmp[index] = neighbour
                numbers.add(String(tmp))
            }
        }

        return numbers.toTypedArray()
    }
}
