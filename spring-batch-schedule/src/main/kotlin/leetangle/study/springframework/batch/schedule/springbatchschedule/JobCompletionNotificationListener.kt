package leetangle.study.springframework.batch.schedule.springbatchschedule

import mu.KotlinLogging
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component


@Component
class JobCompletionNotificationListener(private val jdbcTemplate: JdbcTemplate) : JobExecutionListener {
    override fun afterJob(jobExecution: JobExecution) {
        if (jobExecution.status == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results")
            jdbcTemplate
                .query("SELECT first_name, last_name FROM people", DataClassRowMapper(String::class.java))
                .forEach { person ->
                    log.info(
                        "Found <{{}}> in the database.",
                        person
                    )
                }
        }
    }

    companion object {
        private val log = KotlinLogging.logger {  }
    }
}
