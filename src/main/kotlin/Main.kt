import java.io.File

fun main() {
    val list = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\depth measurement.txt").readLines().map { it.toInt() }.toList()
    println(AoCDay1Part1.numDepthInc(list))
    println(AoCDay1Part2.numDeptIncP2(list))
}