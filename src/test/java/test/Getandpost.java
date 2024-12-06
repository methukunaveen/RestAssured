package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.http.ContentType;

public class Getandpost {
	
	
	/* @Test */
	public void testget() {
		
		baseURI="https://reqres.in/api";
		
		given().
		
		get("/users?page=2").
		//status code
		then().
		statusCode(200).
		body("data[4].first_name", equalTo("George")).log().all().
		body("data.first_name",hasItems("George","Rachel"));
		
		System.out.println("hello world branch2");
		
	}
	@Test
	public void testpost()
	{
		HashMap<String,Object>map= new HashMap<String,Object>();
		/*
		 * map.put("name", "Naveenmethuku"); map.put("job", "Software");
		 * System.out.println(map);
		 */
		
		JSONObject  request= new JSONObject(map);
		request.put("name", "Naveenmethuku");
		request.put("job", "Software");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given().
		 header("Content-Type", "application/json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201).log().all();
		
	}

}
