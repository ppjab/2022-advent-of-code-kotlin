import Day04.part1
import Day04.part2

object Day04 {

    fun part1(input: List<String>) =
        input
            .map { it.split(",") }
            .map { it[0].convertToRange() to it[1].convertToRange() }
            .count { (a, b) -> (a.first in b && a.last in b) || (b.first in a && b.last in a) }
            .also { println(it) }


    fun part2(input: List<String>) =
        input
            .map { it.split(",") }
            .map { it[0].convertToRange() to it[1].convertToRange() }
            .count { (a, b) -> (a.first <= b.last && b.first <= a.last) }
            .also { println(it) }

    private fun String.convertToRange(): IntRange {
        val (start, end) = split("-").map(String::toInt)
        return start..end
    }
}


fun main() {
    val input = readInput("Day04")
    val testInput = readInput("Day04_test")

    part1(testInput)
    part1(input)
    part2(testInput)
    part2(input)
}