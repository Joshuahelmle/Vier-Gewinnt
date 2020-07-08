package de.htwg.se.connect4.model

import de.htwg.se.connect4.model.boardComponent.boardBaseImpl.Color
import de.htwg.se.connect4.model.boardComponent.boardBaseImpl.Color.Color
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.{JsResultException, JsValue, Json}

class EnumReadSpec extends WordSpec with Matchers {

  "An Enum Read" when {

    "gets a string" should {
      val jsString = """{"color": "red"}"""
      val jsValue: JsValue = Json.parse(jsString)
      val value = (jsValue \ "color").as[Color]


      "return correct enum" in {
        value shouldBe Color.RED

      }
    }


    "return error message" in {
      val jsString = """{"color": "p"}"""
      val jsValue: JsValue = Json.parse(jsString)
      an [JsResultException] should be thrownBy (jsValue \ "color").as[Color]

    }

    "return string expected" in {
      val jsString = """{"color": "p"}"""
      val jsValue: JsValue = Json.parse(jsString)
      an [JsResultException] should be thrownBy (jsValue).as[Color]
    }
  }

}
