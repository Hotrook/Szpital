DROP TABLE IF EXISTS Pacjent;

CREATE TABLE IF NOT EXISTS Pacjent
(
id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
Imię varchar(70) NOT NULL,
Nazwisko varchar(70) NOT NULL,
Choroba varchar(70),
Sala int,
Data_Przyjęcia datetime DEFAULT NOW()
) ENGINE = InnoDB;

ALTER TABLE Pacjent ADD INDEX (id);

ALTER TABLE Pacjent 
  ADD CONSTRAINT FOREIGN KEY (Choroba) REFERENCES Choroba(Nazwa) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT FOREIGN KEY (Sala) REFERENCES Sala(Numer) ON DELETE RESTRICT ON UPDATE CASCADE;

DROP TRIGGER IF EXISTS ZajmijMiejsceWSali;

DELIMITER $$
CREATE TRIGGER ZajmijMiejsceWSali
AFTER INSERT ON Pacjent
FOR EACH ROW
BEGIN
UPDATE Sala
SET Sala.Zajęte = Sala.Zajęte + 1
WHERE (Sala.Numer = NEW.Sala);
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS ZwolnijMiejscePrzyPrzeniesieniuIZajmijNowe;

DELIMITER $$
CREATE TRIGGER ZwolnijMiejscePrzyPrzeniesieniuIZajmijNowe
AFTER UPDATE ON Pacjent
FOR EACH ROW
BEGIN
UPDATE Sala
SET Sala.Zajęte = Sala.Zajęte + 1
WHERE (Sala.Numer = NEW.Sala);
UPDATE Sala
SET Sala.Zajęte = Sala.Zajęte + -1
WHERE (Sala.Numer = OLD.Sala);
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS ZwolnijMiejscePrzyWypisieLubSmierci;

DELIMITER $$
CREATE TRIGGER ZwolnijMiejscePrzyWypisieLubSmierci
BEFORE DELETE ON Pacjent
FOR EACH ROW
BEGIN
UPDATE Sala
SET Sala.Zajęte = Sala.Zajęte + -1
WHERE (Sala.Numer = OLD.Sala);
END$$
DELIMITER ;