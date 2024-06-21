package leetangle.study

/**
 *packageName    : leetangle.study
 * fileName       : ImperativeProgramming
 * author         : sm
 * date           : 5/21/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/21/24        sm       최초 생성
 */
class ImperativeProgramming

fun main() {
    val numbers : List<Int> = listOf(1, 3, 21, 10, 8, 11)
    var sum = 0
    for(number in numbers) {
        if (number > 6 && (number%2 != 0)) {
            sum += number
        }
    }

    println("명령형 프로그래밍 사용 : $sum")
}