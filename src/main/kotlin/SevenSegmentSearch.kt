import java.io.File
import java.util.*

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
        val outputSegments: List<List<SortedSet<Char>>> = entries.map { pair -> pair.second.map { item: String -> item.toSortedSet() } }

        val totalSum = entries.map{ entry ->
            val signals = entry.first
            val decodedMap = decode(signals)
            val decodedDigits = entry.second.map { it.toSortedSet() }
                .map { decodedMap[it] }.joinToString("").toInt()
            decodedDigits
        }.sum()
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
        println(totalSum)
//        println(valuesInDigit)
        return -1
    }

    private fun decode(signals: List<String>) : Map<SortedSet<Char>, Int> {
        val one = signals.find { pattern -> pattern.length == 2 }!!.toSortedSet()
        val seven = signals.find { pattern -> pattern.length == 3 }!!.toSortedSet()
        val four = signals.find { pattern -> pattern.length == 4 }!!.toSortedSet()
        val eight = signals.find { pattern -> pattern.length == 7 }!!.toSortedSet()
        val three = signals.map { it.toSortedSet() }.filter { it.size == 5 }
            .find { pattern -> pattern.toSortedSet().subtract(one).size == 3 }!!.toSortedSet()
        val nine = three.union(four).toSortedSet()
        val zero = (three.subtract(four).union(one)).union(eight.subtract(three)).toSortedSet()
        val six = signals.map { it.toSortedSet() }
            .find { pattern -> pattern.size == 6 && pattern != nine && pattern != zero }!!
        val five = signals.map { it.toSortedSet() }.filter { it.size == 5 }
            .filterNot { it == three }
            .find { pattern -> pattern.toSortedSet().intersect(nine) == pattern.toSortedSet() }!!.toSortedSet()
        val two =
            signals.map { it.toSortedSet() }.filter { it.size == 5 }.filterNot { it == five }.filterNot { it == three }
                .first()
        return mapOf(
            one to 1, two to 2, three to 3,
            four to 4, five to 5, six to 6, seven to 7, eight to 8, nine to 9, zero to 0,
        )
    }
}