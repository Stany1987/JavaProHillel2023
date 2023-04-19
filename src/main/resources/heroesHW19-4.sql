
create table heroes (
name varchar(50),
gender varchar(50),
eye_color varchar(50),
race varchar(50),
hair_color varchar(50),
height DOUBLE PRECISION,
publisher varchar(50),
skin_color varchar(50),
aligment varchar (50),
weight integer
);

insert into heroes
select name, gender, eye_color, race, hair_color, to_number(replace(height, ',', '.'), '9999.99'), publisher, skin_color, alignment, weight
from heroes_info;

select avg(height) as avg_height from heroes where height >0; 
select name from heroes where height=(select max(height) from heroes); 
select name from heroes where weight =(select max(weight) from heroes);
select gender,count (*) as count from heroes group by gender;
select aligment , count (*) as count from heroes group by aligment;
select publisher, count(*) as count from heroes group by publisher order by count desc limit 5; 
select hair_color , count(*) as count from heroes where hair_color <>'-' group by hair_color order by count desc limit 3;
select eye_color , count(*) as count from heroes group by eye_color order by count desc limit 1;

