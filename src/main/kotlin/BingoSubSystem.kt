import java.io.File
import kotlin.system.exitProcess

class BingoSubSystem() {
    private val fileName =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day4Input.txt"
    private val bingoNum = File(fileName).bufferedReader().use { it.readLine() }.split(",").map { it.toInt() }.toList()
    private val boardList = File(fileName).bufferedReader().useLines { it.toList() }.drop(2)
    private val boardFilterList = boardList.filter { it.isNotBlank() }.windowed(5, 5)
        .map { it.map { i -> i.split("(?<=\\d)(?=\\s)".toRegex()) } }
    private val bingoBoards = boardFilterList.map { i -> i.map { j -> j.map { it.trim().toInt() } } }.toMutableList()

    /* AoCDay4Part1 */
    fun playBingo() {
        val drawnNumbers = bingoNum.take(4).toMutableSet()
        val remBList = bingoNum.drop(4)
        for (elem in remBList) {
            drawnNumbers.add(elem)
            for (board in bingoBoards) {
                val rows = board.map { it.toSet() }
                val cols = (0 until 5).map { c -> (0 until 5).map { r -> board[r][c] }.toSet() }
                val allRowsCols = rows + cols
                val boardSet = allRowsCols.flatten().toSet()

                for (rowCol in allRowsCols) {
                    if (rowCol.intersect(drawnNumbers).size == 5) {
                        val numNotDrawn = boardSet - drawnNumbers
                        val sumNumNotDrawn = numNotDrawn.sum()
                        val output = sumNumNotDrawn * elem
                        println(output)
                        exitProcess(-1)
                    }
                }
            }
        }
    }

    /* AoCDay4Part2 */
    fun letSquidWin() {
        val winnersSoFar = mutableSetOf<Int>()
        val drawnNumbers = bingoNum.take(4).toMutableSet()
        val remBList = bingoNum.drop(4)
        for (elem in remBList) {
            drawnNumbers.add(elem)
            for ((index, board) in bingoBoards.withIndex()) {
                val rows = board.map { it.toSet() }
                val cols = (0 until 5).map { c -> (0 until 5).map { r -> board[r][c] }.toSet() }
                val allRowsCols = rows + cols
                val boardSet = allRowsCols.flatten().toSet()

                for (rowCol in allRowsCols) {
                    if (rowCol.intersect(drawnNumbers).size == 5) {
                        val numNotDrawn = boardSet - drawnNumbers
                        val sumNumNotDrawn = numNotDrawn.sum()
                        val output = sumNumNotDrawn * elem
                        winnersSoFar.add(index)
                        if (winnersSoFar.size == bingoBoards.size) {
                            println(output)
                        exitProcess(-1)}
                    }
                }
            }
        }
    }
}