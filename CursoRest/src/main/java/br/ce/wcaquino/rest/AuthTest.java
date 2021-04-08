package br.ce.wcaquino.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


import org.junit.Test;



public class AuthTest {
	@Test
	public void deveAcessarASWAPI() {
		given()
		.log().all()
		.when()
		.get("https://swapi.dev/api/people/1")
		.then()
		.log().all()
		.body("name", is("Luke Skywalker"))
		;
	}
	@Test
	public void deveAcessarApiComChave() {
		given()
		.log().all()
		.queryParam("q","Fortaleza,BR")
		.queryParam("appid", "2de1ff1ac222845ffc4de80f888d44d7")
		.queryParam("units", "metric")
		.when() 
		.get("http://api.openweathermap.org/data/2.5/weather")
		.then()
		.log().all()
		.statusCode(200)
		.body("name",is("Fortaleza"))
		.body("coord.lon", is(-38.5247F))
		.body("main.temp", greaterThan(25f))
		;
	}
	
	//http://api.openweathermap.org/data/2.5/weather?q=Fortaleza,BR&appid=2de1ff1ac222845ffc4de80f888d44d7&&units=metric

}
