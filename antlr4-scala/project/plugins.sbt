resolvers += Resolver.sonatypeRepo("snapshots")
addSbtPlugin("org.scalameta" % "sbt-metals" % "0.11.12")
addSbtPlugin("ch.epfl.scala" % "sbt-bloop" % "1032048a")

// For generating Lexer/Parser from ANTLR4 grammar (.g4)
addSbtPlugin("com.simplytyped" % "sbt-antlr4" % "0.8.2")
