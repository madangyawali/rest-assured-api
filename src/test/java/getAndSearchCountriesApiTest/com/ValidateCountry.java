package getAndSearchCountriesApiTest.com;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;

public class ValidateCountry {

	@Test
	public void makeSureThatCountrySearchApiIsUp() {
		// given().get("http://www.groupkt.com/post/c9b0ccb9/country-and-other-related-rest-webservices.htm").then()
		given().when().get("http://services.groupkt.com/country/get/all").then().statusCode(200);
	}

	@Test
	public void getCountry() {
		given().get("http://services.groupkt.com/country/get/all").then().statusCode(200).log().all();
	}

	@Test
	public void getCurrency() {
		given().get("http://www.webservicex.net/CurrencyConvertor.asmx?wsdl").then().statusCode(200).log().all();
	}

	@Test
	public void getCountryAlbania() {
		// get Response body as a String
		String response = get("http://services.groupkt.com/country/get/all").asString();
		// And get Albany from the response
		List<String> albania = from(response).getList("result.name.find{ it.@name=='Albania'}.alpha2_code");

	}

//	@Test
	public void getCountryInfOfNepal() {
		when().get("http://services.groupkt.com/country/get/all").then().body("result.name.find{it.@name='Nepal'}",
				hasItems("NP", "NPL"));

	}
	@Test
	public void getResponseData() {
		// Getting the content of the response in JSON
		InputStream stream = get("http://services.groupkt.com/country/get/all").asInputStream();
		byte[] byteArray = get("http://services.groupkt.com/country/get/all").asByteArray();
		String json = get("http://services.groupkt.com/country/get/all").asString();
		System.out.println("Output data is: " + "\n" + json );
	}
	


}
