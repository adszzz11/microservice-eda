package leetangle.study.springframework.batch.schedule.springbatchschedule

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.stereotype.Component

/**
 *packageName    : leetangle.study.springframework.batch.schedule.springbatchschedule
 * fileName       : BundleJobLauncher
 * author         : sm
 * date           : 5/6/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/6/24        sm       최초 생성
 */


/**
 * Job Launcher를 사용하는 예시 클래스입니다.
 * 스프링 컨텍스트에서 자동으로 JobLauncher와 Job을 주입하여 사용합니다.
 */
@Component
class BundleJobLauncher(
    private val jobLauncher: JobLauncher? = null,
    private val job: Job? = null
) {

    @Throws(Exception::class)
    fun runJob() {
        val jobExecution = jobLauncher!!.run(job, JobParameters())
        println("Job Status : " + jobExecution.status)
    }
}