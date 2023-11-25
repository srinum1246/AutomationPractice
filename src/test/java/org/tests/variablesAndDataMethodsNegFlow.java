package org.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertTrue;

public class variablesAndDataMethodsNegFlow extends commonMethods {


    public Map<String, String> headersValGet(String authtok) {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Authorization", "Bearer " + authtok);
        return  headers1;
    }
    // function to generate a random string of length n


    public JSONObject dataRequired() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("tenantName", getAlphaNumericString(10));
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
      /*  requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerPlan", "trial");
        requestParams.put("customerStatus", "paying");*/
        //requestParams.put("aiEnabled","false");
        return requestParams;
    }





    public String login_api(String emailid, String password,String region) throws IOException, ParseException {


        RestAssured.baseURI =uriVal(region);
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", emailid);
        requestParams.put("password", password);
        Response response = given()
                .contentType("application/json")
//                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post("/auth/login")
                .then()
                .extract().response();
        //   Assertions.assertEquals(200, response.statusCode());
        String tok = response.jsonPath().getString("token.idToken");
        return tok;


    }

    public static String uriVal(String region) throws IOException, ParseException {
        String keyName=region;
        String strFilePath = propsFolderPath+"uris.properties";
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }

    public String login_API() {

        RestAssured.baseURI = "https://hyperspace.apiv2.carear.app/";
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "vimal@carear.io");
        requestParams.put("password", "Testing1");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post("/auth/login")
                .then()
                .extract().response();
        Assertions.assertEquals(200, response.statusCode());
        String tok = response.jsonPath().getString("token.idToken");
        return tok;
    }


    public JSONObject dataAdd_Group(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);

        requestParams.put("group", getAlphaNumericString(1));
        requestParams.put("tenantId", tenantIDVal);

        return requestParams;
    }
    public JSONObject dataAdd_GroupManAsEmpty(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("group","");
        requestParams.put("tenantId","");

        return requestParams;
    }
    public JSONObject dataAdd_GroupManFieldAsInvalidVal(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("group","r");
        requestParams.put("tenantId",tenantIDVal);


        return requestParams;
    }

    public JSONObject dataAdd_Groupid(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("group", getAlphaNumericString(10));
        requestParams.put("uid", getAlphaNumericString(10));
        // requestParams.put("groupid")


        return requestParams;
    }

    public JSONObject dataUpdate_Group(String tenantIDVal,String oldGrpName) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);

        requestParams.put("newGroup", getAlphaNumericString(1));
        requestParams.put("oldGroup", oldGrpName);
        requestParams.put("tenantId", tenantIDVal);

        return requestParams;
    }
    public JSONObject dataUpdate_GroupManAsEmpty(String tenantIDVal,String oldGrpName) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("newGroup", "");
        requestParams.put("oldGroup", "");
        requestParams.put("tenantId", "");

        return requestParams;
    }
    public JSONObject dataUpdate_GroupManAsInvalidVal(String tenantIDVal,String oldGrpName) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("newGroup", "t");
       // requestParams.put("oldGroup", "p");
        requestParams.put("oldGroup", oldGrpName);
        requestParams.put("tenantId", tenantIDVal);

        return requestParams;
    }
    public JSONObject dataRemove_Group(String tenantIDVal,String oldGrpName) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);

        requestParams.put("group", oldGrpName);
        requestParams.put("tenantId", tenantIDVal);

        return requestParams;
    }

    public JSONObject dataSaveNotificationsNotManAsEmpty(String userIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);


        JSONObject requestParams1= new JSONObject();
        requestParams1.put("reminderOne", "");
        requestParams1.put("reminderTwo", "");
        requestParams1.put("reminderThree","");
        requestParams1.put("reminderFour", "");

        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("sessions",requestParams1);



        JSONObject requestParams3 = new JSONObject();
        requestParams3.put("reminderOne", "");
        requestParams3.put("reminderTwo", "");
        requestParams3.put("reminderThree","");
        requestParams3.put("reminderFour", "");



        JSONObject requestParams5 = new JSONObject();
        requestParams5.put("reminderOne", "");
        requestParams5.put("reminderTwo", "");
        requestParams5.put("reminderThree","");
        requestParams5.put("reminderFour", "");

        JSONObject requestParams6 = new JSONObject();
        requestParams6.put("minutes",requestParams5);
        requestParams6.put("sessions",requestParams3);

        JSONObject requestParams7 = new JSONObject();
        requestParams7.put("assist",requestParams6);
        requestParams7.put("instruct",requestParams2);
        JSONArray emailList = new JSONArray();
        emailList.put(userIDVal);
        requestParams.put( "emailNotificationList","");
        requestParams.put("notificationSettings",requestParams7);

        return requestParams;
    }
    public JSONObject dataSaveNotificationsNotManInvalidVal(String userIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);


        JSONObject requestParams1= new JSONObject();
        requestParams1.put("reminderOne", "acs");
        requestParams1.put("reminderTwo", "ybd");
        requestParams1.put("reminderThree","yui");
        requestParams1.put("reminderFour", "wds");

        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("sessions",requestParams1);



        JSONObject requestParams3 = new JSONObject();
        requestParams3.put("reminderOne", "we");
        requestParams3.put("reminderTwo", "yu");
        requestParams3.put("reminderThree","d");
        requestParams3.put("reminderFour", "w");



        JSONObject requestParams5 = new JSONObject();
        requestParams5.put("reminderOne", "qwe");
        requestParams5.put("reminderTwo", "qs");
        requestParams5.put("reminderThree","wds");
        requestParams5.put("reminderFour", "vb");

        JSONObject requestParams6 = new JSONObject();
        requestParams6.put("minutes",requestParams5);
        requestParams6.put("sessions",requestParams3);

        JSONObject requestParams7 = new JSONObject();
        requestParams7.put("assist",requestParams6);
        requestParams7.put("instruct",requestParams2);
        JSONArray emailList = new JSONArray();
        emailList.put(userIDVal);
        // requestParams.put("tenantId", tenantIDVal);
        //requestParams.put( "emailNotificationList","134");
        requestParams.put( "emailNotificationList","xyz@gmail.com");

        requestParams.put("notificationSettings",requestParams7);

        return requestParams;
    }
    public JSONObject dataImportUsers(String tenantIDVal,String binaryPath) {
        String s = binaryPath;
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            binary.append(' ');
        }
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);

        requestParams.put("csvfile", new File("C:/Users/2424975/Downloads/Template_Import_Users_20221106_232755.csv"));
        requestParams.put("tenantId", tenantIDVal);

        return requestParams;
    }
    public JSONObject dataSaveAIConfig(String regionval) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        if(regionval.equalsIgnoreCase("devus")) {
            requestParams.put("aiDNS", "gateway-demo.qa");
            requestParams.put("userName", "ai.platform.carear.dev+usdemo@gmail.com");
            requestParams.put("password", "Carear@1234");
        }
        else if(regionval.equalsIgnoreCase("deveu")) {
            requestParams.put("aiDNS", "345");
            requestParams.put("userName", "789");
            requestParams.put("password", "xv");
        }
        else if(regionval.equalsIgnoreCase("devca")) {
            requestParams.put("aiDNS", "gateway-demo.ca.qa");
            requestParams.put("userName", "ai.platform.carear.dev+cademo@gmail.com");
            requestParams.put("password", "Carear@1234");
        }


        return requestParams;
    }

    public JSONObject dataRegisterUser(String tenantID, String companyName) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("companyName",companyName);
        requestParams.put("email", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@gmail.com");
        requestParams.put("firstName", getAlphaNumericString(10));
        requestParams.put("lastName", getAlphaNumericString(10));
        requestParams.put("tenantId",tenantID);



        return requestParams;
    }

    public JSONObject dataRegisterUserFetch(String tenantID) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("companyName","TestName"+getAlphaNumericString(10));
        requestParams.put("email", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@gmail.com");
        requestParams.put("firstName", getAlphaNumericString(10));
        requestParams.put("lastName", getAlphaNumericString(10));
        requestParams.put("tenantId",tenantID);
        requestParams.put("group",getAlphaNumericString(10));




        return requestParams;
    }

    public JSONObject dataFullCustom() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantName", "TestName"+getAlphaNumericString(10));
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "trial");
        requestParams.put("customerStatus", "paying");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }

    public JSONObject dataUpdatePluginStatus(String tenantID) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("pluginId", "AWS");
        requestParams.put("pluginStatus", "true");
        requestParams.put("tenantID", tenantID);


        return requestParams;
    }

    public JSONObject datafetchKPI(String tenantID) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantID);
        requestParams.put("fromDate", "xxxx/yy/zz");
        requestParams.put("toDate", "xxxx/yy/zz");


        return requestParams;
    }
    public JSONObject datafetchKPIManEmpty(String tenantID) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "");
        requestParams.put("fromDate", "");
        requestParams.put("toDate", "");


        return requestParams;
    }
    public JSONObject datafetchKPIManAsInvalid(String tenantID) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantID);
        requestParams.put("fromDate", "xxxx/yy/zz");
        requestParams.put("toDate", "xxxx/yy/zz");


        return requestParams;
    }
    public JSONObject dataSavePlugin(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("apiURL","123");
        requestParams.put("fqdn","");
        requestParams.put("iName", "23");
        requestParams.put("tenantId", tenantID);
        requestParams.put("username", userNameVal);
        requestParams.put("password", "dc");
        requestParams.put("token", "vcvd");
        return requestParams;
    }
    public JSONObject dataSavePluginManAsEmpty(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","");
        return requestParams;
    }
    public JSONObject dataSavePluginManNonManAsEmpty(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","");
        requestParams.put("apiURL","");
        requestParams.put("fqdn","");
        requestParams.put("iName", "");
        requestParams.put("username","");
        requestParams.put("password", "");
        requestParams.put("token", "");

        return requestParams;
    }

    public JSONObject dataSavePluginManAsInvalid(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","vcd");


        return requestParams;
    }
    public JSONObject dataSavePluginManAndNonManAsInvalid(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","vcd");
        requestParams.put("apiURL","2345");
        requestParams.put("fqdn","@");
        requestParams.put("iName", "6");
        requestParams.put("username","9");
        requestParams.put("password", "%");
        requestParams.put("token", "lo");


        return requestParams;
    }
    public JSONObject dataSavePluginManInvalidAndNonManAsvalid(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","vcd");
        requestParams.put("apiURL","Test");
        requestParams.put("fqdn",getAlphaNumericString(10));
        requestParams.put("iName", "WEBAPI");
        requestParams.put("username",userNameVal);
        requestParams.put("password","Testing1");
        requestParams.put("token", "67b1288ff225adbab24e");


        return requestParams;
    }
    public JSONObject dataSavePluginManvalidAndNonManAsinvalid(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId",tenantID);
        requestParams.put("apiURL","43");
        requestParams.put("fqdn","q");
        requestParams.put("iName", "4");
        requestParams.put("username","ty");
        requestParams.put("password","5");
        requestParams.put("token", "uyt");


        return requestParams;
    }
    public JSONObject dataActivateUserInvalid(String userIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("uid","1234xz");

        return requestParams;
    }
    public JSONObject dataActivateUserEmpty(String userIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("uid","");

        return requestParams;
    }
    public JSONObject dataFull() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("aiEnabled", "345");
        requestParams.put("assistUsageType", "456");
        requestParams.put("azAppId", "");
        requestParams.put("azAppSecret", "");
        requestParams.put("azTenantId", "");
        requestParams.put("contractEffectiveDate","xy/x/zz");
        requestParams.put("createdBy", "678");
        requestParams.put("customerCRMID", "");
        requestParams.put("customerPlan", "234");
        requestParams.put("customerStatus", "431");
        requestParams.put("customerSuccessManager", "");
        requestParams.put("disabled", "789");
        requestParams.put("expiryDate", "{seconds: 1684693799, nanoseconds: 999000000}");
        requestParams.put("gcpTenantId", "");
        requestParams.put("imageRecognitionEntitlement", "gv3");
        requestParams.put("instructSessionsPurchased", "xvb");
        requestParams.put("joinDate", "{seconds: 1669026576, nanoseconds: 771000000}");
        requestParams.put("numberUsers", "no");
        requestParams.put("numberVideoRecordingUsers", "fgh");
        requestParams.put("referralCode", "");
        requestParams.put("resellerOfRecord", "");
        requestParams.put("salesforceConnectorEntitlement", "dca");
        requestParams.put("serviceNowConnectorEntitlement", "mnv1");
        requestParams.put("servicePackage", "2345");
        requestParams.put("subscriptionTerm", "bcd");
        requestParams.put("tenantAdminEmail", "123456@xyz.com");
        requestParams.put("tenantAdminFirstName", "123");
        requestParams.put("tenantAdminLastName", "456");
        requestParams.put("tenantName", "12345");
        requestParams.put("tenantPhysicalAddress", "");
        requestParams.put("tierLevel", "mnb");
        requestParams.put("transactionReason", "purchase");
        requestParams.put("zQuoteID", "");
        return requestParams;
    }
    public JSONObject dataFullManFieldAsEmpty() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("contractEffectiveDate","");
        requestParams.put("customerPlan", "");
        requestParams.put("customerStatus", "");
        requestParams.put("numberUsers", "");
        requestParams.put("subscriptionTerm", "");
        requestParams.put("tenantAdminEmail", "");
        requestParams.put("tenantAdminFirstName", "");
        requestParams.put("tenantAdminLastName", "");
        requestParams.put("tenantName", "");
        return requestParams;
    }
    public JSONObject dataFullManFieldAndNonManFieldAsEmpty() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("contractEffectiveDate","");
        requestParams.put("customerPlan", "");
        requestParams.put("customerStatus", "");
        requestParams.put("numberUsers", "");
        requestParams.put("subscriptionTerm", "");
        requestParams.put("tenantAdminEmail", "");
        requestParams.put("tenantAdminFirstName", "");
        requestParams.put("tenantAdminLastName", "");
        requestParams.put("tenantName", "");
        requestParams.put("tenantPhysicalAddress", "");
        requestParams.put("customerCRMID", "");
        requestParams.put("disabled", "");
        requestParams.put("aiEnabled", "");
        requestParams.put("instructSessionsPurchased", "");
        requestParams.put("assistUsageType", "");
        requestParams.put("sessionsPurchased", "");
        requestParams.put("minutesPurchased", "");
        requestParams.put("resellerOfRecord", "");
        requestParams.put("customerSuccessManager", "");
        requestParams.put("tierLevel", "");
        requestParams.put("zQuoteID", "");
        requestParams.put("serviceNowConnectorEntitlement", "");
        requestParams.put("createdBy", "");
        requestParams.put("numberVideoRecordingUsers", "");
        requestParams.put("referralCode", "");
        requestParams.put("partnerContactEmail", "");
        requestParams.put("transactionReason", "");
        requestParams.put("servicePackage", "");
        requestParams.put("imageRecognitionEntitlement", "");
        requestParams.put("salesforceConnectorEntitlement", "");
        return requestParams;
    }
    public JSONObject dataFullManFieldAsInvalid() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("contractEffectiveDate","xy/x/zz");
        requestParams.put("customerPlan", "234");
        requestParams.put("customerStatus", "431");
        requestParams.put("numberUsers", "no");
        requestParams.put("subscriptionTerm", "bcd");
        requestParams.put("tenantAdminEmail", "123456@xyz.com");
        requestParams.put("tenantAdminFirstName", "123");
        requestParams.put("tenantAdminLastName", "456");
        requestParams.put("tenantName", "12345");
        return requestParams;
    }
    public JSONObject dataFullManFieldAndNonManFieldInvalid() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("contractEffectiveDate","xy/x/zz");
        requestParams.put("customerPlan", "234");
        requestParams.put("customerStatus", "431");
        requestParams.put("numberUsers", "no");
        requestParams.put("subscriptionTerm", "bcd");
        requestParams.put("tenantAdminEmail", "123456@xyz.com");
        requestParams.put("tenantAdminFirstName", "123");
        requestParams.put("tenantAdminLastName", "456");
        requestParams.put("tenantName", "12345");
        requestParams.put("tenantPhysicalAddress","1234");
        requestParams.put("customerCRMID", "v");
        requestParams.put("disabled", "xcv");
        requestParams.put("aiEnabled", "vfg");
        requestParams.put("instructSessionsPurchased", "wer");
        requestParams.put("assistUsageType", "def");
        requestParams.put("sessionsPurchased", "sdf");
        requestParams.put("minutesPurchased", "cdf");
        requestParams.put("resellerOfRecord", "xc");
        requestParams.put("customerSuccessManager", "12");
        requestParams.put("tierLevel", "wer");
        requestParams.put("zQuoteID", "cx");
        requestParams.put("serviceNowConnectorEntitlement", "sdf");
        requestParams.put("createdBy", "xcg");
        requestParams.put("numberVideoRecordingUsers", "cvb");
        requestParams.put("referralCode", "df");
        requestParams.put("partnerContactEmail", "234");
        requestParams.put("transactionReason", "123");
        requestParams.put("servicePackage", "ca");
        requestParams.put("imageRecognitionEntitlement", "djk");
        requestParams.put("salesforceConnectorEntitlement", "gyt");

        return requestParams;
    }
    public JSONObject dataFullManFieldAsInvalidNonManValidVal() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("contractEffectiveDate","xy/x/zz");
        requestParams.put("customerPlan", "234");
        requestParams.put("customerStatus", "431");
        requestParams.put("numberUsers", "no");
        requestParams.put("subscriptionTerm", "bcd");
        requestParams.put("tenantAdminEmail", "123456@xyz.com");
        requestParams.put("tenantAdminFirstName", "123");
        requestParams.put("tenantAdminLastName", "456");
        requestParams.put("tenantName", "12345");
        requestParams.put("tenantPhysicalAddress", "");
        requestParams.put("customerCRMID", "");
        requestParams.put("disabled", false);
        requestParams.put("aiEnabled", true);
        requestParams.put("instructSessionsPurchased", 100);
        requestParams.put("assistUsageType", "user");
        requestParams.put("resellerOfRecord", "");
        requestParams.put("customerSuccessManager", "");
        requestParams.put("tierLevel", 1000);
        requestParams.put("zQuoteID", "");
        requestParams.put("serviceNowConnectorEntitlement", true);
        requestParams.put("createdBy", "Manual");
        requestParams.put("numberVideoRecordingUsers", 0);
        requestParams.put("referralCode", "");
        requestParams.put("transactionReason", "purchase");
        requestParams.put("servicePackage", "PremiumPlus");
        requestParams.put("imageRecognitionEntitlement", true);
        requestParams.put("salesforceConnectorEntitlement", true);


        return requestParams;
    }

    public JSONObject dataFullManFieldValidNonManInValidVal() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("contractEffectiveDate",date1);
        requestParams.put("customerPlan", "platform");
        requestParams.put("customerStatus", "paying");
        requestParams.put("numberUsers", 100);
        requestParams.put("subscriptionTerm", 36);
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantName", "testnewapitenantgmailcom");
        requestParams.put("tenantPhysicalAddress", "dfg");
        requestParams.put("customerCRMID", "sd");
        requestParams.put("disabled", "564");
        requestParams.put("aiEnabled", "67");
        requestParams.put("instructSessionsPurchased", "ty");
        requestParams.put("assistUsageType", "jk");
        requestParams.put("resellerOfRecord", "rt");
        requestParams.put("customerSuccessManager", "cv");
        requestParams.put("tierLevel", "wer");
        requestParams.put("zQuoteID", "xc");
        requestParams.put("serviceNowConnectorEntitlement", "nbv");
        requestParams.put("createdBy", "561");
        requestParams.put("numberVideoRecordingUsers", "njg");
        requestParams.put("referralCode", "sdf");
        requestParams.put("transactionReason", "2345");
        requestParams.put("servicePackage", "3456");
        requestParams.put("imageRecognitionEntitlement", "890");
        requestParams.put("salesforceConnectorEntitlement", "4567");
        return requestParams;


    }


   /* public JSONObject dataFull() {

        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantName", "TestName");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "trial");
        requestParams.put("customerStatus", "paying");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }*/

    public JSONObject dataAIConfig() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("aiDNS", "app");
        return requestParams;
    }

    // trialDataWithAI
    //requestParams.put("aiEnabled", "true");
    public JSONObject dataEnterpriseFull() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantName", "TestName");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "enterprise");
        requestParams.put("customerStatus", "paying");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }

    public JSONObject dataEnterpriseAiconfig() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantName", "TestName");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "aiserviceconfig");
        requestParams.put("customerStatus", "paying");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }

    public JSONObject dataEnterpriseNegative() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantName", "TestName");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "enterprise");
        requestParams.put("customerStatus", "paying");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }

    public JSONObject trialDataWithAI() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantName", "TestName");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "trial");
        requestParams.put("customerStatus", "paying");
        requestParams.put("aiEnabled", "true");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }

    public JSONObject invalidData() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantName", "TestName");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "trial");
        requestParams.put("customerStatus", "paying");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }


    public JSONObject dataFullUpdate(String tenantId) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantId);
        requestParams.put("tenantName", "TestName");
        requestParams.put("tenantAdminFirstName", "Testfirstname");
        requestParams.put("tenantAdminLastName", "Testlastname");
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantPhysicalAddress", "test address 01, 02, 03");
        requestParams.put("numberUsers", 1000);
        requestParams.put("subscriptionTerm", 5);
        requestParams.put("customerCRMID", "1001");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("customerPlan", "trial");
        requestParams.put("customerStatus", "paying");
        requestParams.put("resellerOfRecord", "TCS");
        requestParams.put("customerSuccessManager", "Test Manager");
        requestParams.put("disabled", false);
        requestParams.put("isServiceNowCustomer", false);
        requestParams.put("tierLevel", 2000);
        requestParams.put("zQuoteID", "ID1234");
        requestParams.put("createdBy", "Manual");
        requestParams.put("referralCode", "testCode 123");
        requestParams.put("numberVideoRecordingUsers", 15);

        return requestParams;
    }

    public JSONObject updateData(String tenantId) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantId);
        requestParams.put("numberUsers", 100);

        return requestParams;
    }

    public JSONObject updateRequiredData(String tenantId) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantId);
        requestParams.put("tenantName", getAlphaNumericString(10));
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("aiEnabled", "true");
        return requestParams;
    }

    /*public JSONObject updateFullData(String tenantId) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("tenantId", tenantId);
        requestParams.put("aiEnabled", true);
        requestParams.put("assistUsageType", "minutes");
        requestParams.put("minutesPurchased",20);
        requestParams.put("azAppId", "");
        requestParams.put("azAppSecret", "");
        requestParams.put("azTenantId", "");
        requestParams.put("contractEffectiveDate", date1);
        requestParams.put("createdBy", "Manual");
        requestParams.put("customerCRMID", "");
        requestParams.put("customerPlan", "platform");
        requestParams.put("customerStatus", "paying");
        requestParams.put("customerSuccessManager", "");
        requestParams.put("disabled", false);
        requestParams.put("expiryDate", "{seconds: 1684693799, nanoseconds: 999000000}");
        requestParams.put("gcpTenantId", "");
        requestParams.put("imageRecognitionEntitlement", true);
        requestParams.put("instructSessionsPurchased", 200);
        requestParams.put("joinDate", "{seconds: 1669026576, nanoseconds: 771000000}");
        requestParams.put("numberUsers", 100);
        requestParams.put("numberVideoRecordingUsers", 0);
        requestParams.put("referralCode", "");
        requestParams.put("resellerOfRecord", "");
        requestParams.put("salesforceConnectorEntitlement", true);
        requestParams.put("serviceNowConnectorEntitlement", true);
        requestParams.put("servicePackage", "PremiumPlus");
        requestParams.put("subscriptionTerm", 36);
        requestParams.put("tenantAdminEmail", "automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("tenantName", "testnewapitenantgmailcom");
        requestParams.put("tenantPhysicalAddress", "");
        requestParams.put("tierLevel", 1000);
        requestParams.put("transactionReason", "purchase");
        requestParams.put("zQuoteID", "");
        return requestParams;
    }*/
    public JSONObject updateFullData(String tenantId) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantId);
        requestParams.put("numberUsers", "abc");
        requestParams.put("tenantName", "345");
        requestParams.put("tenantAdminFirstName","2345");
        requestParams.put("tenantAdminLastName", "54321");
        //requestParams.put("aiEnabled", "true");
        requestParams.put("tenantPhysicalAddress",  "234");
        requestParams.put("customerCRMID", "abc");
        requestParams.put("resellerOfRecord", "3456");
        requestParams.put("customerSuccessManager","3456");
        requestParams.put("disabled", "34");
        requestParams.put("isServiceNowCustomer", "67");
        requestParams.put("tierLevel", "asd");
        requestParams.put("zQuoteID",  "123");
        requestParams.put("createdBy", "123");
        requestParams.put("referralCode", "3546");
        requestParams.put("numberVideoRecordingUsers","wert");

        return requestParams;
    }
    public JSONObject updateFullDataManFieldAsEmpty(String tenantId) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "");
        return requestParams;
    }
    public JSONObject updateFullDataManFieldAndNonManFieldAsEmpty(String tenantId) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "");
        requestParams.put("tenantName", "");
        requestParams.put("numberUsers", "");
        requestParams.put("subscriptionTerm", "");
        requestParams.put("disabled", "");
        requestParams.put("aiEnabled", "");
        requestParams.put("customerPlan", "");
        requestParams.put("customerStatus", "");
        requestParams.put("name", "");
        requestParams.put("assistUsageType", "");
        requestParams.put("sessionsPurchased", "");
        requestParams.put("minutesPurchased", "");
        requestParams.put("instructSessionsPurchased", "");
        requestParams.put("contractEffectiveDate", "");
        requestParams.put("tierLevel", "");
        requestParams.put("serviceNowConnectorEntitlement", "");
        requestParams.put("createdBy", "");
        requestParams.put("numberVideoRecordingUsers", "");
        requestParams.put("partnerContactEmail", "");
        requestParams.put("transactionReason", "");
        requestParams.put("servicePackage", "");
        requestParams.put("imageRecognitionEntitlement", "");
        requestParams.put("salesforceConnectorEntitlement", "");
        return requestParams;
    }
    public JSONObject updateFullDataManFieldAsInvalidVal(String tenantId) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "ascd");
        return requestParams;
    }
    public JSONObject updateFullDataManFieldAndNonManFieldAsInvalidVal(String tenantId) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "ascd");
        requestParams.put("tenantName", "345");
        requestParams.put("numberUsers", "dfg");
        requestParams.put("subscriptionTerm", "asd");
        requestParams.put("disabled", "234");
        requestParams.put("aiEnabled", "345");
        requestParams.put("customerPlan", "234");
        requestParams.put("customerStatus", "908");
        requestParams.put("name", "234");
        requestParams.put("assistUsageType", "rty");
        requestParams.put("sessionsPurchased", "gfds");
        requestParams.put("minutesPurchased", "sdf");
        requestParams.put("instructSessionsPurchased", "dssegeg");
        requestParams.put("contractEffectiveDate", "sffv");
        requestParams.put("tierLevel", "wefwefw");
        requestParams.put("serviceNowConnectorEntitlement", "2345");
        requestParams.put("createdBy", "343");
        requestParams.put("numberVideoRecordingUsers", "zxc");
        requestParams.put("partnerContactEmail", "xsd@fds.com");
        requestParams.put("transactionReason", "455");
        requestParams.put("servicePackage", "34345");
        requestParams.put("imageRecognitionEntitlement", "685");
        requestParams.put("salesforceConnectorEntitlement", "987675");
        return requestParams;
    }
    public JSONObject updateFullDataManFieldInValNonManFieldValidVal(String tenantId) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "ascd");
        requestParams.put("numberUsers", 1000);
        requestParams.put("tenantName", getAlphaNumericString(10));
        requestParams.put("resellerOfRecord", getAlphaNumericString(10));
        requestParams.put("disabled", true);
        requestParams.put("createdBy", "Zuora");
        requestParams.put("referralCode", getAlphaNumericString(10));
        requestParams.put("subscriptionTerm", 10);
        requestParams.put("customerStatus", "paying");
        requestParams.put("name", getAlphaNumericString(10));
        requestParams.put("tierLevel", 1000);
        requestParams.put("serviceNowConnectorEntitlement", true);
        requestParams.put("numberVideoRecordingUsers", 0);
        requestParams.put("transactionReason", "purchase");
        requestParams.put("salesforceConnectorEntitlement", true);

        return requestParams;
    }

    public JSONObject updateFullDataManFieldValNonManFieldInValidVal(String tenantId) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId",tenantId);
        requestParams.put("numberUsers", "asd");
        requestParams.put("tenantName", "23");
        requestParams.put("resellerOfRecord","78");
        requestParams.put("disabled", "765");
        requestParams.put("tierLevel", "ert");
        requestParams.put("createdBy", "98798");
        requestParams.put("referralCode", "89");
        requestParams.put("numberVideoRecordingUsers","ytr");
        requestParams.put("subscriptionTerm", "wer");
        requestParams.put("customerStatus", "123");
        requestParams.put("name","234");
        requestParams.put("serviceNowConnectorEntitlement", "2356");
        requestParams.put("transactionReason", "876");
        requestParams.put("salesforceConnectorEntitlement", "233");

        return requestParams;
    }



    public JSONObject updateAIEnabledForTrialPlan(String tenantId) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantId);
        requestParams.put("numberUsers", 1000);
        requestParams.put("tenantName", getAlphaNumericString(10));
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        requestParams.put("aiEnabled", "true");
        requestParams.put("tenantPhysicalAddress", getAlphaNumericString(10));
        requestParams.put("customerCRMID", "1002");
        requestParams.put("resellerOfRecord", getAlphaNumericString(10));
        requestParams.put("customerSuccessManager", getAlphaNumericString(10));
        requestParams.put("disabled", true);
        requestParams.put("isServiceNowCustomer", true);
        requestParams.put("tierLevel", 5000);
        requestParams.put("zQuoteID", getAlphaNumericString(10));
        requestParams.put("createdBy", "Zuora");
        requestParams.put("referralCode", getAlphaNumericString(10));
        requestParams.put("numberVideoRecordingUsers", 20);

        return requestParams;
    }

    public JSONObject updateLessNoOfSubscribersForEnterprise(String tenantId) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantId);
        requestParams.put("numberUsers", 1);
        requestParams.put("tenantName", getAlphaNumericString(10));
        requestParams.put("tenantAdminFirstName", getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName", getAlphaNumericString(10));
        //requestParams.put("aiEnabled", "true");
        requestParams.put("tenantPhysicalAddress", getAlphaNumericString(10));
        requestParams.put("customerCRMID", "1002");
        requestParams.put("resellerOfRecord", getAlphaNumericString(10));
        requestParams.put("customerSuccessManager", getAlphaNumericString(10));
        requestParams.put("disabled", true);
        requestParams.put("isServiceNowCustomer", true);
        requestParams.put("tierLevel", 5000);
        requestParams.put("zQuoteID", getAlphaNumericString(10));
        requestParams.put("createdBy", "Zuora");
        requestParams.put("referralCode", getAlphaNumericString(10));
        requestParams.put("numberVideoRecordingUsers", 20);

        return requestParams;
    }



     public void checkType(String type) {
        assertTrue(("string").equals(type) || ("integer").equals(type) || ("boolean").equals(type),
                "Type " + type + " isn't one of string, integer, boolean. ");
    }

    public void checkField(String tenantId, String field, String value, String type) {
        RestAssured.baseURI = "https://hyperspace.apiv2.carear.app/";
        authtok = login_API();
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + authtok);
        checkType(type);
        if (type.equals("string")) {
            given().headers(headers)
                    .when()
                    .get(FETCH_TENANT + tenantId)
                    .then()
                    .statusCode(HTTP_OK)
                    .body(field, equalTo(value));
        } else if (type.equals("integer")) {
            given().headers(headers)
                    .when()
                    .get(FETCH_TENANT + tenantId)
                    .then()
                    .statusCode(HTTP_OK)
                    .body(field, equalTo(Integer.parseInt(value)));
        } else if (type.equals("boolean")) {
            given().headers(headers)
                    .when()
                    .get(FETCH_TENANT + tenantId)
                    .then()
                    .statusCode(HTTP_OK)
                    .body(field, equalTo(Boolean.parseBoolean(value)));
        }
    }

    public JSONObject updateDataValue(String field, String value, String type) {
        checkType(type);
        JSONObject updateData = new JSONObject();
        if (type.equals("string")) {
            updateData.put(field, value);
        } else if (type.equals("integer")) {
            updateData.put(field, Integer.parseInt(value));
        } else if (type.equals("boolean")) {
            if (value.equals("true") || value.equals("false")) {
                updateData.put(field, Boolean.parseBoolean(value));
            } else {
                updateData.put(field, value);
            }

        }
        return updateData;
    }




    public String createTenantSpecific(JSONObject data, String userName,String region) throws IOException, ParseException {
        RestAssured.baseURI = uriVal(region);
        authtok = login_api(userName, passwordVal(region), region);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + authtok);
        String tenantId = given().headers(headers)
                .body(data.toString())
                .when()
                .post(CREATE_TENANT)
                .then()
                //     .statusCode(HTTP_OK)
                //    .body("message", equalTo(CREATE_SUCCESS_MESSAGE))
                //      .body("error", equalTo(null))
                .extract().path("tenantId");
        idTenantList.add(tenantId);
        return tenantId;


    }
    public JSONObject updatePermission_Data(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("customRole","123");
        requestParams.put("snapshotEnabled","123");
        requestParams.put("recordingEnabled","456");
        return requestParams;
    }

    public JSONObject update_Plugin_statusAsInvalid(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("pluginId","345");
        requestParams.put("pluginStatus","7cv");
        requestParams.put("tenantId",tenantIDVal);
        return requestParams;
    }
    public JSONObject update_Plugin_statusAsEmpty(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("pluginId","");
        requestParams.put("pluginStatus","");
        requestParams.put("tenantId",tenantIDVal);
        return requestParams;
    }






    public JSONObject dataUpdateExperience() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("experienceName", "");

        return requestParams;
    }
    public JSONObject dataUpdateExperienceManAsEmpty() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("experienceName","");

        return requestParams;
    }
    public JSONObject dataUpdateExperienceManNotManEmpty() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("experienceName","");
        requestParams.put("bundleLocation","");
        requestParams.put("experienceDescription","");
        requestParams.put("authenticated","");
        requestParams.put("accessType","");
        requestParams.put("userGroups","");
        return requestParams;
    }
    public JSONObject dataUpdateExperienceManValNonManInvalid() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("experienceName","xecd");
        requestParams.put("bundleLocation","http:asda.as");
        requestParams.put("experienceDescription","24");
        requestParams.put("authenticated","347");
        requestParams.put("accessType","C");
        requestParams.put("userGroups","$");

        return requestParams;
    }
    public JSONObject dataAddExperience() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("experienceName", "experienceNameName"+getAlphaNumericString(10));
        requestParams.put("experienceDescription", getAlphaNumericString(10));
        requestParams.put("qrCode", "");
        requestParams.put("bundleLocation", "http://asda2.asdsd2");
        requestParams.put("authenticated", "false");
        return requestParams;
    }
    public JSONObject dataAddExperienceManAsEmpty() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("experienceName","");
        return requestParams;
    }
    public JSONObject dataAddExperienceManNotManAsEmpty() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("experienceName","");
        requestParams.put("experienceDescription","");
        requestParams.put("authenticated","");
        requestParams.put("accessType","");
        requestParams.put("userGroups","");
        return requestParams;
    }
    public JSONObject dataAddExperienceManValNonManFieldInValidVal() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("experienceName","Test123");
        requestParams.put("experienceDescription","m");
        requestParams.put("authenticated","9676");
        requestParams.put("accessType","98");
        requestParams.put("userGroups","9");
        return requestParams;
    }

    public String createExperienceSpecific(String userName) throws IOException, ParseException {
        //System.out.println("\n*****Create apiTestCases ******\n");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        String region= readProperty("regionVal");

        RestAssured.baseURI = uriValue;
        // login_api(userName, "Testing1",region);
        login_api(userName, passwordVal(region),region);
        JSONObject dataVal = dataFull();
        String tenantId = tenantIDVal(region);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + authtok);
        JSONObject dataAddExperience = dataAddExperience();
        String experienceId= given().headers(headers)
                .body(dataAddExperience.toString())
                .when()
                .post("tenantAdmin/tenants/"+tenantId+"/experiences")
                .then()
                // .body("error", equalTo(null))
                .extract().path("experienceId");
        return experienceId;


    }

    public String deleteExperienceSpecific(String userName,String experienceIDValue) throws IOException, ParseException {
        //System.out.println("\n*****Create apiTestCases ******\n");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        String region= readProperty("regionVal");

        RestAssured.baseURI = uriValue;
        // login_api(userName, "Testing1",region);
        login_api(userName, passwordVal(region),region);
        JSONObject dataVal = dataFull();
        String tenantId = tenantIDVal(region);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + authtok);
        JSONObject dataAddExperience = dataAddExperience();
        String experienceId= given().headers(headers)
                .when()
                .delete("tenantAdmin/tenants/"+tenantId+"/experiences/"+experienceIDValue)
                .then()
                // .body("error", equalTo(null))
                .extract().path("experienceId");
        return experienceId;


    }



    public JSONObject dataAddExperienceid() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("experienceName", "experienceNameName"+getAlphaNumericString(10));
        requestParams.put("experienceDescription", getAlphaNumericString(10));
        requestParams.put("qrCode", "");
        requestParams.put("bundleLocation", "http://asda2.asdsd2");
        requestParams.put("authenticated", "false");
        requestParams.put("guid", getAlphaNumericString(10));
        return requestParams;
    }
    public JSONObject dataTenantsGroups(String tenantIDVal,String userIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("username",userIDVal);
        requestParams.put("deviceToken","123");
        requestParams.put("deviceID","cvx");
        requestParams.put("osType","bnc");
        return requestParams;
    }
    public JSONObject user_Update( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("email", "demo@test.com");
        requestParams.put("secondaryPhoneNumber","+564856133");
        requestParams.put("tenantId", tenantIDVal);
        return requestParams;
    }

    public JSONObject store_Snow_Secret( String tenantIDVal,String regionValue ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("username", "1234");
        requestParams.put("password","12");
        if(regionValue.equalsIgnoreCase("devus"))
        {
            requestParams.put("fqdn","1234");
        }

        return requestParams;
    }
    public JSONObject store_Snow_SecretManAsEmpty( String tenantIDVal,String regionValue ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "");
        requestParams.put("username", "");
        requestParams.put("password","");
        return requestParams;
    }
    public JSONObject store_Snow_SecretManAsInvalid( String tenantIDVal,String regionValue ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", "253677");
        requestParams.put("username", "345");
        requestParams.put("password","89");
        return requestParams;
    }
    public JSONObject secret_Aws_Config( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("bucketAccessKey", "12da");
        requestParams.put("bucketSecretKey","mcv12");
        requestParams.put("awsAccountNumber","duv1");
        requestParams.put("bucketName","1");
        requestParams.put("bucketARN","1w");
        requestParams.put("bucketRegion","rc.v");
        requestParams.put("recordingEnabled","190");
        return requestParams;
    }
    public JSONObject secret_Aws_ConfigManAsEmpty( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","");
        return requestParams;
    }

    public JSONObject secret_Aws_ConfigManNonManAsEmpty( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","");
        requestParams.put("bucketAccessKey","");
        requestParams.put("bucketSecretKey","");
        requestParams.put("awsAccountNumber","");
        requestParams.put("bucketName","");
        requestParams.put("bucketARN","");
        requestParams.put("bucketRegion","");
        requestParams.put("recordingEnabled","");

        return requestParams;
    }
    public JSONObject secret_Aws_ConfigManInvalid( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","3466478");

        return requestParams;
    }

    public JSONObject secret_Aws_ConfigManNonManInvalid( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","3466478");
        requestParams.put("bucketAccessKey","3@#");
        requestParams.put("bucketSecretKey","90*");
        requestParams.put("awsAccountNumber","%w23");
        requestParams.put("bucketName","23");
        requestParams.put("bucketARN","235");
        requestParams.put("bucketRegion","9087");
        requestParams.put("recordingEnabled","908789");

        return requestParams;
    }

    public JSONObject secret_Aws_ConfigManinvalNonManvalid( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","3466478");
        requestParams.put("bucketAccessKey","awsss");
        requestParams.put("bucketSecretKey","awspassword");
        requestParams.put("awsAccountNumber","asd2sum");
        requestParams.put("bucketName","bucketName");
        requestParams.put("bucketARN","bucketarn1");
        requestParams.put("bucketRegion","us-east-1");
        requestParams.put("recordingEnabled",true);

        return requestParams;
    }
    public JSONObject secret_Aws_ConfigManvalNonManinvalid( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId",tenantIDVal);
        requestParams.put("bucketAccessKey","3@#");
        requestParams.put("bucketSecretKey","90*");
        requestParams.put("awsAccountNumber","%w23");
        requestParams.put("bucketName","23");
        requestParams.put("bucketARN","235");
        requestParams.put("bucketRegion","9087");
        requestParams.put("recordingEnabled","908789");

        return requestParams;
    }

    public JSONObject secret_Sfdc_Config( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        /*requestParams.put("bucketAccessKey", "awsss");
        requestParams.put("bucketSecretKey","awspassword");
        requestParams.put("awsAccountNumber","asd2sum");
        requestParams.put("bucketName","bucketName");
        requestParams.put("bucketARN","bucketarn1");
        requestParams.put("bucketRegion","us-east-1");
        requestParams.put("recordingEnabled","true");*/
        requestParams.put("clientId", getAlphaNumericString(1));
        requestParams.put("clientSecret", getAlphaNumericString(1));
        requestParams.put("password", getAlphaNumericString(1));
        requestParams.put("sfdcToken", getAlphaNumericString(1));
        requestParams.put("username", "xcv.vc@xyz.com.xyzxrxd27");
        return requestParams;
    }
    public JSONObject secret_Sfdc_ConfigManEmpty( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","");
        requestParams.put("clientId","");
        requestParams.put("clientSecret","");
        requestParams.put("password", "");
        requestParams.put("sfdcToken", "");
        requestParams.put("username", "");
        return requestParams;
    }
    public JSONObject secret_Sfdc_ConfigManInvalid( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","242456");
        requestParams.put("clientId","1");
        requestParams.put("clientSecret","2");
        requestParams.put("password", "3");
        requestParams.put("sfdcToken", "4");
        requestParams.put("username","xcv.vc@xyz.com.xyzxrxd27");
        return requestParams;
    }

    public JSONObject web_Api( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("apiURL", "sessions/generic_plugin_poc");
        requestParams.put("fqdn","hyperspace.apiv2.carear.app/");
        requestParams.put("iName", "WEBAPI");
        requestParams.put("password", getAlphaNumericString(10));
        requestParams.put("token","7c8e28eb8312aeb6ea2e");
        requestParams.put("username","sunil.pasam@xerox.com");
        return requestParams;
    }
    public JSONObject Save_pluginSystem_Info(String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId",tenantIDVal);
        requestParams.put("username" ,"narayana.n@xerox.com" );
        requestParams.put("password", getAlphaNumericString(10));
        requestParams.put("token", "800f04e552c95a15f656");
        requestParams.put("iName", "EAUT");
        requestParams.put("apiURL", "/apiV2/sessions/generic_plugin_poc");
        requestParams.put("fqdn", "us-central1-carear-hyperspace.cloudfunctions.net");
        return requestParams;
    }  public JSONObject get_Plugin_config(String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId",tenantIDVal);
        requestParams.put("GUID" ,"4757c4e0-4a94-4496-a5a4-1164d13cbe33" );
        requestParams.put("iName","EAUT");

        return requestParams;
    }


    public JSONObject user_Get_Featureform( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("email","gregory.redenshek@xerox.com");
        return requestParams;
    }
    public JSONObject user_Set_Featureform(  String  tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("email","gregory.redenshek@xerox.com");
        requestParams.put("featureTeacher"," \"0\": 2,\n" +
                "        \"1\": 2,\n" +
                "        \"2\": 2,\n" +
                "        \"3\": 1" );
        requestParams.put("user","getFeatureTeacherParms");
        requestParams.put("featureTeacherCompletion","true");

        return requestParams;
    }
    public JSONObject sessions_Fetch(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fromDate", "20/03/2021");
        requestParams.put("toDate", "");
        requestParams.put("type", "assist");

        return requestParams;
    }
    public JSONObject Recording_Start(String tenantIDVal  ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("sessionId","fd98d88b-7a64-4802-b330-146a67bce85d");
        return requestParams;
    }
    public JSONObject dataUpdateUser(String email) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("email", email);
        requestParams.put("secondaryPhoneNumber", "xvc");
        return requestParams;
    }
    public JSONObject dataUpdateUserManAsEmpty(String email) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","");
        return requestParams;
    }
    public JSONObject dataUpdateUserManNonManAsEmpty(String email) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","");
        requestParams.put("userType","");
        requestParams.put("description","");
        requestParams.put("disabled","");
        requestParams.put("secondaryPhoneNumber","");


        return requestParams;
    }
    public JSONObject dataUpdateUserManInvalid(String email) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","Xyz@gmail.com");
        return requestParams;
    }
    public JSONObject dataUpdateUserManNonManInvalid(String email) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","Xyz@gmail.com");
        requestParams.put("userType","456");
        requestParams.put("description","4");
        requestParams.put("disabled","6447");
        requestParams.put("secondaryPhoneNumber","sf");


        return requestParams;
    }
    public JSONObject dataUpdateUserManInvalidNonManvalid(String email) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","Xyz@gmail.com");
        requestParams.put("userType","user");
        requestParams.put("description","dasdc3");
        requestParams.put("disabled",true);
        requestParams.put("secondaryPhoneNumber","+564856133");


        return requestParams;
    }
    public JSONObject dataUpdateUserManvalidNonManinvalid(String email) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email",email);
        requestParams.put("userType","432");
        requestParams.put("description","4");
        requestParams.put("disabled","456");
        requestParams.put("secondaryPhoneNumber","err");


        return requestParams;
    }

    public JSONObject dataUpdateUser1(String email)
    {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("email", email);
        requestParams.put("lastSignInTimePortal", "xxxx/yy/zz");

        return requestParams;
    }
    public JSONObject dataUpdateUser1ManAsEmpty(String email)
    {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","");
        return requestParams;
    }

    public JSONObject dataUpdateUser1ManNonManAsEmpty(String email)
    {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","");
        requestParams.put("userType","");
        requestParams.put("description","");
        requestParams.put("disabled","");
        requestParams.put("lastSignInTimePortal","");
        return requestParams;
    }
    public JSONObject dataUpdateUser1Maninvalid(String email)
    {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","xyz@gmail.com");
        return requestParams;
    }

    public JSONObject dataUpdateUser1ManNonManInvalid(String email)
    {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","xyz@gmail.com");
        requestParams.put("userType","345");
        requestParams.put("description","5");
        requestParams.put("disabled","36");
        requestParams.put("lastSignInTimePortal","6568");
        return requestParams;
    }
    public JSONObject dataUpdateUser1ManInvalidNonManvalid(String email)
    {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = formatter.format(date);
        requestParams.put("email","xyz@gmail.com");
        requestParams.put("userType","user");
        requestParams.put("description","dsar");
        requestParams.put("disabled",true);
        requestParams.put("lastSignInTimePortal",date1);
        return requestParams;
    }

    public JSONObject dataUpdateUser1ManvalidNonManinvalid(String email)
    {
        JSONObject requestParams = new JSONObject();
        requestParams.put("email",email);
        requestParams.put("userType","432");
        requestParams.put("description","5");
        requestParams.put("disabled","456");
        requestParams.put("lastSignInTimePortal","6534");
        return requestParams;
    }



    public JSONObject save_Instruct_Exp( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("id","UlGqpY0hPmUku01iAKde");
        requestParams.put("title","fgh");
        requestParams.put("description","");
        requestParams.put("pages","{}");
        requestParams.put("edges","[]");
        return requestParams;
    }

    public JSONObject login( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("email","vimal@carear.io");
        requestParams.put("password","Testing1");
        return requestParams;
    }


    public JSONObject auth_refresh(  String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);

        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("aiEnabled",false);
        requestParams1.put("workspaceId","");
        requestParams1.put("arServiceId","");
        requestParams1.put("intelligentServiceId","");

        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("message","apiTestCases Updated Successfully");
        requestParams2.put("updatedFields",requestParams1);
        requestParams2.put("error","null");

        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("refreshToken",requestParams2);
        return requestParams;






    }

    public JSONObject download_Save( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","xyzd");
        requestParams.put("index","x");
        requestParams.put("logoURL","cvd");
        requestParams.put("name","234");
        requestParams.put("platformType","2");
        requestParams.put("versionNumber","ghjk");
        return requestParams;
    }
    public JSONObject download_SaveManEmpty( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","");
        requestParams.put("logoURL","");
        requestParams.put("name","");
        requestParams.put("platformType","");
        requestParams.put("versionNumber","");
        return requestParams;
    }
    public JSONObject download_SaveManNonManEmpty( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","");
        requestParams.put("logoURL","");
        requestParams.put("name","");
        requestParams.put("platformType","");
        requestParams.put("versionNumber","");
        requestParams.put("disabled","");
        return requestParams;
    }
    public JSONObject download_Savemaninvalid( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","*");
        requestParams.put("logoURL","c23");
        requestParams.put("name","4");
        requestParams.put("platformType","8");
        requestParams.put("versionNumber","h");
        return requestParams;
    }
    public JSONObject download_update( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","vgp");
        requestParams.put("index","vb");
        requestParams.put("logoURL","c23");
        requestParams.put("name","456");
        requestParams.put("platformType","890");
        requestParams.put("versionNumber","hjkl");
        requestParams.put("disabled","56");
        return requestParams;
    }
    public JSONObject download_updateManInvalid( String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantIDVal);
        return requestParams;
    }
    public JSONObject download_updateManNonManInvalid( String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","vgp");
        requestParams.put("logoURL","c23");
        requestParams.put("name","456");
        requestParams.put("platformType","890");
        requestParams.put("versionNumber","hjkl");
        requestParams.put("disabled","56");
        return requestParams;
    }
    public JSONObject download_updateManInvalidNonManvalid( String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","https://firebasestorage.googleapis.com/v0/b/carear-development.appspot.com/o/download_software%2Fen-common-src.zip?alt=media&token=050e3017-7024-4708-ac41-e689765c8643");
        requestParams.put("logoURL","https://firebasestorage.googleapis.com/v0/b/carear-development.appspot.com/o/download_software_logos%2F4k.jpg?alt=media&token=bc1a862b-bebf-47ac-8ba1-9d7407cd1268");
        requestParams.put("name","Google Play");
        requestParams.put("platformType","GooglePlay1");
        requestParams.put("versionNumber","1234");
        requestParams.put("disabled",false);
        return requestParams;
    }
    public JSONObject download_updateManvalidNonManinvalid( String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","vgp");
        requestParams.put("logoURL","c23");
        requestParams.put("name","456");
        requestParams.put("platformType","890");
        requestParams.put("versionNumber","hjkl");
        requestParams.put("disabled","56");
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForums(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("a","v");
        requestParams1.put("b","c");
        requestParams1.put("c","c");
        requestParams1.put("d","n");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("email",emailIDVal);
        requestParams.put("featureTeacher",requestParams1);
        requestParams.put("featureTeacherCompletion","123");
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForumsManEmpty(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("0","");
        requestParams1.put("1","");
        requestParams1.put("2","");
        requestParams1.put("3","");
        requestParams.put("email","");
        requestParams.put("featureTeacher",requestParams1);
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForumsManNonManEmpty(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("0","");
        requestParams1.put("1","");
        requestParams1.put("2","");
        requestParams1.put("3","");
        requestParams.put("email","");
        requestParams.put("featureTeacher",requestParams1);
        requestParams.put("featureTeacherCompletion","");
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForumsManInvalid(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("0","c");
        requestParams1.put("1","p");
        requestParams1.put("2","d");
        requestParams1.put("3","x");
        requestParams.put("email","xyz@gmail.com");
        requestParams.put("featureTeacher",requestParams1);
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForumsManNonManInvalid(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("0","c");
        requestParams1.put("1","p");
        requestParams1.put("2","d");
        requestParams1.put("3","x");
        requestParams.put("email","xyz@gmail.com");
        requestParams.put("featureTeacher",requestParams1);
        requestParams.put("featureTeacherCompletion","123");
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForumsManInvalidNonManvalid(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("0","c");
        requestParams1.put("1","p");
        requestParams1.put("2","d");
        requestParams1.put("3","x");
        requestParams.put("email","xyz@gmail.com");
        requestParams.put("featureTeacher",requestParams1);
        requestParams.put("featureTeacherCompletion",true);
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForumsManvalidNonManInvalid(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("0",2);
        requestParams1.put("1",2);
        requestParams1.put("2",2);
        requestParams1.put("3",1);
        requestParams.put("email",emailIDVal);
        requestParams.put("featureTeacher",requestParams1);
        requestParams.put("featureTeacherCompletion","234");
        return requestParams;
    }


    public JSONObject dataSessionsGuestNonManInValid(String tenantIDVal){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date1 = formatter.format(date);
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId","34590");
        requestParams.put("email","xyz@gmail.com");
        requestParams.put("fromDate","xxxx/yy/zz");
        requestParams.put("toDate","xxxx/yy/zz");
        requestParams.put("type","1232");
        return requestParams;
    }
    public JSONObject dataSessionsGuestNonManEmpty(String tenantIDVal){
        JSONObject requestParams = new JSONObject();
        requestParams.put("email","");
        requestParams.put("tenantId","");
        requestParams.put("fromDate","");
        requestParams.put("toDate","");
        requestParams.put("type","");
        return requestParams;
    }
    public JSONObject dataAuthRefresh( String refreshTokVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("refreshToken", "2345xyz");
        return requestParams;
    }
    public JSONObject dataAuthRefreshManInvalid( String refreshTokVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("refreshToken", "114455");
        return requestParams;
    }
    public JSONObject dataAuthRefreshManEmpty( String refreshTokVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("refreshToken", "");
        return requestParams;
    }

    public JSONObject dataSaveInstructExp( String tenantIDVal,String expIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("id",expIDVal);
        requestParams.put("title","1");
        requestParams.put("description","");
        requestParams.put("pages","");
        requestParams.putOpt("edges","");
        requestParams.putOpt("navigationNodes","");
        return requestParams;
    }
    public JSONObject dataSaveInstructExpManAsEmpty( String tenantIDVal,String expIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id","");
        requestParams.put("title","");
        requestParams.put("pages","");
        requestParams.putOpt("edges","");
        requestParams.put("version","");
        requestParams.put("languageCode","");
        requestParams.put("languageCodeList","");
        return requestParams;
    }
    public JSONObject dataSaveInstructExpManNonManEmpty( String tenantIDVal,String expIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id","");
        requestParams.put("title","");
        requestParams.put("pages","");
        requestParams.putOpt("edges","");
        requestParams.put("version","");
        requestParams.put("languageCode","");
        requestParams.put("languageCodeList","");
        requestParams.put("tenantId","");
        requestParams.put("navigationNodes","");
        requestParams.put("enableSearch","");
        requestParams.put("searchIndex","");
        requestParams.put("description","");
        requestParams.put("mobileAppEnabled","");
        requestParams.put("webBrowserEnabled","");
        return requestParams;
    }

    public JSONObject dataSaveInstructExpManAsInvalid( String tenantIDVal,String expIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id","987");
        requestParams.put("title","9");
        requestParams.put("pages","e");
        requestParams.putOpt("edges","x");
        requestParams.put("version","3");
        requestParams.put("languageCode","4");
        requestParams.put("languageCodeList","p");
        return requestParams;
    }
    public JSONObject dataSaveInstructExpManNonManInvalid( String tenantIDVal,String expIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id","987");
        requestParams.put("title","9");
        requestParams.put("pages","e");
        requestParams.putOpt("edges","x");
        requestParams.put("version","3");
        requestParams.put("languageCode","4");
        requestParams.put("languageCodeList","p");
        requestParams.put("tenantId","n7");
        requestParams.put("navigationNodes","#");
        requestParams.put("enableSearch","ki");
        requestParams.put("searchIndex","ds");
        requestParams.put("description","678");
        requestParams.put("mobileAppEnabled","7");
        requestParams.put("webBrowserEnabled","kl");
        return requestParams;
    }
    public JSONObject dataSaveInstructExpManinvalNonManvalid( String tenantIDVal,String expIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id","987");
        requestParams.put("title","9");
        requestParams.put("pages","e");
        requestParams.putOpt("edges","x");
        requestParams.put("version","3");
        requestParams.put("languageCode","4");
        requestParams.put("languageCodeList","p");
        requestParams.put("tenantId",tenantIDVal);
        requestParams.put("navigationNodes","[]");
        requestParams.put("enableSearch",false);
        requestParams.put("description","ExpChines desc for de");
        requestParams.put("mobileAppEnabled",false);
        requestParams.put("webBrowserEnabled",false);
        return requestParams;
    }

    public JSONObject dataSaveInstructExpManValidNonManInvalid( String tenantIDVal,String expIDVal ) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("id",expIDVal);
        requestParams.put("title","fgh");
        requestParams.put("pages","{}");
        requestParams.putOpt("edges","[]");
        requestParams.put("version","v1");
        requestParams.put("languageCode","de");
        requestParams.put("tenantId","n7");
        requestParams.put("navigationNodes","#");
        requestParams.put("enableSearch","ki");
        requestParams.put("searchIndex","ds");
        requestParams.put("description","678");
        requestParams.put("mobileAppEnabled","7");
        requestParams.put("webBrowserEnabled","kl");
        return requestParams;
    }
    public JSONObject dataAuthGetScore( String tokVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("token", "wedc1");
        return requestParams;
    }
    public JSONObject dataAuthGetScoreEmpty( String tokVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("token", tokVal);
        return requestParams;
    }
    public JSONObject datasaveKPI(String tenantID) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date1 = formatter.format(date);
        requestParams.put("tenantId", tenantID);
        requestParams.put("index", "1");
        requestParams.put("label", "Rate the experience 3");
        requestParams.put("predefined_data", "");
        requestParams.put("required", true);
        requestParams.put("status", true);
        requestParams.put("type", "singleline");
        requestParams.put("userType", "host");



        return requestParams;
    }

    public  void createSurvey(String regionVal,String tenantIDVal) throws IOException, ParseException {
        RestAssured.baseURI = uriVal(regionVal);
        String authtok = login_api(getUserIdValue("5",regionVal),passwordVal(regionVal), regionVal);
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "application/json");
        headers1.put("Authorization", "Bearer " + authtok);
        JSONObject dataSaveKPI = datasaveKPI(tenantIDVal);
        given().headers(headers1)
                .body(dataSaveKPI.toString())
                .when()
                .post("tenantAdmin/tenant/saveKPI");
    }

    public String surveyIDVal(String regionVal,String tenantIDVal) throws IOException, ParseException {
        RestAssured.baseURI = uriVal(regionVal);
        String authtok = login_api(getUserIdValue("5",regionVal),passwordVal(regionVal), regionVal);
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "application/json");
        headers1.put("Authorization", "Bearer " + authtok);
        Response responseVal=given().headers(headers1)
                .when()
                .get("tenantAdmin/tenant/"+tenantIDVal+"/fetchBuilderKPI");
        String surveyIDValue = responseVal.jsonPath().getString("survey.id[0]");
        return surveyIDValue;
    }
}
