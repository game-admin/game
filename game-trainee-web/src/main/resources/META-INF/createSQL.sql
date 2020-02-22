
CREATE TABLE game.antwort
(
    "GEWAEHLTEANTWORTID" bigint NOT NULL DEFAULT nextval('game."antwort_GEWAEHLTEANTWORTID_seq"'::regclass),
    "GEWAEHLTEANTWORT" text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "ANTWORT_pkey" PRIMARY KEY ("GEWAEHLTEANTWORTID")
);

CREATE TABLE game.antwortmoeglichkeiten
(
    "ANTWID" bigint NOT NULL DEFAULT nextval('game."antwortmoeglichkeiten_ANTWID_seq"'::regclass),
    "FNR" bigint NOT NULL,
    "ANTWORT" text COLLATE pg_catalog."default" NOT NULL,
    "RICHTIGEANTWORT" boolean,
    CONSTRAINT "ANTWORTMOEGLICHKEITEN_pkey" PRIMARY KEY ("ANTWID"),
    CONSTRAINT "Frage" FOREIGN KEY ("FNR")
        REFERENCES game.frage ("FNR") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

CREATE TABLE game.frage
(
    "FNR" bigint NOT NULL DEFAULT nextval('game."frage_FNR_seq"'::regclass),
    "QID" bigint NOT NULL,
    "FRAGE" text COLLATE pg_catalog."default" NOT NULL,
    "PUNKTEZAHL" bigint NOT NULL,
    CONSTRAINT "FRAGE_pkey" PRIMARY KEY ("FNR"),
    CONSTRAINT "Quiz" FOREIGN KEY ("QID")
        REFERENCES game.quiz ("QID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

CREATE TABLE game.kurs
(
    "KURSID" bigint NOT NULL DEFAULT nextval('game."kurs_KURSID_seq"'::regclass),
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "LINK" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default",
    CONSTRAINT "KURS_pkey" PRIMARY KEY ("KURSID")
);

CREATE TABLE game.kursbesuch
(
    "KURSBESUCHID" bigint NOT NULL DEFAULT nextval('game."kursbesuch_KURSBESUCHID_seq"'::regclass),
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
);

CREATE TABLE game.kursvoraussetzung
(
    "KURSVORAUSSETZID" bigint NOT NULL DEFAULT nextval('game."kursvorausetzung_KURSVORRAUSSETZID_seq"'::regclass),
    "VORAUSSETZID" bigint NOT NULL,
    "KURSID" bigint NOT NULL,
    CONSTRAINT "KURSVORAUSSETZUNG_pkey" PRIMARY KEY ("KURSVORAUSSETZID"),
    CONSTRAINT "Kurs" FOREIGN KEY ("KURSID")
        REFERENCES game.kurs ("KURSID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "Voraussetzung" FOREIGN KEY ("VORAUSSETZID")
        REFERENCES game.voraussetzung ("VORAUSSETZID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

CREATE TABLE game.quiz
(
    "QID" bigint NOT NULL DEFAULT nextval('game."quiz_QID_seq"'::regclass),
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default",
    "REWARD" text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "QUIZ_pkey" PRIMARY KEY ("QID")
);

CREATE TABLE game.quizbeantwortung
(
    "QBEID" bigint NOT NULL DEFAULT nextval('game."quizbeantwortung_QBEID_seq"'::regclass),
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
);

CREATE TABLE game.quizvoraussetzung
(
    "QUIZVORAUSSETZID" bigint NOT NULL DEFAULT nextval('game."quizvoraussetzung_QUIZVORAUSSETZID_seq"'::regclass),
    "VORAUSSETZID" bigint NOT NULL,
    "QID" bigint NOT NULL,
    CONSTRAINT "QUIZVORAUSSETZUNG_pkey" PRIMARY KEY ("QUIZVORAUSSETZID"),
    CONSTRAINT "Quiz" FOREIGN KEY ("QID")
        REFERENCES game.quiz ("QID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT "Voraussetzung" FOREIGN KEY ("VORAUSSETZID")
        REFERENCES game.voraussetzung ("VORAUSSETZID") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
);

CREATE TABLE game.trainee
(
    "MITID" bigint NOT NULL DEFAULT nextval('game."trainee_MITID_seq"'::regclass),
    "NAME" text COLLATE pg_catalog."default" NOT NULL,
    "VORNAME" text COLLATE pg_catalog."default",
    "NICKNAME" text COLLATE pg_catalog."default" NOT NULL,
    "ABTEILUNG" text COLLATE pg_catalog."default",
    CONSTRAINT "TRAINEE_pkey" PRIMARY KEY ("MITID"),
    CONSTRAINT "NICKNAME" UNIQUE ("NICKNAME")
);

CREATE TABLE game.voraussetzung
(
    "VORAUSSETZID" bigint NOT NULL DEFAULT nextval('game."voraussetzung_VORAUSSETZID_seq"'::regclass),
    "KURSID" bigint,
    "QID" bigint,
    CONSTRAINT "VORAUSSETZUNG_pkey" PRIMARY KEY ("VORAUSSETZID"),
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
);
