DROP TABLE IF EXISTS Lekarz;

CREATE TABLE IF NOT EXISTS Lekarz
(
id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
Imię varchar(70) NOT NULL,
Nazwisko varchar(70) NOT NULL,
Stopień varchar(70),
CHECK (Stopień = "lekarz medycyny" 
OR  Stopień = "doktor medycyny" 
OR Stopień = "doktor habilitowany medycyny" 
OR Stopień = "profesor medycyny"),
Specjalizacja varchar(70)
CHECK (Specjalizacja = "psychiatra" 
OR  Specjalizacja = "internista" 
OR Specjalizacja = "dentysta"),
Gabinet int
) ENGINE = InnoDB;

ALTER TABLE Lekarz ADD INDEX (id);

ALTER TABLE Lekarz 
  ADD CONSTRAINT FOREIGN KEY (Gabinet) REFERENCES Sala(Numer) ON DELETE RESTRICT ON UPDATE CASCADE;

DROP TRIGGER IF EXISTS UsunZarobkiLekarz;
 
DELIMITER $$
CREATE TRIGGER UsunZarobkiLekarz
BEFORE DELETE ON Lekarz
FOR EACH ROW
BEGIN
DELETE FROM Zarobki
WHERE (OLD.id = Zarobki.id_pracownika
AND Zarobki.Profesja = "lekarz");
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS PrzydzielGabinet;

DELIMITER $$
CREATE TRIGGER PrzydzielGabinet
BEFORE INSERT ON Lekarz
FOR EACH ROW
BEGIN
DECLARE numersali int DEFAULT 0;
DECLARE znaleziona bit DEFAULT 0;
WHILE(znaleziona = 0) DO
	SET numersali = numersali + 1;
    IF EXISTS(SELECT * FROM Sala WHERE (Zajęte<Miejsca AND Sala.Numer = numersali))THEN
		SET znaleziona = 1;
        SET NEW.Gabinet = numersali;
    END IF;
	UPDATE Sala
	SET Sala.Zajęte = Sala.Zajęte + 1
	WHERE (Sala.Numer = numersali AND Sala.Oddział = "gabinet" AND Sala.Zajęte<Sala.Miejsca);
END WHILE;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS DodajLekarzy;

DELIMITER $$
CREATE PROCEDURE DodajLekarzy()
NOT DETERMINISTIC
BEGIN
    INSERT INTO Lekarz(Imię, Nazwisko, Stopień, Specjalizacja)
    VALUES 
    ("Marcin", "Dziemieszonek", "profesor medycyny", "psychiatra"),
    ("Robert", "Fajka", "doktor habilitowany medycyny", "psychiatra"),
    ("Damian", "Gryzipiórek", "doktor habilitowany medycyny", "psychiatra"),
    ("Florian", "Młotek", "doktor medycyny", "psychiatra"),
    ("Krzystof", "Skrzetuski", "doktor medycyny", "psychiatra"),
    ("Dawid", "Kowalski", "doktor medycyny", "psychiatra"),
    ("Jarosław", "Poznański", "doktor medycyny", "psychiatra"),
    ("Michał", "Gadowicz", "lekarz medycyny", "psychiatra"),
    ("Sebastian", "Mróz", "lekarz medycyny", "psychiatra"),
    ("Jolanta", "Dziemieszonek", "lekarz medycyny", "psychiatra"),
    ("Małgorzata", "Pawlak", "lekarz medycyny", "psychiatra"),
    ("Katarzyna", "Kwiatkowska", "lekarz medycyny", "psychiatra"),
    ("Paweł", "Prostacki", "lekarz medycyny", "psychiatra"),
    ("Ilona", "Kowalska", "lekarz medycyny", "psychiatra"),
    ("Fryderyk", "Nowak", "lekarz medycyny", "psychiatra"),
    ("Hanna", "Miła", "doktor medycyny", "internista"),
    ("Zuzanna", "Pogrzaniecka", "doktor medycyny", "internista"),
    ("Piotr", "Podgórski", "lekarz medycyny", "internista"),
    ("Franciszek", "Kleeberg", "lekarz medycyny", "dentysta"),
    ("Bazyli", "Świątkowski", "lekarz medycyny", "dentysta");
END$$

CALL DodajLekarzy();