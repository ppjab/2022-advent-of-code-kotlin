object Day01 {
    private fun backpacksKcalList(input: List<String>): List<Int> = buildList {
        var backpack = 0
        for (i in input.indices) {
            if (input[i].isNotEmpty()) {
                backpack += input[i].toInt()
                if (i == input.lastIndex) {
                    add(backpack)
                }
            } else {
                add(backpack)
                backpack = 0
            }
        }
    }

    fun part1(input: List<String>): Int = backpacksKcalList(input).max()

    fun part2(input: List<String>): Int = backpacksKcalList(input).sortedDescending().take(3).sum()
}

fun main() {
    val input = readInput("Day01")
    Day01.part1(input).println()
    Day01.part2(input).println()
}
