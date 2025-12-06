fun main() {

    fun parse(input: List<String>): MutableSet<Point2D> =
        input.flatMapIndexed { y, line ->
            line.mapIndexedNotNull { x, char ->
                if (char == '@') Point2D(x, y) else null
            }
        }.toMutableSet()

    fun part1(input: List<String>): Int {
        val rolls = parse(input)
        return rolls.count { roll -> roll.allNeighbors().count { neighbor -> neighbor in rolls } < 4 }
    }

    fun part2(input: List<String>): Int {
        val rolls = parse(input)
        var total = 0

        while (true) {
            val removableRolls = rolls.filter { roll ->
                roll.allNeighbors().count { neighbor -> neighbor in rolls } < 4
            }
            if (removableRolls.isEmpty()) break
            total += removableRolls.size
            rolls.removeAll(removableRolls)
        }
        return total
    }

    val testInput = readInput("Day04_test")
    val input = readInput("Day04")

    println("part1(test) = ${part1(testInput)} (expected 13)")
    part1(input).println()

    println("part2(test) = ${part2(testInput)} (expected 43)")
    part2(input).println()
}