object AoCDay3Part2 {
    fun calLifeSupportRating(data: List<String>): Int {
        val dataInput = data.map { it.split("(?<=\\d)(?=\\d)".toRegex()) }
        var (onebit, zeroBit) = Pair(0, 0)
        val size = dataInput[0].size

        var oxyGenerator = dataInput
        for (i in 0 until size) {
            oxyGenerator.forEach {
                if (it[i] == "1") onebit++ else zeroBit++
            }
            oxyGenerator = when  {
                onebit > zeroBit -> oxyGenerator.filter { it[i] == "1" }
                zeroBit > onebit -> oxyGenerator.filter { it[i] == "0" }
                else -> oxyGenerator.filter { it[i] == "1" }
            }
            onebit = 0; zeroBit = 0
            if (oxyGenerator.size == 1) break
        }
        val oxyRating = oxyGenerator.joinToString { it.joinToString("") }.toInt(2)

        var carbonGenerator = dataInput
        for (i in 0 until size) {
            carbonGenerator.forEach {
                if (it[i] == "1") onebit++ else zeroBit++
            }
            carbonGenerator = when  {
                onebit > zeroBit -> carbonGenerator.filter { it[i] == "0" }
                zeroBit > onebit -> carbonGenerator.filter { it[i] == "1" }
                else -> carbonGenerator.filter { it[i] == "0" }
            }
            onebit = 0; zeroBit = 0
            if (carbonGenerator.size == 1) break
        }

        val carbonRating = carbonGenerator.joinToString { it.joinToString("") }.toInt(2)
        return oxyRating.times(carbonRating)
    }
}