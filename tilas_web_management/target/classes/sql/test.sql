select emp.id,emp.name,emp.gender,emp.avatar,dept.name as dept_name,emp.job,emp.entry_date,emp.update_time
            from emp left join dept on emp.dept_id = dept.id;


UPDATE emp
SET avatar = REPLACE(REPLACE(avatar, '/img/', '/imgs/'), '.jpg', '.png')
WHERE avatar LIKE '/img/%';

select dept_id, count(*) as value from emp group by dept_id;
SELECT d.name AS deptName, COUNT(e.id) AS value
FROM emp e
         JOIN dept d ON e.dept_id = d.id
GROUP BY d.name;


SELECT degree AS name, COUNT(*) AS value FROM student GROUP BY degree;