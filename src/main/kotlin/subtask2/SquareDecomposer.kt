package subtask2

class SquareDecomposer {

    fun sqrt(number: Long): Long {
        var k: Long = 0

        while (k * k < number)
            k++

        if (k * k == number)
            return k

        return k - 1
    }

    fun decomposition(solution: MutableList<Int>, number: Int) {

        var k: Long = (number - 1).toLong()
        var sqrNumber: Long = number.toLong() * number.toLong()

        do {
            val sqrK: Long = k * k
            if (k == 0L) {
                if (solution.isEmpty())
                    return
                val last = solution.last()
                solution.remove(solution.last())
                sqrNumber += last * last
                k = (last - 1).toLong()
            }
            else if (sqrK <= sqrNumber && !solution.contains(k.toInt())) {
                solution.add(k.toInt())
                sqrNumber -= sqrK
                k = sqrt(sqrNumber)
            }
            else
                k--
        } while (sqrNumber != 0L)
    }

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0)
            return null

        val solution: MutableList<Int> = mutableListOf()
        decomposition(solution, number)

        if (solution.isEmpty())
            return null

        return solution.reversed().toTypedArray()
    }
}
