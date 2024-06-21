package leetangle.study.springframework.batch.schedule.springbatchschedule

import org.springframework.batch.item.Chunk
import org.springframework.batch.item.ItemWriter

/**
 *packageName    : leetangle.study.springframework.batch.schedule.springbatchschedule
 * fileName       : BundleItemWriter
 * author         : sm
 * date           : 5/6/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/6/24        sm       최초 생성
 */


/**
 * 예시 ItemWriter 클래스입니다.
 * 가공된 데이터를 저장하는 역할을 합니다.
 */
class BundleItemWriter : ItemWriter<String?> {
    override fun write(chunk: Chunk<out String?>) {
        for (s in chunk) {
            println("Writing chunk: $s")
        }
    }
}

