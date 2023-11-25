package org.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVWriter;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class commonMethods {
    public final String BASE_URI = System.getProperty("domain");
    public final String jsonPathVal= System.getProperty("user.dir")+"\\src\\test\\resources\\inputJSONFiles\\inputValues.json";
    public final String IMPORT_USER = "tenantAdmin/users/importUsers";
    public final String BULKEDIT_USERS = "tenantAdmin/users/bulkEditUsers";
    public final String TENANTID_INFO="tenantAdmin/tenants/:tenantId/?GUID=02ff26fb-7d9e-4686-9b28-e970030efed6";
    public final String TENANTID_SAVE_NOTIFICATION="tenantAdmin/tenants/:tenantId/saveNotificationSettings";
    public final String SEARCHUSER_FETCH="tenantAdmin/tenantsGroup/:tenantId/search/:searchString";
    public final String GROUPID_USERS_FETCH="tenantAdmin/tenantsGroup/:tenantId/users/:groupId";
    public final String TENANTID_USERS_AUTHENTICATE="tenantAdmin/tenants/:tenantId/users";
    public final String TENANTID_STARTVALUE_AUTHENTICATE="tenantAdmin/tenantsPaginate/:tenantId/start/:startValue/users";
    public final String SURVEY_TENANTID="tenantAdmin/survey?tenantId=<tenantId>&userType=<userType>";
    public final String UPDATE_PERMISSIONDATA="tenantAdmin/updatePermission";
    public final String TENANTS_UPLOADLOGO="tenantAdmin/tenants/uploadLogo";
    public final String TENANTID_FETCHPLUGIN_LIST="tenantAdmin/tenants/:tenantId/fetchPluginList?GUID=4757c4e0-4a94-4496-a5a4-1164d13cbe33";
    public final String UPDATE_PLUGIN_STATUS="tenantAdmin/updatePluginStatus";
    public final String TENANT_FETCHKPI="tenantAdmin/tenant/fetchKPI";
    public final String TENANTID_EXPERIENCESADD="tenantAdmin/tenants/:tenantId/experiences";
    public final String TENANTID_EXPERIENCES_EXPERIENCEID="tenantAdmin/tenants/:tenantId/experiences/:experienceId";
    public final String TENANTID_EXPERIENCES_EXPERIENCEID_FETCH="tenantAdmin/tenants/:tenantId/experiences/:experienceId/start?guid=27d543b1507f4d3faadf62828a4569ce";
    public final String TENANTID_EXPERIENCES_FETCHALL="tenantAdmin/tenants/:tenantId/experiences";
    public  final String TENANTID_EXPERIENCES_UPDATE="tenantAdmin/tenants/:tenantId/experiences/:experienceId";
    public  final String TENANTID_EXPERIENCES_DELETE="tenantAdmin/tenants/:tenantId/experiences/:experienceId";
    public  final String EXPERIENCEID_ATTACHFILE="tenantAdmin/instructExperience/:experienceId/attachFileToExperience";
    public  final String GETPLUGIN_PLUGINCONFIGURATION_FETCH="tenants/:tenantId/getPluginConfiguration";
    public final String SAVE_SYSTEMINFO_UPDATE="tenants/:tenantId/savePluginSystemInfo";
    public final String SAVE_INSTRUCTBUILDER="tenantAdmin/instructExperience/saveInstructBuilder";
    public final String INSTRUCTBUILDER_EXPERIENCES_FETCH="tenantAdmin/instructExperience/experiences/:experienceId?guid=440c06550bf651b6a1fa527f475a6fbc";
    public final String MESSAGING_GUEST="messaging/guest/5?calltype=guest&roomnumber=8b2c889b-099b-4f41-b1e8-32616ec70c6f&invite=email&param=sanjay.parthasarathy@xerox.com&name=Guest&callername=Udadmins%20Un&callertenantid=TFA5aw9Dc0noZxIW8sTe&guestRegion=AREA_CODE_IN&guestProxy=false&encryption=false&language=en&guestJoinByBrowser=true&guestJoinBySmartGlasses=false&encryption=false&clusterId=V46wbCxFkzXGuaW5";
    public final String MESSAGING_CHANNELNAME=" messaging/rtcToken?channelName=<channelName>&uid=<uid>";
    public final String MESSAGING_CHECKFORUPGRADE="messaging/checkForUpgrade?guid=YwNb6LWI3wRYc7MmZL7x";
    public final String MESSAGING_CHECKURLEXISTS="messaging/checkUrlExists?code=<sessionCode>";
    public final String USER_TENANTSGROUP="user/tenantsGroup";
    public final String USER_FETRCHFAVOURITES="user/:uid/fetchFavorites/start/:startValue/rowsPerPage/:rowsPerPage/?searchString=<searchValue>";
    public final String USER_UPDATEUSER="user/updateUser";
    public final String USER_GETFEATURE_FORMS="user/getFeatureTeacherParms";
    public final String USER_SETFEATURE_FORMS_UPDATE="user/setFeatureTeacherParms";
    public final String USER_REMOVE_USER="user/:userId/removeUser";
    public final String USER_USERINFO="user/userInfo/:uid";
    public final String SECRETMANAGER_STORE_SECRET="secretManager/storeSnowSecret";
    public final String SECRETMANAGER_AWSCONFIG="secretManager/storeAwsConfig";
    public final String SECRETMANAGER_SFDCCCONFIG="secretManager/storeSFDCConfig";
    public final String SESSIONS_FETCH_USER="sessions/fetchSessions/user/:uid/start/:start/rowsPerPage/:rowsPerPage/?searchString=<searchValue>";
    public final String SESSIONS_TENANT_FETCH="sessions/tenant/fetchSessions";
    public final String SESSIONS_RECORDING_START="sessions/:sessionId/recording/start";
    public final String SESSIONS_RECORDING_STOP="sessions/:sessionId/recording/stop";
    public final String SESSIONS_RECORDING_UPDATELAYOUT="sessions/:sessionId/recording/updateLayout";
    public final String SESSIONS_UPLOAD_SNAPSHOT="sessions/user/:uid/uploadSnapshot?isSnapshot=<booleanValue>&sessionId=<sessionId>";
    public final String SESSIONS_UPLOAD_IMAGE="sessions/user/:uid/uploadImage?isSnapshot=<booleanValue>&sessionId=<sessionId>";
    public final String SESSIONS_GUEST_PARTICIPANTS="sessions/get/guestParticipantNumber/?sessionId=<sessionId>";
    public final String  AUTH_LOGIN="auth/login";
    public final String AUTH_LOGOUT="auth/logout";
    public final String AUTH_REFRESH_TOKEN="auth/refreshToken";
    public final String AUTH_ACTIVATE_USER="auth/activateUser";
    public final String AUTH_REGISTER_USER="auth/registerUser";
    public final String AUTH_CHANGE_PSWD="/auth/changePasswordEmail";
    public final String AUTH_FETCHCHECK_TOKEN="auth/fetchAppCheckToken";
    public final String AUTH_FETCHSUPER_USERS="auth/fetchSuperUsers";
    public final String AISERVICES_AUTH_TENANTID="aiServices/auth/:authType/tenant/:tenantId";
    public final String LOOKUP_QUANTPART="lookup/quantEntangPart?email=<email>";
    public final String DOWNLOADMANAGEMENT_SAVE="downloadManagement/downloads/save";
    public final String DOWNLOADMANAGEMENT_UPDATE="downloadManagement/downloads/update/{{downloaderDocId}}";
    public final String DOWNLOADMANAGEMENT_LIST="downloadManagement/downloads/list";
    public final String DOWNLOADMANAGEMENT_DOCI_ID="downloadManagement/downloads/{{downladerDociId}}";
    public final String REMOVE_DOWNLODED_DOCID=":docId/removeDownload";
    public final String TRENANTADMIN_FETCH_KPIBUILDER_DATA="tenantAdmin/tenant/:tenantId/fetchBuilderKPI?surveyId=<surveyId>";
    public final String GET_TENANT_PURCHASEHISTORY="tenantAdmin/tenants/:tenantId/getPurchaseHistory";
    public final String TENANT_SURVEY_DELETE="tenantAdmin/tenants/:tenant/survey/:surveyId";
    public final String GOOGLETRANSLATION="tenantAdmin/instructExperience/googleTranslationInBulk";
    public final String COPYSTORAGEDATA="tenantAdmin/instructExperience/copyStorageData";
    public final String UPDATEDEFAULTLANGUAGE="tenantAdmin/instructExperience/tenants/:tenantId/experiences/:experiencesId/version/:version/languageCode/:languageCode";
    public final String DELETEINSTRUCTLANGUAGE="tenantAdmin/instructExperience/tenants/:tenantId/experiences/:experiencesId/version/:version/languageCode/:languageCode";

    public final String DOWNLOADMANAGEMENT_DELETE="downloadManagement/Mnf11gvoiGRr9z9i9p0K/removeDownload";
    public final String FETCH_INSTRUCTBUILDER="tenantAdmin/instructExperience/experiences/:experienceId?guid=440c06550bf651b6a1fa527f475a6fbc";
    public final String GET_AISERVICE_CONFIG = "tenantManagement/getAIServiceConfig";
    public final String SAVE_AISERVICE_CONFIG_FETCH = "tenantManagement/saveAIServiceConfig";
    public final String SAVE_AISERVICE_CONFIG_UPDA = "tenantManagement/saveAIServiceConfig";
    public final String ADD_GROUP = "tenantAdmin/groups/addGroup";
    public final String UPDATE_GROUP = "tenantAdmin/groups/updateGroup";
    public final String  REMOVE_GROUP= "tenantAdmin/groups/removeGroup";
    public final String CREATE_TENANT = "tenantManagement/createTenant";
    public final String REAL_DELETE_TENANT = "tenantManagement/realDeleteTenant/";
    public final String FETCH_TENANT = "tenantManagement/fetchTenant/";
    public final String UPDATE_TENANT = "tenantManagement/updateTenant";
    public final String UPDATE_TENANT_AI_CONFIG = "tenantManagement/saveAIServiceConfiguration";
    public final String DELETE_TENANT = "tenantManagement/deleteTenant/";

    public final String SAVE_AISERVICE_CONFIGURATION = "tenantManagement/saveAIServiceConfiguration";
    public final String FETCH_TENANT_WITHAIENABLED = "tenantManagement/fetchTenants?aiEnabled=true";
    public final String CREATE_SUCCESS_MESSAGE = "Successfully created the apiTestCases Admin and sent the Initial Invite Email";
    public final String ADDGROUP_SUCCESS_MESSAGE = "Successfully added the group";

    public final String UPDATE_SUCCESS_MESSAGE = "apiTestCases Updated Successfully";
    public final String DELETE_SUCCESS_MESSAGE = "apiTestCases deleted successfully!";
    public final String CREATE_FAIL_MESSAGE = "Failed to create the tenant data";
    public final String FETCH_FAIL_MESSAGE = "Failed to fetch the tenant data";
    public final String FETCH_FAIL_MESSAGE_AIENABLED = "Failed to fetch the apiTestCases info";
    public final String AISERVICE_CONFIG_FAIL_MESSAGE = "Failed to authenticate the user";
    public final String SAVE_AISERVICE_CONFIG_FAIL_MESSAGE = "Failed to fetch AI Service configuration";
    public final String SAVE_AISERVICE_CONFIG_UPDATE_FAIL_MESSAGE = "Failed to update AI service configuration";
    public  String uriValue;
    public final String UPDATE_FAIL_MESSAGE = "Failed to update the tenant data";
    public final String DELETE_FAIL_MESSAGE = "Failed to delete the tenant data";
    public final String NO_CHANGES_MESSAGE = "No changes were made to the tenant";
    public final String BAD_REQUEST_MESSAGE = "Bad request";
    public final String INVALID_REQUEST_MESSAGE = "Invalid Request";
    public final String FORBIDDEN_MESSAGE = "Forbidden";
    public final String UNAUTHORIZED_MESSAGE = "Unauthorized";
    public final String ALREADY_EXISTS_ERROR = "The Email address is already in use by another account";
    public JSONObject data;
    public final String NUMBERUSERS_FAIL_MESSAGE = "numberUsers should be an integer within 10 to 10000";
    public final String NUMBERVIDEORECORDINGUSERS_FAIL_MESSAGE_1 = "numberVideoRecordingUsers should be less than or equal to numberUsers";
    public final String NUMBERVIDEORECORDINGUSERS_FAIL_MESSAGE_2 = "numberVideoRecordingUsers should be less than or equal to numberUsers";
    public final String INVALID_CUSTOMER_PLAN_1 = "Invalid customerPlan. Valid values are \"core\", \"enterprise\", or \"trial\"";
    public final String INVALID_CUSTOMER_PLAN_2 = "Invalid customerPlan value. Valid values are \"core\", \"enterprise\", or \"trial\"";
    public final String INVALID_CUSTOMER_STATUS_1 = "Invalid customerStatus. Valid values are \"suspended\", \"paying\", \"trial\" or \"pendingDeletion\"";
    public final String INVALID_CUSTOMER_STATUS_2 = "Invalid customerStatus value. Valid values are \"suspended\", \"paying\",\"trial\" or \"pendingDeletion\"";
    public final String DISABLED_FAIL_MESSAGE_1 = "disabled should be a boolean";
    public final String DISABLED_FAIL_MESSAGE_2 = "disabled field should be a boolean";
    public final String ISSERVICENOWCUSTOMER_FAIL_MESSAGE_1 = "isServiceNowCustomer field should be a boolean";
    public final String ISSERVICENOWCUSTOMER_FAIL_MESSAGE_2 = "isServiceNowCustomer should be a boolean";
    public final String INVALID_TIERLEVEL = "Invalid Tier Level. Valid values are \"1000\", \"2000\", \"5000\", or \"10000\"";
    public final String INVALID_CREATEDBY = "Invalid createdBy value. Valid values are 'Zuora','Salesforce','AR Enabled Support','Manual'";

    public final String BASIC_LATIN = "!#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    public final String ADMIN_NAME_BASIC_LATIN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy'z";
    public final String EMAIL_BASIC_LATIN_1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public final String EMAIL_BASIC_LATIN_2 = "a_!#&'*+-./=?^_`{|}~a";
    public final String LATIN_SUPPLEMENT = "¡¢£¤¥¦§¨©ª«¬®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ";
    public String experienceIDVal;
    public String currentMethodName;


    public final Integer EMAIL_VALUE = 10000000;
    public final Integer TIME_SLEEP = 20000;
    // TODO remove delays when firebase issue with max number of auth from 1 ip in 1 minute is fixed

    public RequestSpecification requestSpec;

    public List<String> idTenantList = new ArrayList<>();
    public String authtok;

    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter es;
    public static File outPutResultFile;
    public  String requestTypeVal;
    public String payLoadVal;
    public static String csvReportPathVal;
    public String region;
    public org.json.simple.JSONArray usersForTesting;

   // public JSONObject data;
    public JSONObject updateFullData;

    public static Properties prop;
    public CompositeConfiguration config1;
    //public static final Integer EMAIL_VALUE = 10000000;
  //  public static Properties prop;
    public static String propsFolderPath=System.getProperty("user.dir")+"\\src\\test\\resources\\propFiles\\";
    public String propertiesFolderPath=System.getProperty("user.dir")+"\\inputDataPropFiles\\";
    public Map<String, String> headers;

    @BeforeTest
    public void startTest() throws IOException, ParseException {
        region = readProperty("regionVal");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        String reportPath = System.getProperty("user.dir")+"\\reports\\APIAutomation_report_"+region+"_"+timeStamp+".html";
        es=new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(es);
        csvReportPathVal = createCSVFile(region);
        writeToCSVHeaders(csvReportPathVal);
        uriValue=uriVal(region);
        RestAssured.baseURI=uriValue;



    }


    @BeforeMethod
    public void beforeMethodTierup( Method methodName) throws ConfigurationException, IOException, ParseException {
        currentMethodName = methodName.getName();
        test = extent.createTest(currentMethodName);
        this.usersForTesting = usersToTest(jsonPathVal,currentMethodName);
        //test.info("***<b> Starting of "+currentMethodName+" test - "+currentMethodName);
        test.info("*** Starting of <b>"+currentMethodName+"</b> test ***");
    }

    @AfterTest
    public static void endTest()
    {
        extent.flush();
    }

    public  String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.substring(0, 1).toUpperCase() + sb.substring(1).toLowerCase();
    }

    public static String readJSON(String filepath, String find) throws IOException, ParseException {
        String strVal ="";
        try
        {
            org.json.simple.parser.JSONParser jsonParser = new JSONParser();
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(new FileReader(filepath));
            strVal = (String) jsonObject.get(find);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return strVal;

    }


    public static org.json.simple.JSONArray readJSONArray(String inputJSONFileName, String find) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(inputJSONFileName);
        Object obj = jsonParser.parse(reader);
        org.json.simple.JSONObject empjsonobj =(org.json.simple.JSONObject)obj;
        org.json.simple.JSONArray array =(org.json.simple.JSONArray)empjsonobj.get(find);
        return array;

    }

    public static org.json.simple.JSONArray usersToTest(String inputJSONFileName,  String toFind) throws IOException, ParseException {
        org.json.simple.JSONArray array;
        array = readJSONArray( inputJSONFileName, toFind);
        return array;


    }

    public static String getRoleValue(String userName) throws IOException, ParseException {
         //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\roles.json";
        String strFilePath = propsFolderPath+"roles.properties";
       // String userNameVal = readJSON(strFilePath,userName) ;
      //  String userNameVal = readPropertyVal(strFilePath,userName);
        String userNameVal = readPropertyVal(strFilePath,userName);
        return userNameVal;

    }
    public static String getUserIdValue(String userName, String region) throws IOException, ParseException {

        String keyName=region+userName;
        //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\userNames.json";
        String strFilePath = propsFolderPath+"userNames.properties";
       // String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;

    }





    public static String experienceIDVal(String region) throws IOException, ParseException {
        String keyName=region;
        //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\experienceid.json";
        String strFilePath = propsFolderPath+"experienceid.properties";
        // String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }
    public static String experienceIDValInteSearchOptionUsed(String region) throws IOException, ParseException {
        String keyName=region;
        //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\experienceid.json";
        String strFilePath = propsFolderPath+"experienceidintesearchoptionused.properties";
        // String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }
    public static String experienceIDValInteSearchOptionNotUsed(String region) throws IOException, ParseException {
        String keyName=region;
        //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\experienceid.json";
        String strFilePath = propsFolderPath+"experienceidintesearchoptionnotused.properties";
        // String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }

   //niz
   public static String SurveyIDVal(String region) throws IOException, ParseException {
       String keyName=region;
       //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\surveyID.json";
       String strFilePath = propsFolderPath+"surveyID.properties";
       // String userNameVal = readJSON(strFilePath,keyName) ;
       String userNameVal = readPropertyVal(strFilePath,keyName);
       return userNameVal;
   }
    /*public CompositeConfiguration getCompositeConfigVal(String execPathVal) throws ConfigurationException, org.apache.commons.configuration2.ex.ConfigurationException {
        String mainExecPropPath=execPathVal;
        org.apache.commons.configuration2.builder.fluent.Parameters params = new org.apache.commons.configuration2.builder.fluent.Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(mainExecPropPath));

        Configuration config = builder.getConfiguration();
        CompositeConfiguration config2 = new CompositeConfiguration();
        config2.addConfiguration(new SystemConfiguration());
        config2.addConfiguration(config);
        return config2;
    }*/
    public static String readProperty (String value) throws IOException {
        try {

            // File fi=new File(".\\src\\main\\java\\configuration\\test.properties");
            // FileInputStream fis=new FileInputStream(fi);
            FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\test.properties");
            prop = new Properties();
            //buf = new BufferedReader(new FileReader("./configuration/test.properties"));
            prop.load(reader);
            System.out.println(prop.getProperty(value));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(value);

    }

    public static String readPropertyVal (String propPathValue,String value) throws IOException {
        try {

            // File fi=new File(".\\src\\main\\java\\configuration\\test.properties");
            // FileInputStream fis=new FileInputStream(fi);
            FileReader reader = new FileReader(propPathValue);
            prop = new Properties();
            //buf = new BufferedReader(new FileReader("./configuration/test.properties"));
            prop.load(reader);
            System.out.println(prop.getProperty(value));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(value);

    }

    public static String tenantIDVal(String region) throws IOException, ParseException {
        String keyName=region;
       // String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\tenantIDs.json";
        String strFilePath=propsFolderPath+"tenantIDs.properties";
        //String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal =readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }
    public static String tenantIDValCore(String region) throws IOException, ParseException {
        String keyName=region;
        // String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\tenantIDs.json";
        String strFilePath=propsFolderPath+"tenantIDCore.properties";
        //String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal =readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }

    public static String userIdValue(String region) throws IOException, ParseException {
        String keyName=region;
        //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\userIDs.json";
        String strFilePath=propsFolderPath+"userIDs.properties";
        //String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }
    public static String centralSpaceURI( String region) throws IOException, ParseException {
        String keyName=region;
       // String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\centralURIs.properties";
        String strFilePath = propsFolderPath+"centralURIs.properties";
                // String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }

    public static String passwordVal( String region) throws IOException, ParseException {
        String keyName=region;
        //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\pwds.properties";
        String strFilePath = propsFolderPath+"pwds.properties";
                //String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;

    }

    public static String sessionIDVal(String region) throws IOException, ParseException {
        String keyName=region;
        //String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\sessionIDs.properties";
        String strFilePath = propsFolderPath+"sessionIDs.properties";
        //String userNameVal = readJSON(strFilePath,keyName) ;
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }
//me
public  JSONObject getJsonObjectVal() throws IOException {
    JSONObject requestParams=new JSONObject();
    Iterator<String> keyVals=this.config1.getKeys();
  // int a = config1.getNumberOfConfigurations();
    int iVal =1;
   while (keyVals.hasNext()) {
        String keyVal = keyVals.next();
        if(iVal>=56 && !keyVal.contains("java")) {
            requestParams.put(keyVal, getPropertyVal(keyVal));
        }
        iVal=iVal+1;
    }

    return requestParams;
}
    public  JSONObject getJsonObjectValWithBoolean() throws IOException {
        JSONObject requestParams=new JSONObject();
        Iterator<String> keyVals=config1.getKeys();
        // int a = config1.getNumberOfConfigurations();
        int iVal =1;
        while (keyVals.hasNext()) {
            String keyVal = keyVals.next();
            String putVal="";
            if(iVal>=56) {

                if (getPropertyVal(keyVal).equalsIgnoreCase("true")||getPropertyVal(keyVal).equalsIgnoreCase("false")){
                    requestParams.put(keyVal,getBoolVal(getPropertyVal(keyVal)));
                }else {
                    requestParams.put(keyVal,getPropertyVal(keyVal));
                }
            }
            iVal=iVal+1;
        }

        return requestParams;
    }
 public boolean getBoolVal(String val){
     boolean actVal=false;
     if (val.equalsIgnoreCase("true")){
         actVal=true;
     }else {
         actVal=false;
     }
     return actVal;
 }

    public static JSONObject getJsonObject(String Propertiesfile,Properties set) throws IOException {
        JSONObject requestParams=null;
        Properties setval=null;
        if (set==null)
        {
            setval=null;
        }
       if(setval==null){
           FileReader reader = new FileReader(Propertiesfile);
           prop = new Properties();
           prop.load(reader);
            requestParams = new JSONObject();
           for (Map.Entry<Object, Object> e :prop.entrySet()) {
               Object k = e.getKey();
               Object v = e.getValue();
               if (k instanceof String && v instanceof String) {
                   requestParams.put((String) k, (String) v);
               }
           }
       }else{
           FileReader reader = new FileReader(Propertiesfile);
           prop = new Properties();
           prop.load(reader);
           requestParams = new JSONObject();
           for (Map.Entry<Object, Object> e :prop.entrySet()) {
               Object k = e.getKey();
               Object v = e.getValue();
               if (k instanceof String && v instanceof String) {
                   requestParams.put((String) k, (String) v);
               }
           }
       }
        return requestParams;
    }


    public void setPropFilePath(String propFileName) throws ConfigurationException {
        this.config1=getCompositeConfigVal(propertiesFolderPath+propFileName);

    }

    public String getInputKeyValInOP(Response response,String keyVal)
    {
        String retVal="";
        JsonPath jp = new JsonPath(response.asString());
        retVal=jp.get(keyVal).toString();
        return retVal;
    }

    public void log(String msg) {
        System.out.println(msg);
        test.log(Status.INFO, msg);
    }
    public void logPass(String msg) {
        System.out.println("Pass: "+msg);
        test.log(Status.PASS, msg);
    }

    public void logFail(String msg) {
        try {
            System.out.println(msg);
            test.fail(msg );// failure in extent reports
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void verifyTheOutputData(Response response,String keysToSearchVal,JSONObject dataVal)
    {
        JsonPath jp = new JsonPath(response.asString());
        Map<String, String> applicationsMap = jp.getMap(keysToSearchVal);
        Set<String> applicationKeys = applicationsMap.keySet();
        for(String applicationKey:applicationKeys)
        {
            int iCounter=0;
            if(dataVal.has(applicationKey) && !applicationKey.equalsIgnoreCase("expiryDate")) {
                String actVal = "";
                if(!keysToSearchVal.equalsIgnoreCase(""))
                {
                    actVal = jp.get(keysToSearchVal+"."+applicationKey).toString();
                }
                else
                {
                    actVal = jp.get(applicationKey).toString();
                }
                String expVal=dataVal.get(applicationKey).toString();
                if (actVal.equalsIgnoreCase(expVal)) {
                    logPass("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is matching with actual value from the response i.e.\"" + actVal + "\"");
                } else {
                    logFail("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is NOT matching with actual value from the response i.e. \"" + actVal + "\"");
                }
            }
        }
    }

    public void verifyTheOutputDataList(Response response,String keysToSearchVal,JSONObject dataVal)
    {
        JsonPath jp = new JsonPath(response.asString());
        List<Map<String, String>> applicationsMapTmp = jp.getList(keysToSearchVal);
        Map<String, String> applicationsMap = applicationsMapTmp.get(0);
        Set<String> applicationKeys = applicationsMap.keySet();
        for(String applicationKey:applicationKeys)
        {
            int iCounter=0;
            if(dataVal.has(applicationKey)) {
                String actVal=jp.get(keysToSearchVal+"."+applicationKey).toString().replace("[","").replace("]","");
                String expVal=dataVal.get(applicationKey).toString();
                if (expVal.equalsIgnoreCase(actVal)) {
                    logPass("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is matching with actual value from the response i.e.\"" + actVal + "\"");
                } else {
                    logFail("For the input key \"" + applicationKey + "\" in payload, the expected value i.e \"" + expVal + "\" is NOT matching with actual value from the response i.e. \"" + actVal + "\"");
                }
            }
        }
    }

    public void setDataPropFilePath(String propFileName) throws ConfigurationException {
        this.config1=getCompositeConfigVal(propertiesFolderPath+"\\forDataValidation\\"+propFileName);

    }
    public void setDataPropFilePathNeg(String propFileName) throws ConfigurationException {
        this.config1=getCompositeConfigVal(propertiesFolderPath+"forInputFieldValidation\\"+propFileName);

    }
    public void setPropertyVal(String locatorKey,String valToSet){
        try {
            this.config1.setProperty(locatorKey, valToSet);
        }
        catch(Exception e)
        {
            test.fail("Could not able to set the value for the property key");
        }
    }

    public static boolean datawithbooleanvalues(boolean str){
        boolean b1 = Boolean.valueOf(str);
        return b1;
    }

    public String getPropertyVal(String locatorKey){
        String propertyVal="";
        try {
            propertyVal=config1.getProperty(locatorKey).toString();
        }
        catch(Exception ignored)
        {
            System.out.println("Could not able to get the value for the property key for the key \""+locatorKey+"\"");
        }
        return propertyVal;
    }

    public static String uriVal(String region) throws IOException, ParseException {
        String keyName=region;
        String strFilePath = propsFolderPath+"uris.properties";
        String userNameVal = readPropertyVal(strFilePath,keyName);
        return userNameVal;
    }
    public String login_api(String emailid, String password,String region) throws IOException, ParseException {


        RestAssured.baseURI =uriVal(region);
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", emailid);
        requestParams.put("password", password);
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post("/auth/login")
                .then()
                .extract().response();
        //   Assertions.assertEquals(200, response.statusCode());
        String tok = response.jsonPath().getString("token.idToken");
        return tok;


    }

    public Map<String, String> headersVal(String authtok) {
        Map<String, String> headers1 = new HashMap<>();
        headers1.put("Content-Type", "application/json");
        headers1.put("Authorization", "Bearer " + authtok);
        return  headers1;
    }

    public String createTenantFromProp(String userName,String pwd,String regionVal) throws IOException, ParseException, ConfigurationException {
        String authtok = login_api(userName, pwd, regionVal);
        setDataPropFilePath("createPlatformTypeTenant.properties");
        setPropertyVal("tenantAdminEmail","automation"+getAlphaNumericString(5)+"@gmail.com");
        JSONObject data = getJsonObjectVal();
        Response responseVal=commonPostMethod(authtok,data,"tenantManagement/createTenant");
        String tenantId=getInputKeyValInOP(responseVal,"tenantId");
        return tenantId;
    }

    public  Response commonPostMethod(String authtok, JSONObject payload, String apiEndPoint) throws IOException, ParseException {
       /* headers=headersVal(authtok);
        Response responseVal = given().headers(headers)
                .body(payload.toString())
                .when()
                .post(apiEndPoint);
        return responseVal;*/
        Response responseVal=null;
        String payloadVal="NotEmpty";
        if (payload==null)
        {
            payloadVal="";
        }
        headers=headersVal(authtok);

        if(!payloadVal.equalsIgnoreCase("")) {
            responseVal = given().headers(headers)
                    .body(payload.toString())
                    .when()
                    .post(apiEndPoint);

        }else{
            responseVal = given().headers(headers)
                    .when()
                    .post(apiEndPoint);
        }
        return responseVal;
    }

   public Properties setPropertiesCreate() throws IOException {
       LocalDate date = LocalDate.now();
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
       String date1 = formatter.format(date);
       InputStream input = new FileInputStream(propsFolderPath+"createTenant.properties");
       Properties prop= new Properties();
       prop.load(input);
       OutputStream output = new FileOutputStream(propsFolderPath+"createTenant.properties");
       prop.setProperty("contractEffectiveDate",date1);
       prop.setProperty("tenantAdminEmail","automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
       prop.setProperty("tenantAdminFirstName",getAlphaNumericString(10));
       prop.setProperty("tenantAdminLastName",getAlphaNumericString(10));
      /* prop.setProperty(d,date1);
       prop.setProperty(e,"automation" + Math.round(Math.random() * EMAIL_VALUE) + "@xerox.com");
       prop.setProperty(fn,getAlphaNumericString(10));
       prop.setProperty(ln,getAlphaNumericString(10));*/
       prop.store(output,null);

       return prop;
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



    public String createExperienceSpecific(String userName) throws IOException, ParseException {
        //System.out.println("\n*****Create apiTestCases ******\n");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        String region= readProperty("regionVal");

        RestAssured.baseURI = uriValue;
        // login_api(userName, "Testing1",region);
        login_api(userName, passwordVal(region),region);

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

    public  Response commonGetMethod(String authtok, String apiEndPoint) throws IOException, ParseException {
        // RestAssured.baseURI=uriValue;
        // Map<String, String> headers = new HashMap<>();
        // headers.put("Authorization", "Bearer " + authtok);
        headers=headersVal(authtok);
        Response responseVal = given().headers(headers)
                .when()
                .get(apiEndPoint);
        return responseVal;

    }

    public  Response commonPutMethod( String authtok, JSONObject payload, String apiEndPoint ) throws IOException, ParseException {
        headers=headersVal(authtok);
        Response responseVal = given().headers(headers)
                .body(payload.toString())
                .when()
                .put(apiEndPoint);
        return responseVal;
    }

    public  Response commonDeleteMethod(String authtok,JSONObject payload, String apiEndPoint){
        Response responseVal=null;
        String payloadVal="NotEmpty";
        if (payload==null)
        {
            payloadVal="";
        }
        headers=headersVal(authtok);

        if(!payloadVal.equalsIgnoreCase("")) {
            responseVal = given().headers(headers)
                    .body(payload.toString())
                    .when()
                    .delete(apiEndPoint);

        }else{
            responseVal = given().headers(headers)
                    .when()
                    .delete(apiEndPoint);
        }
        return responseVal;
    }



    public Properties setPropertiesUpdate(String tenantid) throws IOException {
        InputStream input = new FileInputStream(propsFolderPath+"updateTenant.properties");
        Properties prop= new Properties();
        prop.load(input);
        OutputStream output = new FileOutputStream(propsFolderPath+"updateTenant.properties");
        prop.setProperty("tenantId",tenantid);
        prop.setProperty("tenantName",getAlphaNumericString(10));
        prop.setProperty("tenantAdminFirstName",getAlphaNumericString(10));
        prop.setProperty("tenantAdminLastName",getAlphaNumericString(10));
        prop.setProperty("tenantPhysicalAddress",getAlphaNumericString(10));
        prop.setProperty("resellerOfRecord",getAlphaNumericString(10));
        prop.setProperty("customerSuccessManager",getAlphaNumericString(10));
        prop.setProperty("zQuoteID",getAlphaNumericString(10));
        prop.setProperty("referralCode",getAlphaNumericString(10));
        prop.store(output,null);

        return prop;
    }

    //me
    public static String rolesAllowedInfo(String methodName) throws IOException, ParseException {
        String keyName=methodName;
        String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\rolesAllowed.json";
        org.json.simple.JSONArray array = readJSONArray( strFilePath, keyName);
        String strVal = "The allowed roles are: ";
        for (int i = 0; i < array.size(); i++) {
            String strTemp = getRoleValue(array.get(i).toString());
            if(i>0) {
                strVal = strVal + " ; " + strTemp;
            }
            else
            {
                strVal = strVal + strTemp;
            }
        }
        strVal = strVal+". These allowed roles are from the same region(US/EU/CA) and also if applicable from the same tenantid.";
        return strVal;
    }

    public static String returnFlag(String methodName,String roleName) throws IOException, ParseException {
        //fetch the roles allowed for then method and store it in a array
        String flagVal="NotAllowed";
        String strFilePath = System.getProperty("user.dir") +"\\src\\test\\resources\\inputJSONFiles\\rolesAllowed.json";
        org.json.simple.JSONArray array = readJSONArray( strFilePath, methodName);
        for(int i =0;i<array.size();i++)
        {
            if(roleName.equalsIgnoreCase(getRoleValue(array.get(i).toString())))
            {
                flagVal ="Allowed";
                return flagVal;
            }
        }
        return flagVal;
    }

    public static String createCSVFile(String region) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        String reportPath = System.getProperty("user.dir")+"\\reports\\csvReportsForFailures\\APIAutomation_report_"+region+"_"+timeStamp+".csv";

        File csvFileVal = new File(reportPath);
        csvFileVal.createNewFile();
        return  reportPath;
    }
    public static void writeToCSVHeaders(String csvFilePathVal) throws IOException {
        File file = new File(csvFilePathVal);
        FileWriter outputfile = new FileWriter(file,true);
        CSVWriter writer = new CSVWriter(outputfile);
        //Writing data to a csv file
        String line1[] = {"Result", "IsRoleAllowedAsPerConfluence::Allowed,NotAllowed", "IsRoleAllowedActually", "MethodName", "APIEndPoint","userName","Role","Typeofrequest","Payload","ResponseStatusCOde","Response"};
        //Writing data to the csv file
        writer.writeNext(line1);
        //Flushing data from writer to file
        writer.flush();
    }



    public static void validationStatements(String roleVal, ExtentTest test1, String flagValue, Response responseVal, String apiEndPointVal, String userNameVal,String rolesAllowed,String methodNameVal,String typeOfRequest,String payLoadVal,String csvFilePathVal) throws IOException, ParseException {
        String infoStatementVal1 = "-----Start of InfoStatements-----"+"<br>"+"<b>1.</b> Testing for "+commonMethods.getRoleValue(roleVal)+"<br>"+"<b>2.</b> "+rolesAllowed+"<br>"+"-----End of InfoStatements-----";
        if(flagValue.equalsIgnoreCase("allowed")) {
            if (responseVal.statusCode() == 200) {
                test1.info(infoStatementVal1);
                String passTempVal1 = "<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">1. Pass Statement is : </FONT></b> This role i.e. " + commonMethods.getRoleValue(roleVal) + " is allowed as per confluence and in actual response it is showing as allowed <br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.pass(passTempVal1);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Pass", "Confluence - Allowed", "ActualResult - Allowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();

            } else if (responseVal.statusCode() == 201 || responseVal.statusCode() == 202 || responseVal.statusCode() == 203 || responseVal.statusCode() == 204 || responseVal.statusCode() == 205 || responseVal.statusCode() == 206) {
                test1.info(infoStatementVal1);
                String passTempVal2 = "<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">1. Pass Statement is : </FONT></b> This role i.e. " + commonMethods.getRoleValue(roleVal) + " is allowed as per confluence and in actual response it is showing as allowed. <b> Here the response code is other than 200, and in the range of 200 series, hence manual verifcation is needed</b><br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.pass(passTempVal2);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Pass - ManualInterventionReqd", "Confluence - Allowed", "ActualResult - Allowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();

            }
            else{
                test1.info(infoStatementVal1);
                String failStatementVal1 =  "<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">1. Failure Statement is :</FONT></b>  This role i.e. " + commonMethods.getRoleValue(roleVal) + " is allowed as per confluence and in actual response it is showing as NOT allowed<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.fail(failStatementVal1);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Fail", "Confluence - Allowed", "ActualResult - NotAllowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();

            }
        }
        else {
            if(responseVal.statusCode()==200 || responseVal.statusCode() == 201 || responseVal.statusCode() == 202 || responseVal.statusCode() == 203 || responseVal.statusCode() == 204 || responseVal.statusCode() == 205 || responseVal.statusCode() == 206) {
                test1.info(infoStatementVal1);
                String failStatementVal2 = "<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">1. Failure Statement is :</FONT></b>  This role i.e. " + commonMethods.getRoleValue(roleVal) + " is NOT allowed as per confluence and in actual response it is showing as allowed<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.fail(failStatementVal2);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Fail", "Confluence - NotAllowed", "ActualResult - Allowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();


            }
            else
            {
                test1.info(infoStatementVal1);
                String passStatementVal2 =  "<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">1. Pass Statement is : </FONT></b> This role i.e. " + commonMethods.getRoleValue(roleVal) + " is NOT allowed as per confluence and in actual response it is showing as NOT allowed<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.pass(passStatementVal2);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Pass", "Confluence - NotAllowed", "ActualResult - NotAllowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();

            }

        }

    }
    public void responsevalidation(List manfield,List nonmanfield,String Expected ,String Actual ,String expcode,String actcode,String roleVal,ExtentTest test1,String payLoadVal,Response responseVal,String rolesAllowed) throws IOException, ParseException {
        /*for (Object li:manfield) {
            test.info(" <b>Mandatory Fields Are :</b>"+li);
        }*/
        if (manfield==null && nonmanfield==null){
            test.info("<b>Mandatory Field Keys :</b> NA <br><b>NonMandatory Field Keys :</b> NA");
        }else if (manfield==null){
            test.info("<b>NonMandatory Field Keys :</b>"+nonmanfield+" <br><b>Mandatory Field Keys :</b> NA");
        }else if (nonmanfield==null ){
            test.info("<b>Mandatory Field Keys :</b>"+manfield+" <br><b> Non Mandatory Field Keys :</b> NA");
        }else{
            test.info("<b>Mandatory Field Keys :</b>"+manfield+"<br><b>NonMandatory Field Keys :</b>"+nonmanfield);
        }

        String infoStatementVal1 ="<b></b>*** Testing for <b>"+commonMethods.getRoleValue(roleVal)+" - Input Field Validation ***</b><br>";
        test1.info(infoStatementVal1);
        String passTempVal1 = "<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">1. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">2. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">3. Response is: </FONT></b>" + responseVal.asString();

        test1.pass(passTempVal1);
             if (expcode.equalsIgnoreCase(actcode)) {
                logPass("<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">4. Actual response code is same as that of expected response code </FONT></b>");
            } else {
                logFail("<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">4. Actual response code is NOT same as that of expected response code </FONT></b>");

            }

            if (Expected.equalsIgnoreCase(Actual)) {
                logPass("<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">5. Actual response is same as that of Expected response </FONT></b>");

            } else {
                logFail("<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">5. Actual response is NOT same as that of Expected response </FONT></b>");

            }



    }

    public static void validationStatementsNegFlow(String roleVal, ExtentTest test1, String flagValue, Response responseVal, String apiEndPointVal, String userNameVal,String rolesAllowed,String methodNameVal,String typeOfRequest,String payLoadVal,String csvFilePathVal) throws IOException, ParseException {
        String infoStatementVal1 = "-----Start of InfoStatements-----"+"<br>"+"<b>1.</b> Testing for <b>"+commonMethods.getRoleValue(roleVal)+"</b>  <br>"+"<b>2.</b> "+rolesAllowed+"<br>"+"-----End of InfoStatements-----";
        if(flagValue.equalsIgnoreCase("allowed")) {
            if (responseVal.statusCode() == 400) {
                test1.info(infoStatementVal1);
                String passTempVal1 = "<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">1. Pass Statement is : </FONT></b> This role i.e. " + commonMethods.getRoleValue(roleVal) + " is allowed as per confluence and in actual response it is showing as NOT allowed <br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                       +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.pass(passTempVal1);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Pass", "Confluence - Allowed", "ActualResult - NotAllowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();

            } else if (responseVal.statusCode() == 401 || responseVal.statusCode() == 402 || responseVal.statusCode() == 403 || responseVal.statusCode() == 404 || responseVal.statusCode() == 405 || responseVal.statusCode() == 406 || responseVal.statusCode() == 500) {
                test1.info(infoStatementVal1);
                String passTempVal2 = "<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">1. Pass Statement is : </FONT></b> This role i.e. " + commonMethods.getRoleValue(roleVal) + " is allowed as per confluence and in actual response it is showing as <b> NOT </b> allowed <b>i.e : Invalid Payload DATA </b>. <b> Here the response code is other than 400, and in the range of 400 series, hence manual verifcation is needed</b><br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                       +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#FF8C00 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.pass(passTempVal2);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Pass - ManualInterventionReqd", "Confluence - Allowed", "ActualResult - NotAllowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();

            }
            else{
                test1.info(infoStatementVal1);
                String failStatementVal1 =  "<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">1. Failure Statement is :</FONT></b>  This role i.e. " + commonMethods.getRoleValue(roleVal) + " is allowed as per confluence and in actual response it is showing as allowed<br>."
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">2. API Endpoint is : </FONT></b>"+apiEndPointVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">3. Username is : </FONT></b> "+userNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">4. Role Tested is : </FONT></b>"+commonMethods.getRoleValue(roleVal)+"<br>"
                       +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">5. Type of request is : </FONT></b>"+typeOfRequest+"<br>"
                       +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">6. Method name is : </FONT></b>"+methodNameVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">7. BodyORPayload is : </FONT></b>"+payLoadVal+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">8. Response status code is: </FONT></b>" + responseVal.statusCode()+"<br>"
                        +" "+"<b><FONT COLOR=\"#ff0000 \" style=\"font-size:20px\">9. Response is: </FONT></b>" + responseVal.asString();
                test1.fail(failStatementVal1);
                File file = new File(csvFilePathVal);
                FileWriter outputfile = new FileWriter(file,true);
                CSVWriter writer = new CSVWriter(outputfile);
                String line1[] = {"Fail", "Confluence - Allowed", "ActualResult - Allowed", methodNameVal, apiEndPointVal,userNameVal,commonMethods.getRoleValue(roleVal),typeOfRequest,payLoadVal,Integer.toString(responseVal.statusCode()),responseVal.asString()};
                writer.writeNext(line1);
                writer.flush();
                writer.close();

            }
        }


    }


    public CompositeConfiguration getCompositeConfigVal(String execPathVal) throws ConfigurationException {
        String mainExecPropPath=execPathVal;
        org.apache.commons.configuration2.builder.fluent.Parameters params = new org.apache.commons.configuration2.builder.fluent.Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(mainExecPropPath));

        Configuration config = builder.getConfiguration();
        CompositeConfiguration config2 = new CompositeConfiguration();
        config2.addConfiguration(new SystemConfiguration());
        config2.addConfiguration(config);
        return config2;
    }


    public String deleteExperienceSpecific(String userName,String experienceIDValue) throws IOException, ParseException {
        //System.out.println("\n*****Create apiTestCases ******\n");
        String currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
        String region= readProperty("regionVal");

        RestAssured.baseURI = uriValue;
        // login_api(userName, "Testing1",region);
        login_api(userName, passwordVal(region),region);
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
    public static List<String> uidVal(){

        ArrayList<String> val = new ArrayList<String>();
        /*val.add("0kMglaaw8JW0I0YPVp4n86dSaVs2");
        val.add("18z1UbnDZPRrgcuyg066dlsj6rT2");*/
        val.add("0kMglaaw8JW0I0YPVp4n86dSaVs2");
        val.add("18z1UbnDZPRrgcuyg066dlsj6rT2");
        val.add("1DehnXYACBelW8KanQpBvntPA8J2");
        val.add("1E2J2M58vePHvxsZdgEONokhEqr1");
        val.add("1IsGK8b1eIeeY5k7U3IRS1lt8Wb2");
        val.add("1N7fxLItmXTyNlmTrtbi3LrxNVA2");
        val.add("1WebpyhJt5Vs1XiqAia7WWu9eNC2");
        val.add("2R7y20quUkaI5zTYyMFHzGg4iP53");
        val.add("2S6AzUfbJVZFSC6qQ0k7gEkPUy23");
        val.add("2ryAO7jmfHhqxNF1xXmVUx35yNb2");
        val.add("3JTz6F7EQWTdSx39NcqP1BOYCF32");
        val.add("3sMjFMesbsUKb7MMsPxnDERDVVR2");
        val.add("3sdWDmXHkUNdhS9Y80ub0UzgVlB2");
        val.add("4V9eLxJXvifFqZ7au1HULTyuy6d2");
        val.add("4ePXaze7F2eQ4IB5oQQmZZZfyW13");
        val.add("4l8qUCcXy9bbFwWpTCE8OZOxDOv2");
        val.add("4utrGlXDQCQEcYOPozRPxg1zNiF3");
        val.add("5QxgzFnugDV9J3t1uC6D1TxqpKO2");
        val.add("5weDkVmjzFNjLIe15DgIMhGNOLi2");
        val.add("6JZeKBaTweZslIzHF8qBxxxEiQF3");
        val.add("6LhM9a00fdZIvZvXX6uue8FztCz2");
        val.add("6ceuJtRpKoQnm87aZGRHuzEDofh2");
        val.add("6hEP074SzRdKlLipBNx9X45x2Yz1");
        val.add("6l5x1GwOaeUSH5ZES1trbGRka1i2");
        val.add("72H75KVSe8coBSZ5Gdr8leSXe9N2");
        val.add("7DWqqPm0zAcIqlnLWvtLEHz6Zgo1");
        val.add("7TgAaRXgqyaLrgJkwXJcO06amVJ3");
        val.add("7kfTqdTn5tdaHJEEw3R68k8T8H63");
        val.add("8aeer92rAqeXQE2wJ6aEVoorRO72");
        val.add("8uhoHy1M7SYT9v5lHIytgMSXPLT2");
        val.add("9SUHPwCZIDbb5QHrxwNWS15eCVB2");
        val.add("9aWXgG8DrqfmmNrKSCzwtoCGZNv1");
        val.add("9gHgbJczs6MUoiSAoU1OrOsKzem1");
        val.add("A7H0YH1ssGZmxJFTu4bPDrRWWRi2");
        val.add("AFl5XuNvhBNQcQFoB6IpbsJw4DN2");
        val.add("ARABXzIDsgOc7NI5FeAB1SpAJRo2");
        val.add("AqnqGFTOOCf2YoJNKUGCfNM6BMB3");
        val.add("AsZNQriJzaWLI8vFSfAYZZzItLg1");
        val.add("Awcvp0yRn4Oofx7sa2KfuYzL88f2");
        val.add("BHAGCjYk9XTKuLaSwTfdX1WVD2w1");
        val.add("BZhjiwrMvubqQiTyIrYBBEjsevJ2");
        val.add("BcAlVaFKwgU4vdMfmaqGuu5c73i2");
        val.add("BhLmaFClozVXIn0Wjt4bXntyQr52");
        val.add("CVHPBWu1wpNiCveh8ML6I8tjFGM2");
        val.add("Ckv0Ru4ICvfb7nNEJhY73UBnoN83");
        val.add("CuAYyHedW3OSh8pOKPgmSlI7oYs2");
        val.add("DPXz0rGZHMa8RWXP5100NkZubAU2");
        val.add("De33oHKCu2Qd7LGuialhSpg0xAp2");
        val.add("DkINTuSwtscCjSAHUuDj7NWnIBy1");
        val.add("DrG9b6vxRSQKqD6DOFTlTq2FWg63");
        val.add("Dy7EoiEdEvX1Wv1n3bzfpJKT3CJ2");
        val.add("E73zvBTaLpTb4AEo2tWMOnrjg823");
        val.add("ETkgnEWHLLYmjUZyPzeEgJXUYY73");
        val.add("EUQJaUnHKmfzpCf0gNWatzTEVUs1");
        val.add("EjxxyDjSBIXyxXEJVPfPr4sYsEj1");
        val.add("Es63opXy6KQ0eTjV26dAXhMRYzn1");
        val.add("F4xv6NIfOyP7ITh5Ntt7UNzC3nY2");
        val.add("F7zD7g7GlwgUisDcd4dkU2NLAK03");
        val.add("GCWN2uFjMIdBMwSJdy2IHYbckcU2");
        val.add("GRtsHuNyVhfEynD4kYyuruYPnAF3");
        val.add("GSeDORqXz9bYjoHqoiwHFcKBxzG3");
        val.add("GqYiw3tPa8R8eDcxL4uIwKA1sPM2");
        val.add("HTg6mOxxwib9R7H4fX2FuRFqQIA2");
        val.add("HXzO0JEIFLfJjWnVi79Kh2Ljp5n2");
        val.add("IjPYAYignMPXBoKii0nJN1c2Ffk2");
        val.add("Jg9J5ELku6S30zihUSZbVnFqL4J2");
        val.add("Jp4JcQQLBThupUo0F1sn7IQEJD03");
        val.add("Jt1POwVVvuhWiBc33ATfJ0665c93");
        val.add("KHxq8yP1MycRASeSTcyTqmoXOkg2");
        val.add("L3DsFlxgViUQ2PDW416m7XY1enB3");
        val.add("LRwPG4qdndavfRMsO9W3Gdqlw993");
        val.add("MD7dloHruKXV0BquEQNaeY0OgkP2");
        val.add("MDWLNaH0pwSYwNl7vOZtfDFUHhZ2");
        val.add("MQ8NARdcMBW6u38ohpmdj8udjyA2");
        val.add("Mg30tBfnGJfHOVEhXp40cKSvnE03");
        val.add("N7j6UvIbAcfncJJRrJIqjfuWymw1");
        val.add("Oe9m3tn2xscLanpnmTUwwlOcZtu1");
        val.add("QKYdYui4HRPYoOCQPH9f2XHeslF2");
        val.add("R5jkChgRO6Z0cHLARawRvShk58Q2");
        val.add("RMDEZZYyM5fBzIIXrjHMJ7uWq1R2");
        val.add("Rimg0jiVccf7b4bM63tqUOsKpkb2");
        val.add("RwWy8KHZTHUTdS1ZNCo6PZK6vQr2");
        val.add("RyoN9HAvOOfAB0DyAlG3dRLFcjF2");
        val.add("SVc40wkhvWNW2PT3wn12JU7wOCt1");
        val.add("TK5OlgNwWiSxpgPQrUvvLQXoq982");
        val.add("TOlBHYExX2VlcToWlDB3KTpkaLR2");
        val.add("TeklS7vMlLOHAwWswJjewZNbu3z1");
        val.add("TlTmwPTVc2Nb9g4tfZq2sJU7gmJ2");
        val.add("UBFLSvyn1OSY4f9r43tX3Ufd5Iw2");
        val.add("Ub6pKUzv7YODl5eGnuL2MY4y5Y13");
        val.add("UyraHSYrZgZOzJf42ern96KsD8r1");
        val.add("VQHBOI5DNcg1o0yfRCsdyFZD2ZX2");
        val.add("VdepLyJNAsXutXUsrjEySrBf42E2");
        val.add("VvQUPnlILySmiDb7IysYi5dddjf1");
        val.add("WLWpCdyoZAZ2KucuFI4sKvJV2Ur1");
        val.add("WqdLAU9zFeanS8lobNerLr6UreF3");
        val.add("X2L66eVWV0WfD4vdq1UoTBZ0UQM2");
        val.add("X2yLbI2CmSZJngY5Cy92YnSo6lc2");
        val.add("XEOrfUcmr6U3RGdIuCA2uCGC91r1");
        val.add("XFJjPedhoMQUFgCUDYKB64umNKA2");
        val.add("XIkC9S9PvUfDDDojXQL7YQnxxiT2");
        val.add("YGWCfNnaL1YdyIWv2IjH9KRxRpy1");
        val.add("YLRTUfuX5ghQya2Ir1wjozO9hby2");
        val.add("YQLGRc6DnFRe9l1OuiRbQWyCGot2");
        val.add("Yg1ddL6e7xOocckPhnOf91Hhg3R2");
        val.add("YxMMKNEpwbVzjZmmwXlD0p9l86J2");
        val.add("ZK7HT6EKr8c6Y6CJ4j58o02NdIK2");
        val.add("ZaQdV9JNyehsOg7cTZeTRLmGWxE3");
        val.add("awfULhBfiDS3MZlaOICZKv3vSIY2");
        val.add("az7WgAzsrMTe7H1wQ6UIyRzvRpn2");
        val.add("cJ54ICA308TjUEs2cT5QdQIbEk23");
        val.add("cS8iuo1XKJgkssfgmfTc5BAOtq62");
        val.add("cTTFLFuTOpOlZRgphrFnpy3Gzkm2");
        val.add("cxWHysNkr6Nmh1RkDzxy6FImyp82");
        val.add("d46ShgqZZRXOvwy1XsD8SsHMS1i2");
        val.add("dqElTlUaWzZfZw00jvjn1CqZyA23");
        val.add("eazv4RfSlfZAkQw8pUEJZkDUtMG2");
        val.add("ebVRGFSWjmfPJpleItnOWItvkN12");
        val.add("fdTdhetj7LgWhtLRnNaILCDcdy03");
        val.add("fuKomyydXAgfDzLNSK0wcTuzOW53");
        val.add("gEdoV3hTLnTTu0XiuBix96ShZ852");
        val.add("gTYR7yPcmPPwGygMe7JwDhDmpE22");
        val.add("hauaCCCCfSXMUZUWNM6Bv580PLK2");
        val.add("iDXjOxNW69Rf52fKXeUb7Oi28xY2");
        val.add("iEFuqrqfsmNV9eRgTYOtO9h5Tr82");
        val.add("jVp8EUnaM6TDo7WVW1feCh8XTF22");
        val.add("kpcofRD8uFUDNkAjxrwTij3mHz72");
        val.add("lFL9spW8CVTP4TKcUqh9sLjnVzG3");
        val.add("lOFqqC6AsgY7yEoEjC7nEHFp73V2");
        val.add("m1ipk0jRrzYA8EYjm00R25neGRr2");
        val.add("m6DPpr3YVuU0Jt9KobhIrmy9sW02");
        val.add("mKLCspOpb3YR4xgbeAGSB5OMNhG2");
        val.add("nFjSfgbIUKd6mYPVGHHGEW0fyEG3");
        val.add("nUcouUCSujMY2qIIFuN2xEp7B5A2");
        val.add("nhqSoI7fedZJkAfvNNT4Yu4JN6l2");
        val.add("nqmwAQ1lhjcGg1qe1ASVgMTPTGo1");
        val.add("o0LLrnyRUhgOz8oS2iKOxC5Z1Kb2");
        val.add("oBcS9CuVQPY7HDIpabbha9GpE4o1");
        val.add("oI9DyzZVfpPx3fOjFuFWdH1uPXP2");
        val.add("oTSlhCcrNkZoptIhD5hEQIl8wBQ2");
        val.add("oeel3SIZWeUp0SjQQXPe6m6d3zJ2");
        val.add("pRHzzR3GhUTfAXgZQdAArF39Egk2");
        val.add("qRpk0YKJJBdxQrmHrnHk3w4pWOB3");
        val.add("qwbu3Gf0DpdvmzkJHDBfDoUws3t2");
        val.add("rKaBqWGZzNhNMHa8XKXUUXxr7RS2");
        val.add("rdZvoCt2AMZw8m5gA1lqFyOpB0f2");
        val.add("rfLDzkiLyfgjpbYIpKzmdLQlEy53");
        val.add("rmhpouAWzHgZKgdOgk8drSvhkF32");
        val.add("su0QHqovhNUh6VGcJZDGWDcVewD3");
        val.add("tDaZDfIxAEgcCdMRSjbHp4X2EAK2");
        val.add("tdNS5RrrihdwGIyw2Z51SyYUij22");
        val.add("txLHgaILzVNPZpataKFI0Dg2kPu2");
        val.add("u8NPykRyTAOIfkVQkUknkdufOAQ2");
        val.add("wxUhLvmG2ETaCIOeWVo3TEL1ikG2");
        val.add("wxlgpC0wo2gnXReYZJdWuJgwUO83");
        val.add("xmgaO1QuOfWuD95QCUfiXOaz0EV2");
        val.add("y4Sy42vk5dWDQbUgra71Hq71EP23");
        val.add("ybbOx9qDuoVo0IP2TDzw8XiDUBk1");
        val.add("ynjFGkXoxbUNvmLHlXDC2MJNgjs1");
        val.add("zcweusRJ0MQNfpDhwNa5tNg15oH2");
        return val;
    }

    public List<String> getListVals(String fileNameVal)
    {
        String filePath= System.getProperty("user.dir")+"\\inputFilesForBulkActions\\"+fileNameVal;
        List<String> lineVals= new ArrayList<String>();
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {
            String str="";
            while ((str = buffer.readLine()) != null)  {
                lineVals.add(str);
            }
            return lineVals;
        }

        catch (IOException e) {

            e.printStackTrace();
            return lineVals;
        }
    }

}


