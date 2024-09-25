//TABLE TO USE IN RESIDENTS ENTITY TO MAP POSSIBLES APARTMENTS IN THE SAME RESIDENTS

CREATE TABLE residents_apartments (
    resident_id INT,
    apartments_id INT,
    FOREIGN KEY (resident_id) REFERENCES resident(id),
    FOREIGN KEY (apartments_id_id) REFERENCES apartment(id)
);