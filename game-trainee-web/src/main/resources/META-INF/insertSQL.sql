/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Jan
 * Created: 16.02.2020
 */

CREATE TABLE game.antwort
(
    "GEWAEHLTEANTWORTID" bigint NOT NULL DEFAULT nextval('game."ANTWORT_GEWAEHLTEANTWORTID_seq"'::regclass),
    "GEWAEHLTEANTWORT" text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "ANTWORT_pkey" PRIMARY KEY ("GEWAEHLTEANTWORTID")
)

CREATE TABLE game.antwortmoeglichkeiten
(
    "ANTWID" bigint NOT NULL DEFAULT nextval('game."ANTWORTMOEGLICHKEITEN_ANTWID_seq"'::regclass),
    "FNR" bigint NOT NULL,
    "ANTWORT" text COLLATE pg_catalog."default" NOT NULL,
    "RICHTIGEANTWORT" boolean,
    CONSTRAINT "ANTWORTMOEGLICHKEITEN_pkey" PRIMARY KEY ("ANTWID"),
    CONSTRAINT "Frage" FOREIGN KEY ("FNR")
        REFERENCES game.frage ("FNR") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

CREATE TABLE game.frage
(
    "FNR" bigint NOT NULL DEFAULT nextval('game."FRAGE_FNR_seq"'::regclass),
    "QID" bigint NOT NULL,
    "FRAGE" text COLLATE pg_catalog."default" NOT NULL,
    "PUNKTEZAHL" bigint NOT NULL,
    CONSTRAINT "FRAGE_pkey" PRIMARY KEY ("FNR"),
    CONSTRAINT "Quiz" FOREIGN KEY ("QID")
        REFERENCES game.quiz ("QID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

CREATE TABLE game.kurs
(
    "KURSID" bigint NOT NULL DEFAULT nextval('game."KURS_KURSID_seq"'::regclass),
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "LINK" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default",
    CONSTRAINT "KURS_pkey" PRIMARY KEY ("KURSID")
)

CREATE TABLE game.kursbesuch
(
    "KURSBESUCHID" bigint NOT NULL DEFAULT nextval('game."KURSBESUCH_KURSBESUCHID_seq"'::regclass),
    "KURSID" bigint NOT NULL,
    "MITID" bigint NOT NULL,
    "DATUM" date NOT NULL,
    CONSTRAINT "KURSBESUCH_pkey" PRIMARY KEY ("KURSBESUCHID"),
    CONSTRAINT "Kurs" FOREIGN KEY ("KURSID")
        REFERENCES game.kurs ("KURSID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "Trainee" FOREIGN KEY ("MITID")
        REFERENCES game.trainee ("MITID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

CREATE TABLE game.kursvorraussetzung
(
    "KURSVORRAUSSETZID" bigint NOT NULL DEFAULT nextval('game."KURSVORRAUSSETZUNG_KURSVORRAUSSETZID_seq"'::regclass),
    "VORRAUSSETZID" bigint NOT NULL,
    "KURSID" bigint NOT NULL,
    CONSTRAINT "KURSVORRAUSSETZUNG_pkey" PRIMARY KEY ("KURSVORRAUSSETZID"),
    CONSTRAINT "Kurs" FOREIGN KEY ("KURSID")
        REFERENCES game.kurs ("KURSID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "Vorraussetzung" FOREIGN KEY ("VORRAUSSETZID")
        REFERENCES game.vorraussetzung ("VORRAUSSETZID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

CREATE TABLE game.quiz
(
    "QID" bigint NOT NULL DEFAULT nextval('game."QUIZ_QID_seq"'::regclass),
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default",
    "REWARD" text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "QUIZ_pkey" PRIMARY KEY ("QID")
)

CREATE TABLE game.quizbeantwortung
(
    "QBEID" bigint NOT NULL DEFAULT nextval('game."QUIZBEANTWORTUNG_QBEID_seq"'::regclass),
    "QID" bigint NOT NULL,
    "MITID" bigint NOT NULL,
    "ERREICHTEPUNKTEZAHL" bigint NOT NULL,
    CONSTRAINT "QUIZBEANTWORTUNG_pkey" PRIMARY KEY ("QBEID"),
    CONSTRAINT "Quiz" FOREIGN KEY ("QID")
        REFERENCES game.quiz ("QID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "Trainee" FOREIGN KEY ("MITID")
        REFERENCES game.trainee ("MITID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

CREATE TABLE game.quizvorraussetzung
(
    "QUIZVORRAUSSETZID" bigint NOT NULL DEFAULT nextval('game."QUIZVORRAUSSETZUNG_QUIZVORRAUSSETZID_seq"'::regclass),
    "VORRAUSSETZID" bigint NOT NULL,
    "QID" bigint NOT NULL,
    CONSTRAINT "QUIZVORRAUSSETZUNG_pkey" PRIMARY KEY ("QUIZVORRAUSSETZID"),
    CONSTRAINT "Quiz" FOREIGN KEY ("QID")
        REFERENCES game.quiz ("QID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "Vorraussetzung" FOREIGN KEY ("VORRAUSSETZID")
        REFERENCES game.vorraussetzung ("VORRAUSSETZID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

CREATE TABLE game.trainee
(
    "MITID" bigint NOT NULL DEFAULT nextval('game."TRAINEE_MITID_seq"'::regclass),
    "NAME" text COLLATE pg_catalog."default" NOT NULL,
    "VORNAME" text COLLATE pg_catalog."default",
    "NICKNAME" text COLLATE pg_catalog."default" NOT NULL,
    "ABTEILUNG" text COLLATE pg_catalog."default",
    CONSTRAINT "TRAINEE_pkey" PRIMARY KEY ("MITID"),
    CONSTRAINT "NICKNAME" UNIQUE ("NICKNAME")
)

CREATE TABLE game.vorraussetzung
(
    "VORRAUSSETZID" bigint NOT NULL DEFAULT nextval('game."VORRAUSSETZUNG_VORRAUSSETZID_seq"'::regclass),
    "KURSID" bigint,
    "QID" bigint,
    CONSTRAINT "VORRAUSSETZUNG_pkey" PRIMARY KEY ("VORRAUSSETZID"),
    CONSTRAINT "Kurs" FOREIGN KEY ("KURSID")
        REFERENCES game.kurs ("KURSID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "Quiz" FOREIGN KEY ("QID")
        REFERENCES game.quiz ("QID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)

INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (1, 1, 'Flawless', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (2, 1, 'Platform Independent', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (3, 1, 'Only compatible with Windows', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (4, 1, 'only compatible with Linux', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (5, 2, '"."', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (6, 2, '"{ or } "', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (7, 2, '";"', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (8, 2, 'Java RE', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (9, 9, 'Object is a addon for Java', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (10, 9, 'You have to use the program Object to run Java.', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (11, 9, 'Java can be extended with Objects.', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (12, 9, 'Java has no Objects', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (13, 10, 'Java S', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (14, 10, 'Java E', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (15, 10, 'Java SS', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (16, 10, 'Java SE', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (17, 11, 'Multiple Inheritance', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (18, 11, 'Classes&Methods', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (19, 11, 'Functions', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (20, 11, 'None of the above', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (21, 12, 'Classes', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (22, 12, 'only state', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (23, 12, 'only behaviour', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (24, 12, 'state and behaviour', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (25, 13, 'Global', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (26, 13, 'Local', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (27, 13, 'Class', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (28, 13, 'Instance', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (29, 14, 'Different name as Class', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (30, 14, 'Same name as attribute', false);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (31, 14, 'Same name as Class', true);
INSERT INTO game.antwortmoeglichkeiten ("ANTWID", "FNR", "ANTWORT", "RICHTIGEANTWORT") VALUES (32, 14, 'Must contain attributes', false);


INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (1, 1, 'What are advantages of Java?', 10);
INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (2, 1, 'What is written after a line of code?', 10);
INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (9, 1, 'What does Object Oriented mean?', 10);
INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (10, 1, 'Which Java Version exist', 10);
INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (11, 2, 'What concept of the following is Java supporting?', 10);
INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (12, 2, 'Which things do objects include?', 10);
INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (13, 2, 'What is not a variabletype which classes can contain?', 10);
INSERT INTO game.frage ("FNR", "QID", "FRAGE", "PUNKTEZAHL") VALUES (14, 2, 'What is the main rule of a constructor?', 10);

INSERT INTO game.kurs ("KURSID", "TITEL", "LINK", "BESCHREIBUNG") VALUES (1, 'Start-Kurs', 'https://www.tutorialspoint.com/java/index.htm', NULL);
INSERT INTO game.kurs ("KURSID", "TITEL", "LINK", "BESCHREIBUNG") VALUES (2, 'Object & Classes', 'https://www.tutorialspoint.com/java/java_object_classes.htm', NULL);
INSERT INTO game.kurs ("KURSID", "TITEL", "LINK", "BESCHREIBUNG") VALUES (3, 'Constructors', 'https://www.tutorialspoint.com/java/java_constructors.htm', NULL);

INSERT INTO game.quiz ("QID", "TITEL", "BESCHREIBUNG", "REWARD") VALUES (1, 'Start', 'Quiz about the general knowledge of Java', 'test');
INSERT INTO game.quiz ("QID", "TITEL", "BESCHREIBUNG", "REWARD") VALUES (2, 'Object, Classes & Constructors', 'Quiz about Objects, Classes and Constructors in Java', 'test');

INSERT INTO game.trainee ("MITID", "NAME", "VORNAME", "NICKNAME", "ABTEILUNG") VALUES (2, 'Haneder', 'Eric', 'ericbensi', NULL);
INSERT INTO game.trainee ("MITID", "NAME", "VORNAME", "NICKNAME", "ABTEILUNG") VALUES (1, 'Binder', 'Jan', 'Syreax', NULL);
INSERT INTO game.trainee ("MITID", "NAME", "VORNAME", "NICKNAME", "ABTEILUNG") VALUES (3, 'Saliger', 'Alex', 'SaAlexX_1010', NULL);
INSERT INTO game.trainee ("MITID", "NAME", "VORNAME", "NICKNAME", "ABTEILUNG") VALUES (4, 'Wurst', 'Alexander', 'wursti', NULL);
