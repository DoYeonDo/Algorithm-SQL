SELECT 
(
  CASE
    WHEN skill_code & (SELECT BIT_OR(code) FROM skillcodes GROUP BY category HAVING category='Front End') > 0
    AND skill_code & (SELECT code FROM skillcodes WHERE name = 'Python') = (SELECT code FROM skillcodes WHERE name = 'Python') THEN 'A'    
    WHEN skill_code & (SELECT code FROM skillcodes WHERE name = 'C#') = 
         (SELECT code FROM skillcodes WHERE name = 'C#') THEN 'B'    
    WHEN skill_code & (SELECT BIT_OR(code) FROM skillcodes GROUP BY category HAVING category='Front End') > 0 THEN 'C'
  END
) AS grade, 
id, 
email
FROM developers
WHERE (
  CASE
    WHEN skill_code & (SELECT BIT_OR(code) FROM skillcodes GROUP BY category HAVING category='Front End') > 0
    AND skill_code & (SELECT code FROM skillcodes WHERE name = 'Python') = (SELECT code FROM skillcodes WHERE name = 'Python') THEN 'A'    
    WHEN skill_code & (SELECT code FROM skillcodes WHERE name = 'C#') = 
         (SELECT code FROM skillcodes WHERE name = 'C#') THEN 'B'    
    WHEN skill_code & (SELECT BIT_OR(code) FROM skillcodes GROUP BY category HAVING category='Front End') > 0 THEN 'C'
END
) IS NOT NULL
ORDER BY grade, id