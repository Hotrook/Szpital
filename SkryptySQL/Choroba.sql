DROP TABLE IF EXISTS Choroba;

CREATE TABLE IF NOT EXISTS Choroba
(
Nazwa varchar(70) UNIQUE PRIMARY KEY,
Stopien_Zagrozenia int NOT NULL,
CHECK (Stopien_Zagrozenia>0 
AND Stopien_Zagrozenia<6)
) ENGINE = InnoDB;

ALTER TABLE Choroba ADD INDEX (Nazwa);

DROP PROCEDURE IF EXISTS DodajChoroby;

DELIMITER $$
CREATE PROCEDURE DodajChoroby()
NOT DETERMINISTIC
BEGIN
    INSERT INTO Choroba(Nazwa, Stopien_Zagrozenia)
    VALUES 
    ("Anoreksja", 5),
	("Depresja", 4),
    ("Autyzm", 1),
    ("Bulimia", 4),
    ("Nekrofilia", 3),
    ("Fobia", 3),
    ("Mania", 4),
    ("Nerwica", 4),
    ("Pochwica", 1),
    ("Seksoholizm", 1),
	("Synestezja", 2),
    ("Psychoza Alkoholowa", 5),
    ("Zespol Aspergera", 2),
    ("Zaburzenia Osobowoeci", 4),
    ("Transseksualizm", 1),
    ("Zespol Paniki", 2),
    ("Otepienie", 1),
    ("Zoofobia", 2),
    ("OCD", 2),
    ("Schizofrenia", 4);
END$$

CALL DodajChoroby();