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

    private fun averagePos() = crabPositions.sum().div(crabPositions.size)

    fun calculateFuelPart1() = crabPositions.sumOf { abs(it - sortAndFindMedian()) }

    // to find sum of 1 to n
    private fun gauss(n: Int) : Int {
        return n.times(n + 1).div(2)
    }

    // gauss formula of 1+2+..n
    fun calculateFuelPart2() : Int {
        var steps = 0
        for (i in crabPositions) {
            steps += gauss(abs(i - averagePos()))
        }
        return steps
    }
}