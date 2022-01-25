# Development team

Console CRUD application interacting with database using Hibernate

Entities:
- Team (id, name, List<Developer> developers)
- Developer (id, firstName, lastName, List<Skill> skills)
- Skill (id, name)

Hibernate configuration:
```sh
src/main/resources/hibernate.cfg.xml
```
Flyway configuration:
```sh
pom.xml
```
Need create database:
```sh
CREATE DATABASE development_teams;
```

Technologies:
```sh
Java
PostgreSQL
Hibernate
Maven
Flyway
JUnit
Mockito
```
