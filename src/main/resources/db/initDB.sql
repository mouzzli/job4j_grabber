DROP TABLE IF EXISTS vacancies;
DROP SEQUENCE IF EXISTS seq;
CREATE SEQUENCE seq START WITH 100000;

CREATE TABLE IF NOT EXISTS vacancies
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('seq'),
    company     VARCHAR   NOT NULL,
    title       VARCHAR   NOT NULL,
    link        VARCHAR   unique,
    description VARCHAR   NOT NULL,
    datetime    TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX vacancies_unique_link_idx ON vacancies (link)
