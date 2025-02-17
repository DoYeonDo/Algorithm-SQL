SELECT ins.animal_id, ins.name
FROM animal_ins AS ins JOIN animal_outs AS outs
ON ins.animal_id = outs.animal_id
ORDER BY DATEDIFF(outs.datetime, ins.datetime)+1 DESC LIMIT 2