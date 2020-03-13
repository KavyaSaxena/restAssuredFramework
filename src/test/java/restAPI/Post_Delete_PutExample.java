package restAPI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Post_Delete_PutExample {

    @Test(priority = 2)
    public void postCheck(){
        RequestSpecification resquestSpecification = RestAssured.given();
        resquestSpecification.header("Content-Type", "Application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "25");
        jsonObject.put("title", "json25");
        jsonObject.put("author", "typi25");
        resquestSpecification.body(jsonObject.toJSONString());
        Response response = resquestSpecification.post("http://localhost:3000/posts");
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 1)
    public void deleteCheck(){
        RequestSpecification resquestSpecification = RestAssured.given();
        Response response = resquestSpecification.delete("http://localhost:3000/posts/21");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void putCheck(){
        RequestSpecification resquestSpecification = RestAssured.given();
        resquestSpecification.header("Content-Type", "Application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "25");
        jsonObject.put("title", "json25");
        jsonObject.put("author", "Aluminium");
        resquestSpecification.body(jsonObject.toJSONString());
        Response response = resquestSpecification.put("http://localhost:3000/posts/25");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
