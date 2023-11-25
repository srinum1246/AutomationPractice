package org.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;

public class userDelete extends variablesAndDataMethods  {
public String apiEndPointValue;
    public userDelete() throws IOException {
    }

    @Test(priority = 1)
    public void userRemoveUserAPI() throws IOException, ParseException {

             for (int j=0; j<commonMethods.uidVal().size(); j++){
                 String authtok2 = login_api(getUserIdValue( "5", region), passwordVal(region), region);
                 String apiEndPointVal = "user/" +uidVal().get(j)+ "/removeUser";
                 Response responseVal = commonDeleteMethod(authtok2, null, apiEndPointVal);
                   if (responseVal.statusCode()==200){
                      test.pass("Response Value is :"+responseVal.asString()+" - Uid Value Is:"+uidVal().get(j));
                  }else{
                      test.fail("Response Value is :"+responseVal.asString()+" - Uid Value Is:"+uidVal().get(j));
                  }
             }


        test.info("*******************EndOfTest*******************");
    }

}


