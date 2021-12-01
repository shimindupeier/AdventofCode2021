object AoCDay1Part1 {
    fun numDepthInc(list: List<Int>) : Int {
        var countInc = 0
        list.windowed(2, 1, false).map { if (it.first() < it.last()) countInc += 1 }
        return countInc
    }
}