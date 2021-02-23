create table Books
(
    id     int          not null,
    title  varchar(200) not null,
    price  double       null,
    constraint Books_id_uindex
        unique (id)
);

alter table Books
    add primary key (id);

INSERT INTO Books (id, title, price) VALUES (1, 'Title 1', 10);
INSERT INTO Books (id, title, price) VALUES (2, 'Title 2', 200);
INSERT INTO Books (id, title, price) VALUES (3, 'Title 3', 45);