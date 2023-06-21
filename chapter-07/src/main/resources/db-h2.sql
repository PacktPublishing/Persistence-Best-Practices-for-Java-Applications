DROP TABLE IF EXISTS book
;
CREATE TABLE book (
                      id INT NOT NULL,
                      title VARCHAR(400) NOT NULL,
                      author VARCHAR(400) NOT NULL,
                      release INT,

                      CONSTRAINT pk_t_book PRIMARY KEY (id)
)
;

INSERT INTO book VALUES (1, 'Fundamentals of Software Architectur', 'Neal Ford' , 2020)
;

INSERT INTO book VALUES (2, 'Staff Engineer: Leadership beyond the management track', 'Will Larson' , 2021)
;

INSERT INTO book VALUES (3, 'Building Evolutionary Architectures', 'Neal Ford' , 2017)
;

INSERT INTO book VALUES (4, 'Clean Code', 'Robert Cecil Martin' , 2008)
;

INSERT INTO book VALUES (5, 'Patterns of Enterprise Application Architecture', 'Martin Fowler' , 2002)
;