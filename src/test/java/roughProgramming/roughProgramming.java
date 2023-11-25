package roughProgramming;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.tests.commonMethods;
import org.tests.variablesAndDataMethods;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class roughProgramming extends variablesAndDataMethods {
public String apiEndPointValue="";
@Test

public void generateRandomObjects(){
    Faker faker=new Faker();
    String firstName=faker.name().firstName();
    String lastName=faker.name().lastName();
    String fullName=faker.name().fullName();
    String userName=faker.name().name();
    String password=faker.internet().password();
    String email=faker.internet().emailAddress();
    String phoneNumber=faker.phoneNumber().toString();
    System.out.println("First Name : "+firstName);
    System.out.println("Last Name : "+lastName);
    System.out.println("Full Name : "+fullName);
    System.out.println("User Name : "+userName);
    System.out.println("Password : "+password);
    System.out.println("email : "+email);
    System.out.println("Phone Number : "+phoneNumber);

}
    @Test
    public void readAllLines()
    {
        List<String> tenantIDVals=getListVals("tenantIDs.txt");

    }

    @Test(priority = 3)
    public void deleteTenantsAPI() throws IOException, ParseException {
        List<String> tenandIDsToDelete = new ArrayList<String>();
        test.info("*** Testing API URI '"+uriValue+"/"+FETCH_TENANT+"' ***");
        authtok = login_api(getUserIdValue("2", region),passwordVal(region), region);
        String apiEndVal="tenantManagement/fetchTenants";
        Response responseVal= commonGetMethod(authtok,apiEndVal);
        JsonPath jp = new JsonPath(responseVal.asString());
        List<String> tenantIDVal=jp.getList("tenantId");
        List<String> tenantEmailIDVal=jp.getList("tenantAdminEmail");
        for(int iVal=0;iVal<tenantEmailIDVal.size();iVal++)
        {
//            if(tenantEmailIDVal.get(iVal).toString().contains("automation"))
            if(tenantEmailIDVal.get(iVal).toString().contains("srinu.ca"))
            {
                tenandIDsToDelete.add(tenantIDVal.get(iVal).toString());
            }
        }
        for(String tenantIDValue : tenandIDsToDelete)
        {
            String apiEndPointVal=REAL_DELETE_TENANT+tenantIDValue;
            Response responseValue = commonDeleteMethod(authtok,null,apiEndPointVal);
            test.info(responseValue.asString());
        }
       /* for (String tenantId : tenantIDVal)
        {
            String apiEndVal1=FETCH_TENANT+tenantId;
            Response responseVal1= commonGetMethod(authtok,apiEndVal1);
            JsonPath jp1 = new JsonPath(responseVal1.asString());
            String emailIDVal= jp1.get("tenantAdminEmail").toString();
            if(emailIDVal.contains("automation"))
            {
                tenandIDsToDelete.add(tenantId);
            }
            String s="abc";
        }*/




        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 19)
    public void deleteHostSurveys() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SURVEY_TENANTID+"' ***");

            authtok = login_api(getUserIdValue("2", region), passwordVal(region), region);
            headers=headersVal(authtok);
            String apiEndPointVal="tenantAdmin/survey?tenantId="+tenantIDVal(region)+"&userType=host";
            Response responseVal= commonGetMethod(authtok,apiEndPointVal);
            JsonPath jp = new JsonPath(responseVal.asString());
            List<String> surveyIDVal=jp.getList("survey.surveyId");
        if(surveyIDVal.size()>10) {
            for (int i = 10; i<surveyIDVal.size();i++)
            {
                String surveyIDValue = surveyIDVal.get(i).toString();
                String apiEndPointVal1="tenantAdmin/tenants/"+tenantIDVal(region)+"/survey/"+surveyIDValue;
                Response responseVal1=commonDeleteMethod(authtok,null,apiEndPointVal1);
            }
        }
            String s="abc";


        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 19)
    public void deleteGuestSurveys() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SURVEY_TENANTID+"' ***");

        authtok = login_api(getUserIdValue("2", region), passwordVal(region), region);
        headers=headersVal(authtok);
        String apiEndPointVal="tenantAdmin/survey?tenantId="+tenantIDVal(region)+"&userType=guest";
        Response responseVal= commonGetMethod(authtok,apiEndPointVal);
        JsonPath jp = new JsonPath(responseVal.asString());
        List<String> surveyIDVal=jp.getList("survey.surveyId");
        if(surveyIDVal.size()>10) {
            for (int i = 10; i<surveyIDVal.size();i++)
            {
                String surveyIDValue = surveyIDVal.get(i).toString();
                String apiEndPointVal1="tenantAdmin/tenants/"+tenantIDVal(region)+"/survey/"+surveyIDValue;
                Response responseVal1=commonDeleteMethod(authtok,null,apiEndPointVal1);
            }
        }
        String s="abc";


        test.info("*******************EndOfTest*******************");
    }
    @Test
    public void deleteUsers() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SURVEY_TENANTID+"' ***");
        List<String> userIDsToDelete = new ArrayList<String>();
        authtok = login_api(getUserIdValue("2", region), passwordVal(region), region);
        headers=headersVal(authtok);
        String tenantId = tenantIDVal(region);
        String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/users";
        Response responseVal= commonGetMethod(authtok,apiEndPointVal);
        JsonPath jp = new JsonPath(responseVal.asString());
        List<String> userIDVal=jp.getList("uid");
        List<String> userIDEmail=jp.getList("email");
        for(int iVal=0;iVal<userIDEmail.size();iVal++){
            if(userIDEmail.get(iVal).toString().contains("automation")){
            userIDsToDelete.add(userIDVal.get(iVal).toString());
            }
        }
        for(String userIdValue : userIDsToDelete){
            apiEndPointVal="user/"+userIdValue+"/removeUser";
            Response responseValue = commonDeleteMethod(authtok,null,apiEndPointVal);
        }
        String s="abc";
        test.info("*******************EndOfTest*******************");
    }

    @Test
    public void deleteUser() throws IOException, ParseException {

        test.info("*** Testing API URI '"+uriValue+"/"+SEARCHUSER_FETCH+"' ***");
        authtok = login_api(getUserIdValue("5", region),passwordVal(region), region);
        String apiEndVal="tenantAdmin/tenantsGroup/"+tenantIDVal(region)+"/search/"+"automation";
        Response responseVal= commonGetMethod(authtok,apiEndVal);
        JsonPath jp = new JsonPath(responseVal.asString());
        List<String> uidIDValList=jp.getList("uid");
        for(String userIDValue : uidIDValList)
        {
            String authtok2 = login_api(getUserIdValue( "5", region), passwordVal(region), region);
            String apiEndPointVal = "user/" +userIDValue+ "/removeUser";
            Response responseValue = commonDeleteMethod(authtok2, null, apiEndPointVal);
            System.out.println("abc");
        }
    }

}
