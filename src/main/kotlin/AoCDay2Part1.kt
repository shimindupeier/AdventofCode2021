object AoCDay2Part1 {
    fun calFinalPosition(list: List<String>): Int {
        val workingList = list.map { it.split(" ") }
        var horizontalCnt = 0
        var depthCnt = 0

        workingList.map {
            val steps = it.last().toInt()
            when (it.first()) {
                "forward" -> horizontalCnt += steps
                "down" -> depthCnt += steps
                "up" -> depthCnt -= steps
            }
        }
        return horizontalCnt.times(depthCnt)
    }
}