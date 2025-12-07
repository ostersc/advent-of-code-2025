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

    fun part2(input: List<String>): Long {
        val freshRanges=input.takeWhile { it.isNotBlank() }.map {
                line->
            val (min,max)=line.split("-")
            min.toLong()..max.toLong()
        }

        return freshRanges.sortedBy { it.first }.fold(mutableListOf<LongRange>() ){acc, range->
            if(acc.isEmpty()){
                acc.add(range)
            }else{
                if(acc.last().last < range.first){
                    acc.add(range)
                }else if(acc.last().last< range.last){
                    acc[acc.size-1]=acc.last().first ..  range.last
                }
            }
            acc
        }.sumOf { it.last-it.first +1 }



    }

    val testInput = readInput("Day05_test")
    val input = readInput("Day05")

    println("part1(test) = ${part1(testInput)} (expected 3)")
    part1(input).println()

    println("part2(test) = ${part2(testInput)} (expected 14)")
    part2(input).println()
}