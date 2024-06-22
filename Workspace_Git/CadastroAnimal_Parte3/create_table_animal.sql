DROP TABLE Animal;

create table Animal ( tipo_animal varchar(10)
                    , caf         varchar(15)
                    , nome        varchar(100)
                    , cor_pelo    varchar(20)
                    , tipo_veneno varchar(20)
                    , preco       decimal(10,2)
					, cep		  varchar(9)
					, localidade  varchar(100)
					, logradouro  varchar(200)
					, bairro	  varchar(100)
					, uf		  varchar(2) );

insert into Animal values ( "CACHORRO", 01, "CAO 01",   "COR PELO 1", null,      0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP" );
insert into Animal values ( "CACHORRO", 02, "CAO 02",   "COR PELO 2", null,      0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP" );
insert into Animal values ( "CACHORRO", 03, "CAO 03",   "COR PELO 3", null,      0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP");
insert into Animal values ( "CACHORRO", 04, "CAO 04",   "COR PELO 4", null,      0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP");
--
insert into Animal values ( "COBRA",    01, "COBRA 01", NULL,        "VENENO 01", 0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP");
insert into Animal values ( "COBRA",    02, "COBRA 02", NULL,        "VENENO 02", 0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP");
insert into Animal values ( "COBRA",    03, "COBRA 03", NULL,        "VENENO 03", 0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP");
insert into Animal values ( "COBRA",    04, "COBRA 04", NULL,        "VENENO 04", 0, "03422-000", "Localidade", "Logradouro", "Bairro", "SP");
--
SELECT * FROM ANIMAL
ORDER BY 1, 2;
COMMIT;
