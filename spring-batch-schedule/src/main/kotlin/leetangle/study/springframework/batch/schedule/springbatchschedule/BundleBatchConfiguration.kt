package leetangle.study.springframework.batch.schedule.springbatchschedule

/**
 *packageName    : leetangle.study.springframework.batch.schedule.springbatchschedule
 * fileName       : BundleBatchConfiguration
 * author         : sm
 * date           : 5/7/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/7/24        sm       최초 생성
 */

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

/**
 * Batch 처리를 활성화하고 필요한 설정을 위한 구성 클래스입니다.
 * 기본 설정을 제공하여 배치 기능을 활성화합니다.
 */
@Configuration
@EnableBatchProcessing
class BundleBatchConfiguration {
}
