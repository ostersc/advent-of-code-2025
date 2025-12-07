fun main() {
    fun part1(input: List<String>): Int {
        val split = input.indexOfFirst { it.isBlank() }

        val fresh=mutableListOf<LongRange>()
        for (line in input.take(split)){
            val (min,max)=line.split("-")
            fresh.add(min.toLong().rangeTo(max.toLong()))
        }

        val ingrediants=mutableListOf<Long>()
        for (line in input.drop(split + 1)){
            ingrediants.add(line.toLong())
        }

        return ingrediants.count { ingrediant -> fresh.any { range->ingrediant in range } }
    }

    fun part2(input: List<String>): Int =0

    val testInput = readInput("Day05_test")
    val input = readInput("Day05")

    println("part1(test) = ${part1(testInput)} (expected 3)")
    part1(input).println()

    println("part2(test) = ${part2(testInput)} (expected ?)")
    part2(input).println()
}