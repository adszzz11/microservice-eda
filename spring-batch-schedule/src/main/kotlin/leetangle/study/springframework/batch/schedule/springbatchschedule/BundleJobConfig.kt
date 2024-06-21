package leetangle.study.springframework.batch.schedule.springbatchschedule

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager


/**
 *packageName    : leetangle.study.springframework.batch.schedule.springbatchschedule
 * fileName       : BundleJobConfig
 * author         : sm
 * date           : 5/6/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/6/24        sm       최초 생성
 */


/**
 * Job과 Step을 정의하는 예시 구성 클래스입니다.
 * JobBuilderFactory 및 StepBuilderFactory를 사용하여 Job 및 Step을 생성합니다.
 */
@Configuration
class BundleJobConfig {

    @Bean
    fun job(jobRepository: JobRepository?, step1: Step?, listener: JobCompletionNotificationListener?): Job {
        return JobBuilder("importUserJob", jobRepository)
            .listener(listener)
            .start(step1)
            .build()
    }

    @Bean
    fun step(
        jobRepository: JobRepository?, transactionManager: DataSourceTransactionManager?,
        reader: BundleItemReader, processor: BundleItemProcessor, writer: BundleItemWriter
    ): Step {
        return StepBuilder("step1", jobRepository)
            .chunk<String, String>(3, transactionManager)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build()
    }


    @Bean
    fun reader(): BundleItemReader {
        return BundleItemReader()
    }

    @Bean
    fun processor(): BundleItemProcessor {
        return BundleItemProcessor()
    }

    @Bean
    fun writer(): BundleItemWriter {
        return BundleItemWriter()
    }
}

