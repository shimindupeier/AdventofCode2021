object AoCDay2Part1 {
    fun calFinalPosition(list: List<String>): Int {
        val workingList = list.map { it.split(" ") }
        var horizontalCnt = 0
        var depthCnt = 0

        workingList.map {
            val dir = it.first()
            val steps = it.last().toInt()
            when (dir) {
                "forward" -> horizontalCnt += steps
                "down" -> depthCnt += steps
                "up" -> depthCnt -= steps
                else -> depthCnt += 0
            }
        }
        return horizontalCnt.times(depthCnt)
    }
}