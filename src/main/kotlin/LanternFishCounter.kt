import java.io.File

class LanternFishCounter {
    private val days = 18
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day6TestSmallSample.txt"
    private val data = File(filename).bufferedReader().readLine()
    private val lanternFirstInitState = data.split("[,]".toRegex()).map { it.toInt() }

    fun spawnFishes() {
        val spawningList = lanternFirstInitState.toMutableList()
        var numOfNewFish = 0
        for (day in 1..days) {
            spawningList.mapIndexed { index, i -> spawningList.set(index, i - 1) }
            spawningList.mapIndexed { index, i -> if (i == -1) spawningList[index] = 6 }
            (1..numOfNewFish).forEach { _ -> spawningList.add(8) }
            numOfNewFish = spawningList.count { it == 0 }
        }
        println(spawningList.size)
    }
}