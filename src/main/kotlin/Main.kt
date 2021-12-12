fun main() {
// LANTERN2().main()

    val dumboOctopus = DumboOctopus(10)
    check(dumboOctopus.part2() == 195)
    check(dumboOctopus.part1(100) == 1656)

//    val sevenSegmentSearch = SevenSegmentSearch()
//    println(sevenSegmentSearch.part2())

//    val treacheryOfWhales = TreacheryOfWhales()
//    println(treacheryOfWhales.calculateFuelPart1())
//    println(treacheryOfWhales.calculateFuelPart2())

//    val lanternFishCounter = LanternFishCounter()
//    lanternFishCounter.spawnFishes()
//    lanternFishCounter.spawnExpoGrowth()
//    lanternFishCounter.exponentialGrowth()

//    val hydrothermalVents = HydrothermalVents()
//    hydrothermalVents.drawLines()
//    hydrothermalVents.findOverlaps()
//    val bingo = BingoSubSystem()
//    bingo.playBingo()
//    bingo.letSquidWin()
//    val list3 = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day3Input.txt").readLines().toList()
//    println(AoCDay3Part1.powerConsumption(list3))
//    println(AoCDay3Part2.calLifeSupportRating(list3))

//    val list2 = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\day2Input.txt").readLines().toList()
//    println(AoCDay2Part2.calFinalPosition(list2))

//    val list = File("C:\\Users\\jasminedupre\\IdeaProjects\\AdventOfCode2021\\src\\main\\resources\\depth measurement.txt").readLines().map { it.toInt() }.toList()
//    println(AoCDay1Part1.numDepthInc(list))
//    println(AoCDay1Part2.numDeptIncP2(list))

}


/*

3,4,3,1,2
day 0 -> +0

no of days  == 1
initial digit = x
 if ( x + 1 > no of days) ==> spawn

 no of days  =      2               5                14
 `                  0               1  (1)

 3  initial
 2  day 1
 1
 0
 6 spanws   8
 5          7
 4          6
 3          5
 2          4
 1          3
0           2
6 spawns    1
5           0
4           6
3
2
1
0


               3,4,3,1,2 => 0
After  1 day:  2,3,2,0,1
After  2 days: 1,2,1,6,0,8
After  3 days: 0,1,0,5,6,7,8
After  4 days: 6,0,6,4,5,6,7,8,8
After  5 days: 5,6,5,3,4,5,6,7,7,8
After  6 days: 4,5,4,2,3,4,5,6,6,7
After  7 days: 3,4,3,1,2,3,4,5,5,6
After  8 days: 2,3,2,0,1,2,3,4,4,5
After  9 days: 1,2,1,6,0,1,2,3,3,4,8
After 10 days: 0,1,0,5,6,0,1,2,2,3,7,8
After 11 days: 6,0,6,4,5,6,0,1,1,2,6,7,8,8,8
After 12 days: 5,6,5,3,4,5,6,0,0,1,5,6,7,7,7,8,8
After 13 days: 4,5,4,2,3,4,5,6,6,0,4,5,6,6,6,7,7,8,8
After 14 days: 3,4,3,1,2,3,4,5,5,6,3,4,5,5,5,6,6,7,7,8
After 15 days: 2,3,2,0,1,2,3,4,4,5,2,3,4,4,4,5,5,6,6,7
After 16 days: 1,2,1,6,0,1,2,3,3,4,1,2,3,3,3,4,4,5,5,6,8
After 17 days: 0,1,0,5,6,0,1,2,2,3,0,1,2,2,2,3,3,4,4,5,7,8
After 18 days: 6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8


 */