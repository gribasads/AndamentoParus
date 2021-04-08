package br.ce.wcaquino.rest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class OlaMundoTest {

	@Test
	public void testOlaMundo(){
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
		Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
		Assert.assertTrue(response.statusCode()==200);
		Assert.assertTrue("O status code deveria ser 200",response.statusCode()==200);
		Assert.assertEquals(200, response.statusCode());
		
		
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
	}
	
	@Test
	public void devoConhecerOutrasFormasRestAssured() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
		ValidatableResponse validacao = response.then();
		validacao.statusCode(200);
		//duas formas da mesma atribuição
		get("http://restapi.wcaquino.me/ola").then().statusCode(200);
		
	 given()
	 //pré condições
	 .when()
	 //ação de fato
	 .get("http://restapi.wcaquino.me/ola")
	 .then()
	 //verificações
	 //.asserThat()
	 .statusCode(200);
	}
	
	@Test
	public void devoConhecerMatchersHamcrest() {
		assertThat("Maria",Matchers.is("Maria"));
		assertThat(128,Matchers.is(128));
		assertThat(128,isA(Integer.class));
		assertThat(128d,Matchers.isA(Double.class));
		assertThat(128d,Matchers.greaterThan(120d));
		assertThat(128d,lessThan(140d));
		
		List<Integer> impares = Arrays.asList(1,3,5,7,9);
		assertThat(impares, hasSize(5));
		assertThat(impares, contains(1,3,5,7,9));
		assertThat(impares,containsInAnyOrder(1,5,3,9,7));
		assertThat(impares, hasItem(1));
		assertThat(impares, hasItems(1,5));
		
		assertThat("Maria", is(not("joao")));
		assertThat("Maria", not("joao"));
		assertThat("Maria",anyOf(is("Maria"), is("Joaquina")));
		assertThat("Joaquina",allOf(startsWith("joa"),endsWith("ina"),containsString("aqui")));
		
	}
	
	@Test
	public void devoValidarBody() {
		  given()
		 .when()
		 .get("http://restapi.wcaquino.me/ola")
		 .then()
		 .statusCode(200)
		 .body(Matchers.is("Ola Mundo!"))
		 .body(containsString("Mundo"))
		 .body(is(not(nullValue())));
	}


}

	
	


