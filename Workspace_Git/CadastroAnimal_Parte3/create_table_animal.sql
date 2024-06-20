DROP TABLE Animal;

create table Animal ( tipo_animal varchar(10)
                    , caf         varchar(15)
                    , nome        varchar(100)
                    , cor_pelo    varchar(20)
                    , tipo_veneno varchar(20)
                    , preco       decimal(10,2)
					, cep		  varchar(8);
					, localidade  varchar(100);
					, logradouro  varchar(200);
					, bairro	  varchar(100);
					, uf		  varchar(2) );

insert into Animal values ( "CACHORRO", 01, "CAO 01", "COR PELO 1", NULL, null, null, null, null, null, null );
insert into Animal values ( "CACHORRO", 02, "CAO 02", "COR PELO 2", NULL, null, null, null, null, null, null );
insert into Animal values ( "CACHORRO", 03, "CAO 03", "COR PELO 3", NULL, null, null, null, null, null, null );
insert into Animal values ( "CACHORRO", 04, "CAO 04", "COR PELO 4", NULL, null, null, null, null, null, null );
--
insert into Animal values ( "COBRA", 01, "COBRA 01", NULL, "VENENO 01", null, null, null, null, null, null );
insert into Animal values ( "COBRA", 02, "COBRA 02", NULL, "VENENO 02", null, null, null, null, null, null );
insert into Animal values ( "COBRA", 03, "COBRA 03", NULL, "VENENO 03", null, null, null, null, null, null );
insert into Animal values ( "COBRA", 04, "COBRA 04", NULL, "VENENO 04", null, null, null, null, null, null );
--
SELECT * FROM ANIMAL
ORDER BY 1, 2;
COMMIT;
