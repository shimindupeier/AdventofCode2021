object AoCDay3Part2 {
    fun calLifeSupportRating(data: List<String>): Int {
        var dataInput = data.map { it.split("(?<=\\d)(?=\\d)".toRegex()) }
        var (trueCnt, falseCnt) = Pair(0, 0)
        val size = dataInput[0].size
        for (i in 0 until size) {
            dataInput.forEach {
                if (it[i] == "1") trueCnt++ else falseCnt++
            }
            dataInput = when  {
                trueCnt > falseCnt -> dataInput.filter { it[i] == "1" }
                falseCnt > trueCnt -> dataInput.filter { it[i] == "0" }
                else -> dataInput.filter { it[i] == "1" }
            }
            trueCnt = 0; falseCnt = 0
            if (dataInput.size == 1) break
        }
        val oxyRating = dataInput.joinToString { it.joinToString("") }.toInt(2)
        println(dataInput.size)

        dataInput = data.map { it.split("(?<=\\d)(?=\\d)".toRegex()) }
        for (i in 0 until size) {
            dataInput.forEach {
                if (it[i] == "1") trueCnt++ else falseCnt++
            }
            dataInput = when  {
                trueCnt > falseCnt -> dataInput.filter { it[i] == "0" }
                falseCnt > trueCnt -> dataInput.filter { it[i] == "1" }
                else -> dataInput.filter { it[i] == "0" }
            }
            trueCnt = 0; falseCnt = 0
            if (dataInput.size == 1) break
            //println(dataInput)
        }
        val carbonRating = dataInput.joinToString { it.joinToString("") }.toInt(2)
        println(dataInput.size)
        return oxyRating.times(carbonRating)
    }
}