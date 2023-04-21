# Building a Secure CI/CD Pipeline with GitHub Actions and Snyk for Java Applications
## Devoxx UK 2023 - MiniLAB

## Required software
To run this application locally you need 
- Java 17 or higher
- Maven
- IDE

However, since we are building GitHub Actions we dont explicitly need this.

## Getting started

- Fork this repository to your own GitHub account
- Check out the forked repository
```
git clone https://github.com/<your_username>/<forked-repo>.git 
```
- Sign up for a free Snyk account at https://snyk.io/signup (unless you already have one)
- Connect the forked project to your Snyk projects and leave it there.

## Assignment

### Build a GitHub action that builds the application and tests your libraries for vulnerabilities using Snyk.

----
Go to the GitHub webinterface and add a new action that builds your project using Maven

![](newaction.jpg)

---
Use [Snyk Maven Github](https://github.com/snyk/actions/tree/master/maven) action to scan your application.

---

- [Hint 1](hint1.md)
- [Hint 2](hint2.md)

---

### Add Snyk Monitor scanning to your pipeline whenever your open-source scanning succeeded

---
Use the same approach as before but see how you can use the command `monitor` in a Snyk GitHub Action.
- [Hint3](hint3.md)
- [Hint4](hint4.md)

---

### Add Snyk Code (SAST) Scanning to your initial pipeline before monitoring and let monitor depend on both open-source and code scanning

---
Use a Snyk Action with the command `code test` to perform SAST analysis.
Use the `need:` parameter of a GitHub action to make your action depend on the outcome of another action.

- [Full Solution](solution.md)



