# Write your MySQL query statement below
SELECT DISTINCT(viewer_id) as id
FROM
    (SELECT 
        COUNT(DISTINCT article_id) as aid, viewer_id
    FROM
        Views
    GROUP BY
        viewer_id, view_date
    HAVING
        aid > 1
    ) t0;
