object AoCDay1Part1 {
    fun numDepthInc(list: List<Int>) : Int {
        var currDepth = readLine()?.toInt() ?: 0
        var nextDept = readLine()?.toInt() ?: 0
        var countInc = 0
        do {
            if (nextDept > currDepth) countInc += 1
            currDepth = nextDept
            nextDept = readLine()?.toInt() ?: 0
        } while (nextDept != 0)
        return countInc
    }
}