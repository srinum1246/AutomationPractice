package org.tests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;

public class apiTestCasesDataValidation extends commonMethods {
public String apiEndPointValue;
    public apiTestCasesDataValidation() throws IOException {
    }
    public variablesAndDataMethods vd =new variablesAndDataMethods();
    @Test(priority = 1)
    public void createTenantAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b>'"+uriValue+"/"+CREATE_TENANT+"</b>***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                test.info("***<b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b>*** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("createPlatformTypeTenant.properties");
                setPropertyVal("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
                JSONObject data = getJsonObjectVal();

                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                if(responseVal.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+getInputKeyValInOP(responseVal,"tenantId");
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
                //delete created tenant instantly
                String tenantIDValue = responseVal.then().extract().path("tenantId");
                String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
                Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);


            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 2)
    public void createTenantCoreAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+CREATE_TENANT+"</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                test.info("***<b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b>*** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("createCoreTypeTenant.properties");
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                String date1 = formatter.format(date);
                setPropertyVal("contractEffectiveDate",date1);
                setPropertyVal("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
                //setPropertyVal("tenantAdminEmail","mohammednizhar.p+71@carear.com");
                setPropertyVal("tenantAdminFirstName",getAlphaNumericString(10));
                setPropertyVal("tenantAdminLastName",getAlphaNumericString(10));
                JSONObject data = getJsonObjectVal();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                if(responseVal.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+getInputKeyValInOP(responseVal,"tenantId");
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
                //delete created tenant instantly
                String tenantIDValue = responseVal.then().extract().path("tenantId");
                String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
                Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);

            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 3)
    public void createTenantEnterpriseAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+CREATE_TENANT+" </b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b>***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                test.info("***<b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b>*** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("createEnterpriseTypeTenant.properties");
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                String date1 = formatter.format(date);
                setPropertyVal("contractEffectiveDate",date1);
                setPropertyVal("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
               // setPropertyVal("tenantAdminEmail","mohammednizhar.p+75@carear.com");
                setPropertyVal("tenantAdminFirstName",getAlphaNumericString(10));
                setPropertyVal("tenantAdminLastName",getAlphaNumericString(10));
                JSONObject data = getJsonObjectVal();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                if(responseVal.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+getInputKeyValInOP(responseVal,"tenantId");
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
                //delete created tenant instantly
                String tenantIDValue = responseVal.then().extract().path("tenantId");
                String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
                Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);

            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 4)
    public void createTenantTrialAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+CREATE_TENANT+" </b>***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b>***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                test.info("***<b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("createTrialTypeTenant.properties");
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                String date1 = formatter.format(date);
                setPropertyVal("contractEffectiveDate",date1);
                setPropertyVal("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
                //setPropertyVal("tenantAdminEmail","mohammednizhar.p+76@carear.com");
                setPropertyVal("tenantAdminFirstName",getAlphaNumericString(10));
                setPropertyVal("tenantAdminLastName",getAlphaNumericString(10));
                JSONObject data = getJsonObjectVal();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                if(responseVal.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+getInputKeyValInOP(responseVal,"tenantId");
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
                //delete created tenant instantly
                String tenantIDValue = responseVal.then().extract().path("tenantId");
                String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
                Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);

            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 5)
    public void createTenantPlatformWithFlexAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI  <b>'"+uriValue+"/"+CREATE_TENANT+" </b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data = vd.dataFlexFull();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                //log(Integer.toString(responseVal.statusCode()));
               // log(responseVal.asString());
                if(responseVal.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+getInputKeyValInOP(responseVal,"tenantId");
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
                //delete created tenant instantly
                String tenantIDValue = responseVal.then().extract().path("tenantId");
                String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
                Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);

            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 6)
    public void createTenantPlatformWithProAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+CREATE_TENANT+"</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b>*** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data = vd.dataProFull();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                if(responseVal.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+getInputKeyValInOP(responseVal,"tenantId");
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
                //delete created tenant instantly
                String tenantIDValue = responseVal.then().extract().path("tenantId");
                String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
                Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);

            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 7)
    public void createTenantPlatformWithPremiumAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b> '"+uriValue+"/"+CREATE_TENANT+"</b>***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b>***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                test.info("***<b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b>*** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data = vd.dataPremiumFull();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                if(responseVal.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+getInputKeyValInOP(responseVal,"tenantId");
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
                //delete created tenant instantly
                String tenantIDValue = responseVal.then().extract().path("tenantId");
                String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
                Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);

            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 8)
    public void updateTenantAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b> '"+uriValue+"/"+UPDATE_TENANT+"'</b>***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b>*****");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId=createTenantFromProp(getUserIdValue(usersForTesting.get(i).toString(), region),passwordVal(region),region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("updateTenant.properties");
                setPropertyVal("tenantId",tenantId);
                JSONObject data=getJsonObjectVal();
                Response responseVal1 = commonPutMethod(authtok, data,UPDATE_TENANT);
                if(responseVal1.statusCode()==200) {
                    String apiEndPointVal=FETCH_TENANT+tenantId;
                    Response responseVal2 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 9)
    public void tenantmanagementSaveAiServicesConfigUpdateAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b> '"+uriValue+"/"+SAVE_AISERVICE_CONFIG_UPDA+"' </b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b>*****");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b>**** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("saveAiServicesConfig.properties");
                if(region.equalsIgnoreCase("devus")) {
                    setPropertyVal("aiDNS", "gateway-demo.qa");
                    setPropertyVal("userName", "ai.platform.carear.dev+usdemo@gmail.com");
                }else if(region.equalsIgnoreCase("deveu")) {
                    setPropertyVal("aiDNS", "gateway-demo.eu.qa");
                    setPropertyVal("userName", "ai.platform.carear.dev+eudemo@gmail.com");
                }else if(region.equalsIgnoreCase("devca")) {
                    setPropertyVal("aiDNS", "gateway-demo.ca.qa");
                    setPropertyVal("userName", "ai.platform.carear.dev+cademo@gmail.com");
                }
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, SAVE_AISERVICE_CONFIG_UPDA);
                if (responseVal.statusCode()==200){
                    String apiEndPointVal= "";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 10)
    public void tenantAdminAddGroupAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+ADD_GROUP+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b>*****");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("addGroup.properties");
                setPropertyVal("group",getAlphaNumericString(10));
                setPropertyVal("tenantId",tenantId);
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, ADD_GROUP);
                 if(responseVal.statusCode()==200){
                     String apiEndPointVal= "";
                     Response responseVal1 = commonGetMethod(authtok, apiEndPointVal);
                     String keysToSearch="";
                     verifyTheOutputData(responseVal1,keysToSearch,data);

                }

            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 11)
    public void tenantAdminUpdateGroupAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b> '"+uriValue+"/"+UPDATE_GROUP+"' </b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
          if (flagVal.equalsIgnoreCase("Allowed")) {
              test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("addGroup.properties");
                setPropertyVal("group",getAlphaNumericString(10));
                setPropertyVal("tenantId",tenantId);
                JSONObject data=getJsonObjectVal();
                commonPostMethod(authtok, data, ADD_GROUP);
                String oldGrpName = data.get("group").toString();
                setDataPropFilePath("updateGroup.properties");
                setPropertyVal("newGroup",getAlphaNumericString(10));
                setPropertyVal("oldGroup",oldGrpName);
                setPropertyVal("tenantId",tenantId);
                JSONObject data1=getJsonObjectVal();
                Response responseVal = commonPutMethod(authtok, data1, UPDATE_GROUP);
                if(responseVal.statusCode()==200){
                    String apiEndPointVal="";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 12)
    public void tenantAdminSaveNotificationsAPI() throws IOException,ParseException{
        test.info("*** Testing API URI <b>'"+uriValue+"/"+TENANTID_SAVE_NOTIFICATION+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                RestAssured.baseURI = uriValue;
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                headers = headersVal(authtok);
                JSONObject dataSaveNotifications = getJsonObjectVal();
                String apiEndPointVal="tenantAdmin/tenants/" + tenantId + "/saveNotificationSettings";
                Response responseVal = commonPostMethod(authtok, dataSaveNotifications,apiEndPointVal );
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/saveNotificationSettings";
                requestTypeVal = "POST";
                payLoadVal = dataSaveNotifications.toString();
            }
         }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 13)
    public void tenantAdminUpdatePermissionDataAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+UPDATE_PERMISSIONDATA+"'</b>***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("updatepermissionData.properties");
                setPropertyVal("tenantId",tenantId);
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, UPDATE_PERMISSIONDATA);
               if(responseVal.statusCode()==200){
                   String apiEndPointVal="";
                   Response responseVal1 = commonGetMethod(authtok, apiEndPointVal);
                   String keysToSearch="";
                   verifyTheOutputData(responseVal1,keysToSearch,data);
               }
            }
         }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 14)
    public void tenantAdminUpdatePluginStatusAPI() throws IOException, ParseException, ConfigurationException {

        test.info("*** Testing API URI  <b>'"+uriValue+"/"+UPDATE_PLUGIN_STATUS+"' </b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b>  *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("updatePluginStatus.properties");
                setPropertyVal("tenantId",tenantId);
                JSONObject data= getJsonObjectValWithBoolean();
                Response responseVal = commonPostMethod(authtok, data, UPDATE_PLUGIN_STATUS);
                if(responseVal.statusCode()==200){
                    String apiEndPointVal="";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);
                 }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 15)
    public void tenantAdminTenantFetchKpiAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+TENANT_FETCHKPI+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String tenantId = tenantIDVal(region);
                setDataPropFilePath("fetchKpi.properties");
                setPropertyVal("tenantId",tenantId);
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String date1 = formatter.format(date);
                setPropertyVal("toDate",date1);
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, TENANT_FETCHKPI);
                if (responseVal.statusCode()==200){
                    String apiEndPointVal="";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 16)
    public void tenantAdminTenantIdExperiencesAddAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+TENANTID_EXPERIENCESADD+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String tenantId = tenantIDVal(region);
                JSONObject data=  vd.dataAddExperience();
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantId + "/experiences";
                Response responseVal = commonPostMethod(authtok, data, apiEndPointVal);
                String expid =responseVal.then().extract().path("experienceId");
                if(responseVal.statusCode()==200){
                    String apiEndPointVal1="tenantAdmin/tenants/"+tenantId+"/experiences/"+expid;
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                    String keysToSearch="";
                  //  verifyTheOutputData(responseVal1,keysToSearch,data);
                    JsonPath jp = new JsonPath(responseVal1.asString());
                    String actVal=jp.get("experienceName").toString().replace("[","").replace("]","");
                    String expVal=data.get("experienceName").toString();
                    String applicationKey="experienceName";
                    if (expVal.equalsIgnoreCase(actVal)) {
                        logPass("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is matching with actual value from the response i.e.\"" + actVal + "\"");
                    } else {
                        logFail("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is NOT matching with actual value from the response i.e. \"" + actVal + "\"");
                    }
                    actVal=jp.get("experienceDescription").toString().replace("[","").replace("]","");
                    expVal=data.get("experienceDescription").toString();
                    applicationKey="experienceDescription";
                    if (expVal.equalsIgnoreCase(actVal)) {
                        logPass("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is matching with actual value from the response i.e.\"" + actVal + "\"");
                    } else {
                        logFail("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is NOT matching with actual value from the response i.e. \"" + actVal + "\"");
                    }

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 17)
    public void tenantAdminTenantIdExperiencesUpdateAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+TENANTID_EXPERIENCES_UPDATE+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                experienceIDVal = createExperienceSpecific(getUserIdValue("2", region));
                setDataPropFilePath("updateExperience.properties");
                setPropertyVal("experienceName",getAlphaNumericString(10));
                JSONObject data=vd.dataUpdateExperience();
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantId + "/experiences/" + experienceIDVal;
                Response responseVal = commonPutMethod(authtok, data, apiEndPointVal);
                 if(responseVal.statusCode()==200){
                     String apiEndPointVal1="tenantAdmin/tenants/"+tenantId+"/experiences/"+experienceIDVal;
                     Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                     String keysToSearch="";
                     verifyTheOutputData(responseVal1,keysToSearch,data);

                }
                deleteExperienceSpecific(getUserIdValue("2", region), experienceIDVal);
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 18)
    public void tenantAdminSavePluginSystemInfoUpdateAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                //setDataPropFilePath("savePluginSysInfo.properties");
               // setPropertyVal("fqdn",getAlphaNumericString(10));
              //  setPropertyVal("tenantId",tenantIDVal(region));
                //setPropertyVal("username",getUserIdValue("5", region));
                //JSONObject data=getJsonObjectVal();
                JSONObject data=vd.dataSavePlugin(tenantIDVal(region),getUserIdValue("5", region));
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                Response responseVal = commonPostMethod(authtok, data, apiEndPointVal);
               if (responseVal.statusCode()==200){
                   String apiEndPointVal1="tenantAdmin/tenants/"+tenantIDVal(region)+"/getPluginConfiguration?GUID=4757c4e0-4a94-4496-a5a4-1164d13cbe33&iName=WEBAPI";
                   Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                   String keysToSearch="data";
                   verifyTheOutputData(responseVal1,keysToSearch,data);

               }

            }
         }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 19)
    public void tenantAdminSaveInstructBuilderExperienceAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String expIDValue = experienceIDVal(region);
               // setDataPropFilePath("saveInsBuilExperience.properties");
               // setPropertyVal("tenantId",tenantId);
               // setPropertyVal("id",expIDValue);
                JSONObject data=vd.dataSaveInstructExp( tenantId,expIDValue);
                Response responseVal = commonPostMethod(authtok, data, SAVE_INSTRUCTBUILDER);
                JsonPath jpVal = new JsonPath(responseVal.asString());
                String expIDVal= jpVal.get("instructExperienceId").toString();
                if(responseVal.statusCode()==200){
                    String apiEndPointVal1="tenantAdmin/instructExperience/tenants/"+tenantId+"/experiences/"+expIDValue+"?guid=440c06550bf651b6a1fa527f475a6fbc";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                    String keysToSearch="experience";
                    //verifyTheOutputDataList(responseVal1,keysToSearch,data);
                    JsonPath jp = new JsonPath(responseVal1.asString());
                    String actVal=jp.get("experience.id").toString().replace("[","").replace("]","");
                    String expVal=expIDVal;
                    String applicationKey="id";
                    if (expVal.equalsIgnoreCase(actVal)) {
                        logPass("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is matching with actual value from the response i.e.\"" + actVal + "\"");
                    } else {
                        logFail("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is NOT matching with actual value from the response i.e. \"" + actVal + "\"");
                    }
                    actVal=jp.get("experience.tenantId").toString().replace("[","").replace("]","");
                    expVal=tenantId;
                    applicationKey="tenantId";
                    if (expVal.equalsIgnoreCase(actVal)) {
                        logPass("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is matching with actual value from the response i.e.\"" + actVal + "\"");
                    } else {
                        logFail("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is NOT matching with actual value from the response i.e. \"" + actVal + "\"");
                    }
                    actVal=jp.get("experience.title").toString().replace("[","").replace("]","");
                    expVal=data.get("title").toString();
                    applicationKey="title";
                    if (expVal.equalsIgnoreCase(actVal)) {
                        logPass("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is matching with actual value from the response i.e.\"" + actVal + "\"");
                    } else {
                        logFail("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is NOT matching with actual value from the response i.e. \"" + actVal + "\"");
                    }

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 20)
    public void userTenantsGroupAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b>  '"+uriValue+"/"+USER_TENANTSGROUP+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("userTenantsGroup.properties");
                setPropertyVal("tenantId",tenantId);
                setPropertyVal("username",getUserIdValue("8", region));
                JSONObject data= getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, USER_TENANTSGROUP);
                if(responseVal.statusCode()==200){
                   String apiEndPointVal1="";
                   Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                   String keysToSearch="";
                   verifyTheOutputData(responseVal1,keysToSearch,data);

               }
            }
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 21)
    public void userUpdateUserAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_UPDATEUSER+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                if (i == 2 || i == 3) {
                    setDataPropFilePath("userUpdateUser.properties");
                    LocalDate date = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String date1 = formatter.format(date);
                    setPropertyVal("email",getUserIdValue(usersForTesting.get(i).toString(), region));
                    setPropertyVal("lastSignInTimePortal",date1);

                } else if (i == 6 || i == 8) {
                    setDataPropFilePath("userUpdateUser1.properties");
                    setPropertyVal("email",getUserIdValue(usersForTesting.get(i).toString(), region));

                } else {
                    setDataPropFilePath("userUpdateUser1.properties");
                    setPropertyVal("email",getUserIdValue("8", region));

                }
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPutMethod(authtok1, data, USER_UPDATEUSER);
                if(responseVal.statusCode()==200){
                    String apiEndPointVal1="";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }




    @Test(priority = 22)
    public void userGetFeatureFormsUpdateAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b> '"+uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE+"' </b>  ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject requestParams1 = new JSONObject();
                requestParams1.put("0",2);
                requestParams1.put("1",2);
                requestParams1.put("2",2);
                requestParams1.put("3",1);
                setDataPropFilePath("setFeatureForms.properties");
                setPropertyVal("email",getUserIdValue("8", region));
                setPropertyVal("featureTeacher",requestParams1.toString());
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, USER_SETFEATURE_FORMS_UPDATE);
                if(responseVal.statusCode()==200){
                  String apiEndPointVal1="";
                  Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                  String keysToSearch="";
                  verifyTheOutputData(responseVal1,keysToSearch,data);

              }
            }
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 23)
    public void secretManagerStoresNowSecretAPI() throws IOException, ParseException, ConfigurationException {
        test.info("***  Testing API URI  <b>'"+uriValue+"/"+SECRETMANAGER_STORE_SECRET+"' </b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("storesNowSecret.properties");
                setPropertyVal("tenantId",tenantId);
                if(region.equalsIgnoreCase("devus")){
                    setPropertyVal("fqdn","us-central1-carear-dev.cloudfunctions.net");
                }
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, SECRETMANAGER_STORE_SECRET);
                if(responseVal.statusCode()==200){
                   String apiEndPointVal1="";
                   Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                   String keysToSearch="";
                   verifyTheOutputData(responseVal1,keysToSearch,data);

               }
            }
         }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 24)
    public void secretManagerAwsConfigAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("secretAwsConfig.properties");
                setPropertyVal("tenantId",tenantId);
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, SECRETMANAGER_AWSCONFIG);
                if(responseVal.statusCode()==200){
                    String apiEndPointVal1="";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 25)
    public void secretManagerSfdcConfigAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_SFDCCCONFIG+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("secretSfdcConfig.properties");
                setPropertyVal("tenantId",tenantId);
                setPropertyVal("clientId",getAlphaNumericString(10));
                setPropertyVal("clientSecret",getAlphaNumericString(10));
                setPropertyVal("password",getAlphaNumericString(10));
                setPropertyVal("sfdcToken",getAlphaNumericString(10));
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, SECRETMANAGER_SFDCCCONFIG);
                if (responseVal.statusCode()==200){
                    String apiEndPointVal1="";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);
                }

            }
         }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 26)
    public void sessionsTenantFetchSessionsAPI() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>  '"+uriValue+"/"+SESSIONS_TENANT_FETCH+"' </b>  ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> ***");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("sessionFetchSession.properties");
                setPropertyVal("tenantId",tenantId);
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                String date1 = formatter.format(date);
                setPropertyVal("toDate",date1);
                JSONObject data=getJsonObjectVal();
                Response responseVal = commonPostMethod(authtok, data, SESSIONS_TENANT_FETCH);
                if (responseVal.statusCode()==200){
                    String apiEndPointVal1="";
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal1,keysToSearch,data);
                }
            }
         }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 27)
    public void downloadManagementSave() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI<b>  '"+uriValue+"/"+DOWNLOADMANAGEMENT_SAVE+"'</b>  ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);

                JSONObject data= vd.download_Save(tenantIDVal(region));

                Response responseVal = commonPostMethod(authtok, data, DOWNLOADMANAGEMENT_SAVE);

                if (responseVal.statusCode()==200){
                    String apiEndPointVal1=DOWNLOADMANAGEMENT_LIST;
                    Response responseVal1 = commonGetMethod(authtok, apiEndPointVal1);
                    String docIDVal = responseVal1.asString().split("\"")[3];
                    String apiEndPointVal2="downloadManagement/downloads/"+docIDVal;
                    Response responseVal2 = commonGetMethod(authtok,apiEndPointVal2);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal2,keysToSearch,data);

                }

            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test  (priority = 28)
    public void downloadManagementUpdate() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+DOWNLOADMANAGEMENT_UPDATE+"'</b> ***");
        test.info("*** Starting of <b>: "+currentMethodName+" - Data Validation </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                test.info("*** <b> Testing for the role - "+getRoleValue(usersForTesting.get(i).toString())+" </b> *** ");
                String tenantId = tenantIDVal(region);
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal1 = commonGetMethod(authtok1, DOWNLOADMANAGEMENT_LIST);
                String docIDVal = responseVal1.asString().split("\"")[3];
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                setDataPropFilePath("downloadManagementUpdate.properties");
                setPropertyVal("tenantId",tenantId);
                int min = 100;
                String s=String.valueOf(min);
                setPropertyVal("index",s);
                JSONObject data=getJsonObjectVal();
                String apiEndPointVal = "downloadManagement/downloads/update/" + docIDVal;
                Response responseVal = commonPostMethod(authtok, data, apiEndPointVal);
                if (responseVal.statusCode()==200){
                    String apiEndPointVal2="downloadManagement/downloads/"+docIDVal;
                    Response responseVal3 = commonGetMethod(authtok,apiEndPointVal2);
                    String keysToSearch="";
                    verifyTheOutputData(responseVal3,keysToSearch,data);
                }
            }
         }
        test.info("*******************EndOfTest*******************");
    }




}


