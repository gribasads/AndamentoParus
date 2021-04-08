package br.ce.wcaquino.rest;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.internal.path.xml.NodeImpl;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



public class UserXMLTest {
	public static RequestSpecification reqSpec;
	public static ResponseSpecification resSpec;
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI="http://restapi.wcaquino.me";
	 // RestAssured.port=80;
	 // RestAssured.basePath="/v2";
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.log(LogDetail.ALL);
		reqSpec = reqBuilder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectStatusCode(200);
		resSpec= resBuilder.build();
		RestAssured.requestSpecification=reqSpec;
		RestAssured.responseSpecification=resSpec;
		}
	
	@Test
	public void devoTrabalharcomXML() {
	
		
		RestAssured.given()
		.spec(reqSpec)
		.when()
		.get("/usersXML/3")
		.then()
		//.statusCode(200)
		.spec(resSpec)
		.rootPath("user")
		.body("name",is("Ana Julia"))
		.body("@id",is("3"))
		
		.rootPath("user.filhos")
		.body("name.size()",is(2))
		
		.detachRootPath("filhos")
		.body("filhos.name[0]",is("Zezinho"))
		.body("filhos.name[1]",is("Luizinho"))
		
		.appendRootPath("filhos")
		.body("name",hasItems("Zezinho"))
		.body("name",hasItems("Luizinho")) 
		
		;
	}
	
	
	@Test
	public void devoTrabalharcomXMLAvancado() {
		RestAssured.given()
		.spec(reqSpec)
		.when()
		.get("/usersXML")
		.then()
		.spec(resSpec)
		.rootPath("users.user")
		.body("size()", is(3))
		.body("findAll{it.age.toInteger() <= 25}.size()", is(2))
		.body("@id",hasItems("1","2","3"))
		.body("find{it.age==25}.name", is("Maria Joaquina"))
		.body("findAll{it.name.toString().contains('n')}.name",hasItems("Maria Joaquina","Ana Julia"))
		.body("salary.find{it != null}.toDouble()", is(1234.5678d))
		.body("age.collect{it.toInteger()*2}", hasItems(40,50,60))
		.body("name.findAll{it.toString().startsWith('Maria')}.collect{it.toString().toUpperCase()}", is("MARIA JOAQUINA"))
		;
	}
	
	@Test
	public void devoTrabalharcomXMLAvancadoEJava() {
		ArrayList<NodeImpl> nomes = RestAssured.given()
				.spec(reqSpec)
		.when()
		.get("/usersXML")
		.then()
		.spec(resSpec)
		.extract().path("users.user.name.findAll{it.toString().contains('n')}");
		
		;
		
		Assert.assertEquals(2, nomes.size());
		Assert.assertEquals("Maria Joaquina".toUpperCase(), nomes.get(0).toString().toUpperCase());
		Assert.assertTrue("ANA JULIA".equalsIgnoreCase(nomes.get(1).toString()));
		//Assert.assertEquals("Maria Joaquina".toUpperCase(), nome.toUpperCase());
		
	}
	
	@Test
	public void devoTrabalharcomXPath() {
		RestAssured.given()
		.spec(reqSpec)
		.when()
		.get("/usersXML")
		.then()
		.spec(resSpec)
		.body(hasXPath("count/users/user",is("3")))
		.body(hasXPath("/users/user[@id='1']"))
		.body(hasXPath("//user[@id='2']"))
		.body(hasXPath("//name[text()='Luizinho']/../../name",is("Ana Julia")))
		.body(hasXPath("//name[text()='Ana Julia']/following-sibling::filhos",allOf(containsString("Zezinho"),containsString("Luizinho"))))
		.body(hasXPath("//name"),is("Joao da Silva"))
		.body("/users/user/name[2]", is("Maria Joaquina "))
		.body(hasXPath("/users/user[last()name]"), is("Ana Julia"))
		.body(hasXPath("/users/username[contains(., 'n')]"), is("2"))
		.body("//user[age <24]/name",is("Ana Julia"))
		.body(hasXPath("//user[age >20 and age <30]/name"), is("Maria Joaquina"))
		.body(hasXPath("//user[age >20] [age <30]/name"), is("Maria Joaquina"))
		
		
		;
		
		
	}
	

}
