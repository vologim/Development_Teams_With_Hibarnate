create table developer_skills (
id_developer int not null,
id_skill int not null,
foreign key (id_developer) references developer (id) on delete cascade,
foreign key (id_skill) references skill (id) on delete cascade
);
