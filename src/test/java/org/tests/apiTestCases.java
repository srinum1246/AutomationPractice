package org.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import roughProgramming.roughProgramming;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;

public class apiTestCases extends variablesAndDataMethods  {
public String apiEndPointValue;
    public apiTestCases() throws IOException {
    }

    @Test(priority = 1)
    public void createTenantAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+CREATE_TENANT+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers = headersVal(authtok);
            data = dataFull();
            Response responseVal = commonPostMethod(authtok, data, CREATE_TENANT);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue = uriValue + "/" + CREATE_TENANT;
            requestTypeVal = "POST";
            payLoadVal = data.toString();
            validationStatements(usersForTesting.get(i).toString(), test, flagVal, responseVal, apiEndPointValue, getUserIdValue(usersForTesting.get(i).toString(), region), rolesAllowedInfo(currentMethodName), currentMethodName, requestTypeVal, payLoadVal, csvReportPathVal);

            //delete created tenant instantly
            String tenantIDValue = responseVal.then().extract().path("tenantId");
            String apiEndPointVal = REAL_DELETE_TENANT + tenantIDValue;
            Response responseValue = commonDeleteMethod(authtok, null, apiEndPointVal);
            System.out.println(responseValue.asString());


        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 2)
    public void updateTenantAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+UPDATE_TENANT+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
             data = dataFull();
             String tenantId = createTenantSpecific(data,getUserIdValue("2", region),region);
             authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
             headers=headersVal(authtok);
             updateFullData = updateFullData(tenantId);
            Response responseVal= commonPutMethod(authtok,updateFullData,UPDATE_TENANT);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+UPDATE_TENANT;
            requestTypeVal = "PUT";
            payLoadVal=updateFullData.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 3)
    public void fetchTenantAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+FETCH_TENANT+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),passwordVal(region), region);
            String apiEndVal=FETCH_TENANT+tenantId;
            Response responseVal= commonGetMethod(authtok,apiEndVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+FETCH_TENANT;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 4)
    public void deleteTenantAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+DELETE_TENANT+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            JSONObject data = dataFull();
            String tenantId = createTenantSpecific(data,getUserIdValue("2", region),region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
           headers= headersVal(authtok);
           String apiEndPointVal=DELETE_TENANT+tenantId;
            Response responseVal =commonDeleteMethod(authtok,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+DELETE_TENANT;
            requestTypeVal = "DELETE";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 5)
    public void realDeleteTenantAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+REAL_DELETE_TENANT+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            JSONObject data = dataFull();
            String tenantId = createTenantSpecific(data,getUserIdValue("2", region),region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            String apiEndPointVal=REAL_DELETE_TENANT+tenantId;
            Response responseVal = commonDeleteMethod(authtok,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+REAL_DELETE_TENANT;
            requestTypeVal = "DELETE";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

//==================================================================================


    @Test(priority = 6)
    public void tenantmanagementFetchTenantAiEnabledAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+FETCH_TENANT_WITHAIENABLED+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            Response responseVal = commonGetMethod(authtok,FETCH_TENANT_WITHAIENABLED);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+FETCH_TENANT_WITHAIENABLED;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 7)
    public void tenantmanagementGetAiServiceConfigAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+GET_AISERVICE_CONFIG+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers= headersVal(authtok);
            Response responseVal= commonGetMethod(authtok,GET_AISERVICE_CONFIG);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+GET_AISERVICE_CONFIG;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");

    }

    @Test(priority = 8)
    public void tenantmanagementSaveAiServicesConfigUpdateAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+SAVE_AISERVICE_CONFIG_UPDA+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers= headersVal(authtok);
            data = dataSaveAIConfig(region);
            Response responseVal =  commonPostMethod(authtok,data,SAVE_AISERVICE_CONFIG_UPDA);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SAVE_AISERVICE_CONFIG_UPDA;
            requestTypeVal = "POST";
            payLoadVal=data.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 9)
    public void tenantAdminAddGroupAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+ADD_GROUP+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers= headersVal(authtok);
            JSONObject dataAddGrp = dataAdd_Group(tenantId);
            Response responseVal = commonPostMethod(authtok,dataAddGrp,ADD_GROUP);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+ADD_GROUP;
            requestTypeVal = "POST";
            payLoadVal=dataAddGrp.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 10)
    public void tenantAdminUpdateGroupAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+UPDATE_GROUP+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            //******************************
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            JSONObject dataAddGrp = dataAdd_Group(tenantId);
            commonPostMethod(authtok,dataAddGrp,ADD_GROUP);
            String oldGrpName = dataAddGrp.get("group").toString();
            JSONObject dataUpdateGrp = dataUpdate_Group(tenantId,oldGrpName);
            Response responseVal = commonPutMethod(authtok,dataUpdateGrp,UPDATE_GROUP);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+UPDATE_GROUP;
            requestTypeVal = "PUT";
            payLoadVal=dataUpdateGrp.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 11)
    public void tenantAdminRemoveGroupAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+REMOVE_GROUP+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            //******************************
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject dataAddGrp = dataAdd_Group(tenantId);
            commonPostMethod(authtok,dataAddGrp,ADD_GROUP);
            String oldGrpName = dataAddGrp.get("group").toString();
            JSONObject dataRemoveGrp = dataRemove_Group(tenantId,oldGrpName);
            Response responseVal = commonDeleteMethod(authtok,dataRemoveGrp,REMOVE_GROUP);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+REMOVE_GROUP;
            requestTypeVal = "DELETE";
            payLoadVal=dataRemoveGrp.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }



    @Test(priority = 12)
    public void tenantAdminBulkEditUsersAPI() throws IOException, ParseException {
        System.out.println("*** tenantAdminBulkEditUsers_API  ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+BULKEDIT_USERS+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            RestAssured.baseURI = uriValue;
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given()
                    .headers(headers)
                    .body(data.toString())
                    .when()
                    .put(BULKEDIT_USERS);
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+BULKEDIT_USERS;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 13)
    public void tenantAdminTenantIdInfoAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_INFO+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            String apiEndpointVal="tenantAdmin/tenants/"+tenantId+"/?GUID=02ff26fb-7d9e-4686-9b28-e970030efed6";
            Response responseVal = commonGetMethod(authtok, apiEndpointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/?GUID=02ff26fb-7d9e-4686-9b28-e970030efed6";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 14)
    public void tenantAdminSaveNotificationsAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_SAVE_NOTIFICATION+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region),region);
            headers= headersVal(authtok);
            JSONObject dataSaveNotifications = dataSaveNotifications(getUserIdValue("5", region));
            Response responseVal = commonPostMethod(authtok,dataSaveNotifications,"tenantAdmin/tenants/"+tenantId+"/saveNotificationSettings");
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/saveNotificationSettings";
            requestTypeVal = "POST";
            payLoadVal=dataSaveNotifications.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 15)
    public void tenantAdminSearchUserFetchAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SEARCHUSER_FETCH+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue("5", region), passwordVal(region), region);
            JSONObject dataRegisterUser = dataRegisterUser(tenantIDVal(region),"TCS");
            headers=headersVal(authtok);
            commonPostMethod(authtok,dataRegisterUser,AUTH_REGISTER_USER).then().extract().path("uid");
            String emailIDVal = dataRegisterUser.get("email").toString();
            String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/tenantsGroup/"+tenantIDVal(region)+"/search/"+emailIDVal;
            Response responseVal=commonGetMethod(authtok1,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenantsGroup/"+tenantIDVal(region)+"/search/"+emailIDVal;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 16)
    public void tenantAdminGroupIdUsersFetchAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+GROUPID_USERS_FETCH+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            String apiEndPointVal="tenantAdmin/tenantsGroup/"+tenantId+"/users/autoGroup1";
            Response responseVal = commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenantsGroup/"+tenantId+"/users/autoGroup1";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 17)
    public void tenantAdminTenantIdUsersAuthenticateAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_USERS_AUTHENTICATE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/users";
            Response responseVal=commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/users";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 18)
    public void tenantAdminTenantIdStartValueUsersAuthenticateAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_STARTVALUE_AUTHENTICATE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            String apiEndPointVal="tenantAdmin/tenantsPaginate/"+tenantId+"/start/first/users";
            Response responseVal=commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenantsPaginate/"+tenantId+"/start/first/users";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 19)
    public void tenantAdminSurveyTenantIdAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SURVEY_TENANTID+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            //String apiEndPointVal="tenantAdmin/survey?tenantId="+tenantIDVal(region)+"&userType=Host";
            String apiEndPointVal="tenantAdmin/survey?tenantId="+tenantIDVal(region)+"&userType=host";
            Response responseVal= commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
           // apiEndPointValue=uriValue+"/"+"tenantAdmin/survey?tenantId="+tenantIDVal(region)+"&userType=Host";
            apiEndPointValue=uriValue+"/"+"tenantAdmin/survey?tenantId="+tenantIDVal(region)+"&userType=host";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 20)
    public void tenantAdminUpdatePermissionDataAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+UPDATE_PERMISSIONDATA+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            JSONObject updatePermissionData = updatePermission_Data(tenantId);
            Response responseVal= commonPostMethod(authtok,updatePermissionData,UPDATE_PERMISSIONDATA);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+UPDATE_PERMISSIONDATA;
            requestTypeVal = "PUT";
            payLoadVal=updatePermissionData.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 21)
    public void tenantAdminTenantsUploadLogoAPI() throws IOException,ParseException{
        System.out.println("*** tenantAdminTenantsUploadLogo_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTS_UPLOADLOGO+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(TENANTS_UPLOADLOGO);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+TENANTS_UPLOADLOGO;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 22)
    public void tenantAdminTenantIdFetchPluginListAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_FETCHPLUGIN_LIST+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            headers=headersVal(authtok);
            String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/fetchPluginList?GUID=4757c4e0-4a94-4496-a5a4-1164d13cbe33";
            Response responseVal = commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/fetchPluginList?GUID=4757c4e0-4a94-4496-a5a4-1164d13cbe33";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 23)
    public void tenantAdminUpdatePluginStatusAPI() throws IOException,ParseException{

        test.info("*** Testing API URI '"+uriValue+"/"+UPDATE_PLUGIN_STATUS+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject updatePluginstatus = update_Plugin_status(tenantId);
            Response responseVal = commonPostMethod(authtok,updatePluginstatus,UPDATE_PLUGIN_STATUS);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+UPDATE_PLUGIN_STATUS;
            requestTypeVal = "POST";
            payLoadVal=updatePluginstatus.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 24)
    public void tenantAdminTenantFetchKpiAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+TENANT_FETCHKPI+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String tenantId = tenantIDVal(region);
            JSONObject datafetchTenantKPI = datafetchKPI(tenantId);
            Response responseVal = commonPostMethod(authtok,datafetchTenantKPI,TENANT_FETCHKPI);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+TENANT_FETCHKPI;
            requestTypeVal = "POST";
            payLoadVal=datafetchTenantKPI.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 25)
    public void tenantAdminTenantIdExperiencesAddAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_EXPERIENCESADD+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String tenantId = tenantIDVal(region);
            JSONObject dataAddExperience = dataAddExperience();
            String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/experiences";
            Response responseVal = commonPostMethod(authtok,dataAddExperience,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/experiences";
            requestTypeVal = "POST";
            payLoadVal=dataAddExperience.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 26)
    public void tenantAdminTenantIdExperiencesExperienceIdAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_EXPERIENCES_EXPERIENCEID+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/tenants/"+tenantIDVal(region)+"/experiences/"+experienceIDVal(region);
            Response responseVal =  commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantIDVal(region)+"/experiences/"+experienceIDVal(region);
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test (priority = 27)
    public void tenantAdminTenantIdExperiencesExperienceIdFetchAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_EXPERIENCES_EXPERIENCEID_FETCH+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
           String apiEndPointVal="tenantAdmin/tenants/"+tenantIDVal(region)+"/experiences/"+experienceIDVal(region)+"/start?guid=27d543b1507f4d3faadf62828a4569ce";
           Response responseVal = commonGetMethod(authtok,apiEndPointVal);
           String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
           apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantIDVal(region)+"/experiences/"+experienceIDVal(region)+"/start?guid=27d543b1507f4d3faadf62828a4569ce";
           requestTypeVal = "GET";
           payLoadVal="NA";
           validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 28)
    public void tenantAdminTenantIdExperiencesFetchAllAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_EXPERIENCES_FETCHALL+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantID = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/tenants/"+tenantID+"/experiences";
            Response responseVal = commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantID+"/experiences";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 29)
    public void tenantAdminTenantIdExperiencesUpdateAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_EXPERIENCES_UPDATE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            experienceIDVal = createExperienceSpecific(getUserIdValue("2", region));
            JSONObject dataUpdateExeperienceVal = dataUpdateExperience();
            String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/experiences/"+experienceIDVal;
            Response responseVal = commonPutMethod(authtok,dataUpdateExeperienceVal,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/experiences/"+experienceIDVal;
            requestTypeVal = "PUT";
            payLoadVal=dataUpdateExeperienceVal.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
            deleteExperienceSpecific(getUserIdValue("2", region),experienceIDVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 30)
    public void tenantAdminTenantIdExperiencesDeleteAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+TENANTID_EXPERIENCES_DELETE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String experienceIDVal = createExperienceSpecific(getUserIdValue("2", region));
            String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/experiences/"+experienceIDVal;
            Response responseVal=commonDeleteMethod(authtok,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/experiences/"+experienceIDVal;
            requestTypeVal = "DELETE";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 31)
    public void tenantAdminExperienceIdAttachFileAPI() throws IOException,ParseException{
        System.out.println("*** tenantAdminExperienceIdAttachFile_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+EXPERIENCEID_ATTACHFILE+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(EXPERIENCEID_ATTACHFILE);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+EXPERIENCEID_ATTACHFILE;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 32)
    public void tenantAdminGetPluginConfigurationFetchAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+GETPLUGIN_PLUGINCONFIGURATION_FETCH+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/tenants/"+tenantIDVal(region)+"/getPluginConfiguration?GUID=4757c4e0-4a94-4496-a5a4-1164d13cbe33&iName=EAUT";
            Response responseVal =commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantIDVal(region)+"/getPluginConfiguration?GUID=4757c4e0-4a94-4496-a5a4-1164d13cbe33&iName=EAUT";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 33)
    public void tenantAdminSavePluginSystemInfoUpdateAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject dataSavePluginVal = dataSavePlugin(tenantIDVal(region),getUserIdValue("5", region));
            String apiEndPointVal="tenantAdmin/tenants/"+tenantIDVal(region)+"/savePluginSystemInfo";
             Response responseVal=commonPostMethod(authtok,dataSavePluginVal,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantIDVal(region)+"/savePluginSystemInfo";
            requestTypeVal = "POST";
            payLoadVal=dataSavePluginVal.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 34)
    public void tenantAdminSaveInstructBuilderExperienceAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region),region);
            String expIDValue = experienceIDVal(region);
            JSONObject saveinstruct = dataSaveInstructExp( tenantId,expIDValue);
            Response responseVal = commonPostMethod(authtok,saveinstruct,SAVE_INSTRUCTBUILDER);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SAVE_INSTRUCTBUILDER;
            requestTypeVal = "POST";
            payLoadVal=saveinstruct.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 35)
    public void tenantAdminInstructBuilderExperienceFetchAPI() throws IOException, ParseException {

        test.info("*** Testing API URI '"+uriValue+"/"+INSTRUCTBUILDER_EXPERIENCES_FETCH+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region),region);
            String experienceIDVal = experienceIDVal(region);
            String apiEndPointVal="tenantAdmin/instructExperience/tenants/"+tenantId+"/experiences/"+experienceIDVal+"?guid=440c06550bf651b6a1fa527f475a6fbc";
            Response responseVal=commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/instructExperience/tenants/"+tenantId+"/experiences/"+experienceIDVal+"?guid=440c06550bf651b6a1fa527f475a6fbc";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 36)
    public void messagingGuestAPI() throws IOException,ParseException{
        System.out.println("*** messagingGuest_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+MESSAGING_GUEST+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(MESSAGING_GUEST);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+MESSAGING_GUEST;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 37)
    public void messagingChannelNameAPI() throws IOException, ParseException {
        System.out.println("*** messagingChannelName_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+MESSAGING_CHANNELNAME+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date1 = formatter.format(date);
            RestAssured.baseURI = uriValue;
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", "Bearer " + authtok);
            Response responseVal = given().headers(headers)
                    .when()
                    .get(MESSAGING_CHANNELNAME);
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+MESSAGING_CHANNELNAME;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 38)
    public void messagingCheckForUpgradeAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+MESSAGING_CHECKFORUPGRADE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Response responseVal=commonGetMethod(authtok,MESSAGING_CHECKFORUPGRADE);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+MESSAGING_CHECKFORUPGRADE;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 39)
    public void messagingCheckUrlExistsAPI() throws IOException, ParseException {
        System.out.println("*** messagingCheckUrlExists_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+MESSAGING_CHECKURLEXISTS+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date1 = formatter.format(date);
            RestAssured.baseURI = uriValue;
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", "Bearer " + authtok);
            Response responseVal = given().headers(headers)
                    .when()
                    .get(MESSAGING_CHECKURLEXISTS);
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+MESSAGING_CHECKURLEXISTS;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    ///////////////////////////////////
    @Test(priority = 40)
    public void userTenantsGroupAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+USER_TENANTSGROUP+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject tenantsgroup = dataTenantsGroups(tenantId,getUserIdValue("8", region));
            Response responseVal = commonPostMethod(authtok,tenantsgroup,USER_TENANTSGROUP);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+USER_TENANTSGROUP;
            requestTypeVal = "POST";
            payLoadVal=tenantsgroup.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 41)
    public void userFetchFavoritesAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+USER_FETRCHFAVOURITES+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String uidVal = userIdValue(region);
            String apiEndPointVal="user/"+uidVal+"/fetchFavorites/start/first/rowsPerPage/10";
            Response responseVal = commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"user/"+uidVal+"/fetchFavorites/start/first/rowsPerPage/10";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 42)
    public void userUpdateUserAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+USER_UPDATEUSER+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            JSONObject dataUpdateUserVal;
            if(i==2 || i==3)
            {
                dataUpdateUserVal = dataUpdateUser1(getUserIdValue(usersForTesting.get(i).toString(), region));
            }
            else if (i==6 || i==8)
            {
                dataUpdateUserVal = dataUpdateUser(getUserIdValue(usersForTesting.get(i).toString(), region));
            }
            else
            {
                dataUpdateUserVal = dataUpdateUser(getUserIdValue("8", region));
            }
            String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            Response responseVal=commonPutMethod(authtok1,dataUpdateUserVal,USER_UPDATEUSER);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+USER_UPDATEUSER;
            requestTypeVal = "PUT";
            payLoadVal=dataUpdateUserVal.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 43)
    public void userGetFeatureFormsAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+USER_GETFEATURE_FORMS+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String apiEndPointVal="user/getFeatureTeacherParms/?email="+getUserIdValue("8", region);
            Response responseVal = commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"user/getFeatureTeacherParms/?email="+getUserIdValue("8", region);
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 44)
    public void userGetFeatureFormsUpdateAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject setFeature = dataUserSetTeacherForums(getUserIdValue("8", region));
            Response responseVal=commonPostMethod(authtok,setFeature,USER_SETFEATURE_FORMS_UPDATE);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE;
            requestTypeVal = "POST";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 45)
    public void userRemoveUserAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+USER_REMOVE_USER+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String authtok1 = login_api(getUserIdValue("5", region),  passwordVal(region), region);
            JSONObject dataRegisterUser = dataRegisterUser(tenantIDVal(region),"TCS");
           String userID=commonPostMethod(authtok1,dataRegisterUser,AUTH_REGISTER_USER).then().extract().path("uid");
            String authtok2 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="user/"+userID+"/removeUser";
            Response responseVal=commonDeleteMethod(authtok2,null,apiEndPointVal);
             String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"user/"+userID+"/removeUser";
            requestTypeVal = "DELETE";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 46)
    public void userUserInfoAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+USER_USERINFO+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String apiEndPointVal="user/userInfo/"+userIdValue(region);
            Response responseVal=commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"user/userInfo/"+userIdValue(region);
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 47)
    public void secretManagerStoresNowSecretAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+SECRETMANAGER_STORE_SECRET+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject storeSnowSecret = store_Snow_Secret(tenantId,region);
            Response responseVal=commonPostMethod(authtok,storeSnowSecret,SECRETMANAGER_STORE_SECRET);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue = uriValue+"/"+SECRETMANAGER_STORE_SECRET;
            requestTypeVal = "POST";
            payLoadVal=storeSnowSecret.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 48)
    public void secretManagerAwsConfigAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId =tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject awsconfig = secret_Aws_Config(tenantId);
            Response responseVal=commonPostMethod(authtok,awsconfig,SECRETMANAGER_AWSCONFIG);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SECRETMANAGER_AWSCONFIG;
            requestTypeVal = "POST";
            payLoadVal=awsconfig.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 49)
    public void secretManagerSfdcConfigAPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+SECRETMANAGER_SFDCCCONFIG+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject sfdcconfig = secret_Sfdc_Config(tenantId);
            Response responseVal=commonPostMethod(authtok,sfdcconfig,SECRETMANAGER_SFDCCCONFIG);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SECRETMANAGER_SFDCCCONFIG;
            requestTypeVal = "POST";
            payLoadVal=sfdcconfig.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 50)
    public void sessionsFetchSessionsUserAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_FETCH_USER+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String uidVal = userIdValue(region);
            String startValue = null;
            String apiEndPointVal="sessions/fetchSessions/user/"+uidVal+"/start/first/rowsPerPage/23";
            Response responseVal=commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"sessions/fetchSessions/user/"+uidVal+"/start/first/rowsPerPage/23";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 51)
    public void sessionsTenantFetchSessionsAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_TENANT_FETCH+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            JSONObject sessionfetch = dataSessionsGuest(tenantId);
            Response responseVal=commonPostMethod(authtok,sessionfetch,SESSIONS_TENANT_FETCH);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SESSIONS_TENANT_FETCH;
            requestTypeVal = "POST";
            payLoadVal=sessionfetch.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 52)
    public void sessionsRecordingStartAPI() throws IOException,ParseException{
        System.out.println("*** sessionsRecordingStart_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_RECORDING_START+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            JSONObject data = dataFull();
            String tenantId = tenantIDVal(region);
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject recordingstart = Recording_Start(tenantId);
            Response responseVal = given().headers(headers)
                    .body(recordingstart.toString())
                    .when()
                    .post("sessions/fd98d88b-7a64-4802-b330-146a67bce85d/recording/start") ;
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"sessions/fd98d88b-7a64-4802-b330-146a67bce85d/recording/start";
            requestTypeVal = "POST";
            payLoadVal=recordingstart.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 53)
    public void sessionsRecordingStopAPI() throws IOException,ParseException{
        System.out.println("*** sessionsRecordingStop_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_RECORDING_STOP+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(SESSIONS_RECORDING_STOP);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SESSIONS_RECORDING_STOP;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 54)
    public void sessionsRecordingUpdateLayoutAPI() throws IOException,ParseException{
        System.out.println("*** sessionsRecordingUpdateLayout_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_RECORDING_UPDATELAYOUT+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(SESSIONS_RECORDING_UPDATELAYOUT);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SESSIONS_RECORDING_UPDATELAYOUT;
            requestTypeVal = "POST";
            payLoadVal=data.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 55)
    public void sessionsUploadSnapshotAPI() throws IOException,ParseException{
        System.out.println("*** sessionsUploadSnapshot_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_UPLOAD_SNAPSHOT+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(SESSIONS_UPLOAD_SNAPSHOT);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SESSIONS_UPLOAD_SNAPSHOT;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 56)
    public void sessionsUploadImageAPI() throws IOException,ParseException{
        System.out.println("*** sessionsUploadImage_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_UPLOAD_IMAGE+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(SESSIONS_UPLOAD_IMAGE);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+SESSIONS_UPLOAD_IMAGE;
            requestTypeVal = "NA";
            payLoadVal="NA";

            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 57)
    public void sessionsGuestParticipantsNumAPI() throws IOException, ParseException {
        test.info("*** Testing API URI '"+uriValue+"/"+SESSIONS_GUEST_PARTICIPANTS+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String apiEndPointVal="sessions/get/guestParticipantNumber/?sessionId="+sessionIDVal(region);
            Response responseVal=commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"sessions/get/guestParticipantNumber/?sessionId="+sessionIDVal(region);
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
/////////////////////////////////////////////////////////////////////////

    @Test(priority = 58)
    public void authLogin() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_LOGIN+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            JSONObject requestParams = new JSONObject();
            requestParams.put("email", getUserIdValue(usersForTesting.get(i).toString(), region));
            requestParams.put("password", passwordVal(region));
            String apiEndPointVal="/auth/login";
            Response responseVal=commonPostMethod(authtok,requestParams,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_LOGIN;
            requestTypeVal = "POST";
            payLoadVal=requestParams.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 59)
    public void authLogout() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_LOGOUT+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            Response responseVal=commonPostMethod(authtok,null,AUTH_LOGOUT);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_LOGOUT;
            requestTypeVal = "POST";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 60)
    public void authRefreshToken() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_REFRESH_TOKEN+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            JSONObject requestParams = new JSONObject();
            requestParams.put("email", getUserIdValue(usersForTesting.get(i).toString(), region));
            requestParams.put("password",  passwordVal(region));
            String apiEndPointVal="/auth/login";
            Response response=commonPostMethod(authtok,requestParams,apiEndPointVal).then().extract().response();
            authtok = response.jsonPath().getString("token.idToken");
            String refreshtok=response.jsonPath().getString("token.refreshToken");
            JSONObject data = dataAuthRefresh(refreshtok);
            Response responseVal = commonPostMethod(authtok,data,AUTH_REFRESH_TOKEN);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_REFRESH_TOKEN;
            requestTypeVal = "POST";
            payLoadVal=data.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 61)
    public void authActivateUser() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_ACTIVATE_USER+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            JSONObject data = dataActivateUser(userIdValue(region));
            Response responseVal =commonPostMethod(authtok,data,AUTH_ACTIVATE_USER);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_ACTIVATE_USER;
            requestTypeVal = "POST";
            payLoadVal=data.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 62)
    public void authRegisterUser() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_REGISTER_USER+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            JSONObject dataRegisterUser = dataRegisterUser(tenantIDVal(region),"TCS");
            Response responseVal=commonPostMethod(authtok,dataRegisterUser,AUTH_REGISTER_USER);
            String uidVal = responseVal.jsonPath().getString("uid");
            String authtok2 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="user/"+uidVal+"/removeUser";
            commonDeleteMethod(authtok2,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_REGISTER_USER;
            requestTypeVal = "DELETE";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 63)
    public void authChangePswd() throws IOException,ParseException{
        System.out.println("*** authChangePswd_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_CHANGE_PSWD+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull( );
            Response responseVal = given()
                    .headers(headers)
                    .when()
                    .get(AUTH_CHANGE_PSWD);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_CHANGE_PSWD;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 64)
    public void authFetchAppCheckToken() throws IOException,ParseException{
        System.out.println("*** authFetchAppCheckToken_API ***");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        test = extent.createTest(currentMethodName);
        String region= readProperty("regionVal");
        String uriValue=uriVal(region);
        org.json.simple.JSONArray usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        test.info("*** Starting of "+currentMethodName+" test ***");
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_FETCHCHECK_TOKEN+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            RestAssured.baseURI = uriValue;
            //test.info("*******************Testing for "+getRoleValue(usersForTesting.get(i).toString())+" role *******************");
            //test.info("*******************"+rolesAllowedInfo(currentMethodName)+"***********");

            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("Authorization", "Bearer " + authtok);
            JSONObject data = dataFull();
            Response responseVal = given().headers(headers)
                    .body(data.toString())
                    .when()
                    .post(AUTH_FETCHCHECK_TOKEN);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_FETCHCHECK_TOKEN;
            requestTypeVal = "NA";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 65)
    public void authFetchsSuperUsers() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+AUTH_FETCHSUPER_USERS+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            Response responseVal =commonGetMethod(authtok,AUTH_FETCHSUPER_USERS);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+AUTH_FETCHSUPER_USERS;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 66)
    public void aiServicesAuthTenantId() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+AISERVICES_AUTH_TENANTID+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="aiServices/auth/ar/tenant/"+tenantId;
            Response responseVal =commonPostMethod(authtok,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"aiServices/auth/ar/tenant/"+tenantId;
            requestTypeVal = "POST";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 67)
    public void centralLookupQuantPart() throws IOException,ParseException{
        String region= readProperty("regionVal");
        String env= readProperty("environment");
        String uriValue=uriVal(region);
        String baseCentralURI = centralSpaceURI(env);
        test.info("*** Testing API URI '"+baseCentralURI+"/"+LOOKUP_QUANTPART+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal=baseCentralURI+"/lookup/quantEntangPart?email="+getUserIdValue(usersForTesting.get(i).toString(), region);
            Response responseVal =commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+LOOKUP_QUANTPART;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 68)
    public void downloadManagementSave() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+DOWNLOADMANAGEMENT_SAVE+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            JSONObject downloadsave = download_Save(tenantId);
            Response responseVal=commonPostMethod(authtok,downloadsave,DOWNLOADMANAGEMENT_SAVE);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+DOWNLOADMANAGEMENT_SAVE;
            requestTypeVal = "POST";
            payLoadVal=downloadsave.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test  (priority = 69)
    public void downloadManagementUpdate() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+DOWNLOADMANAGEMENT_UPDATE+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String tenantId = tenantIDVal(region);
            String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            Response responseVal1 =commonGetMethod(authtok1,DOWNLOADMANAGEMENT_LIST);
            String docIDVal = responseVal1.asString().split("\"")[3];
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            JSONObject downloadupdate = download_update(tenantId);
            String apiEndPointVal="downloadManagement/downloads/update/"+docIDVal;
            Response responseVal=commonPostMethod(authtok,downloadupdate,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"downloadManagement/downloads/update/"+docIDVal;
            requestTypeVal = "POST";
            payLoadVal=downloadupdate.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test  (priority = 70)
    public void downloadManagementList() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+DOWNLOADMANAGEMENT_LIST+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            Response responseVal =commonGetMethod(authtok,DOWNLOADMANAGEMENT_LIST);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+DOWNLOADMANAGEMENT_LIST;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test  (priority = 71)
    public void downloadManagementDociId() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+DOWNLOADMANAGEMENT_DOCI_ID+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            Response responseVal1 =commonGetMethod(authtok1,DOWNLOADMANAGEMENT_LIST);
            String docIDVal = responseVal1.asString().split("\"")[3];
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="downloadManagement/downloads/"+docIDVal;
            Response responseVal = commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"downloadManagement/downloads/"+docIDVal;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

   @Test(priority = 72)
    public void getTenantPurchaseHistory() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+GET_TENANT_PURCHASEHISTORY+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId=tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/getPurchaseHistory";
            Response responseVal = commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+GET_TENANT_PURCHASEHISTORY;
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 73)
    public void authGetScore() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+"auth/getScore"+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
             JSONObject requestParams = new JSONObject();
             requestParams.put("email", getUserIdValue(usersForTesting.get(i).toString(), region));
             requestParams.put("password",  passwordVal(region));
             Response response = commonPostMethod(authtok,requestParams,"/auth/login").then().extract().response();
             authtok = response.jsonPath().getString("token.idToken");
            JSONObject data = dataAuthGetScore(authtok);
            String apiEndPoinVal="auth/getScore";
            Response responseVal =commonPostMethod(authtok,data,apiEndPoinVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"auth/getScore";
            requestTypeVal = "POST";
            payLoadVal=data.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test  (priority = 74)
    public void aiServicesAuthTenantExpId() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+"/aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId"+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="aiServices/auth/ar/experience/"+experienceIDVal(region)+"/tenant/"+tenantIDVal(region);
            Response responseVal =commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName,getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"/aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }


    @Test  (priority = 75)
    public void aiServicesAuthTenantExpIdReadOnly() throws IOException,ParseException{

        test.info("*** Testing API URI '"+uriValue+"/"+"/aiServices/auth/:authType/tenant/:tenantId?tokenType=READ_ONLY"+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="aiServices/auth/ar/tenant/"+tenantIDVal(region)+"?tokenType=READ_ONLY";
            Response responseVal = commonPostMethod(authtok,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName,getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"aiServices/auth/ar/tenant/"+tenantIDVal(region)+"?tokenType=READ_ONLY";
            requestTypeVal = "POST";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

// Below we can find 22.05 Apis

    @Test(priority = 76)
    public void tenantAdminTenantIdSaveKPI() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+"tenantAdmin/tenant/saveKPI"+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
            String tenantId = tenantIDVal(region);
            JSONObject dataSaveKPI = datasaveKPI(tenantId);
            String apiEndPointVal="tenantAdmin/tenant/saveKPI";
            Response responseVal = commonPostMethod(authtok,dataSaveKPI,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenant/saveKPI";
            requestTypeVal = "POST";
            payLoadVal=dataSaveKPI.toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test  (priority = 77)
    public void tenantAdminFetchKpiBuilderData() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+TRENANTADMIN_FETCH_KPIBUILDER_DATA+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            createSurvey(region,tenantId);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/tenant/"+tenantId+"/fetchBuilderKPI?surveyId="+surveyIDVal(region,tenantId);
            Response responseVal=commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenant/"+tenantId+"/fetchBuilderKPI?surveyId="+surveyIDVal(region,tenantId);
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test  (priority = 78)
    public void tenantAdminSurveyDelete() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+TENANT_SURVEY_DELETE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            //saving the survey id
            createSurvey(region,tenantId);
            //Fetching the survey id
            String surveyIDValue = surveyIDVal(region,tenantId);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/survey/"+surveyIDValue;
            Response responseVal=commonDeleteMethod(authtok,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/tenants/"+tenantId+"/survey/"+surveyIDValue;
            requestTypeVal = "DELETE";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 79)
    public void instructExperienceGoogleTranslationInBulk() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+GOOGLETRANSLATION+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            JSONObject google =  gooogleTranslation(tenantId);
            String apiEndPointVal=GOOGLETRANSLATION;
            Response responseVal=commonPostMethod(authtok,google,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/instructExperience/googleTranslationInBulk";
            requestTypeVal = "POST";
            payLoadVal=gooogleTranslation(tenantId).toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 80)
    public void instructExperienceCopyStorageData() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+COPYSTORAGEDATA+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            String Expid = experienceIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            JSONObject Storage =  copyStorageData(tenantId,Expid);
            String apiEndPointVal=COPYSTORAGEDATA;
            Response responseVal=commonPostMethod(authtok,Storage,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/instructExperience/copyStorageData";
            requestTypeVal = "POST";
            payLoadVal= copyStorageData(tenantId,Expid).toString();
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 81)
    public void updateDefaultInstructLanguage() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+UPDATEDEFAULTLANGUAGE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            String Expid = experienceIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            JSONObject Defaultlan =  DefaultLangUpdate(tenantId,Expid);
            String apiEndPointVal="tenantAdmin/instructExperience/tenants/"+tenantId+"/experiences/"+Expid+"/version/v1/languageCode/en";
            Response responseVal=commonPutMethod(authtok,Defaultlan,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/instructExperience/tenants/"+tenantId+"/experiences/"+Expid+"/version/v1/languageCode/en";
            requestTypeVal = "PUT";
            payLoadVal=DefaultLangUpdate(tenantId,Expid).toString();;
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 82)
    public void deleteInstructExperienceLanguage() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+DELETEINSTRUCTLANGUAGE+"' ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String tenantId = tenantIDVal(region);
            String Expid = experienceIDVal(region);
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal="tenantAdmin/instructExperience/tenants/"+tenantId+"/experiences/"+Expid+"/version/v1/languageCode/fr";
            Response responseVal=commonDeleteMethod(authtok,null,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"tenantAdmin/instructExperience/tenants/"+tenantId+"/experiences/"+Expid+"/version/v1/languageCode/fr";
            requestTypeVal = "DELETE";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

//server 10874

//CWP-4737
@Test  (priority = 83)
public void aiServices_CWP4737() throws IOException,ParseException{
    test.info("*** Testing API URI '"+uriValue+"/"+"/aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId"+"' ***");
    for (int i = 0; i < usersForTesting.size(); i++) {
        authtok = login_api( getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
        String apiEndPointVal ="aiServices/auth/intelligent/experience/"+experienceIDValInteSearchOptionUsed(region)+"/tenant/"+tenantIDVal(region);
        Response responseVal =commonGetMethod(authtok,apiEndPointVal);
        String flagVal = returnFlag(currentMethodName,getRoleValue(usersForTesting.get(i).toString()));
        apiEndPointValue=uriValue+"/"+"/aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId";
        requestTypeVal = "GET";
        payLoadVal="NA";
        validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

    }
    test.info("*******************EndOfTest*******************");
}

//CWP-4739
    @Test  (priority = 84)
    public void aiServices_CWP4739() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+"/aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId"+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api( getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal ="aiServices/auth/intelligent/experience/"+experienceIDValInteSearchOptionNotUsed(region)+"/tenant/"+tenantIDVal(region);
             Response responseVal =commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName,getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"/aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatements(usersForTesting.get(i).toString(),test,flagVal,responseVal,apiEndPointValue,getUserIdValue(usersForTesting.get(i).toString(), region),rolesAllowedInfo(currentMethodName),currentMethodName,requestTypeVal,payLoadVal,csvReportPathVal);

        }
        test.info("*******************EndOfTest*******************");
    }

    //CWP-4740
    @Test  (priority = 84)
    public void aiServices_CWP4740() throws IOException,ParseException{
        test.info("*** Testing API URI '"+uriValue+"/"+"/aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId"+"' ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region),  passwordVal(region), region);
            String apiEndPointVal ="aiServices/auth/intelligent/experience/"+experienceIDValInteSearchOptionNotUsed(region)+"/tenant/"+tenantIDValCore(region);
            Response responseVal =commonGetMethod(authtok,apiEndPointVal);
            String flagVal = returnFlag(currentMethodName,getRoleValue(usersForTesting.get(i).toString()));
            apiEndPointValue=uriValue+"/"+"aiServices/auth/:authType/experience/:experienceId/tenant/:tenantId";
            requestTypeVal = "GET";
            payLoadVal="NA";
            validationStatementsNegFlow(usersForTesting.get(i).toString(), test, flagVal, responseVal, apiEndPointValue, getUserIdValue(usersForTesting.get(i).toString(), region), rolesAllowedInfo(currentMethodName), currentMethodName, requestTypeVal, payLoadVal, csvReportPathVal);
        }
        test.info("*******************EndOfTest*******************");
    }




}


