# Cvičenie 1

Cieľom cvičenia je implementácia jednoduchej Java aplikácie, ktorá sa pomocou JDBC pripojí na lokálnu databázu, prečíta a vypíše obsah tabuľky 'Books'.

V Main triede sa nachádzajú dve metódy na otestovanie spojenia s H2 databázou a MySQL databázou.

## H2

H2 databáza a spúšťa v embedded móde a všetky dáta sú ukladané do súboru ```database.mv.db```. Pre otestovanie databázy preto nepotrebujete nič inštalovať.

## MySQL

Pre otestovanie MySQL databázy je potrebné stiahnuť a nainštalovať si danú databázu. Podľa verzie databázy treba použiť správnu verziu drivera v ```pom.xml```. Po nainštalovaní databázy je potrebné vytvoriť novú schému s názvom ```vsa``` a pomocou nasledovných príkazov vytvoriť a naplniť tabuľku 'Books' (alebo spustiť ```mysql_start.sql```):

```sql
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
```