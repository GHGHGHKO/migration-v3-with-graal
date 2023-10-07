package com.example.migrationv3withgraal.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ReaderProcessorWriterConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<String> itemReader() {
        // Implement your custom item reader logic here
        List<String> data = Arrays.asList("Item 1", "Item 2", "Item 3");
        return new ListItemReader<>(data);
    }

    @Bean
    public ItemProcessor<String, String> itemProcessor() {
        // for your custom item processor logic here
        return String::toUpperCase;
    }

    @Bean
    public ItemWriter<String> itemWriter() {
        // here you could Implement your custom item writer logic,
        return items -> {
            for (String item : items) {
                log.info("Writing item: {}", item);
            }
        };
    }

    @Bean
    public Step step(ItemReader<String> itemReader, ItemProcessor<String, String> itemProcessor, ItemWriter<String> itemWriter) {
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(3)
                .build();
    }

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("job")
                .start(step)
                .build();
    }
}
