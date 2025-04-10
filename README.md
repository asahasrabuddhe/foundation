# Single Responsibility Principle

A module should be responsible to one, and only one, actor.

This repository demonstrates the **Single Responsibility Principle (SRP)** using a geometric example of calculating the
length of a line defined by two points. The implementation follows **Test Driven Development** practices using:

* [x] Java
* [x] Go
* [x] Typescript
* [x] Rust

# Simple English Model

Class Point: A `Point` is defined by its coordinates (x, y). It's only job is to represent a location in 2D space.

Class Line: A `Line` is defined by exactly two `Point`'s. It's only responsibility is to calculate the length of the line.

# Why does SRP Matter?

> "A class should have one, and only one, reason to change." - *Robert C. Martin (Uncle Bob)*

By keeping responsibilities focused, we:
* Reduce bugs from unintended side effects
* Improve the code readability
* Make testing and maintaince easier


