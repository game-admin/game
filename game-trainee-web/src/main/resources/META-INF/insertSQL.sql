
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('1', 'Binder', 'Jan', 'Syreax', NULL, 500, NULL);
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('2', 'Haneder', 'Eric', 'ericbensi', NULL, 600, NULL);
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('3', 'Saliger', 'Alex', 'SaAlexX_1010', NULL, 400, NULL);
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('4', 'Wurst', 'Alexander', 'wursti', NULL, 300, NULL);

INSERT INTO game.quiz ("qid", "titel", "beschreibung", "reward", "multiplechoice") VALUES ('1', 'Start', 'Quiz about the general knowledge of Java', 'test', false);
INSERT INTO game.quiz ("qid", "titel", "beschreibung", "reward", "multiplechoice") VALUES ('2', 'Object, Classes & Constructors', 'Quiz about Objects, Classes and Constructors in Java', 'test', false);




INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('1', '1', 'What are advantages of Java?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('2', '1', 'What is written after a line of code?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('3', '1', 'What does Object Oriented mean?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('4', '1', 'Which Java Version exist', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('5', '2', 'What concept of the following is Java supporting?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('6', '2', 'Which things do objects include?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('7', '2', 'What is not a variabletype which classes can contain?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('8', '2', 'What is the main rule of a constructor?', 10);


INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('1', '1', 'Flawless', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('2', '1', 'Platform Independent', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('3', '1', 'Only compatible with Windows', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('4', '1', 'only compatible with Linux', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('5', '2', '"."', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('6', '2', '"{ or } "', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('7', '2', '";"', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('8','2', 'Java RE', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('9', '3', 'Object is a addon for Java', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('10', '3', 'You have to use the program Object to run Java.', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('11', '3', 'Java can be extended with Objects.', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('12', '3', 'Java has no Objects', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('13', '4', 'Java S', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('14', '4', 'Java E', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('15', '4', 'Java SS', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('16', '4', 'Java SE', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('17', '5', 'Multiple Inheritance', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('18', '5', 'Classes&Methods', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('19', '5', 'Functions', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('20', '5', 'None of the above', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('21', '6', 'Classes', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('22', '6', 'only state', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('23', '6', 'only behaviour', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('24', '6', 'state and behaviour', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('25', '7', 'Global', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('26', '7', 'Local', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('27', '7', 'Class', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('28', '7', 'Instance', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('29', '8', 'Different name as Class', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('30', '8', 'Same name as attribute', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('31', '8', 'Same name as Class', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('32', '8', 'Must contain attributes', false);


INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('1', 'Start-Kurs', 'https://www.tutorialspoint.com/java/index.htm', NULL);
INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('2', 'Object & Classes', 'https://www.tutorialspoint.com/java/java_object_classes.htm', NULL);
INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('3', 'Constructors', 'https://www.tutorialspoint.com/java/java_constructors.htm', NULL);




