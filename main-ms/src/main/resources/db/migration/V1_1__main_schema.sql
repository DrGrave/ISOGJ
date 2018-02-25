create table city
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create table company
(
  id bigint auto_increment
  primary key,
  date_of_creation datetime null,
  info varchar(255) null,
  name varchar(255) null,
  company_logo varchar(255) null,
  city_of_company bigint null,
  constraint FKbk2fldd8i3j16sxhiv7u1wlum
  foreign key (city_of_company) references city (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FKbk2fldd8i3j16sxhiv7u1wlum
  on company (city_of_company)
;

create table department
(
  id bigint auto_increment
  primary key,
  name varchar(255) null,
  faculty bigint null
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FK6sk1ry6h6g5ejrihwm8haf88l
  on department (faculty)
;

create table education
(
  id bigint auto_increment
  primary key,
  end_of_education datetime null,
  start_of_education datetime null,
  department bigint null,
  school bigint null,
  type_of_education bigint null,
  user bigint null,
  constraint FK63tr6a4xjq3e62tq52gmt5twn
  foreign key (department) references department (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FK63tr6a4xjq3e62tq52gmt5twn
  on education (department)
;

create index FKaisuay6bqm69r0pd1omskh0l8
  on education (school)
;

create index FK198l9sf1b0xanx6mp4au0cmgf
  on education (type_of_education)
;

create index FK2mvosaxmdk20x35f654ykcplj
  on education (user)
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FKl1hcf6t7l10y28o108exht46d
  on faculty (university)
;

alter table department
  add constraint FK6sk1ry6h6g5ejrihwm8haf88l
  foreign key (faculty) references faculty (id)
;

create table gender
(
  id bigint auto_increment
  primary key,
  name varchar(255) not null
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create table position
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create table possible_cities_to_work
(
  id_user bigint not null,
  id_city bigint not null,
  primary key (id_user, id_city),
  constraint FK2pykxv9f2pgdoa7298s3pxpgn
  foreign key (id_city) references city (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  username varchar(255) null,
  birthday datetime null
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create table type_of_education
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

alter table education
  add constraint FK198l9sf1b0xanx6mp4au0cmgf
  foreign key (type_of_education) references type_of_education (id)
;

create table type_of_link
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create table type_of_skill
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
;

create table type_of_vacancy
(
  id bigint auto_increment
  primary key,
  name varchar(255) null
)
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  middle_name varchar(255) null,
  username varchar(255) not null,
  city_of_living bigint null,
  gender bigint null,
  type_of_user bigint null,
  uid bigint not null,
  birthday datetime null,
  constraint user_uid_uindex
  unique (uid),
  constraint FKkrcm363wm8xl5ydosqnynmhym
  foreign key (city_of_living) references city (id),
  constraint FK1isrcw5olh4k3cddck2x7um5p
  foreign key (gender) references gender (id),
  constraint FKgcjmd56vdfe8y4uxwq5jb852d
  foreign key (type_of_user) references type_of_user (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FKkrcm363wm8xl5ydosqnynmhym
  on user (city_of_living)
;

create index FK1isrcw5olh4k3cddck2x7um5p
  on user (gender)
;

create index FKgcjmd56vdfe8y4uxwq5jb852d
  on user (type_of_user)
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
  id_user_company bigint auto_increment
  primary key,
  company bigint null,
  position bigint null,
  user bigint null,
  company_approve tinyint(1) default '0' null,
  change_approve tinyint(1) default '0' null,
  constraint FKi6q4u3i9d85h47qjn7w7p9687
  foreign key (company) references company (id),
  constraint FKc1goa9mr96odm0l38subly2jf
  foreign key (position) references position (id),
  constraint FKopbeqqs42qr4nhq4ew10dt069
  foreign key (user) references user (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FKi6q4u3i9d85h47qjn7w7p9687
  on user_company (company)
;

create index FKc1goa9mr96odm0l38subly2jf
  on user_company (position)
;

create index FKopbeqqs42qr4nhq4ew10dt069
  on user_company (user)
;

create table user_link
(
  id bigint auto_increment
  primary key,
  link varchar(255) null,
  type_of_link bigint null,
  user bigint null,
  constraint FK87htt7kka5c380ilp3vk0efqm
  foreign key (type_of_link) references type_of_link (id),
  constraint FKb6w40vevtg43uda0m72yddfb7
  foreign key (user) references user (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FK87htt7kka5c380ilp3vk0efqm
  on user_link (type_of_link)
;

create index FKb6w40vevtg43uda0m72yddfb7
  on user_link (user)
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
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FK6pru830ugj5nuapp3nhdl2p9p
  on user_skill (id_marker)
;

create index FKrsvxrshr30q4756yoxncoaeyl
  on user_skill (id_skill)
;

create index FKkwwol8ie05lcjsko1qewnm6r7
  on user_skill (id_user)
;

create table vacancy
(
  id bigint auto_increment
  primary key,
  info varchar(255) null,
  company bigint null,
  type_of_vacancy bigint null,
  constraint FKd8i1boc2bf2p3pmtgi3ucxyqf
  foreign key (company) references company (id),
  constraint FKg1qrdnkrpjlkt2fr9twump8pt
  foreign key (type_of_vacancy) references type_of_vacancy (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FKd8i1boc2bf2p3pmtgi3ucxyqf
  on vacancy (company)
;

create index FKg1qrdnkrpjlkt2fr9twump8pt
  on vacancy (type_of_vacancy)
;

create table task_skill
(
  id bigint auto_increment
  primary key,
  skill bigint null,
  task bigint null,
  constraint FKrqovwv8qhc3vt1r5etshfs0ge
  foreign key (skill) references skill (id),
  constraint FK531rx05uc86qlhwtkx049ce18
  foreign key (task) references task (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FKrqovwv8qhc3vt1r5etshfs0ge
  on task_skill (skill)
;

create index FK531rx05uc86qlhwtkx049ce18
  on task_skill (task)
;

create table vacancy_task
(
  id bigint auto_increment
  primary key,
  task bigint null,
  vacancy bigint null,
  constraint FK6ba9j9jtk95526blq7994470h
  foreign key (task) references task (id),
  constraint FKsfm3668avg4bw12qfax2slrrd
  foreign key (vacancy) references vacancy (id)
)
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FK6ba9j9jtk95526blq7994470h
	on vacancy_task (task)
;

create index FKsfm3668avg4bw12qfax2slrrd
	on vacancy_task (vacancy)
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
  engine=InnoDb DEFAULT CHARSET=utf8
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
  engine=InnoDb DEFAULT CHARSET=utf8
;

create index FKgqk92dw8f09b5kttg02uff0rm
  on vacancy_user (user)
;

create index FKpe3ak6fx2jbgormipmkxy9rff
  on vacancy_user (vacancy)
;

