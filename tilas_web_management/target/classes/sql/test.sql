select emp.id,emp.name,emp.gender,emp.avatar,dept.name as dept_name,emp.job,emp.entry_date,emp.update_time
            from emp left join dept on emp.dept_id = dept.id;


UPDATE emp
SET avatar = REPLACE(REPLACE(avatar, '/img/', '/imgs/'), '.jpg', '.png')
WHERE avatar LIKE '/img/%';