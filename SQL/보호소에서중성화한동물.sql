SELECT ins.animal_id, ins.animal_type, ins.name
FROM animal_ins AS ins JOIN animal_outs AS outs
ON ins.animal_id = outs.animal_id
WHERE SUBSTR(ins.sex_upon_intake, 1, 6) = 'Intact' 
AND (SUBSTR(outs.sex_upon_outcome, 1, 8) = 'Neutered' OR SUBSTR(outs.sex_upon_outcome, 1, 6) = 'Spayed')