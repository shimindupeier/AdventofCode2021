import java.io.File

fun main() {
    val list3 = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day3Input.txt").readLines().toList()
    println(AoCDay3Part1.powerConsumption(list3))
    println(AoCDay3Part2.calLifeSupportRating(list3))

//    val list2 = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day2Input.txt").readLines().toList()
//    println(AoCDay2Part2.calFinalPosition(list2))

//    val list = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\depth measurement.txt").readLines().map { it.toInt() }.toList()
//    println(AoCDay1Part1.numDepthInc(list))
//    println(AoCDay1Part2.numDeptIncP2(list))

}