package com.dataflowstudio

import org.scalatest._

class ParameterParserSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    // ParameterParser.parse("CURRENT_DATE")
    ParameterParser.parse("CURRENT_DATE('yyyy-mm-dd', 'Asia/Tokyo', 'aaaaaaaaa')")
  }
}
