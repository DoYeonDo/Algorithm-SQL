SELECT students.student_id, student_name, subjects.subject_name, IFNULL(attended_exams, 0) AS attended_exams
FROM students CROSS JOIN subjects
LEFT JOIN(
SELECT student_id, subject_name, COUNT(*) AS attended_exams
FROM examinations
GROUP BY student_id, subject_name
) AS tmp
ON students.student_id = tmp.student_id AND subjects.subject_name = tmp.subject_name
ORDER BY students.student_id, subjects.subject_name