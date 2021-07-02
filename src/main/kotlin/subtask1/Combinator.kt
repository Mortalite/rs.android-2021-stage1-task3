package subtask1

class Combinator {

    fun fillMapFact(factMap: MutableMap<Long, Long>, n: Long) {
        var result = 1L

        for (k in 0L..1L)
            factMap[k] = result

        for (k in 2..n) {
            result *= k
            factMap[k] = result
        }
    }

    fun findMinCoeff(factMap: MutableMap<Long, Long>, posters:Long, n: Long): Int? {
        for (k in 0..n) {
            val combination = factMap[n]!! / (factMap[k]!! * factMap[n-k]!!)
            if (combination == posters)
                return k.toInt()
        }
        return null
    }

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val factMap = mutableMapOf<Long, Long>()
        fillMapFact(factMap, array[1].toLong())
        return findMinCoeff(factMap, array[0].toLong(), array[1].toLong())
    }

}
