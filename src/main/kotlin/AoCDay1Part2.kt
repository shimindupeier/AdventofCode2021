object AoCDay1Part2 {
    fun numDeptIncP2(list: List<Int>) : Int {
        val windowSize = 3
        var countInc = 0
        list.windowed(windowSize, 1, false).map { it.sum() }
            .windowed(2, 1, false)
            .map { if (it.first() < it.last()) countInc += 1 }
        return countInc
    }
}