

INSERT INTO public.project (id, create_time, name) VALUES (3, '2021-05-10 19:39:49.139354', 'Интеграция с платежной системой') on conflict do nothing;
INSERT INTO public.project (id, create_time, name) VALUES (4, '2021-05-10 19:39:49.139354', 'Корпоративный сайт') on conflict do nothing;

INSERT INTO public.employe (id, create_time, last_name, first_name, middle_name, position) VALUES (1, '2021-05-10 19:37:53.249725', 'Семёнов', 'Иван', 'Сергеевич', 'Java Developer') on conflict do nothing;
INSERT INTO public.employe (id, create_time, last_name, first_name, middle_name, position) VALUES (2, '2021-05-10 19:37:53.249725', 'Маскин', 'Дмитрий', 'Борисович', 'Frontend Developer') on conflict do nothing;

INSERT INTO public.timesheet (id, create_time, work_date, project_id, employe_id, task_num, task_description, time_wasted) VALUES (2, '2021-05-10 19:41:51.018325', '2021-05-02 00:00:00.000000', 3, 2, 'THE_TASK-0001', 'Сделал задачу. Правки, и бог знает что ещё', 18000) on conflict do nothing;
INSERT INTO public.timesheet (id, create_time, work_date, project_id, employe_id, task_num, task_description, time_wasted) VALUES (3, '2021-05-10 19:41:51.018325', '2021-04-26 19:40:00.222000', 4, 2, 'THE_TASK-00012', 'Сделал задачу', 10800) on conflict do nothing;
INSERT INTO public.timesheet (id, create_time, work_date, project_id, employe_id, task_num, task_description, time_wasted) VALUES (4, '2021-05-13 00:33:04.259000', '2021-05-13 00:29:20.184000', 3, 1, 'TASK-123343', 'Нашёл и поправил блокировки в БД.', 480) on conflict do nothing;
INSERT INTO public.timesheet (id, create_time, work_date, project_id, employe_id, task_num, task_description, time_wasted) VALUES (5, '2021-05-14 02:02:50.494000', '2021-05-14 02:02:12.525000', 3, 2, 'TASK-0000', 'Description', 480) on conflict do nothing;

select nextval('public.timesheet_id_seq') as the_val from generate_series(1, 1000);
select nextval('public.employe_id_seq') as the_val from generate_series(1, 1000);
select nextval('public.project_id_seq') as the_val from generate_series(1, 1000);
