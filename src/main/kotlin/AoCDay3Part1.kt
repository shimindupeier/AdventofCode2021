import kotlin.experimental.inv

object AoCDay3Part1 {
    fun powerConsumption(data: List<String>): Int {
        val dataInput = data.map { it.split("(?<=\\d)(?=\\d)".toRegex()) }
        var s = ""
        for (i in 0 until dataInput[0].size) {
            var (trueCnt, falseCnt) = Pair(0,0)
            dataInput.forEach {
                if (it[i] == "1") trueCnt++ else falseCnt++
            }
            s += if (trueCnt > falseCnt) "1" else "0"
        }
        return (s.toInt(2)).times(s.toInt(2).xor("111111111111".toInt(2)))
    }
}