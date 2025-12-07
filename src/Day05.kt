fun main() {
    fun part1(input: List<String>): Int {
        val split = input.indexOfFirst { it.isBlank() }

        val freshRanges=input.take(split).map {
            line->
                val (min,max)=line.split("-")
                min.toLong()..max.toLong()
        }

        return input.drop(split + 1).count { ingrediant -> freshRanges.any { range->ingrediant.toLong() in range } }
    }

    fun part2(input: List<String>): Int =0

    val testInput = readInput("Day05_test")
    val input = readInput("Day05")

    println("part1(test) = ${part1(testInput)} (expected 3)")
    part1(input).println()

    println("part2(test) = ${part2(testInput)} (expected ?)")
    part2(input).println()
}