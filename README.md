##Practical Probablistic Programming

The purpose of this repo is to work through the exercies and material in Avi Pfeffer's book [Practical Probablistic Programming](https://www.manning.com/books/practical-probabilistic-programming) all about the new probablistic programming language [Figaro](https://github.com/p2t2/figaro) written as a library for [Scala](http://www.scala-lang.org/).

To run my examples I am using the [Figaro Work](https://www.cra.com/sites/default/files/files/FigaroWork.zip) directory specified in the [Figaro Quickstart Guide](://www.cra.com/sites/default/files/pdf/Figaro_Quick_Start_Guide.pdf) and [SBT](http://www.scala-sbt.org/)

To run Figaro programs that you create:

1) Install SBT v0.13 for your chosen operating system
2) Copy your Figaro program files to FigaroWork\src\main\scala
3) Open a command line prompt
4) Navigate to your local FigaroWork directory
5) At the command prompt, type
	a) sbt "runMain <class_with_main> <parameters>"

Note: don't forget the quotes around the runMain command!

To test if your local environment is properly configured, run

	sbt "runMain Test"

You should see the following output

	[info] Running Test
	1.0


Here is a link to the complete SBT Tutorial:

	http://www.scala-sbt.org/0.13/tutorial/index.html
