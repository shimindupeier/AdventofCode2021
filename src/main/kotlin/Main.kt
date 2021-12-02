import java.io.File

fun main() {
//    val list = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\depth measurement.txt").readLines().map { it.toInt() }.toList()
//    println(AoCDay1Part1.numDepthInc(list))
//    println(AoCDay1Part2.numDeptIncP2(list))

    val list2 = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day2Input.txt").readLines().toList()
    println(AoCDay2Part1.calFinalPosition(list2))
}