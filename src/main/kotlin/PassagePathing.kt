import java.io.File

class PassagePathing {
    private val filename =
        "C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day12TestSmallSample.txt"

    fun part1(): Int {
        val caveConnections: List<Pair<String, String>> = File(filename).readLines()
            .map { str ->
                Pair(str.split("-".toRegex()).map { it }.component1(), str.split("-".toRegex()).map { it }.component2())
            }

        val pathsToProcess = listOf(listOf("start"))
        val completePath = emptyList<List<String>>()
        printData(caveConnections)
        val fromTo = findFromTo(caveConnections)
        return findPaths(fromTo, pathsToProcess, completePath).size
    }

    tailrec private fun findPaths(
        fromTo: Map<String, List<String>>,
        pathsToProcess: List<List<String>>,
        completePath: List<List<String>>
    ): List<List<String>> {

        return if (pathsToProcess.isEmpty())
            completePath
        else {
            val path: List<String> = pathsToProcess.first()
            val lastPos = path.last()
            val pair = fromTo[lastPos]!!.map { path + it }.filter { !isInValidPath(it) }.partition { it.last() == "end" }
            val completedPath = pair.first + completePath
            val incompletePath = pair.second + pathsToProcess.drop(1)
            findPaths(fromTo, incompletePath, completedPath)
        }
    }

    private fun isValidPath(path: List<String>) : Boolean {
        val dd = path.filter { it == it.lowercase() }.groupBy { it }
        return dd.values.all { it.size == 1 }
    }

    private fun isInValidPath(path: List<String>) : Boolean {
        val dd = path.filter { it == it.lowercase() }.groupBy { it }
        return if ( dd["start"]!!.size > 1 ) true
        else {
            dd.filter { it.value.size > 1 }.size > 1 || dd.filter { it.value.size > 2 }.size > 0
        }

    }

    private fun findFromTo(caves: List<Pair<String, String>>): Map<String, List<String>> {
        val fromTo: MutableMap<String, List<String>> = mutableMapOf()
        caves.forEach {
            val l = it.first
            val r = it.second
            fromTo[l] = fromTo.getOrDefault(l, emptyList()) + r
            fromTo[r] = fromTo.getOrDefault(r, emptyList()) + l
        }
        fromTo.remove("end")
        return fromTo
    }

    private fun printData(obj: List<Pair<String, String>>) {
        println(obj)
    }
}