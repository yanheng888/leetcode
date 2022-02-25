select
    score,
    (dense_rank() over (order by score desc)) AS "rank"
from scores;
