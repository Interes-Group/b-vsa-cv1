create table Books
(
    id     int          not null,
    title  varchar(200) not null,
    author varchar(200) null,
    constraint Books_id_uindex
        unique (id)
);

alter table Books
    add primary key (id);

INSERT INTO vsa.Books (id, title, author) VALUES (1, 'Title 1', 'Author 1');
INSERT INTO vsa.Books (id, title, author) VALUES (2, 'Title 2', 'Author 2');
INSERT INTO vsa.Books (id, title, author) VALUES (3, 'Title 3', 'Author 3');