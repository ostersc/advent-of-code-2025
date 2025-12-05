fun main() {
    fun joltage(bank: String, numBatteries: Int): Long =
        (1..numBatteries).fold("" to 0) { (total, index), battNum ->
           bank.substring(index, bank.length-numBatteries+battNum)
                .withIndex()
                .maxBy { it.value }
                .let { "$total${it.value}" to index+it.index+1 }
        }.first.toLong()

    fun part1(input: List<String>): Long = input.sumOf { joltage(it, 2) }

    fun part2(input: List<String>): Long = input.sumOf { joltage(it, 12) }

    val testInput = readInput("Day03_test")
    val input = readInput("Day03")

    println("part1(test) = ${part1(testInput)} (expected 357)")
    part1(input).println()

    println("part2(test) = ${part2(testInput)} (expected 3121910778619)")
    part2(input).println()
}
