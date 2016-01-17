DROP TABLE IF EXISTS Pielęgniarka;

CREATE TABLE IF NOT EXISTS Pielęgniarka
(
id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
Imię varchar(70) NOT NULL,
Nazwisko varchar(70) NOT NULL,
Sala int
) ENGINE = InnoDB;

ALTER TABLE Pielęgniarka ADD INDEX (id);

ALTER TABLE Pielęgniarka 
  ADD CONSTRAINT FOREIGN KEY (Sala) REFERENCES Sala(Numer) ON DELETE RESTRICT ON UPDATE CASCADE;

DROP TRIGGER IF EXISTS UsunZarobkiPielegniarka;

DELIMITER $$
CREATE TRIGGER UsunZarobkiPielegniarka
BEFORE DELETE ON Pielęgniarka
FOR EACH ROW
BEGIN
DELETE FROM Zarobki
WHERE (OLD.id = Zarobki.id_pracownika
AND Zarobki.Profesja = "pielegniarka");
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS DodajPielęgniarki;

DELIMITER $$
CREATE PROCEDURE DodajPielęgniarki()
NOT DETERMINISTIC
BEGIN
DECLARE otwarte int DEFAULT 201;
DECLARE ratunkowe int DEFAULT 101;
DECLARE zamkniete int DEFAULT 301;
DECLARE eksperymentalne int DEFAULT 401;
DECLARE gabinety int DEFAULT 1;
	WHILE (otwarte<=220) DO
    INSERT INTO Pielęgniarka(Imię, Nazwisko, Sala)
    VALUES ("Barbara", "Otwarta", otwarte);
	SET otwarte = otwarte + 1;
	END WHILE;
    
    WHILE (ratunkowe<=110) DO
    INSERT INTO Pielęgniarka(Imię, Nazwisko, Sala)
    VALUES ("Anna", "Ratunkowa", ratunkowe);
	SET ratunkowe = ratunkowe + 1;
	END WHILE;
    
    WHILE (zamkniete<=340) DO
    INSERT INTO Pielęgniarka(Imię, Nazwisko, Sala)
    VALUES ("Joanna", "Zamknięta", zamknięte);
	SET zamkniete = zamkniete + 1;
	END WHILE;
    
    WHILE (eksperymentalne<=410) DO
    INSERT INTO Pielęgniarka(Imię, Nazwisko, Sala)
    VALUES ("Zofia", "Eksperymentalna", eksperymentalne);
	SET eksperymentalne = eksperymentalne + 1;
	END WHILE;
END$$

CALL DodajPielęgniarki();