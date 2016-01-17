DROP TABLE IF EXISTS Kostnica;

CREATE TABLE IF NOT EXISTS Kostnica
(
id int PRIMARY KEY UNIQUE NOT NULL,
Data_Zgonu datetime DEFAULT NOW(),
Data_Utylizacji datetime DEFAULT NULL
);

ALTER TABLE Kostnica ADD INDEX (id);

DROP PROCEDURE IF EXISTS DoPiachu;

DELIMITER $$
CREATE PROCEDURE DoPiachu(IN id_denata int, IN data_utylizacji datetime)
DETERMINISTIC
BEGIN
DELETE FROM Pacjent
WHERE Pacjent.id = id_denata;
INSERT INTO Kostnica(id, Data_Utylizacji) VALUES
(id_denata, data_utylizacji);
END$$
