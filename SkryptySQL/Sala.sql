DROP TABLE IF EXISTS Wizyta;
DROP TABLE IF EXISTS Pacjent, Lekarz, Pielęgniarka;
DROP TABLE IF EXISTS Choroba;
DROP TABLE IF EXISTS Sala;

CREATE TABLE IF NOT EXISTS Sala
(
Numer int UNIQUE NOT NULL,
Oddział varchar(70) NOT NULL,
CHECK (Oddział = "zamknięty" 
OR  Oddział = "otwarty" 
OR Oddział = "ratunkowy"
OR Oddział = "eksperymentalny"
OR Oddział = "gabinet"),
Miejsca int NOT NULL,
Zajęte int NOT NULL DEFAULT 0
) ENGINE = InnoDB;

ALTER TABLE Sala ADD INDEX (Numer);

DROP PROCEDURE IF EXISTS DodajSale;

DELIMITER $$
CREATE PROCEDURE DodajSale()
NOT DETERMINISTIC
BEGIN
DECLARE otwarte int DEFAULT 201;
DECLARE ratunkowe int DEFAULT 101;
DECLARE zamkniete int DEFAULT 301;
DECLARE eksperymentalne int DEFAULT 401;
DECLARE gabinety int DEFAULT 1;
	WHILE (otwarte<=220) DO
    INSERT INTO Sala(Numer, Oddział, Miejsca)
    VALUES (otwarte, "otwarty", 4);
	SET otwarte = otwarte + 1;
	END WHILE;
    
    WHILE (ratunkowe<=110) DO
    INSERT INTO Sala(Numer, Oddział, Miejsca)
    VALUES (ratunkowe, "ratunkowy", 2);
	SET ratunkowe = ratunkowe + 1;
	END WHILE;
    
    WHILE (zamkniete<=340) DO
    INSERT INTO Sala(Numer, Oddział, Miejsca)
    VALUES (zamkniete, "zamkniety", 1);
	SET zamkniete = zamkniete + 1;
	END WHILE;
    
    WHILE (eksperymentalne<=410) DO
    INSERT INTO Sala(Numer, Oddział, Miejsca)
    VALUES (eksperymentalne, "eksperymentalny", 1);
	SET eksperymentalne = eksperymentalne + 1;
	END WHILE;
    
    WHILE (gabinety<=20) DO
    INSERT INTO Sala(Numer, Oddział, Miejsca)
    VALUES (gabinety, "gabinet", 1);
	SET gabinety = gabinety + 1;
	END WHILE;
END$$

CALL DodajSale();