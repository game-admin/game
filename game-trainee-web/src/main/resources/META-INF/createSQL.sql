
CREATE SCHEMA IF NOT EXISTS game AUTHORIZATION darbeit;

CREATE TABLE game.antwortmoeglichkeiten
(
    "ANTWID" bigint NOT NULL DEFAULT nextval('game."antwortmoeglichkeiten_ANTWID_seq"'::regclass),
    "FNR" bigint NOT NULL,
    "ANTWORT" text COLLATE pg_catalog."default" NOT NULL,
    "RICHTIGEANTWORT" boolean
);

CREATE TABLE game.frage
(
    "FNR" bigint NOT NULL DEFAULT nextval('game."frage_FNR_seq"'::regclass),
    "QID" bigint NOT NULL,
    "FRAGE" text COLLATE pg_catalog."default" NOT NULL,
    "PUNKTEZAHL" bigint NOT NULL
);

CREATE TABLE game.kurs
(
    "KURSID" bigint NOT NULL DEFAULT nextval('game."kurs_KURSID_seq"'::regclass),
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "LINK" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default"
);

CREATE TABLE game.kursbesuch
(
    "KURSBESUCHID" bigint NOT NULL DEFAULT nextval('game."kursbesuch_KURSBESUCHID_seq"'::regclass),
    "KURSID" bigint NOT NULL,
    "MITID" bigint NOT NULL,
    "DATUM" date NOT NULL
);

CREATE TABLE game.kursvoraussetzung
(
    "KURSVORAUSSETZID" bigint NOT NULL DEFAULT nextval('game."kursvoraussetzung_KURSVORAUSSETZID_seq"'::regclass),
    "VORAUSSETZID" bigint NOT NULL,
    "KURSID" bigint NOT NULL
);

CREATE TABLE game.quiz
(
    "QID" bigint NOT NULL DEFAULT nextval('game."quiz_QID_seq"'::regclass),
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default",
    "REWARD" text COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE game.quizbeantwortung
(
    "QBEID" bigint NOT NULL DEFAULT nextval('game."quizbeantwortung_QBEID_seq"'::regclass),
    "QID" bigint NOT NULL,
    "MITID" bigint NOT NULL,
    "ERREICHTEPUNKTEZAHL" bigint NOT NULL
);

CREATE TABLE game.quizvoraussetzung
(
    "QUIZVORAUSSETZID" bigint NOT NULL DEFAULT nextval('game."quizvoraussetzung_QUIZVORAUSSETZID_seq"'::regclass),
    "VORAUSSETZID" bigint NOT NULL,
    "QID" bigint NOT NULL
);

CREATE TABLE game.trainee
(
    "MITID" bigint NOT NULL DEFAULT nextval('game."trainee_MITID_seq"'::regclass),
    "NAME" text COLLATE pg_catalog."default" NOT NULL,
    "VORNAME" text COLLATE pg_catalog."default",
    "NICKNAME" text COLLATE pg_catalog."default" NOT NULL,
    "ABTEILUNG" text COLLATE pg_catalog."default"
);

CREATE TABLE game.voraussetzung
(
    "VORAUSSETZID" bigint NOT NULL DEFAULT nextval('game."voraussetzung_VORAUSSETZID_seq"'::regclass),
    "KURSID" bigint,
    "QID" bigint
);
