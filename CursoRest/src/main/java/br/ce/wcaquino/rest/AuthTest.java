package br.ce.wcaquino.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;



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
	@Test
	public void naoDeveAcessarSemSenha() {
		
		given()
		.log().all()
		.when()
		.get("https://restapi.wcaquino.me/basicauth")
		.then()
		.log().all()
		.statusCode(401)
		;
	}
	@Test
	public void deveAcessarSenha() {
		
		given()
		.log().all()
		.when()
		.get("https://admin:senha@restapi.wcaquino.me/basicauth")
		.then()
		.log().all()
		.statusCode(200)
		.body("status", is("logado"))
		;
	}
	
	@Test
	public void deveAcessarSenha2() {
		
		given()
		.log().all()
		.auth().basic("admin", "senha")
		.when()
		.get("https://restapi.wcaquino.me/basicauth")
		.then()
		.log().all()
		.statusCode(200)
		.body("status", is("logado"))
		;
	}
	@Test
	public void deveAcessarSenhaChallenge() {
		
		given()
		.log().all()
		.auth().preemptive().basic("admin", "senha")
		.when()
		.get("https://restapi.wcaquino.me/basicauth2")
		.then()
		.log().all()
		.statusCode(200)
		.body("status", is("logado"))
		;
	}
	@Test
	public void deveFazerAutenticacaoComToken() {
		//login na api
		Map<String, String> login= new HashMap<String,String>();
		login.put("email","guga2k@gmail.com");
		login.put("senha","123456");
		String token=given()
		.log().all()
		.body(login)
		.contentType(ContentType.JSON)
		.when()
		.post("https://barrigarest.wcaquino.me/signin")
		.then()
		.log().all()
		.statusCode(200)
		.extract().path("token")
		;
		//receber o token
		
		       given()
				.log().all()
				.header("Authorization","JWT "+ token)
			   .when()
				.get("https://barrigarest.wcaquino.me/contas")
			   .then()
				.log().all()
				.statusCode(200)
				.body("nome", hasItem("conta de teste"))
				;
		//obter as contas
		
	}
	
	@Test
	public void deveAcessarAplicacaoWeb() {
		//login
	String cookie=	given()
		.log().all()
		.formParam("email", "guga2k@gmail.com")
		.formParam("senha", "123456")
		.contentType(ContentType.URLENC.withCharset("UTF-8"))
	   .when()
		.post("https://seubarriga.wcaquino.me/logar")
	   .then()
	   .log().all()
	   .statusCode(200)
	   .extract().header("set-cookie")
	   ;
	
	cookie=cookie.split("=")[1].split(";")[0];
	System.out.println(cookie);
		//obterconta
	
	String body= given()
		    .log().all()
		    .cookie("connect.sid",cookie)
	 .when()
			.get("https://seubarriga.wcaquino.me/contas")
	 .then()
		   .log().all()
		   .statusCode(200)
		   .body("html.body.table.tbody.tr[0].td[0]", is("conta de teste"))
		   .extract().body().asString()	   
		   ;
	System.out.println("-----------------------------------------------");
	XmlPath xmlPath=new XmlPath(CompatibilityMode.HTML, body);
	System.out.println(xmlPath.getString("html.body.table.tbody.tr[0].td[0]"));
	
	}
	
	//http://api.openweathermap.org/data/2.5/weather?q=Fortaleza,BR&appid=2de1ff1ac222845ffc4de80f888d44d7&&units=metric

}
