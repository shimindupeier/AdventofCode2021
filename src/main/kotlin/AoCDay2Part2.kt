object AoCDay2Part2 {
    fun calFinalPosition(list: List<String>): Int {
        val workingList = list.map { it.split(" ") }
        var horizontalCnt = 0
        var depthCnt = 0
        var aim = 0

        workingList.map {
            val steps = it.last().toInt()
            when (it.first()) {
                "forward" -> {horizontalCnt += steps
                                depthCnt += steps.times(aim)}
                "down" -> { aim += steps }
                "up" -> { aim -= steps}
                else -> depthCnt += 0
            }
        }
        return horizontalCnt.times(depthCnt)
    }
}