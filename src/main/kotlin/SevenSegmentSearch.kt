import java.io.File

class SevenSegmentSearch {
    private val fileName =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day8TestSmallSample.txt"

    //       "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day8Input.txt"
    private val data = File(fileName).bufferedReader().readLines().map { it.split("|") }
    private val entries =
        data.map { Pair(it.first().trim().split(" "), it.last().trim().split(" ")) }
    private val uniqueSegment = listOf(2, 4, 3, 7)

    fun numberOfUniqueInstances() = entries.sumOf { list -> list.second.count { uniqueSegment.contains(it.length) } }

    fun part2(): Int {
//        println(entry.map { it.second.map { output -> output.toSet() } })
        val outputValues = mutableListOf<Int>()
        val signalPatterns = entries.map { pair -> pair.first.map { item: String -> item.toSortedSet() } }
        val outputSegments = entries.map { pair -> pair.second.map { item: String -> item.toSortedSet() } }

        for (entry in entries) {
            val signals = entry.first
            val one = signals.find { pattern -> pattern.length == 2 }!!.toSortedSet()
            val seven = signals.find { pattern -> pattern.length == 3 }!!.toSortedSet()
            val four = signals.find { pattern -> pattern.length == 4 }!!.toSortedSet()
            val eight = signals.find { pattern -> pattern.length== 7 }!!.toSortedSet()
            val three = signals.find { pattern -> pattern.toSortedSet().subtract(one).size == 3 }!!.toSortedSet()
            val nine = three.union(four).toSortedSet()
            val zero = (three.subtract(four).union(one)).union(eight.subtract(three)).toSortedSet()
            val six = signals.find { pattern -> pattern.length == 6 }!!.toSortedSet()
            val five = signals.find { pattern -> pattern.toSortedSet().subtract(nine).size == 1 }!!.toSortedSet()
            val two = signals.find() {pattern -> pattern.toSortedSet().subtract(three).size == 2}!!.toSortedSet()
            println(five)
        }
        /*val valuesInDigit = outputSegments.map { valueSets -> valueSets
                                            .map {
                                                when {
                                                    it.size == 2 -> 1
                                                    it.size == 4 -> 4
                                                    it.size == 3 -> 7
                                                    it.size == 7 -> 8
                                                    it.size == 5 -> {
                                                        when {
                                                            it.containsAll("agd".toSet()) -> 2
                                                            it.containsAll("cba".toSet()) -> 3
                                                            it.containsAll("bgc".toSet()) -> 5
                                                            else -> ""
                                                        }
                                                    }
                                                    it.size == 6 -> {
                                                        when {
                                                            it.intersect("ab".toSet()).size == 1 -> 6
                                                            it.intersect("ab".toSet()).size == 2 -> 9
                                                            else -> 0
                                                        }
                                                    }
                                                    else -> ""
                                                }
                                            }
                            }.joinToString()*/
        println(signalPatterns)
//        println(valuesInDigit)
        return -1
    }
}