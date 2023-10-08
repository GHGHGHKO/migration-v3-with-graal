package com.example.migrationv3withgraal.config;

import com.example.migrationv3withgraal.tasklet.SampleTasklet;
import com.example.migrationv3withgraal.tasklet.SaveUserTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TaskletBatchConfiguration {

    private final SampleTasklet sampleTasklet;

    private final SaveUserTasklet saveUserTasklet;

    @Bean
    public Job sampleTaskletJob(JobRepository jobRepository, Step sampleStep) {
        return new JobBuilder("sampleTaskletJob", jobRepository)
                .start(sampleStep)
                .build();
    }

    @Bean
    public Step sampleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("sampleStep1", jobRepository)
                .tasklet(sampleTasklet, transactionManager)
                .build();
    }

    @Bean
    public Job saveUserTaskletJob(JobRepository jobRepository, Step saveUserStep) {
        return new JobBuilder("saveUserTaskletJob", jobRepository)
                .start(saveUserStep)
                .build();
    }

    @Bean
    public Step saveUserStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("saveUserStep1", jobRepository)
                .tasklet(saveUserTasklet, transactionManager)
                .build();
    }
}
