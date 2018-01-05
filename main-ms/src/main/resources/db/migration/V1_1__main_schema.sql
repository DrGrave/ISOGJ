SET character_set_client = utf8;
SET character_set_results = utf8;
SET character_set_connection = utf8;

create table city
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDB
;



create table company
(
  id bigint auto_increment primary key,
  date_of_creation datetime null,
  info varchar(255) null,
  name varchar(255) null,
  city_of_company bigint null,
  constraint FKbk2fldd8i3j16sxhiv7u1wlum
  foreign key (city_of_company) references city (id)
)
  engine=InnoDB
;

create index FKbk2fldd8i3j16sxhiv7u1wlum
  on company (city_of_company)
;

create table education
(
  id bigint auto_increment
  primary key,
  end_of_education datetime null,
  start_of_education datetime null,
  faculty_id bigint null,
  school bigint null,
  type_of_education bigint null,
  user bigint null
)
  engine=InnoDB
;

create index FK198l9sf1b0xanx6mp4au0cmgf
  on education (type_of_education)
;

create index FK2mvosaxmdk20x35f654ykcplj
  on education (user)
;

create index FKaisuay6bqm69r0pd1omskh0l8
  on education (school)
;

create index FKtchrwogqsqbxdtmm32cjdl7v2
  on education (faculty_id)
;

create table experience
(
  id bigint auto_increment
  primary key,
  date_of_end datetime null,
  date_of_start datetime null,
  prev_company bigint null,
  user bigint null,
  constraint FKc19dq0h5qymr9epwviyngjxic
  foreign key (prev_company) references company (id)
)
  engine=InnoDB
;



create index FKc19dq0h5qymr9epwviyngjxic
  on experience (prev_company)
;

create index FKsal35eberq8nmfvfis0bxp5j
  on experience (user)
;

create table faculty
(
  id bigint auto_increment
  primary key,
  name varchar(255) null,
  university bigint null
)
  engine=InnoDB
;



create index FKl1hcf6t7l10y28o108exht46d
  on faculty (university)
;

alter table education
  add constraint FKtchrwogqsqbxdtmm32cjdl7v2
  foreign key (faculty_id) references faculty (id)
;

create table gender
(
  id bigint auto_increment
  primary key,
  name varchar(255) not null
)
  engine=InnoDB
;



create table position
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDB
;



create table possible_cities_to_work
(
  id_user bigint not null,
  id_city bigint not null,
  primary key (id_user, id_city),
  constraint FK2pykxv9f2pgdoa7298s3pxpgn
  foreign key (id_city) references city (id)
)
  engine=InnoDB
;



create index FK2pykxv9f2pgdoa7298s3pxpgn
  on possible_cities_to_work (id_city)
;

create table school
(
  id bigint auto_increment
  primary key,
  name varchar(255) null,
  city bigint null,
  constraint FKfoakajih50nlit17nuymdsc4w
  foreign key (city) references city (id)
)
  engine=InnoDB
;



create index FKfoakajih50nlit17nuymdsc4w
  on school (city)
;

alter table education
  add constraint FKaisuay6bqm69r0pd1omskh0l8
  foreign key (school) references school (id)
;

create table skill
(
  id bigint auto_increment
  primary key,
  name varchar(255) null,
  type_of_skill bigint not null
)
  engine=InnoDB
;



create index FK2pq7nkn4vi1tw0f3sh9te20ak
  on skill (type_of_skill)
;

create table summary
(
  id bigint auto_increment
  primary key,
  text varchar(255) null,
  user bigint null
)
  engine=InnoDB
;



create index FKsr71us8i74ib72m71y2jy21tc
  on summary (user)
;

create table task
(
  id bigint auto_increment
  primary key,
  info varchar(255) null,
  name varchar(255) null,
  type_of_task bigint null
)
  engine=InnoDB
;



create index FKhnxotnqsbea4shipxmjxk4a1v
  on task (type_of_task)
;

create table temp_user
(
  id bigint auto_increment
  primary key,
  confirm_link varchar(255) null,
  email varchar(255) null,
  first_name varchar(255) null,
  last_name varchar(255) null,
  middle_name varchar(255) null,
  password varchar(255) null,
  username varchar(255) null
)
  engine=InnoDB
;


create table type_of_education
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDB
;



alter table education
  add constraint FK198l9sf1b0xanx6mp4au0cmgf
  foreign key (type_of_education) references type_of_education (id)
;

create table type_of_skill
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDB
;



alter table skill
  add constraint FK2pq7nkn4vi1tw0f3sh9te20ak
  foreign key (type_of_skill) references type_of_skill (id)
;

create table type_of_task
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDB
;



alter table task
  add constraint FKhnxotnqsbea4shipxmjxk4a1v
  foreign key (type_of_task) references type_of_task (id)
;

create table type_of_user
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDB
;



create table type_of_vacancy
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDB
;



create table university
(
  id bigint auto_increment
  primary key,
  name varchar(255) null,
  city bigint null,
  constraint FKgpb65dw0enw32ntji9bjuhr0l
  foreign key (city) references city (id)
)
  engine=InnoDB
;



create index FKgpb65dw0enw32ntji9bjuhr0l
  on university (city)
;

alter table faculty
  add constraint FKl1hcf6t7l10y28o108exht46d
  foreign key (university) references university (id)
;

create table user
(
  id bigint auto_increment
  primary key,
  active bit null,
  email varchar(255) not null,
  first_name varchar(255) not null,
  last_name varchar(255) not null,
  middle_name varchar(255) not null,
  username varchar(255) not null,
  city_of_living bigint null,
  gender bigint null,
  type_of_user bigint null,
  constraint FKkrcm363wm8xl5ydosqnynmhym
  foreign key (city_of_living) references city (id),
  constraint FK1isrcw5olh4k3cddck2x7um5p
  foreign key (gender) references gender (id),
  constraint FKgcjmd56vdfe8y4uxwq5jb852d
  foreign key (type_of_user) references type_of_user (id)
)
  engine=InnoDB
;



create index FK1isrcw5olh4k3cddck2x7um5p
  on user (gender)
;

create index FKgcjmd56vdfe8y4uxwq5jb852d
  on user (type_of_user)
;

create index FKkrcm363wm8xl5ydosqnynmhym
  on user (city_of_living)
;

alter table education
  add constraint FK2mvosaxmdk20x35f654ykcplj
  foreign key (user) references user (id)
;

alter table experience
  add constraint FKsal35eberq8nmfvfis0bxp5j
  foreign key (user) references user (id)
;

alter table possible_cities_to_work
  add constraint FKhawf6m0kjxwn02ajtgjpjbam7
  foreign key (id_user) references user (id)
;

alter table summary
  add constraint FKsr71us8i74ib72m71y2jy21tc
  foreign key (user) references user (id)
;

create table user_company
(
  id_user_company int auto_increment
  primary key,
  company bigint null,
  position bigint null,
  user bigint null,
  constraint FKi6q4u3i9d85h47qjn7w7p9687
  foreign key (company) references company (id),
  constraint FKc1goa9mr96odm0l38subly2jf
  foreign key (position) references position (id),
  constraint FKopbeqqs42qr4nhq4ew10dt069
  foreign key (user) references user (id)
)
  engine=InnoDB
;



create index FKc1goa9mr96odm0l38subly2jf
  on user_company (position)
;

create index FKi6q4u3i9d85h47qjn7w7p9687
  on user_company (company)
;

create index FKopbeqqs42qr4nhq4ew10dt069
  on user_company (user)
;

create table user_skill
(
  id bigint auto_increment
  primary key,
  end_skilling datetime null,
  skill_mark varchar(255) null,
  skill_practical_mark varchar(255) null,
  start_skilling datetime null,
  id_marker bigint null,
  id_skill bigint null,
  id_user bigint null,
  constraint FK6pru830ugj5nuapp3nhdl2p9p
  foreign key (id_marker) references user (id),
  constraint FKrsvxrshr30q4756yoxncoaeyl
  foreign key (id_skill) references skill (id),
  constraint FKkwwol8ie05lcjsko1qewnm6r7
  foreign key (id_user) references user (id)
)
  engine=InnoDB
;



create index FK6pru830ugj5nuapp3nhdl2p9p
  on user_skill (id_marker)
;

create index FKkwwol8ie05lcjsko1qewnm6r7
  on user_skill (id_user)
;

create index FKrsvxrshr30q4756yoxncoaeyl
  on user_skill (id_skill)
;

create table vacancy
(
  id bigint auto_increment
  primary key,
  info varchar(255) null,
  company bigint null,
  task bigint null,
  type_of_vacancy bigint null,
  constraint FKd8i1boc2bf2p3pmtgi3ucxyqf
  foreign key (company) references company (id),
  constraint FK88okuegm0qxj10q8nrp4odo97
  foreign key (task) references task (id),
  constraint FKg1qrdnkrpjlkt2fr9twump8pt
  foreign key (type_of_vacancy) references type_of_vacancy (id)
)
  engine=InnoDB
;



create index FK88okuegm0qxj10q8nrp4odo97
  on vacancy (task)
;

create index FKd8i1boc2bf2p3pmtgi3ucxyqf
  on vacancy (company)
;

create index FKg1qrdnkrpjlkt2fr9twump8pt
  on vacancy (type_of_vacancy)
;

create table vacancy_skill
(
  id bigint auto_increment
  primary key,
  expected_mark varchar(255) null,
  skill bigint null,
  vacancy bigint null,
  constraint FKk10dm3uxe9tlepfwottw6q072
  foreign key (skill) references skill (id),
  constraint FKogk31vh34wanbyjgvq8yer6hi
  foreign key (vacancy) references vacancy (id)
)
  engine=InnoDB
;



create index FKk10dm3uxe9tlepfwottw6q072
  on vacancy_skill (skill)
;

create index FKogk31vh34wanbyjgvq8yer6hi
  on vacancy_skill (vacancy)
;

create table vacancy_user
(
  id bigint auto_increment
  primary key,
  if_accepted_user bit null,
  if_company_accepted bit null,
  user bigint null,
  vacancy bigint null,
  constraint FKgqk92dw8f09b5kttg02uff0rm
  foreign key (user) references user (id),
  constraint FKpe3ak6fx2jbgormipmkxy9rff
  foreign key (vacancy) references vacancy (id)
)
  engine=InnoDB
;


create index FKgqk92dw8f09b5kttg02uff0rm
  on vacancy_user (user)
;

create index FKpe3ak6fx2jbgormipmkxy9rff
  on vacancy_user (vacancy)
;

