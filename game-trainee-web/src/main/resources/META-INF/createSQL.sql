
CREATE SCHEMA IF NOT EXISTS game AUTHORIZATION darbeit;


CREATE TABLE game.antwortmoeglichkeiten(
    "ANTWID" bigint NOT NULL,
    "FNR" bigint NOT NULL,
    "ANTWORT" text COLLATE pg_catalog."default" NOT NULL,
    "RICHTIGEANTWORT" boolean
);

CREATE TABLE game.frage(
    "FNR" bigint NOT NULL,
    "QID" bigint NOT NULL,
    "FRAGE" text COLLATE pg_catalog."default" NOT NULL,
    "PUNKTEZAHL" bigint NOT NULL
);

CREATE TABLE game.kurs(
    "KURSID" bigint NOT NULL,
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "LINK" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default"
);

CREATE TABLE game.kursbesuch(
    "KURSBESUCHID" bigint NOT NULL,
    "KURSID" bigint NOT NULL,
    "MITID" bigint NOT NULL,
    "DATUM" date NOT NULL
);

CREATE TABLE game.kursvoraussetzung(
    "KURSVORAUSSETZID" bigint NOT NULL,
    "VORAUSSETZID" bigint NOT NULL,
    "KURSID" bigint NOT NULL
);

CREATE TABLE game.quiz(
    "QID" bigint NOT NULL,
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default",
    "REWARD" text COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE game.quizbeantwortung(
    "QBEID" bigint NOT NULL,
    "QID" bigint NOT NULL,
    "MITID" bigint NOT NULL,
    "ERREICHTEPUNKTEZAHL" bigint NOT NULL
);

CREATE TABLE game.quizvoraussetzung(
    "QUIZVORAUSSETZID" bigint NOT NULL,
    "VORAUSSETZID" bigint NOT NULL,
    "QID" bigint NOT NULL
);

CREATE TABLE game.trainee (
    "MITID" bigint NOT NULL,
    "NAME" text COLLATE pg_catalog."default" NOT NULL,
    "VORNAME" text COLLATE pg_catalog."default",
    "NICKNAME" text COLLATE pg_catalog."default" NOT NULL,
    "ABTEILUNG" text COLLATE pg_catalog."default"
);

CREATE TABLE game.voraussetzung(
    "VORAUSSETZID" bigint NOT NULL,
    "KURSID" bigint,
    "QID" bigint
);
