package org.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.codemodel.JTryBlock;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class variablesAndDataMethods extends commonMethods {

    public JSONObject dataAdd_Group(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);

        requestParams.put("group", getAlphaNumericString(10));
        requestParams.put("tenantId", tenantIDVal);

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

        requestParams.put("newGroup", getAlphaNumericString(10));
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

    public JSONObject dataSaveNotifications(String userIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);

        JSONObject requestParams1= new JSONObject();
        requestParams1.put("reminderOne", 500);
        requestParams1.put("reminderTwo", 340);
        requestParams1.put("reminderThree",330);
        requestParams1.put("reminderFour", 0);

        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("sessions",requestParams1);

        JSONObject requestParams3 = new JSONObject();
        requestParams3.put("reminderOne", 80);
        requestParams3.put("reminderTwo", 60);
        requestParams3.put("reminderThree",0);
        requestParams3.put("reminderFour", 0);

        JSONObject requestParams5 = new JSONObject();
        requestParams5.put("reminderOne", 550);
        requestParams5.put("reminderTwo", 400);
        requestParams5.put("reminderThree",0);
        requestParams5.put("reminderFour", 0);

        JSONObject requestParams6 = new JSONObject();
        requestParams6.put("minutes",requestParams5);
        requestParams6.put("sessions",requestParams3);

        JSONObject requestParams7 = new JSONObject();
        requestParams7.put("assist",requestParams6);
        requestParams7.put("instruct",requestParams2);
        JSONArray emailList = new JSONArray();
        emailList.put(userIDVal);
        // requestParams.put("tenantId", tenantIDVal);
        requestParams.put( "emailNotificationList",emailList);
        requestParams.put("notificationSettings",requestParams7);

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
            requestParams.put("aiDNS", "gateway-demo.eu.qa");
            requestParams.put("userName", "ai.platform.carear.dev+eudemo@gmail.com");
            requestParams.put("password", "Carear@1234");
        }
        else if(regionval.equalsIgnoreCase("devca")) {
            requestParams.put("aiDNS", "gateway-demo.ca.qa");
            requestParams.put("userName", "ai.platform.carear.dev+cademo@gmail.com");
            requestParams.put("password", "Carear@1234");
        }else if (regionval.equalsIgnoreCase("hypus")){

            requestParams.put("aiDNS", "app");
            requestParams.put("userName", "fritzebner+hyperspace@gmail.com");
            requestParams.put("password", "uzx_HTB1qjg4njp8nby");

        }else if (regionval.equalsIgnoreCase("hypeu")){

            requestParams.put("aiDNS", "gateway-demo.eu.qa");
            requestParams.put("userName", "ai.platform.carear+eudemo@gmail.com");
            requestParams.put("password", "SBWS@carear123");

        }else if (regionval.equalsIgnoreCase("hypca")){

            requestParams.put("aiDNS", "gateway-demo.ca.qa");
            requestParams.put("userName", "ai.platform.carear+cademo@gmail.com");
            requestParams.put("password", "SBWS@carear123");
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
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date1 = formatter.format(date);
        // requestParams.put("tenantId", "0rPB6Jpqzq4OFVFN5crD");
        requestParams.put("tenantId", tenantID);
        requestParams.put("fromDate", "2022/06/21");
        requestParams.put("toDate", date1);


        return requestParams;
    }

    public JSONObject dataSavePlugin(String tenantID,String userNameVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("apiURL","Test");
        requestParams.put("fqdn",getAlphaNumericString(10));
        requestParams.put("iName", "WEBAPI");
        requestParams.put("tenantId", tenantID);
        requestParams.put("username", userNameVal);
        requestParams.put("password", "Testing1");
        requestParams.put("token", "67b1288ff225adbab24e");
        return requestParams;
    }

    public JSONObject dataActivateUser(String userIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("uid",userIDVal);

        return requestParams;
    }

    public JSONObject dataFull() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("aiEnabled", true);
        requestParams.put("assistUsageType", "user");
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
        requestParams.put("instructSessionsPurchased", 100);
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
    }


    public JSONObject dataFlexFull() throws IOException {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("aiEnabled",true);
        requestParams.put("assistUsageType","user");
        requestParams.put("azAppId","");
        requestParams.put("azAppSecret","");
        requestParams.put("azTenantId","");
        requestParams.put("contractEffectiveDate",date1);
        requestParams.put("createdBy","Manual");
        requestParams.put("customerCRMID","");
        requestParams.put("customerPlan","platform");
        requestParams.put("customerStatus","paying");
        requestParams.put("customerSuccessManager","");
        requestParams.put("disabled",false);
        requestParams.put("expiryDate","{seconds: 1688927399, nanoseconds: 999000000}");
            requestParams.put("gcpTenantId","");
requestParams.put("imageRecognitionEntitlement",false);
requestParams.put("instructSessionsPurchased","100");
requestParams.put("joinDate","{seconds: 1673244029, nanoseconds: 763000000}");
        requestParams.put("numberUsers","100");
        requestParams.put("numberVideoRecordingUsers","0");
        requestParams.put("referralCode","");
        requestParams.put("resellerOfRecord","");
        requestParams.put("salesforceConnectorEntitlement",false);
        requestParams.put("serviceNowConnectorEntitlement",false);
        requestParams.put("servicePackage","Flex");
        requestParams.put("subscriptionTerm","12");
        requestParams.put("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
        requestParams.put("tenantAdminFirstName",getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName",getAlphaNumericString(10));
        requestParams.put("tenantName","Tcs");
        requestParams.put("tenantPhysicalAddress","");
        requestParams.put("tierLevel","1000");
        requestParams.put("transactionReason","purchase");
        requestParams.put("zQuoteID","");
        return  requestParams;
    }

    public JSONObject dataProFull() throws IOException {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("aiEnabled",true);
        requestParams.put("assistUsageType","user");
        requestParams.put("azAppId","");
        requestParams.put("azAppSecret","");
        requestParams.put("azTenantId","");
        requestParams.put("contractEffectiveDate",date1);
        requestParams.put("createdBy","Manual");
        requestParams.put("customerCRMID","");
        requestParams.put("customerPlan","platform");
        requestParams.put("customerStatus","paying");
        requestParams.put("customerSuccessManager","");
        requestParams.put("disabled",false);
        requestParams.put("expiryDate","{seconds: 1688927399, nanoseconds: 999000000}");
        requestParams.put("gcpTenantId","");
        requestParams.put("imageRecognitionEntitlement",false);
        requestParams.put("instructSessionsPurchased","100");
        requestParams.put("joinDate","{seconds: 1673244029, nanoseconds: 763000000}");
        requestParams.put("numberUsers","100");
        requestParams.put("numberVideoRecordingUsers","0");
        requestParams.put("referralCode","");
        requestParams.put("resellerOfRecord","");
        requestParams.put("salesforceConnectorEntitlement",false);
        requestParams.put("serviceNowConnectorEntitlement",false);
        requestParams.put("servicePackage","Pro");
        requestParams.put("subscriptionTerm","12");
        requestParams.put("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
        requestParams.put("tenantAdminFirstName",getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName",getAlphaNumericString(10));
        requestParams.put("tenantName","Tcs");
        requestParams.put("tenantPhysicalAddress","");
        requestParams.put("tierLevel","1000");
        requestParams.put("transactionReason","purchase");
        requestParams.put("zQuoteID","");
        return  requestParams;
    }

    public JSONObject dataPremiumFull() throws IOException {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("aiEnabled",true);
        requestParams.put("assistUsageType","user");
        requestParams.put("azAppId","");
        requestParams.put("azAppSecret","");
        requestParams.put("azTenantId","");
        requestParams.put("contractEffectiveDate",date1);
        requestParams.put("createdBy","Manual");
        requestParams.put("customerCRMID","");
        requestParams.put("customerPlan","platform");
        requestParams.put("customerStatus","paying");
        requestParams.put("customerSuccessManager","");
        requestParams.put("disabled",false);
        requestParams.put("expiryDate","{seconds: 1688927399, nanoseconds: 999000000}");
        requestParams.put("gcpTenantId","");
        requestParams.put("imageRecognitionEntitlement",false);
        requestParams.put("instructSessionsPurchased","100");
        requestParams.put("joinDate","{seconds: 1673244029, nanoseconds: 763000000}");
        requestParams.put("numberUsers","100");
        requestParams.put("numberVideoRecordingUsers","0");
        requestParams.put("referralCode","");
        requestParams.put("resellerOfRecord","");
        requestParams.put("salesforceConnectorEntitlement",false);
        requestParams.put("serviceNowConnectorEntitlement",false);
        requestParams.put("servicePackage","Premium");
        requestParams.put("subscriptionTerm","12");
        requestParams.put("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
        requestParams.put("tenantAdminFirstName",getAlphaNumericString(10));
        requestParams.put("tenantAdminLastName",getAlphaNumericString(10));
        requestParams.put("tenantName","Tcs");
        requestParams.put("tenantPhysicalAddress","");
        requestParams.put("tierLevel","1000");
        requestParams.put("transactionReason","purchase");
        requestParams.put("zQuoteID","");
        return  requestParams;
    }

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


    public JSONObject updateFullData(String tenantId) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId", tenantId);
        requestParams.put("numberUsers", 1000);
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


    public JSONObject updatePermission_Data(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("customRole","false");
        requestParams.put("snapshotEnabled","false");
        requestParams.put("recordingEnabled","false");
        return requestParams;
    }

    public JSONObject update_Plugin_status(String tenantIDVal) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("pluginId","AWS");
        requestParams.put("pluginStatus",false);
        requestParams.put("tenantId",tenantIDVal);
        return requestParams;
    }






    public JSONObject dataUpdateExperience() {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("experienceName", getAlphaNumericString(10));

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
        requestParams.put("qrCode", "https://firebasestorage.googleapis.com/v0/b/carear-emea-dev.appspot.com/o/qrcode%2F02YQ6pnBCc9c9sxJOlYN%2FAc6issvZMAOqVLXSjmpR.png?alt=media&token=e3ae3dda-1c09-48f0-bf3a-f4bb8fec902b");
        requestParams.put("bundleLocation", "");
        requestParams.put("authenticated", "false");
        return requestParams;
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
        requestParams.put("deviceToken","");
        requestParams.put("deviceID","");
        requestParams.put("osType","");
        return requestParams;
    }


    public JSONObject store_Snow_Secret( String tenantIDVal,String regionValue ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("username", "snowussername");
        requestParams.put("password","password");
        if(regionValue.equalsIgnoreCase("devus"))
        {
            requestParams.put("fqdn","us-central1-carear-dev.cloudfunctions.net");
        }

        return requestParams;
    }
    public JSONObject secret_Aws_Config( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        //System.out.println(date1);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("bucketAccessKey", "awsss");
        requestParams.put("bucketSecretKey","awspassword");
        requestParams.put("awsAccountNumber","asd2sum");
        requestParams.put("bucketName","bucketName");
        requestParams.put("bucketARN","bucketarn1");
        requestParams.put("bucketRegion","us-east-1");
        requestParams.put("recordingEnabled","true");
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
        requestParams.put("clientId", getAlphaNumericString(10));
        requestParams.put("clientSecret", getAlphaNumericString(10));
        requestParams.put("password", getAlphaNumericString(10));
        requestParams.put("sfdcToken", getAlphaNumericString(10));
        requestParams.put("username", "niteshnavnath.mishra@hcl.com.hclxrxd27");
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
        requestParams.put("secondaryPhoneNumber", "+564856133");
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
        requestParams.put("lastSignInTimePortal", date1);

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

    public JSONObject download_Save( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","https://firebasestorage.googleapis.com/v0/b/carear-development.appspot.com/o/download_software%2Fen-common-src.zip?alt=media&token=050e3017-7024-4708-ac41-e689765c8643");
        requestParams.put("index",100);
        requestParams.put("logoURL","https://firebasestorage.googleapis.com/v0/b/carear-development.appspot.com/o/download_software_logos%2F4k.jpg?alt=media&token=bc1a862b-bebf-47ac-8ba1-9d7407cd1268");
        requestParams.put("name","Google Play");
        requestParams.put("platformType","GooglePlay1");
        requestParams.put("versionNumber","1234");
        return requestParams;
    }
    public JSONObject download_update( String tenantIDVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("tenantId", tenantIDVal);
        requestParams.put("fileLocation","https://firebasestorage.googleapis.com/v0/b/carear-development.appspot.com/o/download_software%2Fen-common-src.zip?alt=media&token=050e3017-7024-4708-ac41-e689765c8643");
        requestParams.put("index",Math.random());
        requestParams.put("logoURL","https://firebasestorage.googleapis.com/v0/b/carear-development.appspot.com/o/download_software_logos%2F4k.jpg?alt=media&token=bc1a862b-bebf-47ac-8ba1-9d7407cd1268");
        requestParams.put("name","Google Play");
        requestParams.put("platformType","GooglePlay1");
        requestParams.put("versionNumber","1234");
        requestParams.put("disabled",false);
        return requestParams;
    }
    public JSONObject dataUserSetTeacherForums(String  emailIDVal ) {
        JSONObject requestParams = new JSONObject();
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("0",2);
        requestParams1.put("1",2);
        requestParams1.put("2",2);
        requestParams1.put("3",1);
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("email",emailIDVal);
        requestParams.put("featureTeacher",requestParams1);
        requestParams.put("featureTeacherCompletion",true);
        return requestParams;
    }
    public JSONObject dataSessionsGuest(String tenantIDVal){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date1 = formatter.format(date);
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId",tenantIDVal);
        requestParams.put("fromDate","2021/03/20");
        requestParams.put("toDate",date1);
        requestParams.put("type","assist");
        return requestParams;
    }
    public JSONObject dataAuthRefresh( String refreshTokVal ) {
        JSONObject requestParams = new JSONObject();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        requestParams.put("refreshToken", refreshTokVal);
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
        requestParams.put("title","fgh");
       // requestParams.put("description","");
        requestParams.put("description","ExpChines desc for de");
        requestParams.put("languageCode","de");
        requestParams.put("version","v1");
        requestParams.put("pages","{}");
        requestParams.putOpt("edges","[]");
        requestParams.putOpt("navigationNodes","[]");

        return requestParams;
    }
    public JSONObject dataAuthGetScore( String tokVal ) {
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
    public static JSONArray tn(  String tar1) {
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(0, tar1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray ;
    }
    public JSONObject gooogleTranslation(String tenantid) {
        JSONObject requestParams = new JSONObject();
         requestParams.put("sourceLangCode","en");
         requestParams.put("targetLangCode","es");
         requestParams.put("inputText",tn("Demo text for translation"));
         requestParams.put("tenantId",tenantid);

        return requestParams;
    }
    public JSONObject copyStorageData(String tenantid,String expid) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId",tenantid);
        requestParams.put("experienceId",expid);
        requestParams.put("version","v1");
        requestParams.put("fromLanguageCode","en");
        requestParams.put("toLanguageCode","fr");
        //requestParams.put("filesToCopy","[{\"path\":\"/video/2021 XEROX CareAR _ B405 _ 3 _ MAC DRIVER SETUP _ 1080.mp4\"}]");
        requestParams.put("filesToCopy",tn("{\"path\":\"/video/2021 XEROX CareAR _ B405 _ 3 _ MAC DRIVER SETUP _ 1080.mp4\"}"));
        return requestParams;
    }
    public JSONObject DefaultLangUpdate(String tenantid,String expid) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("tenantId",tenantid);
        requestParams.put("experienceId",expid);
        requestParams.put("version","v1");
        requestParams.put("languageCode","en");
         return requestParams;
    }


    public  void createSurvey(String regionVal,String tenantIDVal) throws IOException, ParseException {
        RestAssured.baseURI = uriVal(regionVal);
        String authtok = login_api(getUserIdValue("5",regionVal),passwordVal(regionVal), regionVal);
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "application/json");
        headers1.put("Authorization", "Bearer " + authtok);
        JSONObject dataSaveKPI = datasaveKPI(tenantIDVal);
        Response re=given().headers(headers1)
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
