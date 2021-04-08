package br.ce.wcaquino.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;


import org.junit.Test;

import io.restassured.http.ContentType;




public class VerbosTeste {
	
	@Test
	public void devoRequisitarUsuario(){
		given()
		.log().all()
		.contentType("application/json")
		.body("{\r\n"
				+ "	\"name\": \"Jose\",\r\n"
				+ "	\"age\": 50\r\n"
				+ "}\r\n"
				+ "")
		.when()
		.post("http://restapi.wcaquino.me/users")
		.then()
		.log().all()
		.statusCode(201)
		.body("id", is(notNullValue()))
		.body("name", is("Jose"))
		.body("age",is(50))
		;
		
	}
	@Test
	public void naoDeveSalvarUsuarioSemNome() {
		given()
		.log().all()
		.contentType("application/json")
		.body("{\"ague\": 50}")
		.when()
		.post("http://restapi.wcaquino.me/users")
		.then()
		.log().all()
		.statusCode(400)
		.body("id", is(notNullValue()))
		.body("error", is("Name é um atributo obrigatório"))
		;
	}
	@Test
	public void devoRequisitarUsuarioXML(){
		given()
		.log().all()
		.contentType(ContentType.XML)
		.body("<user><name>Jose</name><age>50</age></user>")
		.when()
		.post("http://restapi.wcaquino.me/usersXML")
		.then()
		.log().all()
		.statusCode(201)
		.body("user.@id", is(notNullValue()))
		.body("user.name", is("Jose"))
	    .body("user.age",is("50"))
		;
		
	}
	
	@Test
	public void devoAlterarUsuario(){
		given()
		.log().all()
		.contentType("application/json")
		.body("{\"name\": \"Usuario alterado\", \"age\":80}")
		.when()
		.put("http://restapi.wcaquino.me/users/1")
		.then()
		.log().all()
		.statusCode(200)
		.body("id", is(1))
		.body("name", is("Usuario alterado"))
		.body("age",is(80))
		.body("salary", is(1234.5678f))
		;
		
	}
	@Test
	public void devoCustomizarUrl(){
		given()
		.log().all()
		.contentType("application/json")
		.body("{\"name\": \"Usuario alterado\", \"age\":80}")
		.pathParam("entidade", "users")
		.pathParam("userId", 1)
		.when()
		//.put("http://restapi.wcaquino.me/{entidade}/{userId}","users","1")
		.put("http://restapi.wcaquino.me/{entidade}/{userId}")
		.then()
		.log().all()
		.statusCode(200)
		.body("id", is(1))
		.body("name", is("Usuario alterado"))
		.body("age",is(80))
		.body("salary", is(1234.5678f))
		;
		
	}
	@Test
	public void deveRemoverUsuario() {
		given()
		.log().all()
		.when()
		.delete("http://restapi.wcaquino.me/users/1")
		.then()
		.log().all()
		.statusCode(204);
	}
	@Test
	public void deveNaoRemoverUsuarioInexistente() {
		given()
		.log().all()
		.when()
		.delete("http://restapi.wcaquino.me/users/1000")
		.then()
		.log().all()
		.statusCode(400)
		.body("error",is("Registro inexistente"));
	}
	
	@Test
	public void devoRequisitarUsuarioMap(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", "Usuario via map");
		params.put("age", 25);
		
		given()
		.log().all()
		.contentType("application/json")
		.body(params)
		.when()
		.post("http://restapi.wcaquino.me/users")
		.then()
		.log().all()
		.statusCode(201)
		.body("id", is(notNullValue()))
		.body("name", is("Usuario via map"))
		.body("age",is(25))
		;
		
	}

	
	@Test
	public void devoRequisitarUsuarioObj(){
		User user = new User("Usuario via objeto",35);
		
		given()
		.log().all()
		.contentType("application/json")
		.body(user)
		.when()
		.post("http://restapi.wcaquino.me/users")
		.then()
		.log().all()
		.statusCode(201)
		.body("id", is(notNullValue()))
		.body("name", is("Usuario via objeto"))
		.body("age",is(35))
		;
		
	}
	@Test
	public void devoDeserializarAoSalvarUsuarioObj(){
		User user = new User("Usuario deserializado",35);
		
		User usuarioInserido = given()
		.log().all()
		.contentType("application/json")
		.body(user)
		.when()
		.post("http://restapi.wcaquino.me/users")
		.then()
		.log().all()
		.statusCode(201)
		.extract().body().as(User.class)
		;
		System.out.println(usuarioInserido);
		assertThat(usuarioInserido.getId(), notNullValue());
		assertEquals("Usuario deserializado", usuarioInserido.getName());
		assertThat(usuarioInserido.getAge(), is(35));
		
	}
	
	@Test
	public void devoSalvarUsuarioXML(){
		User user = new User("Usuario XML",40);
		
		given()
		.log().all()
		.contentType(ContentType.XML)
		.body(user)
		.when()
		.post("http://restapi.wcaquino.me/usersXML")
		.then()
		.log().all()
		.statusCode(201)
		.body("user.@id", is(notNullValue()))
		.body("user.name", is("Usuario XML"))
	    .body("user.age",is("40"))
		;
		
	}
	@Test
	public void devoDesearilizarXMLAoSalvarUsuario(){
		User user = new User("Usuario XML",40);
		
		User usuarioInserido=given()
		.log().all()
		.contentType(ContentType.XML)
		.body(user)
		.when()
		.post("http://restapi.wcaquino.me/usersXML")
		.then()
		.log().all()
		.statusCode(201)
		.extract().body().as(User.class)
		;
	assertThat(usuarioInserido.getId(), notNullValue());
	assertThat(usuarioInserido.getName(), is("Usuario XML"));
	assertThat(usuarioInserido.getAge(), is(40));
	assertThat(usuarioInserido.getSalary(), nullValue());
	}
}




