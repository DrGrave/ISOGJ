INSERT INTO isogj_account.city (name) VALUES ('Minsk');
INSERT INTO isogj_account.city (name) VALUES ('Brest');
INSERT INTO isogj_account.type_of_education (name) VALUES ('High education');
INSERT INTO isogj_account.type_of_education (name)  VALUES ('School education');
INSERT INTO isogj_account.type_of_skill (name) VALUES ('Coding');
INSERT INTO isogj_account.type_of_skill (name) VALUES ('Methoding');
INSERT INTO isogj_account.type_of_skill (name) VALUES ('Frontend');
INSERT INTO isogj_account.type_of_skill (name) VALUES ('DBA');
INSERT INTO isogj_account.type_of_task (name) VALUES ('Sum type of task');
INSERT INTO isogj_account.type_of_user (name)  VALUES ('User');
INSERT INTO isogj_account.type_of_user (name) VALUES ('Company');
INSERT INTO isogj_account.type_of_user (name)  VALUES ('Admin');
INSERT INTO isogj_account.type_of_vacancy (name)  VALUES ('Dba');
INSERT INTO isogj_account.type_of_vacancy (name) VALUES ('Frontend');
INSERT INTO isogj_account.company (date_of_creation, info, name, city_of_company) VALUES ('2014-11-14 16:30:18', 'Bsuir company', 'Bsuir', 1);
INSERT INTO isogj_account.gender (name) VALUES ('Male');
INSERT INTO isogj_account.gender (name) VALUES ('Female');
INSERT INTO isogj_account.position (name) VALUES ('Junior');
INSERT INTO isogj_account.position (name) VALUES ('Senior');
INSERT INTO isogj_account.position (name) VALUES ('Middle');
INSERT INTO isogj_account.position (name) VALUES ('Expert');
INSERT INTO isogj_account.school (name, city) VALUES ('Number 6', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Model', 2);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Java', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Java EE', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Spring security', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Front', 3);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Spring boot', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('JWT', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('System engineering', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Hibernate', 1);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('Angular5', 3);
INSERT INTO isogj_account.skill (name, type_of_skill) VALUES ('MySql', 4);
INSERT INTO isogj_account.task (info, name, type_of_task) VALUES ('Do frontend', 'Front', 1);
INSERT INTO isogj_account.university (name, city) VALUES ('BSUIR', 1);
INSERT INTO isogj_account.faculty (name, university) VALUES ('Poit', 1);
INSERT INTO isogj_account.user (username, active, email, first_name, middle_name, last_name, city_of_living, gender, type_of_user) VALUES ('DrGrave', 1, 'Vad@bsuir.by', 'Vadim', 'Mikalaevich', 'Vidnichuk', 1, 1, 3);
INSERT INTO isogj_account.user (username, active, email, first_name, middle_name, last_name, city_of_living, gender, type_of_user) VALUES ('ntrln', 1, 'User@Bsuir.by', 'User', 'Userovich', 'Userchuk', 1, 1, 1);
INSERT INTO isogj_account.user (username, active, email, first_name, middle_name, last_name, city_of_living, gender, type_of_user) VALUES ('Epam Systems', 1, 'Company', 'Company', 'Company', 'Company', 1, 1, 2);
INSERT INTO isogj_account.possible_cities_to_work (id_user, id_city) VALUES (1, 1);
INSERT INTO isogj_account.user_company (company, position, user) VALUES (1, 1, 1);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('6', '7', 2, '2015-11-14 16:39:36', '2017-11-14 16:39:38', 1, 1);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '8', 2, '2017-12-19 21:52:27', '2017-12-19 21:52:30', 2, 1);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('6', '8', 2, '2016-12-19 22:36:05', '2017-12-19 22:36:03', 3, 1);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '7', 2, '2017-07-19 22:37:06', '2017-11-19 22:37:10', 4, 1);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('6', '8', 1, '2017-12-19 22:37:33', '2017-12-19 22:37:35', 5, 2);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '8', 2, '2017-12-19 21:52:27', '2017-12-19 21:52:30', 6, 1);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '8', 1, '2017-12-19 21:52:27', '2017-12-19 21:52:30', 7, 2);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '8', 2, '2017-12-19 21:52:27', '2017-12-19 21:52:30', 8, 3);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '8', 2, '2017-12-19 21:52:27', '2017-12-19 21:52:30', 9, 3);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '8', 2, '2017-12-19 21:52:27', '2017-12-19 21:52:30', 10, 3);
INSERT INTO isogj_account.user_skill (skill_mark, skill_practical_mark, id_marker, start_skilling, end_skilling, id_skill, id_user) VALUES ('7', '8', 2, '2017-12-19 21:52:27', '2017-12-19 21:52:30', 1, 3);
INSERT INTO isogj_account.vacancy (info, task, type_of_vacancy, company) VALUES ('Do work', 1, 1, 1);
INSERT INTO isogj_account.vacancy_skill (expected_mark, skill, vacancy) VALUES ('6', 1, 1);
INSERT INTO isogj_account.vacancy_skill (expected_mark, skill, vacancy) VALUES ('7', 2, 1);
INSERT INTO isogj_account.vacancy_skill (expected_mark, skill, vacancy) VALUES ('7', 3, 1);
INSERT INTO isogj_account.vacancy_skill (expected_mark, skill, vacancy) VALUES ('7', 4, 1);
INSERT INTO isogj_account.vacancy_skill (expected_mark, skill, vacancy) VALUES ('8', 5, 1);
INSERT INTO isogj_account.vacancy_user (if_accepted_user , if_company_accepted, user, vacancy) VALUES (0, 0, 1, 1);
INSERT INTO isogj_account.education (end_of_education, start_of_education, faculty_id, school, type_of_education, user) VALUES ('2014-11-14 16:38:39', '2017-11-14 16:38:42', 1, null, 1, 1);
INSERT INTO isogj_account.experience (date_of_end, date_of_start, prev_company, user) VALUES ('2015-11-14 16:39:36', '2017-11-14 16:39:38', 1, 1);
INSERT INTO isogj_account.summary (text, user) VALUES ('Good user summary', 1);