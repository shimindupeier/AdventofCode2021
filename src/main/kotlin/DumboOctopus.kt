import java.io.File

class DumboOctopus(private val steps: Int, private val size: Int) {
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day11TestSmallSample.txt"
    private val octopusesGrid = File(filename).readLines()
        .map { str -> str.split("(?<=\\d)(?=\\d)".toRegex()).map { it.toInt() }.toIntArray() }

    fun countFlashes(): Int {
        var flashCount = 0
        for (step in 1..steps) {
            for (row in 0 until size) {
                for (col in 0 until size) {
                    octopusesGrid[row][col]++
                    val counter = octopusesGrid[row][col]
                    try {
                        if (counter > 9) {
                            flashCount++
                            when {
                                row == 0 && col == 0 -> octopusesGrid[row][col.inc()]++
                                row == 0 -> {
                                    octopusesGrid[row][col.dec()]++
                                    if (col < size) octopusesGrid[row][col.inc()]++
                                    (0 until 3).forEach {
                                        octopusesGrid[row.inc()][col.dec().plus(it)]++
                                    }
                                }
                                col == 0 -> {
                                    octopusesGrid[row.dec()][col]++
                                    if (row < size) octopusesGrid[row.inc()][col]++
                                    (0 until 3).forEach {
                                        octopusesGrid[row.dec().plus(it)][col.inc()]++
                                    }
                                }
                                else -> {
                                    (0 until 3).forEach {
                                        if (col < size) {
                                            octopusesGrid[row.dec()][col.dec().plus(it)]++
                                        }
                                    }
                                    (0 until 3).forEach {
                                        octopusesGrid[row.inc()][col.dec().plus(it)]++
                                    }
                                    octopusesGrid[row][col.dec()]++
                                    octopusesGrid[row][col.inc()]++
                                }
                            }
                            octopusesGrid[row][col] = 0
                        }
                    } catch (e: ArrayIndexOutOfBoundsException) {
                        continue
                    } catch (i: IndexOutOfBoundsException) {
                        continue
                    }
                }
            }
        }
        return flashCount
    }
}