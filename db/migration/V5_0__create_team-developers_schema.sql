create table team_developers (
id_team int not null,
id_developer int not null,
foreign key (id_team) references team (id) on delete cascade,
foreign key (id_developer) references developer (id) on delete cascade
);
