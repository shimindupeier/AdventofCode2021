import java.io.File

class LanternFishCounter {
    private val days = 256
    private val filename =
//        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day6TestSmallSample.txt"
   "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day6Input.txt"
    private val data = File(filename).bufferedReader().readLine()
    private val lanternFirstInitState: List<Int> = data.split("[,]".toRegex()).map { it.toInt() }

    fun digitValue(digit: Int): Int {
        var spawningDigit = digit
        val spawningList = listOf(spawningDigit).toMutableList()
        var numOfNewFish = 0
        var spawned = 0
        for (day in 1..days) {
            spawningList.forEachIndexed { index, i -> spawningList.set(index, i - 1) }
            spawningList.forEachIndexed { index, i -> if (i == -1) spawningList[index] = 6 }
            (1..numOfNewFish).forEach { _ -> spawningList.add(8) }
            numOfNewFish = spawningList.count { it == 0 }

        }
        println("${digit} ->  ${spawningList.size}")
        return spawningList.size
    }

    tailrec  fun recurseThis(remain: List<Pair<Int, Int>>, spawn: Int): Int{
        println("     $spawn")
        if (remain.isEmpty())
            return spawn
        else {

            val head = remain.first()
            val tail = remain.drop(1)
            val days = head.first
            val digit = head.second

            if (days >= digit + 1){
                val updatedPair = Pair(days - digit -1 , 6)
                val newPair = Pair(days - digit -1, 8)
                val newList: List<Pair<Int, Int>> = listOf(updatedPair) + tail + listOf(newPair)
                val newSpawn = spawn + 1
                return recurseThis(newList, newSpawn)
            } else
                return recurseThis(tail, spawn)

        }
    }
    fun spawnExpoGrowth() {
        val v = recurseThis( listOf(Pair(days, 3)), 1)
        println(v)
        val uniqueDigits: Map<Int, Int> = lanternFirstInitState.groupBy { it }.mapValues { it.value.size }
        var fishesSpawn = lanternFirstInitState.size
        println(uniqueDigits)
       // val tmp = uniqueDigits.map{it -> digitValue(it.key) * it.value}.sum()

        val tmp2 = uniqueDigits.map{it -> recurseThis(listOf(Pair(days, it.key)), 1) * it.value}.sum()
        //println(tmp)
        println(tmp2)
//
//        for (i in uniqueDigits) {
//            fishesSpawn += i.value.times(digitValue(i.key))
//        }
//        println(fishesSpawn)
    }

    fun spawnFishes() {
        val spawningList = lanternFirstInitState.toMutableList()
        var numOfNewFish = 0
        for (day in 1..days) {
            spawningList.forEachIndexed { index, i -> spawningList.set(index, i - 1) }
            spawningList.forEachIndexed { index, i -> if (i == -1) spawningList[index] = 6 }
            (1..numOfNewFish).forEach { _ -> spawningList.add(8) }
            numOfNewFish = spawningList.count { it == 0 }
        }
        println(spawningList.size)
    }
}