-- 击败的用户5%
select p.FirstName,p.LastName,a.City,a.State
from Person p left join Address a on p.PersonId=a.PersonId

-- 这样写击败的用户更多一些80%
select FirstName,LastName,City,State
from Person left join Address on Person.PersonId=Address.PersonId