select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId
;

作者：LeetCode
链接：https://leetcode-cn.com/problems/combine-two-tables/solution/zu-he-liang-ge-biao-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
