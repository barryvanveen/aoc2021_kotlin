fun main(args: Array<String>) {
    val input = Input().convertStringToInt(
        Input().readFile("day1.txt")
    );

    part1(input);
    part2(input);
}

fun part1(input: List<Int>) {
    val increments = input.windowed(2, 1, false)
        .fold(0) {
            result, window -> result + (window[0] < window[1]).toInt()
        }

    println("Part 1: ${increments}");
}

fun part2(input: List<Int>) {
    var increments = input.windowed(3, 1, false)
        .map { window -> window.sum() }
        .windowed(2, 1, false)
        .fold(0) {
            result, window -> result + (window[0] < window[1]).toInt()
        }

    println("Part 2: ${increments}");
}

fun Boolean.toInt() = if (this) 1 else 0

fun List<Int>.countIncrements(): Int
{
    return this.foldIndexed(0) {
        index, result, _ ->
            result + this.isBigger(index, index-1).toInt()
    }
}

fun List<Int>.isBigger(a: Int, b: Int): Boolean
{
    return a > 0 && this.get(a) > this.get(b)
}
