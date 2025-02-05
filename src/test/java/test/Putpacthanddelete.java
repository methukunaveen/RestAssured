package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.http.ContentType;

public class Putpacthanddelete {
	
	@Test
	public void testPut()
	{
		
		
		JSONObject  request= new JSONObject();
		request.put("name", "Naveen");
		request.put("job", "Software");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given().
		 header("Content-Type", "application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 put("/users/2").
		then().
		 statusCode(200).log().all();
		
	}
	
	@Test
	
	public void testPatch()
	{
		
		
		JSONObject  request= new JSONObject();
		request.put("name", "Naveenmethuku");
		request.put("job", "Software");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/";
		given().
		 header("Content-Type", "application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 patch("api/users/2").
		then().
		 statusCode(200).log().all();
		
	}

	
	@Test
	public void testDelete()
	{
		
		

		baseURI="https://reqres.in/";
		when().
		 patch("api/users/2").
		then().
		 statusCode(200).log().all();
		
	}
}
