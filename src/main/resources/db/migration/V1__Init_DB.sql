
CREATE DATABASE timesheet
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;


create table if not exists employe (
    id bigserial NOT NULL primary key ,
    create_time timestamp not null default now(),
    last_name text not null,
    first_name text not null,
    middle_name text,
    position text
);

create table if not exists project (
    id bigserial NOT NULL primary key ,
    create_time timestamp not null default now(),
    name text not null
);

create table if not exists timesheet (
    id bigserial NOT NULL primary key ,
    create_time timestamp not null default now(),
    work_date timestamp not null,
    project_id bigint not null
         references project(id),
    employe_id bigint not null
         references employe(id),
    task_num text not null,
    task_description text,
    time_wasted bigint not null
);

create or replace view v_timesheet_info as (
    select
        t.id,
        t.create_time,
        e.last_name,
        e.first_name,
        e.middle_name,
        e.position,
        p.name as project_name,
        t.work_date,
        t.task_num,
        t.task_description,
        t.time_wasted
    from timesheet t
        join employe e on t.employe_id = e.id
        join project p on t.project_id = p.id
);
