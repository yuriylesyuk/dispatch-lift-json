import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class LiftJsonSpec extends Specification {
  import dispatch.classic._
  import dispatch.liftjson.Js._
  import net.liftweb.json.JsonAST._

  val test = :/("technically.us") / "test.json"
  
  "Json Parsing" should {
    "find title of test glossary" in {
      val http = new Http
      http(test ># { js =>
        for (JString(s) <- js \ "glossary" \ "title") yield s
      } ) must_== List("example glossary")
    }
    "find reference list" in {
      val http = new Http
      http(test ># { js =>
        for (JField("GlossSeeAlso", JArray(l)) <- js; JString(s) <- l) yield s
      } ) must_== List("GML","XML")
    }
  }
}
