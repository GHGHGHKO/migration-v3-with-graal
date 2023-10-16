# migration-v3-with-graal
Migrating from Spring Boot(batch) 2 to 3 with GraalVM

https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide

# Migration order

## 1. add spring-boot-properties-migrator
### commits
[feat: add spring-boot-properties-migrator](https://github.com/GHGHGHKO/migration-v3-with-graal/commit/951aee5984792ddf7e07e3f6b246919071273b50)  
[Revert "feat: add spring-boot-properties-migrator"](https://github.com/GHGHGHKO/migration-v3-with-graal/commit/bfeca161f1f606fb356158a6d8886bde7bcb0511)

## 2. springboot v3 version up
### commits
[feat: springboot v3 version up](https://github.com/GHGHGHKO/migration-v3-with-graal/commit/34d94ffd4a76f4a4cf1560cfb5f4b11359e826ff)

## 3. `javax` to `jakarta`
### commits
[feat: javax to jakarta](https://github.com/GHGHGHKO/migration-v3-with-graal/commit/241a6c6fdd5fd21b4af21a7f2756a74010153e8a)

## 4. Job, Step springbatch 5 migration
### commits
[feat: Job, Step springbatch v5 migration](https://github.com/GHGHGHKO/migration-v3-with-graal/commit/96a5ae72b838a05feed19885ba2f36d2dd7b84bd)  
[feat: job.names to job.name](https://github.com/GHGHGHKO/migration-v3-with-graal/commit/c366514ca498a5e3fe21e711d5e16e8bcc1c16bb)

# Without GraalVM

### Build time
![스크린샷 2023-10-16 190415](https://github.com/GHGHGHKO/migration-v3-with-graal/assets/26823834/cb497b3f-90b5-4739-8f72-1c71c8ede12f)

### command
```shell
$ docker run -p 8080:8080 -e SPRING_BATCH_JOB_NAME=sampleTaskletJob migration-v3-with-graal:0.0.1-SNAPSHOT
```

### Started MigrationV3WithGraalApplication in 2.474 seconds (process running for 2.888)
```text
2023-10-16T09:52:25.073Z  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2023-10-16T09:52:25.489Z  INFO 1 --- [           main] c.e.m.MigrationV3WithGraalApplication    : Started MigrationV3WithGraalApplication in 2.474 seconds (process running for 2.888)
2023-10-16T09:52:25.491Z  INFO 1 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-10-16T09:52:25.522Z  INFO 1 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=sampleTaskletJob]] launched with the following parameters: [{}]
2023-10-16T09:52:25.541Z  INFO 1 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [sampleStep1]
2023-10-16T09:52:25.547Z  INFO 1 --- [           main] c.e.m.tasklet.SampleTasklet              : Hello Tasklet !
2023-10-16T09:52:25.547Z  INFO 1 --- [           main] c.e.m.tasklet.SampleTasklet              : parameter is null
2023-10-16T09:52:25.551Z  INFO 1 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [sampleStep1] executed in 9ms
```

# With GraalVM

### Build time
![스크린샷 2023-10-16 190234](https://github.com/GHGHGHKO/migration-v3-with-graal/assets/26823834/daa594db-c839-4403-8809-ecd389417a4c)

### command
```shell
docker run -p 8080:8080 -e SPRING_BATCH_JOB_NAME=sampleTaskletJob migration-v3-with-graal:0.1.1-SNAPSHOT
```

### Started MigrationV3WithGraalApplication in 0.114 seconds (process running for 0.121)
```text
2023-10-16T10:00:47.530Z  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2023-10-16T10:00:47.596Z  INFO 1 --- [           main] c.e.m.MigrationV3WithGraalApplication    : Started MigrationV3WithGraalApplication in 0.114 seconds (process running for 0.121)
2023-10-16T10:00:47.597Z  INFO 1 --- [           main] o.s.b.a.b.JobLauncherApplicationRunner   : Running default command line with: []
2023-10-16T10:00:47.599Z  INFO 1 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=sampleTaskletJob]] launched with the following parameters: [{}]
2023-10-16T10:00:47.600Z  INFO 1 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [sampleStep1]
2023-10-16T10:00:47.601Z  INFO 1 --- [           main] c.e.m.tasklet.SampleTasklet              : Hello Tasklet !
2023-10-16T10:00:47.601Z  INFO 1 --- [           main] c.e.m.tasklet.SampleTasklet              : parameter is null
2023-10-16T10:00:47.601Z  INFO 1 --- [           main] o.s.batch.core.step.AbstractStep         : Step: [sampleStep1] executed in 1ms
```
