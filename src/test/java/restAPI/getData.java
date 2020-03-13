package restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getData {

    @Test
    public void testResponseCode(){
        Response response = RestAssured.get("http://localhost:3000/posts");
        int code =response.getStatusCode();
        System.out.println(code);
        Assert.assertEquals(code, 200);
    }
}
