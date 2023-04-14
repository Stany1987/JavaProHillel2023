create table homework(
    id serial primary key,
    name VARCHAR(255),
    description text
);

create table lesson(
    id serial primary key,
    name VARCHAR(255),
    updated_at TIMESTAMP,
    homework_id INTEGER references homework(id)
);

create table schedule(
    id serial primary key,
    name VARCHAR(255),
    updated_at TIMESTAMP
);

create table schedule_lesson(
    schedule_id INTEGER references schedule(id),
    lesson_id INTEGER references lesson(id),
    primary key (schedule_id, lesson_id)
);

alter table homework alter column id set default nextval('homework_id_seq');
alter table lesson alter column id set default nextval('lesson_id_seq');
alter table schedule alter column id set default nextval('schedule_id_seq'); 

insert into homework (name, description) values ('Homework1', 'Description for Homework1');
insert into homework (name, description) values ('Homework2', 'Description for Homework2');

insert into lesson (name, updated_at, homework_id) values ('Lesson1', '2023-04-13', 1);
insert into lesson (name, updated_at, homework_id) values ('Lesson2', '2023-04-14', 2);

insert into schedule (name, updated_at) values ('Schedule1', '2023-04-13');
insert into schedule (name, updated_at) values ('Schedule2', '2023-04-14');

insert into schedule_lesson (schedule_id, lesson_id) values (1, 1);
insert into schedule_lesson (schedule_id, lesson_id) values (1, 2);
insert into schedule_lesson (schedule_id, lesson_id) values (2, 2);
