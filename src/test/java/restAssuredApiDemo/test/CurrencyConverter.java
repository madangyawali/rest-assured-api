package restAssuredApiDemo.test;

import static io.restassured.RestAssured.given;

import org.junit.Test;

public class CurrencyConverter {

	@Test
	public void validateCurrency() {
		given().
	 get("http://www.webservicex.net/CurrencyConvertor.asmx?wsdl").then().statusCode(200).log().all();
		// get("http://www.webservicex.net/stockquote.asmx?op=GetQuote").then().statusCode(200).log().all();
		// get("http://www.groupkt.com/post/5c85b92f/restful-rest-webservice-to-get-and-search-states-and-territories-of-a-country.htm").then().statusCode(200).log().all();

				//get("http://www.groupkt.com/post/c9b0ccb9/country-and-other-related-rest-webservices.htm").then().statusCode(200).log().all();

	}

}
