
CREATE SCHEMA IF NOT EXISTS game AUTHORIZATION darbeit;


CREATE TABLE game.antwortmoeglichkeiten(
    antwid text NOT NULL,
    fnr text NOT NULL,
    antwort text COLLATE pg_catalog."default" NOT NULL,
    richtigeantwort boolean
);

CREATE TABLE game.frage(
    "FNR" text NOT NULL,
    "QID" text NOT NULL,
    "FRAGE" text COLLATE pg_catalog."default" NOT NULL,
    "PUNKTEZAHL" bigint NOT NULL
);

CREATE TABLE game.kurs(
    "KURSID" text NOT NULL,
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "LINK" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default"
);

CREATE TABLE game.kursbesuch(
    "KURSBESUCHID" text NOT NULL,
    "KURSID" text NOT NULL,
    "MITID" text NOT NULL,
    "DATUM" date NOT NULL
);

CREATE TABLE game.kursvoraussetzung(
    "KURSVORAUSSETZID" text NOT NULL,
    "VORAUSSETZID" text NOT NULL,
    "KURSID" text NOT NULL
);

CREATE TABLE game.quiz(
    "QID" text NOT NULL,
    "TITEL" text COLLATE pg_catalog."default" NOT NULL,
    "BESCHREIBUNG" text COLLATE pg_catalog."default",
    "REWARD" text COLLATE pg_catalog."default" NOT NULL
);

CREATE TABLE game.quizbeantwortung(
    "QBEID" text NOT NULL,
    "QID" text NOT NULL,
    "MITID" text NOT NULL,
    "ERREICHTEPUNKTEZAHL" bigint NOT NULL
);

CREATE TABLE game.quizvoraussetzung(
    "QUIZVORAUSSETZID" text NOT NULL,
    "VORAUSSETZID" text NOT NULL,
    "QID" text NOT NULL
);

CREATE TABLE game.trainee (
    "MITID" text NOT NULL,
    "NAME" text COLLATE pg_catalog."default" NOT NULL,
    "VORNAME" text COLLATE pg_catalog."default",
    "NICKNAME" text COLLATE pg_catalog."default" NOT NULL,
    "ABTEILUNG" text COLLATE pg_catalog."default"
);

CREATE TABLE game.voraussetzung(
    "VORAUSSETZID" text NOT NULL,
    "KURSID" text,
    "QID" text
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

