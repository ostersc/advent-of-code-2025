fun sumInvalidSerials(input: List<String>, halfOnly: Boolean): Long =
    input.first().split(",").sumOf { range ->
        val (start, end) = range.split("-").map(String::toLong)
        (start..end).sumOf { serial ->
            val s = serial.toString()
            val mid = s.length / 2
            if (halfOnly) {
                // check if the first half equals the second half
                val isInvalid = s.length % 2 == 0 && s.take(mid) == s.drop(mid)
                if (isInvalid) serial else 0L
            } else {
                var isInvalid = false
                // check each divisor length for repeats of that segment equals all others
                for (div in 1..(mid)) {
                    if (s.length % div == 0) {
                        val segment = s.substring(0, div)
                        val repeated = segment.repeat(s.length / div)
                        if (repeated == s) {
                            isInvalid = true
                            break
                        }
                    }
                }
                if (isInvalid) serial else 0L
            }
        }
    }

fun part1(input: List<String>): Long = sumInvalidSerials(input, true)

fun part2(input: List<String>): Long = sumInvalidSerials(input, false)


fun main() {
    val testInput = readInput("Day02_test")
    val input = readInput("Day02")

    println("part1(test) = ${part1(testInput)} (expected 1227775554)")
    part1(input).println()

    println("part2(test) = ${part2(testInput)} (expected ?)")
    part2(input).println()
}
