fun main() {

    fun turn(dial: Int, direction: Char, amount: Int): Int {
        return when (direction) {
            'L' -> if(dial-amount < 0) {dial - amount + 100} else {dial - amount}
            'R' -> if(dial+amount >= 100) {dial + amount - 100} else{ dial + amount}
            else -> amount
        }
    }

    fun part1(input: List<String>): Int {
        var dial=50
        var zeros=0
        for (line in input) {
            val direction = line.first()
            val amount = line.substring(1).toInt() % 100
            val newDial = turn(dial, direction, amount)
            check(newDial>=0 && newDial<100)
            //println("From $dial turn $direction $amount to $newDial")
            dial=newDial
            if (dial==0) {
                zeros+=1
            }
        }
        return zeros
    }

    fun part2(input: List<String>): Int {
        var dial=50
        var zeros=0
        for (line in input) {
            val direction = line.first()
            val num = line.substring(1).toInt()
            val amount = num % 100
            val multiple = kotlin.math.floor(num / 100.0).toInt()
            val newDial = turn(dial, direction, amount)
            check(newDial>=0 && newDial<100)
            //println("From $dial turn $direction $amount to $newDial")
            if (direction=='L' && (newDial > dial || newDial==0 ) && dial!=0) {
                zeros+=1
            }else if (direction=='R' && (newDial < dial || newDial==0) && dial!=0) {
                zeros+=1
            }

            if(multiple>0){
                zeros+=multiple
            }
            dial=newDial
            //println("Zero count: $zeros")
        }
        return zeros
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    val input = readInput("Day01")

    check(part1(testInput) == 3)
    part1(input).println()

    check(part2(testInput) == 6)
    part2(input).println()
}
