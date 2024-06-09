# iVoteService

## Overview

This program simulates an iVote service that allows students to submit answers to questions and then displays the results. The system supports two types of questions: single choice (only one answer can be selected) and multiple choice (more than one answer can be selected).

## Key Concepts

### Polymorphism

Polymorphism in this program is achieved through the use of an abstract `Question` class and its subclasses, `SingleChoiceQuestion` and `MultipleChoiceQuestion`. These subclasses override the `isValidAnswer` method to provide specific validation logic for single choice and multiple choice questions.

### Inheritance

Inheritance is used to create a common structure and behavior for different types of questions. The `Question` class serves as a base class, providing shared properties (like candidate answers) and an abstract method (`isValidAnswer`). The `SingleChoiceQuestion` and `MultipleChoiceQuestion` classes inherit from `Question`, allowing them to extend and customize the behavior defined in the base class.

## Classes

### Question

An abstract base class that represents a question. It holds a list of candidate answers and defines an abstract method `isValidAnswer` to validate answers.

### SingleChoiceQuestion

A subclass of `Question` that represents a single choice question. It implements the `isValidAnswer` method to ensure only one valid answer is selected.

### MultipleChoiceQuestion

A subclass of `Question` that represents a multiple choice question. It implements the `isValidAnswer` method to ensure that multiple valid answers can be selected.

### Student

Represents a student with a unique ID and an answer.

### VotingService

Handles the configuration of the question, submission of answers, and output of submission statistics.

### SimulationDriver

The main class that simulates the entire process of configuring a question, generating students and their answers, submitting answers to the voting service, and displaying the results.

## Usage

1. **Compile the Program**

   Compile all Java files using the following command:
   ```sh
   javac -d . *.java

2. **Run the Program**

   Run the 'SimulationDriver' class to start the simulation:
   ```sh
   java SimulationDriver
   
  ## Sample Output

  ```sh
  Question Type: Multiple Choice
  Number of Students Answering: 55
  A : 35
  B : 33
  C : 23
  D : 31

  Question Type: Single Choice
  Number of Students Answering: 71
  1. Right : 36
  2. Wrong : 35
   ```

## Code Structure
- Question.java: Defines the abstract Question class.
- SingleChoiceQuestion.java: Defines the SingleChoiceQuestion class that extends Question.
- MultipleChoiceQuestion.java: Defines the MultipleChoiceQuestion class that extends Question.
- Student.java: Defines the Student class.
- VotingService.java: Defines the VotingService class.
- SimulationDriver.java: Contains the main method to run the simulation.
  
## Conclusion
This program demonstrates the use of polymorphism and inheritance to manage different types of questions in an iVote service. It simulates the process of configuring questions, generating student answers, and displaying submission statistics.
