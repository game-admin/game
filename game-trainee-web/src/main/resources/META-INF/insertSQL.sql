
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('1', 'Binder', 'Jan', 'Syreax', 'Projektmanagement', 500, NULL);
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('2', 'Haneder', 'Eric', 'ericbensi', 'Softwaredevelopment', 600, NULL);
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('3', 'Saliger', 'Alex', 'SaAlexX_1010', 'Hausmeister', 400, NULL);
INSERT INTO game.trainee ("mitid", "nachname", "vorname", "nickname", "abteilung", "progress", "embleme") VALUES ('4', 'Wurst', 'Alexander', 'wursti', 'Front-End Development', 300, NULL);

INSERT INTO game.quiz ("qid", "titel", "beschreibung", "reward", "multiplechoice") VALUES ('1', 'Start', 'Quiz about the general knowledge of Java', 'test', false);
INSERT INTO game.quiz ("qid", "titel", "beschreibung", "reward", "multiplechoice") VALUES ('2', 'Object, Classes & Constructors', 'Quiz about Objects, Classes and Constructors in Java', 'test', false);


INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('1', '1', 'What are advantages of Java?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('2', '1', 'What is written after a line of code?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('3', '1', 'What does Object Oriented mean?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('4', '1', 'Which Java Version exist?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('5', '1', 'What is a feature of Java?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('6', '2', 'What concept of the following is Java supporting?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('7', '2', 'Which things do objects include?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('8', '2', 'What is not a variabletype which classes can contain?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('9', '2', 'What is the main rule of a constructor?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('10', '2', 'How do you create an Object?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('11', '2', 'How can you access instance variables and methods?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('12', '2', 'What does the import statement do?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('13', '2', 'What does a constructor do?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('14', '2', 'Which classes contain a contructor?', 10);
INSERT INTO game.frage ("fid", "qid", "frage", "punktezahl") VALUES ('15', '2', 'What is a correct contructor head(considering the name of the class is MyClass)?', 10);


INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('1', '1', 'Flawless', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('2', '1', 'Platform Independent', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('3', '1', 'Only compatible with Windows', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('4', '1', 'only compatible with Linux', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('5', '2', '"."', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('6', '2', '"{ or } "', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('7', '2', '";"', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('8','2', '"/>"', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('9', '3', 'Object is a addon for Java', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('10', '3', 'You have to use the program Object to run Java.', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('11', '3', 'Java can be extended with Objects.', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('12', '3', 'Java has no Objects', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('13', '4', 'Java S', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('14', '4', 'Java E', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('15', '4', 'Java SS', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('16', '4', 'Java SE', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('17', '5', 'High graphical visualisation', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('18', '5', 'Dynamic', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('19', '5', 'Platform Dependant', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('20', '5', 'Insecure', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('21', '6', 'Multiple Inheritance', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('22', '6', 'Classes&Methods', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('23', '6', 'Functions', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('24', '6', 'None of the above', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('25', '7', 'Classes', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('26', '7', 'only state', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('27', '7', 'only behaviour', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('28', '7', 'state and behaviour', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('29', '8', 'Global', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('30', '8', 'Local', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('31', '8', 'Class', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('32', '8', 'Instance', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('33', '9', 'Different name as Class', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('34', '9', 'Same name as attribute', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('35', '9', 'Same name as Class', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('36', '9', 'Must contain attributes', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('37', '10', 'With the "create" Keyword', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('38', '10', 'It creates itself automatically', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('39', '10', 'With the "new" Keyword', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('40', '10', 'With the "make" Keyword', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('41', '11', 'Object.variable & Object.methode()', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('42', '11', 'Object.variable & Object.methode', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('43', '11', 'variable.Object & methode.Object()', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('44', '11', 'Object.variable() & Object.methode()', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('45', '12', 'import a method', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('46', '12', 'gives the location to a class', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('47', '12', 'creates a database connection', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('48', '12', 'imports a variable from another class', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('49', '13', 'Nothing', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('50', '13', 'It functions as a Getter/Setter', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('51', '13', 'It initializes an object when its created', true);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('52', '13', 'None of the above', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('53', '14', 'Only classes with defined contructors', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('54', '14', 'No class has a contructor', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('55', '14', 'Only classes with specific settings', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('56', '14', 'Every class ', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('57', '15', 'public static void MyClass()', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('58', '15', 'public constructor()', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('59', '15', 'public MyClass()', false);
INSERT INTO game.antwortmoeglichkeiten ("antwid", "fid", "antwort", "richtigeantwort") VALUES ('60', '15', 'public String MyClass()', false);

INSERT INTO game.quizbeantwortung ("qbeid", "qid", "mitid", "erreichtepunktezahl", "istbestanden") VALUES ('1', '1', '1', 0, false);
INSERT INTO game.quizbeantwortung ("qbeid", "qid", "mitid", "erreichtepunktezahl", "istbestanden") VALUES ('2', '2', '1', 0, false);


INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('1', 'Start-Kurs', 'https://www.tutorialspoint.com/java/index.htm', 'Dieser Kurs ist der erste Kurs der abgelegt werden muss. Er erklärt dir die Basics von Java.');
INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('2', 'Object & Classes', 'https://www.tutorialspoint.com/java/java_object_classes.htm', 'In diesem Kurs geht es um Objekte und Klassen die in Java sehr wichig sind. Der Kurs erklärt dir die Grundlagen, die du über dieses Thema wisse musst.');
INSERT INTO game.kurs ("kursid", "titel", "link", "beschreibung") VALUES ('3', 'Constructors', 'https://www.tutorialspoint.com/java/java_constructors.htm', 'Das ist ein Kurs über die Konstruktoren in Java. Konstruktoren sind wichtig um ordentlich mit Objekten und Klassen arbeiten zu können.');

INSERT INTO game.voraussetzung("voraussetzid", "kursid", "qid") VALUES ('1', null, '1');

INSERT INTO game.quizvoraussetzung("quizvoraussetzid", "voraussetzid", "qid") VALUES ('1', '1', '2');



