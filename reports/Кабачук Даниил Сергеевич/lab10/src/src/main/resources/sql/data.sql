delete from Equipment;
delete from Employees;
delete from Departments;
delete from Type_Equipment;
delete from Manufacturers;



insert into Departments (name) values ('Human resources department');
insert into Departments (name) values ('Sales department');
insert into Departments (name) values ('Marketing department');
insert into Departments (name) values ('Reception');

insert into Type_Equipment (name) values ('Сomputer');
insert into Type_Equipment (name) values ('Printer');
insert into Type_Equipment (name) values ('Server');
insert into Type_Equipment (name) values ('Telephone');

insert into Manufacturers (name, warranty) values ('Acer', '12');
insert into Manufacturers (name, warranty) values ('Lenovo', '24');
insert into Manufacturers (name, warranty) values ('Intel', '36');
insert into Manufacturers (name, warranty) values ('Dell', '48');

insert into Employees (fname, lname, department) values ('Margarita', 'Abramova', '1');
insert into Employees (fname, lname, department) values ('Victoria', 'Nosova', '2');
insert into Employees (fname, lname, department) values ('Evgeniya', 'Kharitonova', '3');
insert into Employees (fname, lname, department) values ('Alexander', ' Yakovlev', '4');

insert into Equipment (registration_number, type_equipment, manufacturer, employee) values ('ab1', '3', '2', '1');
insert into Equipment (registration_number, type_equipment, manufacturer, employee) values ('ab2', '1', '1', '2');
insert into Equipment (registration_number, type_equipment, manufacturer, employee) values ('ab3', '2', '4', '3');
insert into Equipment (registration_number, type_equipment, manufacturer, employee) values ('ab4', '1', '3', '4');