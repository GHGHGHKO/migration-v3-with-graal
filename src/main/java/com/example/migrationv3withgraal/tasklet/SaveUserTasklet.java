package com.example.migrationv3withgraal.tasklet;

import com.example.migrationv3withgraal.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SaveUserTasklet implements Tasklet {

    private final UsersService usersService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        usersService.saveUser();
        usersService.updateQuitUser();
        return RepeatStatus.FINISHED;
    }
}
