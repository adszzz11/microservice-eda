package leetangle.study

import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

/**
 *packageName    : leetangle.study
 * fileName       : TodoSample
 * author         : sm
 * date           : 5/24/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/24/24        sm       최초 생성
 */
class TodoSample

fun main() {
    Flux.just(100, 200, 300, 400, 500)
        .doOnNext { println("${getThreadName()} #doOnNext() : $it" ) }
        .subscribeOn(Schedulers.newSingle("Test"))
        .filter { it > 300 }
        .subscribe { println("${getThreadName()} : Result : $it") }

    Thread.sleep(5000)
}

fun getThreadName(): String = Thread.currentThread().name