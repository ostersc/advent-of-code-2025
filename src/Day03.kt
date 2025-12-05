fun main() {
    fun part1(input: List<String>): Int =
        input.sumOf { bank ->
            val (firstDigit, index) = bank.dropLast(1)
                .withIndex()
                .maxBy { it.value }
                .let { it.value to it.index }
            val secondDigit= bank.drop(index+1).maxBy { it }

            "$firstDigit$secondDigit".toInt()
        }


    fun part2(input: List<String>): Int = 0

    val testInput = readInput("Day03_test")
    val input = readInput("Day03")

    println("part1(test) = ${part1(testInput)} (expected 357)")
    part1(input).println()

    println("part2(test) = ${part2(testInput)} (expected ?)")
    part2(input).println()
}
