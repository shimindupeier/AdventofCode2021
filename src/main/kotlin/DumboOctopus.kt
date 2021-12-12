import java.io.File

class DumboOctopus(private val size: Int) {
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day11TestSmallSample.txt"
    private var octopusesGrid: List<List<Int>> = File(filename).readLines()
        .map { str -> str.split("(?<=\\d)(?=\\d)".toRegex()).map { it.toInt() }.toList() }

    fun part1(steps: Int) : Int {
        var octopusesGrid: List<List<Int>> = File(filename).readLines()
            .map { str -> str.split("(?<=\\d)(?=\\d)".toRegex()).map { it.toInt() }.toList() }
        var totalFlashes = 0
        for (step in 1..steps) {
            val gridPlusOne =
                (0 until size).map { r ->
                    (0 until size).map { c -> octopusesGrid[r][c] + 1 }
                }
            printMatrix(octopusesGrid)
            printMatrix(gridPlusOne)
            val pair = stepB(gridPlusOne, 0)
            totalFlashes += pair.first
            octopusesGrid = pair.second
            println(pair.first)
        }
        return totalFlashes
    }

    fun part2() : Int {
        var octopusesGrid: List<List<Int>> = File(filename).readLines()
            .map { str -> str.split("(?<=\\d)(?=\\d)".toRegex()).map { it.toInt() }.toList() }
        var steps = 0
        while (true) {
            val gridPlusOne =
                (0 until size).map { r ->
                    (0 until size).map { c -> octopusesGrid[r][c] + 1 }
                }
            printMatrix(octopusesGrid)
            printMatrix(gridPlusOne)
            val pair = stepB(gridPlusOne, 0)
            steps = steps.inc()
            octopusesGrid = pair.second
            if (pair.second.flatten().all { it == 0 }) {
                println("break $steps")
                break
            }
            println(pair.first)
        }
        return steps
    }

    private fun stepB(gridPlusOne: List<List<Int>>, flashes: Int): Pair<Int, List<List<Int>>> {

        val posToReset: List<Pair<Int, Int>> =
            (0 until size).flatMap { r ->
                (0 until size).map { c -> Pair(Pair(r, c), gridPlusOne[r][c]) }.filter { it.second > 9 }
                    .map { it.first }
            }

        val updatedGrid: List<List<Int>> =
            (0 until size).map { r ->
                (0 until size).map { c ->
                    val coord = (genCoord(r, c, size))
                        .filter { gridPlusOne[it.first][it.second] > 9 }.size
                    if (gridPlusOne[r][c] == 0) 0 else gridPlusOne[r][c] + coord
                }
            }

        printMatrix(updatedGrid)
        val updatedGridReset: List<List<Int>> =
            (0 until size).map { r ->
                (0 until size).map { c -> if (posToReset.contains(Pair(r, c))) 0 else updatedGrid[r][c] }
            }

        printMatrix(updatedGridReset)
        return if (shouldStop(updatedGridReset))
            Pair(flashes + posToReset.size, updatedGridReset)
        else {
            stepB(updatedGridReset, flashes + posToReset.size)
        }
    }

    private fun shouldStop(grid: List<List<Int>>) = grid.flatten().all { it < 10 }

    private fun genCoord(r: Int, c: Int, size: Int): List<Pair<Int, Int>> =
        (-1..1).flatMap { x -> (-1..1).map { y -> Pair(x + r, y + c) } }
            .filterNot { it == Pair(r, c) }
            .filterNot { it.first < 0 || it.second < 0 }
            .filterNot { it.first >= size || it.second >= size }

    private fun printMatrix(grid: List<List<Int>>) {
        for (row in grid) {
            println(row.joinToString(" "))
        }
        println()
    }

    fun printIntArray(grid: List<IntArray>) {
        for (row in grid) {
            println(row.joinToString(" "))
        }
        println()
    }
}