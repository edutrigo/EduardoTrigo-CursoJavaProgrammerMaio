DROP TABLE Animal;

create table Animal ( tipo_animal varchar(10)
                    , caf         varchar(15)
                    , nome        varchar(100)
                    , cor_pelo    varchar(10)
                    , tipo_veneno varchar(10) );
					

insert into Animal values ( "CACHORRO", 01, "CAO 01", "COR PELO 1", NULL );
insert into Animal values ( "CACHORRO", 02, "CAO 02", "COR PELO 2", NULL );
insert into Animal values ( "CACHORRO", 03, "CAO 03", "COR PELO 3", NULL );
insert into Animal values ( "CACHORRO", 04, "CAO 04", "COR PELO 4", NULL );
--
insert into Animal values ( "COBRA", 01, "COBRA 01", NULL, "VENENO 01" );
insert into Animal values ( "COBRA", 02, "COBRA 02", NULL, "VENENO 02" );
insert into Animal values ( "COBRA", 03, "COBRA 03", NULL, "VENENO 03" );
insert into Animal values ( "COBRA", 04, "COBRA 04", NULL, "VENENO 04" );
--
SELECT * FROM ANIMAL
ORDER BY 1, 2;
COMMIT;
