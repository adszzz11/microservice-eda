package leetangle.study.springframework.batch.schedule.springbatchschedule

import org.springframework.batch.item.ItemProcessor

/**
 *packageName    : leetangle.study.springframework.batch.schedule.springbatchschedule
 * fileName       : BundleItemProcessor
 * author         : sm
 * date           : 5/6/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/6/24        sm       최초 생성
 */


/**
 * 예시 ItemProcessor 클래스입니다.
 * 입력된 데이터를 가공하는 역할을 합니다.
 */
class BundleItemProcessor : ItemProcessor<String, String> {
    override fun process(item: String): String {
        return "$item processed"
    }
}

