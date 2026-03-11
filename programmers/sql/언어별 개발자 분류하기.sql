WITH sk AS (
  SELECT
    d.ID,
    d.EMAIL,
    SUM(CASE WHEN s.NAME = 'C#' THEN 1 ELSE 0 END) AS is_c,
    SUM(CASE WHEN s.CATEGORY = 'Front End' THEN 1 ELSE 0 END) AS is_f,
    SUM(CASE WHEN s.NAME = 'Python' THEN 1 ELSE 0 END) AS is_p
  FROM DEVELOPERS d
  JOIN SKILLCODES s
    ON (d.SKILL_CODE & s.CODE) > 0
  GROUP BY d.ID, d.EMAIL
)
SELECT
  CASE
    WHEN is_p > 0 AND is_f > 0 THEN 'A'
    WHEN is_c > 0 THEN 'B'
    WHEN is_f > 0 THEN 'C'
  END AS GRADE,
  ID,
  EMAIL
FROM sk
WHERE (is_p > 0 AND is_f > 0) OR (is_c > 0) OR (is_f > 0)
ORDER BY GRADE ASC, ID ASC;
