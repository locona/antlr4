resolvers += Resolver.sonatypeRepo("snapshots")
addSbtPlugin("org.scalameta" % "sbt-metals" % "0.7.6")
addSbtPlugin("ch.epfl.scala" % "sbt-bloop" % "1.4.3-23-550c6c0a")

// For generating Lexer/Parser from ANTLR4 grammar (.g4)
addSbtPlugin("com.simplytyped" % "sbt-antlr4" % "0.8.2")
