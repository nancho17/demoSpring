CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title varchar(258) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    kilometers INT NOT NULL,
    location varchar(18) NOT NULL,
    PRIMARY KEY (id)
);


