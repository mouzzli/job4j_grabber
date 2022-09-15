# job4j_grabber
[![Build](https://github.com/mouzzli/job4j_grabber/actions/workflows/build.yml/badge.svg)](https://github.com/mouzzli/job4j_grabber/actions/workflows/build.yml)

Агрегатор вакансий.

Описание.

Система запускается по расписанию - раз в минуту.  Период запуска указывается в настройках - app.properties. 

Файл инициализации БД находится  в resource/db/initDB.sql

Первый сайт career.habr.com. Работаем с разделом https://career.habr.com/vacancies/java_developer.  Программа считывает все вакансии c первых 5 страниц относящиеся к Java и записывать их в базу.


