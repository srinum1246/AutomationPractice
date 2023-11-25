package org.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;

public class apiTestCasesNegFlow extends variablesAndDataMethodsNegFlow {
public String apiEndPointValue;
public variablesAndDataMethods vd = new variablesAndDataMethods();
public responseValidationVariables re= new responseValidationVariables();
    public apiTestCasesNegFlow() throws IOException {
    }
   // create tenant
    @Test(priority = 1)
    public void createTenantAPIManFieldAsEmpty() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+CREATE_TENANT+"' </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=dataFullManFieldAsEmpty();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.createTenantManField(),responseValidationVariables.createTenantNonManField() ,re.createtenantfailuremsg,responseVal.asString(),rescode,re.createtenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 2)
    public void createTenantAPIManFieldAndNonManFieldAsEmpty() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+CREATE_TENANT+"' </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=dataFullManFieldAndNonManFieldAsEmpty();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                  responsevalidation(responseValidationVariables.createTenantManField(),responseValidationVariables.createTenantNonManField(),re.createtenantmanandnonmanfieldasempty,responseVal.asString(),rescode,re.createtenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 3)
    public void createTenantAPIManFieldAsInvalidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+CREATE_TENANT+"' </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=dataFullManFieldAsInvalid();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.createTenantManField(),responseValidationVariables.createTenantNonManField(),re.createtenantmanfieldasinvalid,responseVal.asString(),rescode,re.createtenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 4)
    public void createTenantAPIManFieldAndNonManFieldAsInvalidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+CREATE_TENANT+"' </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=dataFullManFieldAndNonManFieldInvalid();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.createTenantManField(),responseValidationVariables.createTenantNonManField(),re.createtenantmanandnonmanasinvalid,responseVal.asString(),rescode,re.createtenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 5)
    public void createTenantAPIManFieldInValNonManFieldValidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+CREATE_TENANT+"' </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=dataFullManFieldAsInvalidNonManValidVal();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.createTenantManField(),responseValidationVariables.createTenantNonManField(),re.createtenantmaninvalidnonmanvalid,responseVal.asString(),rescode,re.createtenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 6)
    public void createTenantAPIManFieldValNonManFieldInValidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+CREATE_TENANT+"' </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")){
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=dataFullManFieldValidNonManInValidVal();
                Response responseVal=commonPostMethod(authtok,data,CREATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.createTenantManField(),responseValidationVariables.createTenantNonManField(),re.createtenantmanvalidnonmaninvalid,responseVal.asString(),rescode,re.createtenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    // update tenant
    @Test(priority = 7)
    public void updateTenantAPIManFieldAsEmpty() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+UPDATE_TENANT+"' </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject data = vd.dataFull();
                String tenantId = createTenantSpecific(data, getUserIdValue("2", region), region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data1 = updateFullDataManFieldAsEmpty(tenantId);
                Response responseVal = commonPutMethod(authtok, data1, UPDATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data1.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.updateTenantManField(),responseValidationVariables.updateTenantNonManField(),re.updatetenantfailuremsg,responseVal.asString(),rescode,re.updatetenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 8)
    public void updateTenantAPIManFieldAndNonManFieldAsEmpty() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+UPDATE_TENANT+"' </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject data = vd.dataFull();
                String tenantId = createTenantSpecific(data, getUserIdValue("2", region), region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data1 = updateFullDataManFieldAndNonManFieldAsEmpty(tenantId);
                Response responseVal = commonPutMethod(authtok, data1, UPDATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data1.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                   responsevalidation(responseValidationVariables.updateTenantManField(),responseValidationVariables.updateTenantNonManField(),re.updatetenantmanandnonmanasempty,responseVal.asString(),rescode,re.updatetenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 9)
    public void updateTenantAPIManFieldAsInvalidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+UPDATE_TENANT+"' </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject data = vd.dataFull();
                String tenantId = createTenantSpecific(data, getUserIdValue("2", region), region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data1 = updateFullDataManFieldAsInvalidVal(tenantId);
                Response responseVal = commonPutMethod(authtok, data1, UPDATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data1.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500||responseVal.statusCode()==404) {
                    responsevalidation(responseValidationVariables.updateTenantManField(),responseValidationVariables.updateTenantNonManField(),re.updatetenantmanfieldinvalid,responseVal.asString(),rescode,re.updatetenantmaninvalidrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 10)
    public void updateTenantAPIManFieldNonManFieldAsInvalidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+UPDATE_TENANT+"' </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject data = vd.dataFull();
                String tenantId = createTenantSpecific(data, getUserIdValue("2", region), region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data1 = updateFullDataManFieldAndNonManFieldAsInvalidVal(tenantId);
                Response responseVal = commonPutMethod(authtok, data1, UPDATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data1.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500||responseVal.statusCode()==404) {
                    responsevalidation(responseValidationVariables.updateTenantManField(),responseValidationVariables.updateTenantNonManField(),re.updatetenantmannonmanasinvalid,responseVal.asString(),rescode,re.updatetenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 11)
    public void updateTenantAPIManFieldInValNonManFieldValidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+UPDATE_TENANT+"' </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject data = vd.dataFull();
                String tenantId = createTenantSpecific(data, getUserIdValue("2", region), region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data1 = updateFullDataManFieldInValNonManFieldValidVal(tenantId);
                Response responseVal = commonPutMethod(authtok, data1, UPDATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data1.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500||responseVal.statusCode()==404) {
                    responsevalidation(responseValidationVariables.updateTenantManField(),responseValidationVariables.updateTenantNonManField(),re.updatetenantmaninvalidnonmanvalid,responseVal.asString(),rescode,re.updatetenantmaninvalidrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 12)
    public void updateTenantAPIManFieldValNonManFieldInValidVal() throws IOException, ParseException, ConfigurationException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+UPDATE_TENANT+"' </b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if(flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject data = vd.dataFull();
                String tenantId = createTenantSpecific(data, getUserIdValue("2", region), region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data1 = updateFullDataManFieldValNonManFieldInValidVal(tenantId);
                Response responseVal = commonPutMethod(authtok, data1, UPDATE_TENANT);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data1.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500||responseVal.statusCode()==404) {
                    responsevalidation(responseValidationVariables.updateTenantManField(),responseValidationVariables.updateTenantNonManField(),re.updatetenantmanvalidnonmaninvalid,responseVal.asString(),rescode,re.updatetenantrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

  // add group api
  @Test(priority = 13)
  public void tenantAdminAddGroupAPIManFieldAsEmpty() throws IOException, ParseException, ConfigurationException, InterruptedException {
      test.info("*** Testing API URI <b>'"+uriValue+"/"+ADD_GROUP+"' </b> ***");
      for (int i = 0; i < usersForTesting.size(); i++) {
          String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
          if (flagVal.equalsIgnoreCase("Allowed")) {
              String tenantId = tenantIDVal(region);
              authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
              JSONObject data=dataAdd_GroupManAsEmpty(tenantId);
              System.out.println(data.toString());
              Response responseVal = commonPostMethod(authtok, data, ADD_GROUP);
              String rescode= String.valueOf(responseVal.statusCode());
              payLoadVal = data.toString();
              if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                   responsevalidation(responseValidationVariables.addGroupManField(),null,re.addgroupfailuremsg,responseVal.asString(),rescode,re.addgroupmanfieldrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
              }
          }
      }
      test.info("*******************EndOfTest*******************");
  }
    @Test(priority = 14)
    public void tenantAdminAddGroupAPIManFieldAsInvalidVal() throws IOException, ParseException, ConfigurationException, InterruptedException {
        test.info("*** Testing API URI <b>'"+uriValue+"/"+ADD_GROUP+"' </b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data=dataAdd_GroupManFieldAsInvalidVal(tenantId);
                System.out.println(data.toString());
                Response responseVal = commonPostMethod(authtok, data, ADD_GROUP);
                String rescode= String.valueOf(responseVal.statusCode());
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.addGroupManField(),null,re.addgroupmanfieldinvalidval,responseVal.asString(),rescode,re.addgroupmanfieldrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
           //update group
           @Test(priority = 15)
           public void tenantAdminUpdateGroupAPIManFieldAsEmpty() throws IOException, ParseException {
               test.info("*** Testing API URI<b>'"+uriValue+"/"+UPDATE_GROUP+"'</b> ***");
               for(int i=0;i<usersForTesting.size();i++) {
                   String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
                   if (flagVal.equalsIgnoreCase("Allowed")) {
                       String tenantId = tenantIDVal(region);
                       authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                       headers = headersVal(authtok);
                       JSONObject dataAddGrp = vd.dataAdd_Group(tenantId);
                       commonPostMethod(authtok, dataAddGrp, ADD_GROUP);
                       String oldGrpName = dataAddGrp.get("group").toString();
                       JSONObject dataUpdateGrp = dataUpdate_GroupManAsEmpty(tenantId, oldGrpName);
                       Response responseVal = commonPutMethod(authtok, dataUpdateGrp, UPDATE_GROUP);
                       String rescode= String.valueOf(responseVal.statusCode());
                       apiEndPointValue = uriValue + "/" + UPDATE_GROUP;
                       requestTypeVal = "PUT";
                       payLoadVal = dataUpdateGrp.toString();
                       if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                           responsevalidation(responseValidationVariables.updateGroupManField(),null,re.updategroupfailuremsg,responseVal.asString(),rescode,re.updategrouprescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));

                       }
                   }
               }
               test.info("*******************EndOfTest*******************");
           }
    @Test(priority = 16)
    public void tenantAdminUpdateGroupAPIManFieldAsInvalidVal() throws IOException, ParseException {
        test.info("*** Testing API URI<b>'"+uriValue+"/"+UPDATE_GROUP+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                headers = headersVal(authtok);
                JSONObject dataAddGrp = vd.dataAdd_Group(tenantId);
                commonPostMethod(authtok, dataAddGrp, ADD_GROUP);
                String oldGrpName = dataAddGrp.get("group").toString();
                JSONObject dataUpdateGrp = dataUpdate_GroupManAsInvalidVal(tenantId, oldGrpName);
                Response responseVal = commonPutMethod(authtok, dataUpdateGrp, UPDATE_GROUP);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + UPDATE_GROUP;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateGrp.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.updateGroupManField(),null,re.updategroupmanfieldinvalid,responseVal.asString(),rescode,re.updategrouprescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
   //save notification api

    @Test(priority = 17)
    public void tenantAdminSaveNotificationsAPINonManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI <b>'"+uriValue+"/"+TENANTID_SAVE_NOTIFICATION+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                RestAssured.baseURI = uriValue;
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                headers = headersVal(authtok);
                JSONObject dataSaveNotifications = dataSaveNotificationsNotManAsEmpty(getUserIdValue("5", region));
                String apiEndPointVal="tenantAdmin/tenants/" + tenantId + "/saveNotificationSettings";
                Response responseVal = commonPostMethod(authtok, dataSaveNotifications,apiEndPointVal );
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/saveNotificationSettings";
                requestTypeVal = "POST";
                payLoadVal = dataSaveNotifications.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(null,responseValidationVariables.saveNotificationNonManField(),re.savenotificationnonmanempty,responseVal.asString(),rescode,re.savenotificationrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 18)
    public void tenantAdminSaveNotificationsNonManFieldInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI <b>'"+uriValue+"/"+TENANTID_SAVE_NOTIFICATION+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                RestAssured.baseURI = uriValue;
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                headers = headersVal(authtok);
                JSONObject dataSaveNotifications = dataSaveNotificationsNotManInvalidVal(getUserIdValue("5", region));
                String apiEndPointVal="tenantAdmin/tenants/" + tenantId + "/saveNotificationSettings";
                Response responseVal = commonPostMethod(authtok, dataSaveNotifications,apiEndPointVal );
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/saveNotificationSettings";
                requestTypeVal = "POST";
                payLoadVal = dataSaveNotifications.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(null,responseValidationVariables.saveNotificationNonManField(),re.savenotificationnonmaninvalid,responseVal.asString(),rescode,re.savenotificationrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    //update plugin status
    @Test(priority = 19)
    public void tenantAdminUpdatePluginStatusAPIInvalidVal() throws IOException,ParseException{

        test.info("*** Testing API URI<b> '"+uriValue+"/"+UPDATE_PLUGIN_STATUS+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject updatePluginstatus = update_Plugin_statusAsInvalid(tenantId);
                Response responseVal = commonPostMethod(authtok, updatePluginstatus, UPDATE_PLUGIN_STATUS);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + UPDATE_PLUGIN_STATUS;
                requestTypeVal = "POST";
                payLoadVal = updatePluginstatus.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(null,null,re.updatepluginstatus,responseVal.asString(),rescode,re.updatepluginstatusrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 20)
    public void tenantAdminUpdatePluginStatusAPIAsEmptyVal() throws IOException,ParseException{

        test.info("*** Testing API URI<b> '"+uriValue+"/"+UPDATE_PLUGIN_STATUS+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject updatePluginstatus = update_Plugin_statusAsEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, updatePluginstatus, UPDATE_PLUGIN_STATUS);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + UPDATE_PLUGIN_STATUS;
                requestTypeVal = "POST";
                payLoadVal = updatePluginstatus.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(null,null,re.updatepluginstatusempty,responseVal.asString(),rescode,re.updatepluginstatusrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    // fetch kpi

    @Test(priority = 21)
    public void tenantAdminTenantFetchKpiAPIManFieldAsEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANT_FETCHKPI+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String tenantId = tenantIDVal(region);
                JSONObject datafetchTenantKPI = datafetchKPIManEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, datafetchTenantKPI, TENANT_FETCHKPI);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + TENANT_FETCHKPI;
                requestTypeVal = "POST";
                payLoadVal = datafetchTenantKPI.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.fetchKpiManField(),null,re.fetchkpifailuremsg,responseVal.asString(),rescode,re.fetchkpirescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 22)
    public void tenantAdminTenantFetchKpiAPIManFieldAsInvalid() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANT_FETCHKPI+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String tenantId = tenantIDVal(region);
                JSONObject datafetchTenantKPI = datafetchKPIManAsInvalid(tenantId);
                Response responseVal = commonPostMethod(authtok, datafetchTenantKPI, TENANT_FETCHKPI);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + TENANT_FETCHKPI;
                requestTypeVal = "POST";
                payLoadVal = datafetchTenantKPI.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.fetchKpiManField(),null,re.fetchkpimanfieldasinvalid,responseVal.asString(),rescode,re.fetchkpirescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    // add experience
    @Test(priority = 23)
    public void tenantAdminTenantIdExperiencesAddManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANTID_EXPERIENCESADD+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String tenantId = tenantIDVal(region);
                JSONObject dataAddExperience = dataAddExperienceManAsEmpty();
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantId + "/experiences";
                Response responseVal = commonPostMethod(authtok, dataAddExperience, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/experiences";
                requestTypeVal = "POST";
                payLoadVal = dataAddExperience.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                     responsevalidation(responseValidationVariables.addExperienceManField(),responseValidationVariables.addExperienceNonManField(),re.addexperiencefailuremsg,responseVal.asString(),rescode,re.addexperiencesrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 24)
    public void tenantAdminExperiencesAddManNonManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANTID_EXPERIENCESADD+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String tenantId = tenantIDVal(region);
                JSONObject dataAddExperience = dataAddExperienceManNotManAsEmpty();
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantId + "/experiences";
                Response responseVal = commonPostMethod(authtok, dataAddExperience, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/experiences";
                requestTypeVal = "POST";
                payLoadVal = dataAddExperience.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.addExperienceManField(),responseValidationVariables.addExperienceNonManField(),re.addexpmanandnonmanasempty,responseVal.asString(),rescode,re.addexperiencesrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 25)
    public void tenantAdminExperienceAddManValNonManInValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANTID_EXPERIENCESADD+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String tenantId = tenantIDVal(region);
                JSONObject dataAddExperience = dataAddExperienceManValNonManFieldInValidVal();
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantId + "/experiences";
                Response responseVal = commonPostMethod(authtok, dataAddExperience, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/experiences";
                requestTypeVal = "POST";
                payLoadVal = dataAddExperience.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.addExperienceManField(),responseValidationVariables.addExperienceNonManField(),re.addexpmanvalidnonmaninvalid,responseVal.asString(),rescode,re.addexperiencesrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
   //update experience

    @Test(priority = 26)
    public void tenantAdminExperiencesUpdateAPIManFieldAsEmpty() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANTID_EXPERIENCES_UPDATE+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                experienceIDVal = createExperienceSpecific(getUserIdValue("2", region));
                JSONObject dataUpdateExeperienceVal = dataUpdateExperienceManAsEmpty();
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantId + "/experiences/" + experienceIDVal;
                Response responseVal = commonPutMethod(authtok, dataUpdateExeperienceVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/experiences/" + experienceIDVal;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateExeperienceVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                     responsevalidation(responseValidationVariables.updateExperienceManField(),responseValidationVariables.updateExperienceNonManField(),re.updateexperiencefailuremsg,responseVal.asString(),rescode,re.updateexperiencerescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
                deleteExperienceSpecific(getUserIdValue("2", region), experienceIDVal);
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 27)
    public void tenantAdminExperienceUpdateManNonManEmpty() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANTID_EXPERIENCES_UPDATE+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                experienceIDVal = createExperienceSpecific(getUserIdValue("2", region));
                JSONObject dataUpdateExeperienceVal = dataUpdateExperienceManNotManEmpty();
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantId + "/experiences/" + experienceIDVal;
                Response responseVal = commonPutMethod(authtok, dataUpdateExeperienceVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/experiences/" + experienceIDVal;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateExeperienceVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.updateExperienceManField(),responseValidationVariables.updateExperienceNonManField(),re.updateexpmannonasempty,responseVal.asString(),rescode,re.updateexperiencerescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
                deleteExperienceSpecific(getUserIdValue("2", region), experienceIDVal);
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 28)
    public void tenantAdminExperienceUpdateManValNonManInValVal() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+TENANTID_EXPERIENCES_UPDATE+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                experienceIDVal = createExperienceSpecific(getUserIdValue("2", region));
                JSONObject dataUpdateExeperienceVal = dataUpdateExperienceManValNonManInvalid();
                String apiEndPointVal="tenantAdmin/tenants/"+tenantId+"/experiences/"+experienceIDVal;
                Response responseVal = commonPutMethod(authtok,dataUpdateExeperienceVal,apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantId + "/experiences/" + experienceIDVal;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateExeperienceVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.updateExperienceManField(),responseValidationVariables.updateExperienceNonManField(),re.updateexpmanvalnonmaninvalid,responseVal.asString(),rescode,re.updateexperiencerescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
                deleteExperienceSpecific(getUserIdValue("2", region), experienceIDVal);
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    //save plugin info
    @Test(priority = 29)
    public void tenantAdminSavePluginInfoUpdateManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject dataSavePluginVal = dataSavePluginManAsEmpty(tenantIDVal(region), getUserIdValue("5", region));
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                Response responseVal = commonPostMethod(authtok, dataSavePluginVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                requestTypeVal = "POST";
                payLoadVal = dataSavePluginVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.savePluginInfoManField(),responseValidationVariables.savePluginInfoNonManField(),re.savepluginfailuremsg,responseVal.asString(),rescode,re.saveplugininforescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 30)
    public void tenantSavePluginInfoUpdateManNonManFieEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject dataSavePluginVal = dataSavePluginManNonManAsEmpty(tenantIDVal(region), getUserIdValue("5", region));
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                Response responseVal = commonPostMethod(authtok, dataSavePluginVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                requestTypeVal = "POST";
                payLoadVal = dataSavePluginVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.savePluginInfoManField(),responseValidationVariables.savePluginInfoNonManField(),re.savepluginmannonmanempty,responseVal.asString(),rescode,re.saveplugininforescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }


    @Test(priority = 31)
    public void tenantAdminSavePluginInfoUpdateManFieldInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject dataSavePluginVal = dataSavePluginManAsInvalid(tenantIDVal(region), getUserIdValue("5", region));
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                 Response responseVal = commonPostMethod(authtok, dataSavePluginVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                requestTypeVal = "POST";
                payLoadVal = dataSavePluginVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.saveplugininfoinvalid, responseVal.asString(), rescode, re.saveplugininforescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.saveplugininfoother, responseVal.asString(), rescode, re.saveplugininfootherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 32)
    public void tenantSavePluginInfoUpdateManNonManFieInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject dataSavePluginVal = dataSavePluginManAndNonManAsInvalid(tenantIDVal(region), getUserIdValue("5", region));
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                Response responseVal = commonPostMethod(authtok, dataSavePluginVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                requestTypeVal = "POST";
                payLoadVal = dataSavePluginVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.saveplugininfomannonmaninvalid, responseVal.asString(), rescode, re.saveplugininforescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.saveplugininfoother, responseVal.asString(), rescode, re.saveplugininfootherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 33)
    public void tenantSavePluginInfoUpdateManInValNonManValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject dataSavePluginVal = dataSavePluginManInvalidAndNonManAsvalid(tenantIDVal(region), getUserIdValue("5", region));
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                Response responseVal = commonPostMethod(authtok, dataSavePluginVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                requestTypeVal = "POST";
                payLoadVal = dataSavePluginVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.saveplugininfomaninvalidnonmanvalid, responseVal.asString(), rescode, re.saveplugininforescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.saveplugininfoother, responseVal.asString(), rescode, re.saveplugininfootherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 34)
    public void tenantSavePluginInfoUpdateManValNonManInValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_SYSTEMINFO_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject dataSavePluginVal = dataSavePluginManvalidAndNonManAsinvalid(tenantIDVal(region), getUserIdValue("5", region));
                String apiEndPointVal = "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                Response responseVal = commonPostMethod(authtok, dataSavePluginVal, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "tenantAdmin/tenants/" + tenantIDVal(region) + "/savePluginSystemInfo";
                requestTypeVal = "POST";
                payLoadVal = dataSavePluginVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.savepluginmanvalidnonmaninvalid, responseVal.asString(), rescode, re.saveplugininforescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.savePluginInfoManField(), responseValidationVariables.savePluginInfoNonManField(), re.saveplugininfoother, responseVal.asString(), rescode, re.saveplugininfootherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
   // save instruct builder experience

    @Test(priority = 35)
    public void SaveInstructBuilderExperienceManFieldAsEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String expIDValue = experienceIDVal(region);
                JSONObject saveinstruct = dataSaveInstructExpManAsEmpty(tenantId, expIDValue);
                Response responseVal = commonPostMethod(authtok, saveinstruct, SAVE_INSTRUCTBUILDER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SAVE_INSTRUCTBUILDER;
                requestTypeVal = "POST";
                payLoadVal = saveinstruct.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructfailuremsg, responseVal.asString(), rescode, re.saveinstructbuilderrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructfailuremsgother, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 36)
    public void SaveInstructBuilderExperienceManNonManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String expIDValue = experienceIDVal(region);
                JSONObject saveinstruct = dataSaveInstructExpManNonManEmpty(tenantId, expIDValue);
                Response responseVal = commonPostMethod(authtok, saveinstruct, SAVE_INSTRUCTBUILDER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SAVE_INSTRUCTBUILDER;
                requestTypeVal = "POST";
                payLoadVal = saveinstruct.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmannonmanempty, responseVal.asString(), rescode, re.saveinstructbuilderrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmannonmanemptyother, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 37)
    public void SaveInstructBuilderExperienceManFieldAsInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String expIDValue = experienceIDVal(region);
                JSONObject saveinstruct = dataSaveInstructExpManAsInvalid(tenantId, expIDValue);
                Response responseVal = commonPostMethod(authtok, saveinstruct, SAVE_INSTRUCTBUILDER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SAVE_INSTRUCTBUILDER;
                requestTypeVal = "POST";
                payLoadVal = saveinstruct.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.Saveinstructmaninvalid, responseVal.asString(), rescode, re.saveinstructbuilderrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.Saveinstructmaninvalidother, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 38)
    public void SaveInstructBuilderExperienceManNonManInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String expIDValue = experienceIDVal(region);
                JSONObject saveinstruct = dataSaveInstructExpManNonManInvalid(tenantId, expIDValue);
                Response responseVal = commonPostMethod(authtok, saveinstruct, SAVE_INSTRUCTBUILDER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SAVE_INSTRUCTBUILDER;
                requestTypeVal = "POST";
                payLoadVal = saveinstruct.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmannonmaninvalid, responseVal.asString(), rescode, re.saveinstructbuilderrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        if (responseValidationVariables.saveinstructmannonmaninvalidother.equalsIgnoreCase( responseVal.asString())) {
                            responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmannonmaninvalidother, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                        }else {
                            responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmannonmaninvalidfail, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                        }
                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 39)
    public void SaveInstructBuilderExpManInValNonManValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String expIDValue = experienceIDVal(region);
                JSONObject saveinstruct = dataSaveInstructExpManinvalNonManvalid(tenantId, expIDValue);
                Response responseVal = commonPostMethod(authtok, saveinstruct, SAVE_INSTRUCTBUILDER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SAVE_INSTRUCTBUILDER;
                requestTypeVal = "POST";
                payLoadVal = saveinstruct.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.Saveinstructmaninvalidnonmanvalid, responseVal.asString(), rescode, re.saveinstructbuilderrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.Saveinstructmaninvalidnonmanvalidother, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 40)
    public void SaveInstructBuilderExpManValNonManInValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SAVE_INSTRUCTBUILDER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                String expIDValue = experienceIDVal(region);
                JSONObject saveinstruct = dataSaveInstructExpManValidNonManInvalid(tenantId, expIDValue);
                Response responseVal = commonPostMethod(authtok, saveinstruct, SAVE_INSTRUCTBUILDER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SAVE_INSTRUCTBUILDER;
                requestTypeVal = "POST";
                payLoadVal = saveinstruct.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    if (!rescode.equalsIgnoreCase("403")) {
                        responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmanvalnonmaninvalid, responseVal.asString(), rescode, re.saveinstructbuilderrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        if (responseValidationVariables.saveinstructmannonmaninvalidother.equalsIgnoreCase( responseVal.asString())) {
                            responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmanvalidnonmaninvalidother, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                        }else {
                            responsevalidation(responseValidationVariables.saveInstructBuilderManField(), responseValidationVariables.saveInstructBuilderNonManField(), re.saveinstructmanvalidnonmaninvalidfail, responseVal.asString(), rescode, re.saveinstructbuilderotherrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                        }
                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

// user update user api

    @Test(priority = 41)
    public void userUpdateUserAPIManFieldAsEmpty() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_UPDATEUSER+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject dataUpdateUserVal;
                if (i == 2 || i == 3) {
                    dataUpdateUserVal = dataUpdateUser1ManAsEmpty(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else if (i == 6 || i == 8) {
                    dataUpdateUserVal = dataUpdateUserManAsEmpty(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else {
                    dataUpdateUserVal = dataUpdateUserManAsEmpty(getUserIdValue("8", region));
                }
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal = commonPutMethod(authtok1, dataUpdateUserVal, USER_UPDATEUSER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_UPDATEUSER;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateUserVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.userupdateuserManField(),responseValidationVariables.userupdateusernonManField(),re.updateuserfailuremsg,responseVal.asString(),rescode,re.userupdateuserrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 42)
    public void userUpdateUserAPIManFieldAndNonManFieldAsEmpty() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_UPDATEUSER+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject dataUpdateUserVal;
                if (i == 2 || i == 3) {
                    dataUpdateUserVal = dataUpdateUser1ManNonManAsEmpty(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else if (i == 6 || i == 8) {
                    dataUpdateUserVal = dataUpdateUserManNonManAsEmpty(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else {
                    dataUpdateUserVal = dataUpdateUserManNonManAsEmpty(getUserIdValue("8", region));
                }
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal = commonPutMethod(authtok1, dataUpdateUserVal, USER_UPDATEUSER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_UPDATEUSER;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateUserVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.userupdateuserManField(),responseValidationVariables.userupdateusernonManField(),re.updateusermannonmanempty,responseVal.asString(),rescode,re.userupdateuserrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 43)
    public void userUpdateUserAPIManFieldAsInvalidVal() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_UPDATEUSER+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject dataUpdateUserVal;
                if (i == 2 || i == 3) {
                    dataUpdateUserVal = dataUpdateUser1Maninvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else if (i == 6 || i == 8) {
                    dataUpdateUserVal = dataUpdateUserManInvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else {
                    dataUpdateUserVal = dataUpdateUserManInvalid(getUserIdValue("8", region));
                }
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal = commonPutMethod(authtok1, dataUpdateUserVal, USER_UPDATEUSER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_UPDATEUSER;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateUserVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.userupdateuserManField(),responseValidationVariables.userupdateusernonManField(),re.userupdatemaninvalid,responseVal.asString(),rescode,re.userupdaterescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 44)
    public void userUpdateUserAPIManFieldNonManFieldInvalidVal() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_UPDATEUSER+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject dataUpdateUserVal;
                if (i == 2 || i == 3) {
                    dataUpdateUserVal = dataUpdateUser1ManNonManInvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else if (i == 6 || i == 8) {
                    dataUpdateUserVal = dataUpdateUserManNonManInvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else {
                    dataUpdateUserVal = dataUpdateUserManNonManInvalid(getUserIdValue("8", region));
                }
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal = commonPutMethod(authtok1, dataUpdateUserVal, USER_UPDATEUSER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_UPDATEUSER;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateUserVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {

                    if (responseValidationVariables.userupdatemannonmaninvalid.equalsIgnoreCase(responseVal.asString())) {
                        responsevalidation(responseValidationVariables.userupdateuserManField(), responseValidationVariables.userupdateusernonManField(), re.userupdatemannonmaninvalid, responseVal.asString(), rescode, re.userupdateuserrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.userupdateuserManField(), responseValidationVariables.userupdateusernonManField(), re.userupdatemannonmaninvalidother, responseVal.asString(), rescode, re.userupdateuserrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 45)
    public void userUpdateUserAPIManInValNonManFieldValidVal() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_UPDATEUSER+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject dataUpdateUserVal;
                if (i == 2 || i == 3) {
                    dataUpdateUserVal = dataUpdateUser1ManInvalidNonManvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else if (i == 6 || i == 8) {
                    dataUpdateUserVal = dataUpdateUserManInvalidNonManvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else {
                    dataUpdateUserVal = dataUpdateUserManInvalidNonManvalid(getUserIdValue("8", region));
                }
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal = commonPutMethod(authtok1, dataUpdateUserVal, USER_UPDATEUSER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_UPDATEUSER;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateUserVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.userupdateuserManField(), responseValidationVariables.userupdateusernonManField(), re.userupdatemaninvalidnonmanval, responseVal.asString(), rescode, re.userupdaterescodeother, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 46)
    public void userUpdateUserAPIManValNonManFieldInValidVal() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_UPDATEUSER+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject dataUpdateUserVal;
                if (i == 2 || i == 3) {
                    dataUpdateUserVal = dataUpdateUser1ManvalidNonManinvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else if (i == 6 || i == 8) {
                    dataUpdateUserVal = dataUpdateUserManvalidNonManinvalid(getUserIdValue(usersForTesting.get(i).toString(), region));
                } else {
                    dataUpdateUserVal = dataUpdateUserManvalidNonManinvalid(getUserIdValue("8", region));
                }
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal = commonPutMethod(authtok1, dataUpdateUserVal, USER_UPDATEUSER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_UPDATEUSER;
                requestTypeVal = "PUT";
                payLoadVal = dataUpdateUserVal.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.userupdateuserManField(), responseValidationVariables.userupdateusernonManField(), re.userupdatemanvalnonmaninvalid, responseVal.asString(), rescode, re.userupdateuserrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    //user set feature form

    @Test(priority = 47)
    public void userSetFeatureFormsUpdateAPIManFieldAsEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject setFeature = dataUserSetTeacherForumsManEmpty(getUserIdValue("8", region));
                Response responseVal = commonPostMethod(authtok, setFeature, USER_SETFEATURE_FORMS_UPDATE);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_SETFEATURE_FORMS_UPDATE;
                requestTypeVal = "POST";
                payLoadVal = setFeature.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                     responsevalidation(responseValidationVariables.usersetFeatureManField(),responseValidationVariables.usersetFeaturenonManField(),re.setfeaturefailuremsg,responseVal.asString(),rescode,re.setfeaturerescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 48)
    public void userSetFeatureFormsUpdateManNonManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject setFeature = dataUserSetTeacherForumsManNonManEmpty(getUserIdValue("8", region));
                Response responseVal = commonPostMethod(authtok, setFeature, USER_SETFEATURE_FORMS_UPDATE);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_SETFEATURE_FORMS_UPDATE;
                requestTypeVal = "POST";
                payLoadVal = setFeature.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.usersetFeatureManField(),responseValidationVariables.usersetFeaturenonManField(),re.setfeaturemannonmanempty,responseVal.asString(),rescode,re.setfeaturerescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 49)
    public void userSetFeatureFormsUpdateAPIManFieldAsInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject setFeature = dataUserSetTeacherForumsManInvalid(getUserIdValue("8", region));
                Response responseVal = commonPostMethod(authtok, setFeature, USER_SETFEATURE_FORMS_UPDATE);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_SETFEATURE_FORMS_UPDATE;
                requestTypeVal = "POST";
                payLoadVal = setFeature.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.usersetFeatureManField(),responseValidationVariables.usersetFeaturenonManField(),re.setfeaturemaninvalid,responseVal.asString(),rescode,re.setfeaturerescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 50)
    public void userSetFeatureFormsUpdateManNonManFieInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject setFeature = dataUserSetTeacherForumsManNonManInvalid(getUserIdValue("8", region));
                Response responseVal = commonPostMethod(authtok, setFeature, USER_SETFEATURE_FORMS_UPDATE);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_SETFEATURE_FORMS_UPDATE;
                requestTypeVal = "POST";
                payLoadVal = setFeature.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.usersetFeatureManField(),responseValidationVariables.usersetFeaturenonManField(),re.setfeaturemannonmaninvalid,responseVal.asString(),rescode,re.setfeaturerescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 51)
    public void userSetFeatureFormsUpdateManInValNonManValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+USER_SETFEATURE_FORMS_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject setFeature = dataUserSetTeacherForumsManInvalidNonManvalid(getUserIdValue("8", region));
                Response responseVal = commonPostMethod(authtok, setFeature, USER_SETFEATURE_FORMS_UPDATE);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + USER_SETFEATURE_FORMS_UPDATE;
                requestTypeVal = "POST";
                payLoadVal = setFeature.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.usersetFeatureManField(),responseValidationVariables.usersetFeaturenonManField(),re.setfeaturemaninvalidnonmanvalid,responseVal.asString(),rescode,re.setfeaturerescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

  // secret manager store now secret
  @Test(priority = 52)
  public void secretManagerStoresNowSecretAPIManFieldAsEmpty() throws IOException,ParseException{
      test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_STORE_SECRET+"'</b> ***");
      for (int i = 0; i < usersForTesting.size(); i++) {
          String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
          if (flagVal.equalsIgnoreCase("Allowed")) {
              String tenantId = tenantIDVal(region);
              authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
              JSONObject storeSnowSecret = store_Snow_SecretManAsEmpty(tenantId, region);
              Response responseVal = commonPostMethod(authtok, storeSnowSecret, SECRETMANAGER_STORE_SECRET);
              String rescode= String.valueOf(responseVal.statusCode());
              apiEndPointValue = uriValue + "/" + SECRETMANAGER_STORE_SECRET;
              requestTypeVal = "POST";
              payLoadVal = storeSnowSecret.toString();
              if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                   responsevalidation(responseValidationVariables.secretmanagerstorenowManField(),null,re.storesnowfailuremsg,responseVal.asString(),rescode,re.secretstorenowsecretrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
              }
          }
      }
      test.info("*******************EndOfTest*******************");
  }
    @Test(priority = 53)
    public void secretManagerStoresNowSecretManFieldAsInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_STORE_SECRET+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject storeSnowSecret = store_Snow_SecretManAsInvalid(tenantId, region);
                Response responseVal = commonPostMethod(authtok, storeSnowSecret, SECRETMANAGER_STORE_SECRET);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_STORE_SECRET;
                requestTypeVal = "POST";
                payLoadVal = storeSnowSecret.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==403||responseVal.statusCode()==500) {
                    if (responseValidationVariables.secstorenowmaninvalid.equalsIgnoreCase(responseVal.asString())) {
                        responsevalidation(responseValidationVariables.secretmanagerstorenowManField(), null, re.secstorenowmaninvalid, responseVal.asString(), rescode, re.secretstorenowsecretrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.secretmanagerstorenowManField(), null, re.secstorenowmaninvalidother, responseVal.asString(), rescode, re.secretstorenowsecretrescodeother, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }

                    }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
// secret aws config

    @Test(priority = 54)
    public void secretManagerAwsConfigAPIManFieldAsEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject awsconfig = secret_Aws_ConfigManAsEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, awsconfig, SECRETMANAGER_AWSCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_AWSCONFIG;
                requestTypeVal = "POST";
                payLoadVal = awsconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.secretawsconfigManField(),responseValidationVariables.secretawsconfignonManField(),re.awsconfigfailuremsg,responseVal.asString(),rescode,re.secretawsrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 55)
    public void secretManagerAwsConfigAPIManNonManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject awsconfig = secret_Aws_ConfigManNonManAsEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, awsconfig, SECRETMANAGER_AWSCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_AWSCONFIG;
                requestTypeVal = "POST";
                payLoadVal = awsconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.secretawsconfigManField(),responseValidationVariables.secretawsconfignonManField(),re.secretawsmannonmanempty,responseVal.asString(),rescode,re.secretawsrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 56)
    public void secretManagerAwsConfigAPIManFieldAsInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject awsconfig = secret_Aws_ConfigManInvalid(tenantId);
                Response responseVal = commonPostMethod(authtok, awsconfig, SECRETMANAGER_AWSCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_AWSCONFIG;
                requestTypeVal = "POST";
                payLoadVal = awsconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==403) {
                    if(responseValidationVariables.secretawsmaninvalid.equalsIgnoreCase(responseVal.asString())) {
                        responsevalidation(responseValidationVariables.secretawsconfigManField(), responseValidationVariables.secretawsconfignonManField(), re.secretawsmaninvalid, responseVal.asString(), rescode, re.secretawsrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.secretawsconfigManField(), responseValidationVariables.secretawsconfignonManField(), re.secretawsmaninvalidother, responseVal.asString(), rescode, re.secretawsrescodeother, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 57)
    public void secretManagerAwsConfigAPIManNonManInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject awsconfig = secret_Aws_ConfigManNonManInvalid(tenantId);
                Response responseVal = commonPostMethod(authtok, awsconfig, SECRETMANAGER_AWSCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_AWSCONFIG;
                requestTypeVal = "POST";
                payLoadVal = awsconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==403) {
                        responsevalidation(responseValidationVariables.secretawsconfigManField(), responseValidationVariables.secretawsconfignonManField(), re.secretawsmannonmaninvalid, responseVal.asString(), rescode, re.secretawsrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 58)
    public void secretManagerAwsConfigManInValNonManValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject awsconfig = secret_Aws_ConfigManinvalNonManvalid(tenantId);
                Response responseVal = commonPostMethod(authtok, awsconfig, SECRETMANAGER_AWSCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_AWSCONFIG;
                requestTypeVal = "POST";
                payLoadVal = awsconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==403) {
                    if (responseValidationVariables.secretmaninvalidnonmanval.equalsIgnoreCase(responseVal.asString())) {
                        responsevalidation(responseValidationVariables.secretawsconfigManField(), responseValidationVariables.secretawsconfignonManField(), re.secretmaninvalidnonmanval, responseVal.asString(), rescode, re.secretawsrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                    }else {
                        responsevalidation(responseValidationVariables.secretawsconfigManField(), responseValidationVariables.secretawsconfignonManField(), re.secretmaninvalidnonmanvalother, responseVal.asString(), rescode, re.secretawsrescodeother, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                    }

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 59)
    public void secretManagerAwsConfigManValNonManInValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_AWSCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject awsconfig = secret_Aws_ConfigManvalNonManinvalid(tenantId);
                Response responseVal = commonPostMethod(authtok, awsconfig, SECRETMANAGER_AWSCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_AWSCONFIG;
                requestTypeVal = "POST";
                payLoadVal = awsconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==403) {
                    responsevalidation(responseValidationVariables.secretawsconfigManField(), responseValidationVariables.secretawsconfignonManField(), re.secretawsmanvalnonmaninval, responseVal.asString(), rescode, re.secretawsrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
/// secret sfdc config


    @Test(priority = 60)
    public void secretManagerSfdcConfigAPIManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_SFDCCCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject sfdcconfig = secret_Sfdc_ConfigManEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, sfdcconfig, SECRETMANAGER_SFDCCCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_SFDCCCONFIG;
                requestTypeVal = "POST";
                payLoadVal = sfdcconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.secretsfdcconfignManField(),null,re.sfdcconfigfailuremsg,responseVal.asString(),rescode,re.secretsfdcrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 61)
    public void secretManagerSfdcConfigAPIManFieldInvalid() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SECRETMANAGER_SFDCCCONFIG+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject sfdcconfig = secret_Sfdc_ConfigManInvalid(tenantId);
                Response responseVal = commonPostMethod(authtok, sfdcconfig, SECRETMANAGER_SFDCCCONFIG);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SECRETMANAGER_SFDCCCONFIG;
                requestTypeVal = "POST";
                payLoadVal = sfdcconfig.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {

                 if(responseValidationVariables.secretsfdcmaninvalid.equalsIgnoreCase(responseVal.asString())) {
                     responsevalidation(responseValidationVariables.secretsfdcconfignManField(), null, re.secretsfdcmaninvalid, responseVal.asString(), rescode, re.secretsfdcrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));
                 }else{
                     responsevalidation(responseValidationVariables.secretsfdcconfignManField(), null, re.secretsfdcmaninvalidother, responseVal.asString(), rescode, re.secretsfdcrescodeother, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                 }

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    //session fetch session

    @Test(priority = 62)
    public void sessionsTenantFetchSessionsAPINonManEmpty() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SESSIONS_TENANT_FETCH+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject sessionfetch = dataSessionsGuestNonManEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, sessionfetch, SESSIONS_TENANT_FETCH);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SESSIONS_TENANT_FETCH;
                requestTypeVal = "POST";
                payLoadVal = sessionfetch.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                         responsevalidation(null, responseValidationVariables.sessionfetchsessionnonManField(), re.sessionfetchsession, responseVal.asString(), rescode, re.sessionfetchsessionrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 63)
    public void sessionsTenantFetchSessionsAPINonManInvalid() throws IOException, ParseException {
        test.info("*** Testing API URI<b> '"+uriValue+"/"+SESSIONS_TENANT_FETCH+"'</b> ***");
        for(int i=0;i<usersForTesting.size();i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject sessionfetch = dataSessionsGuestNonManInValid(tenantId);
                Response responseVal = commonPostMethod(authtok, sessionfetch, SESSIONS_TENANT_FETCH);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + SESSIONS_TENANT_FETCH;
                requestTypeVal = "POST";
                payLoadVal = sessionfetch.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    responsevalidation(null, responseValidationVariables.sessionfetchsessionnonManField(), re.sessionfetchsessionnonmaninvalid, responseVal.asString(), rescode, re.sessionfetchsessionrescode, usersForTesting.get(i).toString(), test, payLoadVal, responseVal, rolesAllowedInfo(currentMethodName));

                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
// auth login

    @Test(priority = 64)
    public void authLoginManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI <b>'"+uriValue+"/"+AUTH_LOGIN+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject requestParams = new JSONObject();
                requestParams.put("email","");
                requestParams.put("password","");
                String apiEndPointVal = "/auth/login";
                Response responseVal = commonPostMethod(authtok, requestParams, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + AUTH_LOGIN;
                requestTypeVal = "POST";
                payLoadVal = requestParams.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                     responsevalidation(responseValidationVariables.authloginManField(),null,re.authloginfailuremsg,responseVal.asString(),rescode,re.authloginrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 65)
    public void authLoginManFieldInvalid() throws IOException,ParseException{
        test.info("*** Testing API URI <b>'"+uriValue+"/"+AUTH_LOGIN+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject requestParams = new JSONObject();
                requestParams.put("email", "xyz@zyx.com");
                requestParams.put("password","567dc");
                String apiEndPointVal = "/auth/login";
                Response responseVal = commonPostMethod(authtok, requestParams, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + AUTH_LOGIN;
                requestTypeVal = "POST";
                payLoadVal = requestParams.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    responsevalidation(responseValidationVariables.authloginManField(),null,re.authloginmaninvalid,responseVal.asString(),rescode,re.authloginrescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
   //auth refresh token

    @Test(priority = 66)
    public void authRefreshTokenManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+AUTH_REFRESH_TOKEN+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject requestParams = new JSONObject();
                requestParams.put("email", getUserIdValue(usersForTesting.get(i).toString(), region));
                requestParams.put("password", passwordVal(region));
                String apiEndPointVal = "/auth/login";
                Response response = commonPostMethod(authtok, requestParams, apiEndPointVal).then().extract().response();
                authtok = response.jsonPath().getString("token.idToken");
                String refreshtok = response.jsonPath().getString("token.refreshToken");
                JSONObject data = dataAuthRefreshManEmpty(refreshtok);
                Response responseVal = commonPostMethod(authtok, data, AUTH_REFRESH_TOKEN);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + AUTH_REFRESH_TOKEN;
                requestTypeVal = "POST";
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.authrefreshtokenManField(),null,re.refreshtokenfailuremsg,responseVal.asString(),rescode,re.authrefreshtokenrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 67)
    public void authRefreshTokenManFieldInvalid() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+AUTH_REFRESH_TOKEN+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                JSONObject requestParams = new JSONObject();
                requestParams.put("email", getUserIdValue(usersForTesting.get(i).toString(), region));
                requestParams.put("password", passwordVal(region));
                String apiEndPointVal = "/auth/login";
                Response response = commonPostMethod(authtok, requestParams, apiEndPointVal).then().extract().response();
                authtok = response.jsonPath().getString("token.idToken");
                String refreshtok = response.jsonPath().getString("token.refreshToken");
                JSONObject data = dataAuthRefreshManInvalid(refreshtok);
                Response responseVal = commonPostMethod(authtok, data, AUTH_REFRESH_TOKEN);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + AUTH_REFRESH_TOKEN;
                requestTypeVal = "POST";
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403) {
                    responsevalidation(responseValidationVariables.authrefreshtokenManField(),null,re.authrefreshtokeninvalid,responseVal.asString(),rescode,re.authrefreshtokenrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    // auth activate user
    @Test(priority = 68)
    public void authActivateUserFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+AUTH_ACTIVATE_USER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data = dataActivateUserEmpty(userIdValue(region));
                Response responseVal = commonPostMethod(authtok, data, AUTH_ACTIVATE_USER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + AUTH_ACTIVATE_USER;
                requestTypeVal = "POST";
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403||responseVal.statusCode()==500) {
                    responsevalidation(null,null,re.authactivateuserempty,responseVal.asString(),rescode,re.authactivateuserrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test(priority = 69)
    public void authActivateUserFieldInvalid() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+AUTH_ACTIVATE_USER+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject data = dataActivateUserInvalid(userIdValue(region));
                Response responseVal = commonPostMethod(authtok, data, AUTH_ACTIVATE_USER);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + AUTH_ACTIVATE_USER;
                requestTypeVal = "POST";
                payLoadVal = data.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==403||responseVal.statusCode()==500) {
                    responsevalidation(null,null,re.authactivateuserinvalid,responseVal.asString(),rescode,re.authactivateuserrescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    // download management save
    @Test(priority = 70)
    public void downloadManagementSaveManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+DOWNLOADMANAGEMENT_SAVE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject downloadsave = download_SaveManEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, downloadsave, DOWNLOADMANAGEMENT_SAVE);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + DOWNLOADMANAGEMENT_SAVE;
                requestTypeVal = "POST";
                payLoadVal = downloadsave.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.downloadmanageManField(),responseValidationVariables.downloadmanageNonManField(),re.downmanagesavefailuremsg,responseVal.asString(),rescode,re.downloadmanasaverescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test(priority = 71)
    public void downloadManagementSaveManNonManFieldEmpty() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+DOWNLOADMANAGEMENT_SAVE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject downloadsave = download_SaveManNonManEmpty(tenantId);
                Response responseVal = commonPostMethod(authtok, downloadsave, DOWNLOADMANAGEMENT_SAVE);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + DOWNLOADMANAGEMENT_SAVE;
                requestTypeVal = "POST";
                payLoadVal = downloadsave.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401) {
                    responsevalidation(responseValidationVariables.downloadmanageManField(),responseValidationVariables.downloadmanageNonManField(),re.downmanagesavemannonmanempty,responseVal.asString(),rescode,re.downloadmanasaverescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    // download mana update
    @Test  (priority = 72)
    public void downloadManagementUpdateManFieldInvalid() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+DOWNLOADMANAGEMENT_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal1 = commonGetMethod(authtok1, DOWNLOADMANAGEMENT_LIST);
                String docIDVal = responseVal1.asString().split("\"")[2];
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject downloadupdate = download_updateManInvalid(tenantId);
                String apiEndPointVal = "downloadManagement/downloads/update/"+docIDVal;
                Response responseVal = commonPostMethod(authtok, downloadupdate, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "downloadManagement/downloads/update/" + docIDVal;
                requestTypeVal = "POST";
                payLoadVal = downloadupdate.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.downloadmanageupdateManField(),responseValidationVariables.downloadmanageupdateNonManField(),re.downloadmanaupdatemaninvalid,responseVal.asString(),rescode,re.downloadmanaupdaterescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }

    @Test  (priority = 73)
    public void downloadManagementUpdateManNonManInvalidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+DOWNLOADMANAGEMENT_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal1 = commonGetMethod(authtok1, DOWNLOADMANAGEMENT_LIST);
                String docIDVal = responseVal1.asString().split("\"")[2];
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject downloadupdate = download_updateManNonManInvalid(tenantId);
                String apiEndPointVal = "downloadManagement/downloads/update/"+docIDVal;
                Response responseVal = commonPostMethod(authtok, downloadupdate, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "downloadManagement/downloads/update/" + docIDVal;
                requestTypeVal = "POST";
                payLoadVal = downloadupdate.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.downloadmanageupdateManField(),responseValidationVariables.downloadmanageupdateNonManField(),re.downloadmanupdatemannonmaninvalid,responseVal.asString(),rescode,re.downloadmanaupdaterescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test  (priority = 74)
    public void downloadManageUpdateManInValNonManValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+DOWNLOADMANAGEMENT_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal1 = commonGetMethod(authtok1, DOWNLOADMANAGEMENT_LIST);
                String docIDVal = responseVal1.asString().split("\"")[2];
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject downloadupdate = download_updateManInvalidNonManvalid(tenantId);
                String apiEndPointVal = "downloadManagement/downloads/update/"+docIDVal;
                Response responseVal = commonPostMethod(authtok, downloadupdate, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "downloadManagement/downloads/update/" + docIDVal;
                requestTypeVal = "POST";
                payLoadVal = downloadupdate.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.downloadmanageupdateManField(),responseValidationVariables.downloadmanageupdateNonManField(),re.downloadmanaupdatemaninvalidnonmanvalid,responseVal.asString(),rescode,re.downloadmanaupdaterescode,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }
    @Test  (priority = 75)
    public void downloadManageUpdateManValNonManInValidVal() throws IOException,ParseException{
        test.info("*** Testing API URI<b> '"+uriValue+"/"+DOWNLOADMANAGEMENT_UPDATE+"'</b> ***");
        for (int i = 0; i < usersForTesting.size(); i++) {
            String flagVal = returnFlag(currentMethodName, getRoleValue(usersForTesting.get(i).toString()));
            if (flagVal.equalsIgnoreCase("Allowed")) {
                String tenantId = tenantIDVal(region);
                String authtok1 = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                Response responseVal1 = commonGetMethod(authtok1, DOWNLOADMANAGEMENT_LIST);
                String docIDVal = responseVal1.asString().split("\"")[3];
                authtok = login_api(getUserIdValue(usersForTesting.get(i).toString(), region), passwordVal(region), region);
                JSONObject downloadupdate = download_updateManvalidNonManinvalid(tenantId);
                String apiEndPointVal = "downloadManagement/downloads/update/"+docIDVal;
                Response responseVal = commonPostMethod(authtok, downloadupdate, apiEndPointVal);
                String rescode= String.valueOf(responseVal.statusCode());
                apiEndPointValue = uriValue + "/" + "downloadManagement/downloads/update/" + docIDVal;
                requestTypeVal = "POST";
                payLoadVal = downloadupdate.toString();
                if (responseVal.statusCode()==400||responseVal.statusCode()==401||responseVal.statusCode()==500) {
                    responsevalidation(responseValidationVariables.downloadmanageupdateManField(),responseValidationVariables.downloadmanageupdateNonManField(),re.downloadmanupdatemanvalidnonmaninvalid,responseVal.asString(),rescode,re.downloadmanaupdaterescodeother,usersForTesting.get(i).toString(),test,payLoadVal,responseVal,rolesAllowedInfo(currentMethodName));
                }
            }
        }
        test.info("*******************EndOfTest*******************");
    }





}


