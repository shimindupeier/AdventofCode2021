import java.io.File
import kotlin.math.abs

class TreacheryOfWhales {
//    private val filename = "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day7TestSmallSample.txt"
    private val filename = "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day7Input.txt"
    private val data = File(filename).bufferedReader().readLine()
    private val crabPositions = data.split("[,]".toRegex()).map { it.toInt() }

    private fun sortAndFindMedian(): Int {
        val sortedPos = crabPositions.sorted()
        val medianInd = sortedPos.size.div(2)

        return sortedPos[medianInd]
    }

    fun calculateFuel() = crabPositions.sumOf { abs(it - sortAndFindMedian()) }
}