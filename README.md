# Parentheses Balancer

The `Parentheses` class provides a method to check whether a sequence of curly brackets, square brackets, and parentheses is properly balanced. It uses a stack-based approach for efficient handling of nested structures.

## Usage

Instantiate the `Parentheses` class and call the `isBalanced` method with a string sequence:

```java
String sequence = "{[()]}";
Parentheses par = new Parentheses();
boolean result = par.isBalanced(sequence);
System.out.println(result); // Output: true
