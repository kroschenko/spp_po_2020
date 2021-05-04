create table if not exists Coach (
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null
);

create table if not exists Referee (
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null
);

create table if not exists Stadion (
id int AUTO_INCREMENT PRIMARY KEY,
stadion_name varchar(255) not null,
stadion_size varchar(255) not null
);

create table if not exists Comand (
id int AUTO_INCREMENT PRIMARY KEY,
comand_name varchar(255) not null,
city varchar(255) not null,
coach int not null,
foreign key (coach) references Coach(id)
);

create table if not exists MatchFootball (
id int AUTO_INCREMENT PRIMARY KEY,
match_name varchar(255) not null,
comand int not null,
referee int not null,
stadion int not null,
foreign key (comand) references Comand(id),
foreign key (referee) references Referee(id),
foreign key (stadion) references Stadion(id)
);
