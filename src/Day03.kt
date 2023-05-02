import Day03.part1
import Day03.part2

object Day03 {
    private val prioritiesMap = (('a'..'z') + ('A'..'Z')).zip((1..57)).toMap()

    fun part1(input: List<String>) = input
        .map { it.substring(0, it.length / 2) to it.substring(it.length / 2) }
        .map { (first, second) -> first.toSet() to second.toSet() }
        .flatMap { (first, second) -> first intersect second }
        .sumOf { prioritiesMap[it] ?: 0 }
        .also { println(it) }

    fun part2(input: List<String>) = input
        .chunked(3)
        .map { it.map(String::toSet) }
        .flatMap { it.reduce(Set<Char>::intersect) }
        .sumOf { prioritiesMap[it] ?: 0 }
        .also { println(it) }
}

fun main() {
    val realInput = readInput("Day03")

    part1(realInput)
    part2(realInput)
}