CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      SELECT IFNULL((
        SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT N,1
      ),null) AS 'getNthHighestSalary(N)'
  );
END