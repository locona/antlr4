package com.dataflowstudio

import org.antlr.v4.runtime.{DefaultErrorStrategy, RecognitionException, _}
import scala.util._

sealed trait Root
case class FunctionCallResult(res: String) extends Root

object ParameterParser {
  class DynamicParameterVisitorApp extends DynamicParameterParserBaseVisitor[Root] {
    override def visitRoot(ctx: DynamicParameterParser.RootContext): FunctionCallResult = {
      val rootText = ctx.getText
      println(s"Expression after tokenization = $rootText")

      visitFunctionCall(ctx.functionCall)

      FunctionCallResult("AAAA")
    }

    override def visitFunctionCall(ctx: DynamicParameterParser.FunctionCallContext): FunctionCallResult = {
      println("ctx.specificFunction.getText", ctx.specificFunction)
      println("ctx.scalarFunctionName.getText", ctx.scalarFunctionName.getText)
      println("ctx.functionArgs.getText", ctx.functionArgs.getText)

      if (ctx.specificFunction != null)
        visitSpecificFunction(ctx.specificFunction)
      else
        visitScalarFunctionName(ctx.scalarFunctionName)


      FunctionCallResult("")
    }

    override def visitSpecificFunction(ctx: DynamicParameterParser.SpecificFunctionContext): FunctionCallResult = {
      println("##########")
      ctx.getStart.getType match {
        case DynamicParameterLexer.CURRENT_DATE => println("CURRENT_DATE")
      }

      println(ctx.getStop.getType)
      FunctionCallResult("S")
    }

    override def visitScalarFunctionName(ctx: DynamicParameterParser.ScalarFunctionNameContext): FunctionCallResult = {
      println(ctx.getText)
      FunctionCallResult("S")
    }

    override def visitFunctionArgs(ctx: DynamicParameterParser.FunctionArgsContext): FunctionCallResult = {
      FunctionCallResult("S")
    }
  }

  def parse(params: String): Unit = {
    val charStream = new ANTLRInputStream(params)
    val lexer = new DynamicParameterLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new DynamicParameterParser(tokens)

    val visitor = new DynamicParameterVisitorApp()
    visitor.visit(parser.root)
    // println(res)
    // val res = listener.visit(parser.expr())
    // println(res)
    // val ctx = parser.removeErrorListeners()
    // trace(ctx.toStringTree(parser))
  }
}
