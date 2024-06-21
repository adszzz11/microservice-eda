package leetangle.study.client.communicate

import reactor.core.publisher.Mono

interface Communicative<R, S> {
    fun requestBlock(request: R) : S
    fun requestNonBlock(request: R) : Mono<S>
}