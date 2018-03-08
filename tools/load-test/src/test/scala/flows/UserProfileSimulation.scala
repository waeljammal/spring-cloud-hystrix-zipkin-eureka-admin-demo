package flows


import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class UserProfileSimulation extends Simulation {
    val httpConf = http
      .baseURL("http://localhost:8765")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  private var compose = http("Get Profile")
    .get("/user/profile")
    .check(status.is(200))

    val compose_scn = scenario("Get Profile")
      .exec(compose)
      .exitHereIfFailed

    setUp(
      compose_scn.inject(
        atOnceUsers(10),
        rampUsersPerSec(20) to 100 during (1 minutes)
      ))
      .maxDuration(2 minutes)
    .protocols(httpConf)
}

