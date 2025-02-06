SELECT *, IF((IF(x+y>z,1,0) && IF(x+z>y,1,0) && IF(y+z>x,1,0))=1, 'Yes', 'No') AS triangle
FROM triangle