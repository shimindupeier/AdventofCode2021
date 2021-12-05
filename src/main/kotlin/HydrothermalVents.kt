import java.io.File

class HydrothermalVents {
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day5Input.txt"
    private val input = File(filename).bufferedReader().readLines()
        .map { it.split("[\\->]".toRegex()) }.map { listOf(it.first().trim(), it.last().trim()) }
    private val lineSegments = input.map {
        mutableListOf(
            listOf(it.first().substringBefore(",").toInt(), it.first().substringAfter(",").toInt()),
            listOf(it.last().substringBefore(",").toInt(), it.last().substringAfter(",").toInt())
        )
    }

    fun findOverlaps() {
        val g = lineSegments.flatten().groupBy { it }
        val m = g.filter { it.value.size >= 2 }
        println(m.size) // part 1 answer : 7085 ; part 2 answer 20271
    }

    fun drawLines() {
        for (lineSegments in lineSegments) {
            val (x1, y1) = lineSegments.first()
            val (x2, y2) = lineSegments.last()

            lineSegments.clear()
            if (x1 == x2 && y1 != y2) {
                if (y1 < y2) {
                    var yCoordinates = y1
                    for (i in y1..y2) {
                        lineSegments.add(listOf(x1, yCoordinates++))
                    }
                } else {
                    var yCoordinates = y1
                    for (i in y1 downTo y2) {
                        lineSegments.add(listOf(x1, yCoordinates--))
                    }
                }
            } else if (y1 == y2 && x1 != x2) {
                if (x1 < x2) {
                    var xCoordinates = x1
                    for (i in x1..x2) {
                        lineSegments.add(listOf(xCoordinates++, y1))
                    }
                } else {
                    var xCoordinates = x1
                    for (i in x1 downTo x2) {
                        lineSegments.add(listOf(xCoordinates--, y1))
                    }
                }
            } else { // diagonal
                if (x1 < x2 && y1 < y2) {
                    var xCoord = x1
                    var yCoord = y1
                    val diagonalSteps = x2.minus(x1)
                    for (i in 0..diagonalSteps) {
                        lineSegments.add(listOf(xCoord++, yCoord++))
                    }
                } else if (x1 > x2 && y1 > y2) {
                    var xCoord = x1
                    var yCoord = y1
                    val diagonalSteps = x1.minus(x2)
                    for (i in 0..diagonalSteps) {
                        lineSegments.add(listOf(xCoord--, yCoord--))
                    }
                } else if (x1 > x2 && y1 < y2) {
                    var xCoord = x1
                    var yCoord = y1
                    val diagonalSteps = x1.minus(x2)
                    for (i in 0..diagonalSteps) {
                        lineSegments.add(listOf(xCoord--, yCoord++))
                    }
                } else if (x1 < x2 && y1 > y2) {
                    var xCoord = x1
                    var yCoord = y1
                    val diagonalSteps = x2.minus(x1)
                    for (i in 0..diagonalSteps) {
                        lineSegments.add(listOf(xCoord++, yCoord--))
                    }
                }
            }
        }
        lineSegments.filter { it.isNotEmpty() }
    }
}