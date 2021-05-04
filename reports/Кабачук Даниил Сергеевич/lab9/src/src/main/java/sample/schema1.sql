create table if not exists Departments (
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null
);

create table if not exists Type_Equipment (
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null
);

create table if not exists Manufacturers (
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null,
warranty varchar(255) not null
);

create table if not exists Employees (
id int AUTO_INCREMENT PRIMARY KEY,
fname varchar(255) not null,
lname varchar(255) not null,
department int not null,
foreign key (department) references Departments(id)
);

create table if not exists Equipment (
id int AUTO_INCREMENT PRIMARY KEY,
registration_number varchar(255) not null,
type_equipment int not null,
manufacturer int not null,
employee int not null,
foreign key (type_equipment) references Type_Equipment(id),
foreign key (manufacturer) references Manufacturers(id),
foreign key (employee) references Employees(id)
);
