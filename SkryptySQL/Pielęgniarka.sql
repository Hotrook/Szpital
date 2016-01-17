DROP TABLE IF EXISTS Pielegniarka;

CREATE TABLE IF NOT EXISTS Pielegniarka
(
id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
Imie varchar(70) NOT NULL,
Nazwisko varchar(70) NOT NULL,
Sala int
) ENGINE = InnoDB;

ALTER TABLE Pielegniarka ADD INDEX (id);

ALTER TABLE Pielegniarka 
  ADD CONSTRAINT FOREIGN KEY (Sala) REFERENCES Sala(Numer) ON DELETE RESTRICT ON UPDATE CASCADE;

DROP TRIGGER IF EXISTS UsunZarobkiPielegniarka;

DELIMITER $$
CREATE TRIGGER UsunZarobkiPielegniarka
BEFORE DELETE ON Pielegniarka
FOR EACH ROW
BEGIN
DELETE FROM Zarobki
WHERE (OLD.id = Zarobki.id_pracownika
AND Zarobki.Profesja = "pielegniarka");
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS DodajPielegniarki;

DELIMITER $$
CREATE PROCEDURE DodajPielegniarki()
NOT DETERMINISTIC
BEGIN
DECLARE otwarte int DEFAULT 201;
DECLARE ratunkowe int DEFAULT 101;
DECLARE zamkniete int DEFAULT 301;
DECLARE eksperymentalne int DEFAULT 401;
DECLARE gabinety int DEFAULT 1;
	WHILE (otwarte<=220) DO
    INSERT INTO Pielegniarka(Imie, Nazwisko, Sala)
    VALUES ("Barbara", "Otwarta", otwarte);
	SET otwarte = otwarte + 1;
	END WHILE;
    
    WHILE (ratunkowe<=110) DO
    INSERT INTO Pielegniarka(Imie, Nazwisko, Sala)
    VALUES ("Anna", "Ratunkowa", ratunkowe);
	SET ratunkowe = ratunkowe + 1;
	END WHILE;
    
    WHILE (zamkniete<=340) DO
    INSERT INTO Pielegniarka(Imie, Nazwisko, Sala)
    VALUES ("Joanna", "Zamknieta", zamkniete);
	SET zamkniete = zamkniete + 1;
	END WHILE;
    
    WHILE (eksperymentalne<=410) DO
    INSERT INTO Pielegniarka(Imie, Nazwisko, Sala)
    VALUES ("Zofia", "Eksperymentalna", eksperymentalne);
	SET eksperymentalne = eksperymentalne + 1;
	END WHILE;
END$$

CALL DodajPielegniarki();