# Recursion
Below is a grammar that represents a restricted form of an infix expression.  The restriction is that unless you use parenthesis for clarification, you can only have one '+' or '-' per expression.  In addition, '*' and/or '/' may not appear consecutively (A/B*C) -- note that A/B+C/D is valid.

<expression> = <term> | <term>+<term> | <term>-<term>
<term>       = <factor> | <factor>*<factor> | <factor>/<factor>
<factor>     = <letter> | (<expression>)
<letter>     = A | B | C | D | ... | Z

Thus A+B-C is not valid.  Similarly, A/B*C is not valid.  Note that A+(B-C) is fine, as is (A/B)*C.

Here is some pseudo-code to aid you in construction of your algorithm:

FIND AN EXPRESSION

Find a term
if (next symbol is a + or a -)
Find a term
FIND A TERM

Find a factor
if (next symbol is a * or a /)
Find a factor
FIND A FACTOR

if (the first symbol is a letter)
Done
else if (the first symbol is a '(' )
Find an expression starting at character after '('
Check for ')'
else
No factor exists
Given an input file that contains infix expressions, you must process each of those expressions and state whether an infix expression is valid based on the above grammar, or not valid.  Your program should print each expression processed and report whether or not it is valid.  As an example, if your input file contained:

A+B-C
A+B*C
A/B+C
(A+B)-C
(A)
(A-B-C)

Your program output should be as follows:

A+B-C is NOT Valid
A+B*C is Valid
A/B+C is Valid
(A+B)-C is Valid
(A) is Valid
(A-B-C) is NOT Valid

Your input file will be named infix.txt -- you may hard code this into your program.  This file will contain one infix expression per line.  The valid characters used for an infix expression will be upper case letters, parens, and the arithmetic operators for addition, subtraction, multiplication, and division.  Any other characters are not valid (your recursive descent parser will report expressions that contain such characters as not valid).

