
INSERT INTO game.trainee ("mitid", "name", "vorname", "nickname", "abteilung") VALUES ('1', 'Binder', 'Jan', 'Syreax', NULL);
INSERT INTO game.trainee ("mitid", "name", "vorname", "nickname", "abteilung") VALUES ('2', 'Haneder', 'Eric', 'ericbensi', NULL);
INSERT INTO game.trainee ("mitid", "name", "vorname", "nickname", "abteilung") VALUES ('3', 'Saliger', 'Alex', 'SaAlexX_1010', NULL);
INSERT INTO game.trainee ("mitid", "name", "vorname", "nickname", "abteilung") VALUES ('4', 'Wurst', 'Alexander', 'wursti', NULL);

INSERT INTO game.quiz ("qid", "titel", "beschreibung", "reward") VALUES ('1', 'Start', 'Quiz about the general knowledge of Java', 'test');
INSERT INTO game.quiz ("qid", "titel", "beschreibung", "reward") VALUES ('2', 'Object, Classes & Constructors', 'Quiz about Objects, Classes and Constructors in Java', 'test');



INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('1', '1', 'What are advantages of Java?', 10);
INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('2', '1', 'What is written after a line of code?', 10);
INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('9', '1', 'What does Object Oriented mean?', 10);
INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('10', '1', 'Which Java Version exist', 10);
INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('11', '2', 'What concept of the following is Java supporting?', 10);
INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('12', '2', 'Which things do objects include?', 10);
INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('13', '2', 'What is not a variabletype which classes can contain?', 10);
INSERT INTO game.frage ("fnr", "qid", "frage", "punktezahl") VALUES ('14', '2', 'What is the main rule of a constructor?', 10);


INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('1', '1', 'Flawless', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('2', '1', 'Platform Independent', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('3', '1', 'Only compatible with Windows', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('4', '1', 'only compatible with Linux', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('5', '2', '"."', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('6', '2', '"{ or } "', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('7', '2', '";"', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('8','2', 'Java RE', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('9', '9', 'Object is a addon for Java', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('10', '9', 'You have to use the program Object to run Java.', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('11', '9', 'Java can be extended with Objects.', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('12', '9', 'Java has no Objects', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('13', '10', 'Java S', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('14', '10', 'Java E', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('15', '10', 'Java SS', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('16', '10', 'Java SE', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('17', '11', 'Multiple Inheritance', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('18', '11', 'Classes&Methods', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('19', '11', 'Functions', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('20', '11', 'None of the above', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('21', '12', 'Classes', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('22', '12', 'only state', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('23', '12', 'only behaviour', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('24', '12', 'state and behaviour', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('25', '13', 'Global', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('26', '13', 'Local', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('27', '13', 'Class', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('28', '13', 'Instance', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('29', '14', 'Different name as Class', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('30', '14', 'Same name as attribute', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('31', '14', 'Same name as Class', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fnr", "antwort", "richtigeantwort") VALUES ('32', '14', 'Must contain attributes', false);





INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('1', 'Start-Kurs', 'https://www.tutorialspoint.com/java/index.htm', NULL);
INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('2', 'Object & Classes', 'https://www.tutorialspoint.com/java/java_object_classes.htm', NULL);
INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('3', 'Constructors', 'https://www.tutorialspoint.com/java/java_constructors.htm', NULL);




