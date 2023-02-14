# Laboratory work 1. Regular grammars. Finite Automata

### Course: Formal Languages and Finite Automata
### Author: Diana Belaia FAF-213
### Variant: 5
----

## Theoretical Notes:
A language is a set of strings from some alphabet (finite or infinite).\
A grammar is a set of rules over the language.\
An alphabet is a set of valid characters.\
A grammar G is an order of quadruple G = {Vt, Vn, P, S}, where:

-Vt is a set of terminal symbols;\
-Vn is a set of non-terminal symbols;\
-P is a set of all possible productions;\
-S is a starting symbol.

---

## Implementation:
I wrote this laboratory work in Java programming language.  There are to classes whicjh implements the main logic (Grammar and FiniteAutomata) and App class used to call necessary methods. First of all, I identifyed grammar in Grammar class (method setGrammar()), then I convert the set of all possible productions into three arrays to seperate productions for every single non-terminal symbol. It is necessary because when we generate a string we have to identify somehow non-ternimal symbol and pick the corresponding production for this symbol. In the method generateString() I check for the corresponding non-terminal symbol and check if the last symbol is terminal, if it so, I stop execution:
![](Images/Screenshot%20from%202023-02-14%2020-56-42.png)

Also, in classGrammar I have a method convertToFiniteAutomata() to make an analitical form of Finite Atomaton representation. To do this I just "convert" arrays into HashMap seperation each transition:
![](Images/Screenshot%20from%202023-02-14%2020-57-03.png)

 Then let me explain a bit about class FiniteAutomaton. It has a construstor with parameters:\
-Alphabet which is the set of terminal symbols;\
 -Set of all possible states - the set of non-terminal characters;\
-Initial state S;\
-Final state X;\
-Transition function which is HashMap returned from Grammar class.\

Class FiniteAutomaton contains method which provides the validation of a string, in other words, it checks if the strings obtained from the given Grammar are generated correctly:

![](Images/Screenshot%20from%202023-02-14%2020-57-21.png)
---
## Output of the program:
---
![](Images/Screenshot%20from%202023-02-14%2021-19-07.png)

I, also, have to mention that productions are picked randomly to generate the strings. but sometimes we can have same string generated several times.
![](Images/Screenshot%20from%202023-02-14%2021-21-31.png)