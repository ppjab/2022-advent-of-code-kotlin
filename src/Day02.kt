import Move.*
import Outcome.*
import java.lang.IllegalArgumentException

typealias Rounds = List<Pair<String, String>>

enum class Move {
    ROCK,
    PAPER,
    SCISSOR;

    infix fun vs(opponentPick: Move): Int {
        when (this) {
            ROCK -> return when (opponentPick) {
                ROCK -> 4
                PAPER -> 1
                SCISSOR -> 7
            }

            PAPER -> return when (opponentPick) {
                ROCK -> 8
                PAPER -> 5
                SCISSOR -> 2
            }

            SCISSOR -> return when (opponentPick) {
                ROCK -> 3
                PAPER -> 9
                SCISSOR -> 6
            }
        }
    }

    infix fun and(outcome: Outcome): Int {
        when (this) {
            ROCK -> return when (outcome) {
                WIN -> 8
                DRAW -> 4
                LOSE -> 3
            }

            PAPER -> return when (outcome) {
                WIN -> 9
                DRAW -> 5
                LOSE -> 1
            }

            SCISSOR -> return when (outcome) {
                WIN -> 7
                DRAW -> 6
                LOSE -> 2
            }
        }
    }

}

enum class Outcome {
    WIN, DRAW, LOSE
}

private fun parseRounds(input: List<String>): Rounds =
    input
        .map { it.split(" ") }
        .map { it[0] to it[1] }

fun parseMoves(input: String): Move =
    when (input) {
        "X", "A" -> ROCK
        "Y", "B" -> PAPER
        "Z", "C" -> SCISSOR
        else -> throw IllegalArgumentException("Unacceptable input")
    }

fun parseOutcomes(input: String): Outcome =
    when (input) {
        "X" -> LOSE
        "Y" -> DRAW
        "Z" -> WIN
        else -> throw IllegalArgumentException("Unacceptable input")
    }

fun part1(input: Rounds): Int =
    input
        .map { (oppMove, myMove) -> parseMoves(myMove) to parseMoves(oppMove) }
        .sumOf { (myMove, oppMove) -> myMove vs oppMove }

fun part2(input: Rounds): Int =
    input
        .map { (oppMove, outcome) -> parseMoves(oppMove) to parseOutcomes(outcome) }
        .sumOf { (oppMove, outcome) -> oppMove and outcome }

fun main() {
    val input = parseRounds(readInput("Day02"))
    println(part1(input))
    println(part2(input))
}