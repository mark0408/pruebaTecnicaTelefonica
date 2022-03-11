

insert into  practica.cliente (id, fecha_nacimiento, nombre_completo, numero_documento, tipo_documento) values (1,'2021-09-24 07:38:38','Ccori Perez Rojas','73152374','DNI');
insert into  practica.cliente (id, fecha_nacimiento, nombre_completo, numero_documento, tipo_documento) values (2,'2021-09-24 07:38:38','Jose Perez Paucar','73154374','DNI');
insert into  practica.cliente (id, fecha_nacimiento, nombre_completo, numero_documento, tipo_documento) values (3,'2021-09-24 07:38:38','Marco Torres Rojas','73122374','DNI');
insert into  practica.cliente (id, fecha_nacimiento, nombre_completo, numero_documento, tipo_documento) values (4,'2021-09-24 07:38:38','Flor Perez Gonzales','73152874','DNI');
insert into  practica.cliente (id, fecha_nacimiento, nombre_completo, numero_documento, tipo_documento) values (5,'2021-09-24 07:38:38','Ricardo Torres Moran','73155370','DNI');
insert into  practica.cliente (id, fecha_nacimiento, nombre_completo, numero_documento, tipo_documento) values (6,'2021-09-24 07:38:38','Rosio Perez Gonzales','10931528','Carnet de extranjeria');


insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (1,'activo','Plan Prepago','987546258','Prepago',1);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (2,'cancelado','Plan S/29.90','965832695','Postpago',2);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (3,'activo','Plan S/39.90','975428631','Postpago',3);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (4,'cancelado','Plan S/49.90','974823654','Postpago',4);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (5,'cancelado','Plan S/65.90','963259865','Postpago',5);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (6,'cancelado','Plan S/49.90','974823654','Postpago',2);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (7,'cancelado','Plan S/65.90','963259865','Postpago',3);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (8,'activo','Plan S/29.90','975428637','Postpago',3);
insert into  practica.linea_movil (id, estado, nombre_plan, numero_telefono, tipo, cliente) values (9,'activo','Plan S/65.90','975428635','Postpago',3);




insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (1,'C001','oferta de Plan Prepago','2022-01-10 07:38:38','2022-01-01 07:38:38',1);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (2,'C002','oferta de Plan S/29.90','2022-02-10 07:38:38','2022-02-01 07:38:38',2);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (3,'C003','oferta de Plan S/39.90','2022-03-10 07:38:38','2022-03-04 07:38:38',3);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (4,'C004','oferta de Plan S/49.90','2022-02-20 07:38:38','2022-02-01 07:38:38',4);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (5,'C005','oferta de Plan S/65.90','2022-03-28 07:38:38','2022-03-04 07:38:38',5);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (6,'C005','oferta de Plan S/65.90','2022-03-28 07:38:38','2022-03-04 07:38:38',7);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (7,'C005','oferta de Plan S/29.90','2022-03-21 07:38:38','2022-03-03 07:38:38',8);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (8,'C005','oferta de Plan S/65.90','2022-03-15 07:38:38','2022-03-02 07:38:38',9);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (9,'C002','oferta 2 de Plan S/29.90','2022-03-10 07:38:38','2022-03-01 07:38:38',2);
insert into  practica.oferta (id, codigo_oferta, descripcion_oferta, fecha_final, fecha_inicio, linea_movil) values (10,'C005','oferta 2 de Plan S/65.90','2022-04-20 07:38:38','2022-04-01 07:38:38',9);