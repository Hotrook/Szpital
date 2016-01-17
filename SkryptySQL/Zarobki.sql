DROP TABLE IF EXISTS Zarobki;

CREATE TABLE IF NOT EXISTS Zarobki
(
id_pracownika int NOT NULL,
Profesja varchar(70) NOT NULL,
CHECK(Profesja = "lekarz"
OR Profesja = "pielegniarka"),
Stanowisko varchar(70),
CHECK(Stanowisko = "dyrektor"
OR Stanowisko = "wicedyrektor"
OR Stanowisko = "ordynator"
OR Stanowisko = "lekarz dyżurny"
OR Stanowisko = "oddzialowa"
OR Stanowisko = "salowa"),
Miesięcznie int
CHECK (Miesięcznie>100)
) ENGINE = InnoDB;

DROP PROCEDURE IF EXISTS DodajZarobki;

DELIMITER $$
CREATE PROCEDURE DodajZarobki()
NOT DETERMINISTIC
BEGIN
DECLARE iterator int DEFAULT 1;
INSERT INTO Zarobki(id_pracownika, Profesja, Stanowisko, Miesięcznie)
VALUES 
(1, "lekarz", "dyrektor", 10000),
(2, "lekarz", "wicedyrektor", 7000),
(3, "lekarz", "ordynator", 6000),
(4, "lekarz", "ordynator", 6000),
(5, "lekarz", "ordynator", 6000),
(6, "lekarz", "ordynator", 6000),
(7, "lekarz", "lekarz dyzurny", 4000),
(8, "lekarz", "lekarz dyzurny", 4000),
(9, "lekarz", "lekarz dyzurny", 4000),
(10, "lekarz", "lekarz dyzurny", 4000),
(11, "lekarz", "lekarz dyzurny", 4000),
(12, "lekarz", "lekarz dyzurny", 4000),
(13, "lekarz", "lekarz dyzurny", 4000),
(14, "lekarz", "lekarz dyzurny", 4000),
(15, "lekarz", "lekarz dyzurny", 4000),
(16, "lekarz", "lekarz dyzurny", 4000),
(17, "lekarz", "lekarz dyzurny", 4000),
(18, "lekarz", "lekarz dyzurny", 4000),
(19, "lekarz", "lekarz dyzurny", 4000),
(20, "lekarz", "lekarz dyzurny", 4000);
WHILE (iterator<=80) DO
	IF iterator=1 OR iterator=21 OR iterator=31 OR iterator=71 THEN
		INSERT INTO Zarobki(id_pracownika, Profesja, Stanowisko, Miesięcznie)
		VALUES (iterator, "pielegniarka", "oddzialowa", 2000);
	ELSE
		INSERT INTO Zarobki(id_pracownika, Profesja, Stanowisko, Miesięcznie)
		VALUES (iterator, "pielegniarka", "salowa", 1500);
    END IF;
	SET iterator = iterator + 1;
END WHILE;    
END$$

CALL DodajZarobki();