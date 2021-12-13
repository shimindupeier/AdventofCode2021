import java.io.File

class TransparentOrigami {
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day13Input.txt"
    private val inputLines: List<String> = File(filename).readLines()

//    fun part1(): Int {
//        val foldInstructions: List<String> = inputLines.filter { it.contains("=") }
//            .map { f -> f.split(" ").last() }
//        val dotPositions: List<List<String>> = inputLines.filter { it.contains(",") }
//            .map { c -> c.split("\\n".toRegex()) }
//        val pair: List<Pair<Int, Int>> = dotPositions
//            .map { Pair(it.first().substringBefore(",").toInt(), it.first().substringAfter(",").toInt()) }
//
//        val temp = foldInstructions.map {
//                foldByY(it.substringAfter("=").toInt(), pair)
//        }
//        display(pair)
//        return temp.first()
//    }

    fun part2(): Int {
        val foldInstructions: List<String> = inputLines.filter { it.contains("=") }
            .map { f -> f.split(" ").last() }
        val dotPositions: List<List<String>> = inputLines.filter { it.contains(",") }
            .map { c -> c.split("\\n".toRegex()) }
        val pair: Set<Pair<Int, Int>> = dotPositions
            .map { Pair(it.first().substringBefore(",").toInt(), it.first().substringAfter(",").toInt()) }.toSet()

        val temp = foldInstructions.fold(pair) { updatedCoordList, ele ->
            foldByY(ele.substringBefore("="), ele.substringAfter("=").toInt(), updatedCoordList)
        }
        display(temp)
        return temp.size
    }

    private fun display(coordinate: Set<Pair<Int, Int>>) {
        val maxX = coordinate.maxOf { it.first }
        val maxY = coordinate.maxOf { it.second }

        for (r in 0..maxY) {
            for (c in 0..maxX) {
                if (Pair(c, r) in coordinate)
                    print("#")
                else
                    print(".")
            }
            println()
        }
    }

    private fun foldByY(line: String, lineNum: Int, dp: Set<Pair<Int, Int>>): Set<Pair<Int, Int>> {
        val setDots = mutableSetOf<Pair<Int, Int>>()
        if (line == "y") {
            val temp = dp.filter { c -> c.second > lineNum }
            val temp2 = temp.map {
                val distFromFold = it.second.minus(lineNum)
                Pair(it.first, lineNum.minus(distFromFold))
            }
            setDots.addAll(temp2)
            setDots.addAll(dp.filter { c -> c.second < lineNum })
        } else {
            val temp = dp.filter { c -> c.first > lineNum }
            val temp2 = temp.map {
                val distFromFold = it.first.minus(lineNum)
                Pair(lineNum.minus(distFromFold), it.second)
            }
            setDots.addAll(temp2)
            setDots.addAll(dp.filter { c -> c.first < lineNum })
        }
        return setDots
    }
}