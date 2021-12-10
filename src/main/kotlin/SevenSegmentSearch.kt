import java.io.File

class SevenSegmentSearch {
    private val fileName =
//        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day8TestSmallSample.txt"
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day8Input.txt"
    private val data = File(fileName).bufferedReader().readLines().map { it.split("|") }
    private val signalPatterns =
        data.map { Pair(it.first().trim().split(" "), it.last().trim().split(" ")) }
    private val uniqueSegment = listOf(2,4,3,7)

    fun part1() = signalPatterns.sumOf { list -> list.second.count { uniqueSegment.contains(it.length) } }
}