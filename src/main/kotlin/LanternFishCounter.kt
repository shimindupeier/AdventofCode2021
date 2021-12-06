import java.io.File

class LanternFishCounter {
    private val days = 18
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day6Input.txt"
    private val data = File(filename).bufferedReader().readLine()
    private val lanternFirstInitState = data.split("[,]".toRegex()).map { it.toInt() }

    fun spawnFishes() {
        val spawningList = lanternFirstInitState.toMutableList()

        for (day in 1 .. days) {
            if (spawningList.contains(0)) {
                val newFish = spawningList.count { it == 0 }
                (1..newFish).forEach { _ -> spawningList.add(9) }
                spawningList.mapIndexed { index, i -> if (i == 0) spawningList[index] = 7 }
            }
            spawningList.mapIndexed { index, i -> spawningList.set(index, i-1) }
        }
        println(spawningList.size)
    }
}