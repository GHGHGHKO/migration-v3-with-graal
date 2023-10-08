package com.example.migrationv3withgraal.config;

import com.example.migrationv3withgraal.tasklet.SampleTasklet;
import com.example.migrationv3withgraal.tasklet.SaveUserTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TaskletBatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final SampleTasklet sampleTasklet;

    private final SaveUserTasklet saveUserTasklet;

    @Bean
    public Job sampleTaskletJob() {
        return jobBuilderFactory.get("sampleTaskletJob")
                .start(sampleStep())
                .build();
    }

    private Step sampleStep() {
        return stepBuilderFactory.get("sampleStep1")
                .tasklet(sampleTasklet)
                .build();
    }

    @Bean
    public Job saveUserTaskletJob() {
        return jobBuilderFactory.get("saveUserTaskletJob")
                .start(saveUserStep())
                .build();
    }

    private Step saveUserStep() {
        return stepBuilderFactory.get("saveUserStep1")
                .tasklet(saveUserTasklet)
                .build();
    }
}
