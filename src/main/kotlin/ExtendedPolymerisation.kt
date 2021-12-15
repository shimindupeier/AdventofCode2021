import java.io.File

class ExtendedPolymerisation {
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day14Input.txt"
    private val input: List<String> = File(filename).readLines()

    private fun <T> MutableMap<T, Long>.plus(key: T, amount: Long) {
        this[key] = this.getOrDefault(key, 0L) + amount
    }

    // create {NN=1, NC=1, CB=1} template from NNCB
    private fun parseTemplate(input: String): Map<String, Long> =
        input
            .windowed(2)
            .groupingBy { it }
            .eachCount().mapValues { it.value.toLong() }

    // Create map of rules
    private fun parseRules(input: List<String>): Map<String, Char> =
        input.drop(2).associate {
            it.substring(0..1) to it[6]
        }

    fun part2(steps: Int) : Long {
        var template: Map<String, Long> = parseTemplate(input.first())
        val lastChar = input.first().last()
        val rules: Map<String, Char> = parseRules(input)


        println("template: $template")

        println("rules: $rules")
        (1..steps).forEach { _ ->
            val frequencyMap: MutableMap<String, Long> = mutableMapOf()
            val tmp = template.toMutableMap() // {NN=1, NC=1, CB=1}
            tmp.forEach { it ->
                val polymer = rules[it.key].toString()
                val toRight = it.key.first().plus(polymer)
                val toLeft = polymer.plus(it.key.last())
                frequencyMap.plus(toRight, it.value)
                frequencyMap.plus(toLeft, it.value)
            }

            println("updatedMap: $tmp")
            template = frequencyMap
        }
        val groupMap = template.map { it.key.first() to it.value }
            .groupBy({ it.first }, { it.second })
            .mapValues { it.value.sum() + if (it.key == lastChar) 1 else 0 }
        return groupMap.maxOf { it.value }.minus(groupMap.minOf { it.value })
    }

    fun part1(): Long {
        val template: String = input.filterNot { it.contains("->") }.first()
        val insertRules: List<String> = input.filter { it.contains("->") }
        val rulePairs: List<Pair<String, String>> =
            insertRules.map { Pair(it.substringBefore("->").trim(), it.substringAfter("->").trim()) }
        val steps = 10
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
        val sum: Long = polymerGrouping.maxOf { k -> k.value.size.toLong() }
            .minus(polymerGrouping.minOf { k -> k.value.size.toLong() })
        return sum
    }
}




