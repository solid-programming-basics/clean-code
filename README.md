# SOLID Points System - Code Improvement Task 1

This project implements a simple system to manage SOLID points awarded to users based on their code reviews. The existing codebase has several design flaws and violations of good programming practices. Your task is to **improve the code quality**, keeping the following principles in mind:

## Task Description

Refactor the provided code, taking into account the following principles:

### 1. **Refactor Whenever You Work on the Existing Code Base**
- Refactor the code to improve readability and maintainability whenever changes are made. Ensure the code follows clean code practices.

### 2. **Remove Duplication**
- Identify areas in the code where logic or validation is repeated, and eliminate duplication by consolidating the logic into reusable methods or classes.

### 3. **When Using an Anemic Domain Model, Have a Clear Understanding Why and Where You Use It**
- Consider if the current model is anemic (data-only with no business logic) and assess whether this approach is necessary. If you find that the anemic model is not justified, refactor it to encapsulate behavior within the domain objects.

### 4. **Minimize the Accessibility of Classes and Members**
- Ensure that class members (fields, methods) are as private as possible. Avoid exposing implementation details unnecessarily, and use proper access modifiers (`private`, `protected`, `public`) to encapsulate data.

### 5. **Minimize Mutability**
- Ensure that the state of objects is immutable wherever possible. For example, avoid unnecessary setter methods or direct access to mutable fields. Refactor the code to create immutable objects that make the system more predictable and safer.

### 6. **Favor Composition Over Inheritance**
- Avoid over-reliance on inheritance, especially where composition could be a better alternative. Identify areas in the code where inheritance introduces complexity and refactor those parts to use composition instead.

### 7. **Design and Document for Inheritance or Prohibit It**
- If inheritance is used, it must be intentional and documented. If inheritance doesn’t provide clear benefits, consider marking classes as `final` to prevent unintended subclassing. Ensure that the inheritance structure makes sense and doesn't lead to fragile base classes.

### 8. **Use Exceptions Only for Exceptional Conditions**
- Refactor any code that uses exceptions to handle regular control flow. Exceptions should only be used for truly exceptional conditions, such as invalid inputs or unexpected states, not for routine operations.

### 9. **Avoid Anything That Obscures the Code Like Unused Classes, Methods, and Unnecessary Comments**
- Remove any unused classes, methods, or fields. Clean up unnecessary comments that describe the obvious behavior of the code. Ensure the code is self-explanatory, using meaningful names for classes, methods, and variables.

# SOLID Points System - Code Improvement Task 2

This project continues the implementation of a simple system to manage SOLID points awarded to users based on their code reviews. The existing codebase has several design flaws and violations of good programming practices. Your task is to **improve the code quality**, keeping the following principles in mind:

## Task Description

Refactor the provided code, taking into account the following principles:

### 1. **Names in Code Should Reveal Intent**
- Ensure that all class, method, and variable names clearly convey their purpose and functionality.

### 2. **Names Must Not Mislead**
- Avoid names that could create confusion about the functionality of a class or method.

### 3. **Names Should Facilitate Responsibility Differentiation**
- Class and method names should clearly indicate distinct responsibilities.

### 4. **Names Must Be Consistent**
- Follow consistent naming conventions across the codebase to promote clarity.

### 5. **Names Should Be Understandable to More Than Just the Creator**
- Use clear and descriptive names that can be understood by other developers.

### 6. **Names Should Use Appropriate Parts of Speech**
- Use nouns for classes and methods and verbs for actions to enhance readability.

### 7. **Methods Should Do One Thing and Only One**
- Ensure that each method is focused on a single task.

### 8. **Method Content Should Be at the Same Level of Abstraction**
- Keep method implementations consistent in terms of abstraction.

### 9. **Methods Should Have No Side Effects**
- Avoid methods that alter the state of the system outside their own scope.

### 10. **Methods Should Either Do Something or Answer a Question**
- Design methods to perform an action or return a value, not both.

### 11. **Methods Should Only Change the State of the Object They Are Called On**
- Ensure that methods operate solely on their own object instance.

### 12. **Methods Should Have Only a Few Arguments**
- Limit the number of parameters in methods to improve readability and maintainability.

### 13. **Methods Should Not Have Output Parameters**
- Avoid using output parameters to return multiple results.

### 14. **Methods Should Not Have Boolean Arguments that Control Logic**
- Avoid boolean parameters that dictate the flow of a method.

### 15. **Methods Should Not Contain Switch Statements**
- Refactor switch statements into polymorphic methods or other control structures to enhance maintainability.

### 16. **Methods Should Contain a Minimal Number of 'if' Statements**
- Limit the use of conditional statements to keep methods straightforward and clear.

### 17. **Methods Should Be Small**
- Keep methods short to enhance readability and maintainability.

### 18. **Methods Should Not Return Nulls**
- Ensure that methods return meaningful values or throw exceptions instead of returning null.

### 19. **Factory Methods Simplify Object Construction**
- Use factory methods to encapsulate the creation of objects, improving code clarity and encapsulation.
