object AoCDay3Part1 {
    fun powerConsumption(data: List<String>): Int {
        val dataInput = data.map { it.split("(?<=\\d)(?=\\d)".toRegex()) }
        var gammaBinary = ""
        var epsilonBinary = ""
        for (i in 0 until dataInput[0].size) {
            var (oneBit, zeroBit) = Pair(0,0)
            dataInput.forEach {
                if (it[i] == "1") oneBit++ else zeroBit++
            }
            gammaBinary += if (oneBit > zeroBit) "1" else "0"
            epsilonBinary += if (oneBit > zeroBit) "0" else "1"
        }
        val gammaRate = gammaBinary.toInt(2)
        val epsilonRate = epsilonBinary.toInt(2)
        return (gammaRate).times(epsilonRate)
    }
}