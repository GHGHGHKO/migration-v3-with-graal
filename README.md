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
