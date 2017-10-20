package googleMapApi;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.io.InputStream;

import org.junit.Test;

import io.restassured.response.ValidatableResponse;

public class GoogleMapApi {

	String AppURL = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=Paris&types=geocode&key=AIzaSyD2gpGVwo8Bgi81kVgPLFHWPJINpg6jHwM";

	@Test
	public void makeSureApiIsUp() {
		given().when()
				.get(AppURL)
				.then().statusCode(200);

	}

	@Test
	public void getResponseGoogleMapApiData() {
		// Getting the content of the response in JSON
		InputStream stream = get(AppURL).asInputStream();
		byte[] byteArray = get(AppURL).asByteArray();
		String json = get(AppURL).asString();
		System.out.println("Output data is: " + "\n" + json);
	}

	@Test
	public void verifyCityCountry() {
		given().when().get(AppURL).then().body(containsString("Paris, France"));

	}
	

	//@Test
	public void verifyPlaceIDFalse(){
		given().
		when().get(AppURL).then().body("predictions.place_id", equalTo("ChIJO5XGnIyXcog"));
	}

}
