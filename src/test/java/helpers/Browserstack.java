package helpers;

import static io.restassured.RestAssured.given;


public class Browserstack {

    // curl -u "qaguru_ti9G5S:5yrxu4nFTKkRExUAhqxh" -X GET "https://api.browserstack.com/app-automate/sessions/0359d759d2aaa4f46401dac46bd281b6d9b24943.json"
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