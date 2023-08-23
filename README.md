# ulam-spiral

## Description
Simple desktop app that dynamically draws the [Ulam spiral](https://en.wikipedia.org/wiki/Ulam_spiral). 
It uses the [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes) algorithm for the generation of primes that are then represented on a square. Built using AWT/Swing framework.

## How to run
Compile the project yourself and run it through your CLI/IDE or create .jar executable:

`C:\ulam-spiral> jar cvfm ulam-spiral.jar MANIFEST.mf *.class`

and run it by either double-clicking the icon or by:

`C:\ulam-spiral> java -jar ulam-spiral.jar`

Java's `jar.exe` utility is located in the JDK's `\bin` folder so make sure your system `PATH` variable includes it.

## Preview
![](res/preview.gif)