delete from Coach;
delete from Referee;
delete from Stadion;
delete from Comand;
delete from MatchFootball;

insert into Coach (name) values ('Coach: Dan');
insert into Coach (name) values ('Coach: Alice');
insert into Coach (name) values ('Coach: Dima');
insert into Coach (name) values ('Coach: Jane');

insert into Referee (name) values ('Referee: Ann');
insert into Referee (name) values ('Referee: Lukas');
insert into Referee (name) values ('Referee: Alex');
insert into Referee (name) values ('Referee: Igor');

insert into Stadion (stadion_name, stadion_size) values ('Old Trafford', '18000');
insert into Stadion (stadion_name, stadion_size) values ('Stadio Olimpico', '24000');
insert into Stadion (stadion_name, stadion_size) values ('Mestalla', '10000');
insert into Stadion (stadion_name, stadion_size) values ('Millennium Stadium', '14500');

insert into Comand (comand_name, city, coach) values ('Manchester United', 'Manchester', '1');
insert into Comand (comand_name, city, coach) values ('Dinamo', 'Brest', '2');
insert into Comand (comand_name, city, coach) values ('Barcelona', 'Barcelona', '3');
insert into Comand (comand_name, city, coach) values ('Juventus', ' Turin', '4');

insert into MatchFootball (match_name, comand, referee, stadion) values ('Match1', '1', '2', '3');
insert into MatchFootball (match_name, comand, referee, stadion) values ('Match2', '1', '1', '2');
insert into MatchFootball (match_name, comand, referee, stadion) values ('Match3', '1', '4', '2');
insert into MatchFootball (match_name, comand, referee, stadion) values ('Match4', '1', '2', '4');