SELECT user_id, name, mail
FROM users
WHERE mail REGEXP '^[A-Za-z][A-Za-z0-9_\.\-]*@leetcode[\.]com$'