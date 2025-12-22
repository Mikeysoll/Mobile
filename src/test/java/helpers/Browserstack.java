package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {

    // curl -u "mikhail_B9r2gX:J2wxzLgWN29oy28V9K2b" -X GET "https://api.browserstack.com/app-automate/sessions/bdf95f227067d02681efeb8438b32a7e419961fd.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("mikhail_B9r2gX", "J2wxzLgWN29oy28V9K2b")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}