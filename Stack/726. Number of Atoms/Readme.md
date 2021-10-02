There are a few problems we need to consider before coding:

1 how to process parenthesis

2 how to return the count of all elements as a string 

3 how to deal with digit, lowercase letter


Solutions:
1. we use Stack<Hashmap> stack and Hashmap<String,Integer> cur to deal with parenthesis. Loop over formula, if formula[i] is '(' means add cur to stack. If formula[i] is ')' means pop a previous cur map out of stack. For example, if formula is "Mg(OH)2" and when formula[i] == '(', add cur to stack and cur is {"Mg":1}.
  When formula[i] == ')', pop a previous cur map out of stack. Concatenate two map and update cur, cur is {"Mg":1,"o":2,"H":2}
  
2. we loop over sorted cur's keyset() and generate a string.
  
3. we can solve this if we know the relative index digit,letter. We know digit will next to ')' or atom, lowercase letter will next to uppercase letter, and full name of atom always comes before it's digit.
  
