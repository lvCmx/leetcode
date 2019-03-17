SELECT IFNULL((SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1,1),
NULL) AS SecondHighestSalary

-- 求topN我们很容易想到使用linit，只是如果不存的时候要为NULL，这一点可能不太容易想到
-- 为什么要DISTINCT，是因为如果两条记录的Salary一样，那就会有问题