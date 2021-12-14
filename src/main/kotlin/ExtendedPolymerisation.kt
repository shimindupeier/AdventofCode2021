import java.io.File

class ExtendedPolymerisation {
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day14Input.txt"
    private val input: List<String> = File(filename).readLines()

    fun part1(): Long {
        val template: String = input.filterNot { it.contains("->") }.first()
        val insertRules: List<String> = input.filter { it.contains("->") }
        val rulePairs: List<Pair<String, String>> =
            insertRules.map { Pair(it.substringBefore("->").trim(), it.substringAfter("->").trim()) }
        val steps = 20
        var startPoint = template
        var polymer = ""
        (1..steps).forEach { _ ->
            polymer = ""
            while (startPoint.length > 1) {
                val rule: List<Pair<String, String>> =
                    rulePairs.filter { it.first.contentEquals(startPoint.substring(0, 2)) }
                val letterToInsert = rule.first().second
                polymer += if (startPoint.length > 2)
                    startPoint.replaceRange(1, 1, letterToInsert).substring(0, 2)
                else
                    startPoint.replaceRange(1, 1, letterToInsert)
                startPoint = startPoint.drop(1)
            }
            startPoint = polymer
        }
        val polymerGrouping: Map<Char, List<Char>> = polymer.toList().groupBy { it }
        val sum = polymerGrouping.maxOf { k -> k.value.size }
            .minus(polymerGrouping.minOf { k -> k.value.size })
        println(sum)
        return sum.toLong()
    }
}