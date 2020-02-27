
CREATE SCHEMA IF NOT EXISTS game AUTHORIZATION darbeit;


CREATE TABLE game.antwortmoeglichkeiten(
    "antwid" text NOT NULL,
    "fnr" text NOT NULL,
    "antwort" text COLLATE pg_catalog."default" NOT NULL,
    "richtigeantwort" boolean
);

CREATE TABLE game.frage(
    "fnr" text NOT NULL,
    "qid" text NOT NULL,
    "frage" text COLLATE pg_catalog."default" NOT NULL,
    "punktezahl" bigint NOT NULL
);

CREATE TABLE game.kurs(
    "kursid" text NOT NULL,
    "titel" text COLLATE pg_catalog."default" NOT NULL,
    "link" text COLLATE pg_catalog."default" NOT NULL,
    "beschreibung" text COLLATE pg_catalog."default"
);

CREATE TABLE game.kursbesuch(
    "kursbesuchid" text NOT NULL,
    "kursid" text NOT NULL,
    "mitid" text NOT NULL,
    "datum" date NOT NULL
);

CREATE TABLE game.kursvoraussetzung(
    "kursvoraussetzid" text NOT NULL,
    "voraussetzid" text NOT NULL,
    "kursid" text NOT NULL
);

CREATE TABLE game.quiz(
    qid text NOT NULL,
    "titel" text COLLATE pg_catalog."default" NOT NULL,
    "beschreibung" text COLLATE pg_catalog."default",
    "reward" text COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE game.quizbeantwortung(
    "qbeid" text NOT NULL,
    "qid" text NOT NULL,
    "mitid" text NOT NULL,
    "erreichtepunktezahl" bigint NOT NULL
);

CREATE TABLE game.quizvoraussetzung(
    "quizvoraussetzid" text NOT NULL,
    "voraussetzid" text NOT NULL,
    "qid" text NOT NULL
);

CREATE TABLE game.trainee (
    "mitid" text NOT NULL,
    "name" text COLLATE pg_catalog."default" NOT NULL,
    "vorname" text COLLATE pg_catalog."default",
    "nickname" text COLLATE pg_catalog."default" NOT NULL,
    "abteilung" text COLLATE pg_catalog."default"
);

CREATE TABLE game.voraussetzung(
    "voraussetzid" text NOT NULL,
    "kursid" text,
    "qid" text
);





ALTER TABLE game.antwortmoeglichkeiten ADD CONSTRAINT "ANTWORTMOEGLICHKEITEN_pkey" PRIMARY KEY ("antwid");
    
ALTER TABLE game.frage ADD CONSTRAINT "FRAGE_pkey" PRIMARY KEY ("fnr");

ALTER TABLE game.kurs ADD CONSTRAINT "KURS_pkey" PRIMARY KEY ("kursid");

ALTER TABLE game.kursbesuch ADD CONSTRAINT "KURSBESUCH_pkey" PRIMARY KEY ("kursbesuchid");

ALTER TABLE game.kursvoraussetzung ADD CONSTRAINT "KURSVORAUSSETZUNG_pkey" PRIMARY KEY ("kursvoraussetzid");

ALTER TABLE game.quiz ADD CONSTRAINT "QUIZ_pkey" PRIMARY KEY (qid);

ALTER TABLE game.quizbeantwortung ADD CONSTRAINT "QUIZBEANTWORTUNG_pkey" PRIMARY KEY ("gbeid");

ALTER TABLE game.quizvoraussetzung ADD CONSTRAINT "QUIZVORAUSSETZUNG_pkey" PRIMARY KEY ("quizvoraussetzid");

ALTER TABLE game.trainee ADD CONSTRAINT "TRAINEE_pkey" PRIMARY KEY ("mitid");

ALTER TABLE game.trainee ADD CONSTRAINT "NICKNAME" UNIQUE ("nickname");

ALTER TABLE game.voraussetzung ADD CONSTRAINT "VORAUSSETZUNG_pkey" PRIMARY KEY ("voraussetzid");


ALTER TABLE game.antwortmoeglichkeiten ADD CONSTRAINT "Frage" FOREIGN KEY ("fnr")
        REFERENCES game.frage ("fnr") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;


    
ALTER TABLE game.frage ADD CONSTRAINT "Quiz" FOREIGN KEY ("qid")
        REFERENCES game.quiz ("qid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;

    
ALTER TABLE game.kursbesuch ADD CONSTRAINT "Kurs" FOREIGN KEY ("kursid")
        REFERENCES game.kurs ("kursid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;
    
ALTER TABLE game.kursbesuch ADD CONSTRAINT "Trainee" FOREIGN KEY ("mitid")
        REFERENCES game.trainee ("mitid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;




    
ALTER TABLE game.kursvoraussetzung ADD CONSTRAINT "Kurs" FOREIGN KEY ("kursid")
        REFERENCES game.kurs ("kursid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;
    
ALTER TABLE game.kursvoraussetzung ADD CONSTRAINT "Voraussetzung" FOREIGN KEY ("voraussetzid")
        REFERENCES game.voraussetzung ("voraussetzid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;




    
ALTER TABLE game.quizbeantwortung ADD CONSTRAINT "Quiz" FOREIGN KEY ("qid")
        REFERENCES game.quiz ("qid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;

ALTER TABLE game.quizbeantwortung ADD CONSTRAINT "Trainee" FOREIGN KEY ("mitid")
        REFERENCES game.trainee ("mitid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;




    
ALTER TABLE game.quizvoraussetzung ADD CONSTRAINT "Quiz" FOREIGN KEY ("qid")
        REFERENCES game.quiz ("qid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;

ALTER TABLE game.quizvoraussetzung ADD CONSTRAINT "Voraussetzung" FOREIGN KEY ("voraussetzid")
        REFERENCES game.voraussetzung ("voraussetzid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;


ALTER TABLE game.voraussetzung ADD CONSTRAINT "Kurs" FOREIGN KEY ("kursid")
        REFERENCES game.kurs ("kursid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;
   
ALTER TABLE game.voraussetzung ADD CONSTRAINT "Quiz" FOREIGN KEY ("qid")
        REFERENCES game.quiz ("qid") MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID;

