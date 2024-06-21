package leetangle.study.springframework.batch.schedule.springbatchschedule

import org.springframework.batch.item.ItemReader

/**
 *packageName    : leetangle.study.springframework.batch.schedule.springbatchschedule
 * fileName       : BundleItemReader
 * author         : sm
 * date           : 5/6/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/6/24        sm       최초 생성
 */


/**
 * 예시 ItemReader 클래스입니다.
 * 데이터를 읽어들여 처리의 첫 번째 단계로 제공합니다.
 */
class BundleItemReader : ItemReader<String?> {
    private var count = 0
    override fun read(): String? {
        return if (count < 10) {
            "Item " + ++count
        } else {
            null // No more items
        }
    }
}