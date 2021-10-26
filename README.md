# Word Hunt Solver

This project was built to find all the potential solutions of a given board
from the WordHunt game from Game Pigeon's IOS iMessage App. It showcases
some basic algorithmic design written in the Java language.

## Getting Started

These instructions will give you a copy of the project up and running on
your local machine for development and testing purposes.

### Prerequisites

Requirements for the software and other tools to build, test and push
- [JAVA JDK](https://www.oracle.com/java/technologies/downloads/)

### Installing

Start by cloning the repository onto your system.
```
git clone https://github.com/danielcollishaw/WordHunt.git
```
Once cloned, compile the source code using your java compiler.
```
javac WordHunt.java
```

### Usage

Insert the 16 letters into board.txt. Begin reading off the board from top-left and moving left to right until all letters have been inserted.

To run the program run the compiled class file using your Java environment.
```
java WordHunt
```
All words that can be formed will be outputted into out.txt sorted by length.


## Built With

  - [JAVA 8](https://www.oracle.com/java/)

## Authors

  - **Daniel Collishaw** - *Lead Developer* -

See also the list of
[contributors](https://github.com//danielcollishaw/WordHunt.git/contributors)
who participated in this project.

## Acknowledgments

  - Thank you to the [SCOWL](http://app.aspell.net/create) team running the open source dictionary the project uses.
