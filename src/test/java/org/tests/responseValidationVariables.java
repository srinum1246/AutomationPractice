package org.tests;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class responseValidationVariables {

  // 1.Man Field as Empty
  public String createtenantfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Tenant Name field cannot be empty\",\"value\":\"\",\"param\":\"tenantName\"},{\"msg\":\"First Name field cannot be empty\",\"value\":\"\",\"param\":\"tenantAdminFirstName\"},{\"msg\":\"Invalid First Name value\",\"value\":\"\",\"param\":\"tenantAdminFirstName\"},{\"msg\":\"Last Name field cannot be empty\",\"value\":\"\",\"param\":\"tenantAdminLastName\"},{\"msg\":\"Invalid Last Name value\",\"value\":\"\",\"param\":\"tenantAdminLastName\"},{\"msg\":\"Customer Status field cannot be empty\",\"value\":\"\",\"param\":\"customerStatus\"},{\"msg\":\"Contract Effective Date should not be empty\",\"value\":\"\",\"param\":\"contractEffectiveDate\"},{\"msg\":\"Maximum Subscribers field cannot be empty\",\"value\":\"\",\"param\":\"numberUsers\"},{\"msg\":\"Subcription Term field cannot be empty\",\"value\":\"\",\"param\":\"subscriptionTerm\"},{\"msg\":\"Plan Type field cannot be empty\",\"value\":\"\",\"param\":\"customerPlan\"},{\"msg\":\"Email field cannot be empty\",\"value\":\"\",\"param\":\"tenantAdminEmail\"}]}";
  public String updatetenantfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"}]}";
  public String addgroupfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"TenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"Group field cannot be empty\",\"value\":\"\",\"param\":\"group\"}]}";
  public String updategroupfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"TenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"oldGroup field cannot be empty\",\"value\":\"\",\"param\":\"oldGroup\"},{\"msg\":\"newGroup field cannot be empty\",\"value\":\"\",\"param\":\"newGroup\"}]}";
  public String fetchkpifailuremsg="{\"message\":\"Failed to fetch KPI data\",\"error\":\"Required fields are missing\"}";
  public String addexperiencefailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Experience Name cannot be empty\",\"value\":\"\",\"param\":\"experienceName\"}]}";
  public String updateexperiencefailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Experience Name cannot be empty\",\"value\":\"\",\"param\":\"experienceName\"}]}";
  public String savepluginfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"iName field is required & cannot be empty\",\"value\":\"\",\"param\":\"iName\"}]}";
  public String saveinstructfailuremsg="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Required fields are missing\"}";
  public String saveinstructfailuremsgother="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Insufficient Permission\"}";
  public String updateuserfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Email field cannot be empty\",\"value\":\"\",\"param\":\"email\"}]}";
  public String setfeaturefailuremsg="{\"code\":500,\"message\":\"Email is required\"}";
  public String storesnowfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"username field cannot be empty\",\"value\":\"\",\"param\":\"username\"},{\"msg\":\"password field cannot be empty\",\"value\":\"\",\"param\":\"password\"}]}";
  public String awsconfigfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"}]}";
  public String sfdcconfigfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"clientId field cannot be empty\",\"value\":\"\",\"param\":\"clientId\"},{\"msg\":\"clientSecret field cannot be empty\",\"value\":\"\",\"param\":\"clientSecret\"},{\"msg\":\"username field cannot be empty\",\"value\":\"\",\"param\":\"username\"},{\"msg\":\"password field cannot be empty\",\"value\":\"\",\"param\":\"password\"},{\"msg\":\"sfdcToken field is required & cannot be empty\",\"value\":\"\",\"param\":\"sfdcToken\"}]}";
  public String authloginfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Password field cannot be empty\",\"value\":\"\",\"param\":\"password\"},{\"msg\":\"Email field cannot be empty\",\"value\":\"\",\"param\":\"email\"}]}";
  public String refreshtokenfailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"refreshToken field cannot be empty\",\"value\":\"\",\"param\":\"refreshToken\"}]}";
  public String downmanagesavefailuremsg="{\"message\":\"Bad request\",\"errors\":[{\"value\":\"\",\"msg\":\"fileLocation is mandatory\",\"param\":\"fileLocation\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"logoURL is mandatory\",\"param\":\"logoURL\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"name is mandatory\",\"param\":\"name\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"platformType is mandatory\",\"param\":\"platformType\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"versionNumber is mandatory\",\"param\":\"versionNumber\",\"location\":\"body\"}]}";




  //2. man field and non man field as empty
  public String createtenantmanandnonmanfieldasempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Tenant Name field cannot be empty\",\"value\":\"\",\"param\":\"tenantName\"},{\"msg\":\"Service Package must have any one of the values Flex, Pro, Premium, PremiumPlus\",\"value\":\"\",\"param\":\"servicePackage\"},{\"msg\":\"First Name field cannot be empty\",\"value\":\"\",\"param\":\"tenantAdminFirstName\"},{\"msg\":\"Invalid First Name value\",\"value\":\"\",\"param\":\"tenantAdminFirstName\"},{\"msg\":\"Last Name field cannot be empty\",\"value\":\"\",\"param\":\"tenantAdminLastName\"},{\"msg\":\"Invalid Last Name value\",\"value\":\"\",\"param\":\"tenantAdminLastName\"},{\"msg\":\"Invalid Created By value. Valid values are 'Zuora','Salesforce','AR Enabled Support','Manual'\",\"value\":\"\",\"param\":\"createdBy\"},{\"msg\":\"Invalid Transaction Reason\",\"value\":\"\",\"param\":\"transactionReason\"},{\"msg\":\"Assist Usage type is not requried when customer plan is not platform\",\"value\":\"\",\"param\":\"assistUsageType\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"\",\"param\":\"disabled\"},{\"msg\":\"Customer Status field cannot be empty\",\"value\":\"\",\"param\":\"customerStatus\"},{\"msg\":\"Contract Effective Date should not be empty\",\"value\":\"\",\"param\":\"contractEffectiveDate\"},{\"msg\":\"Service Now Connector Entitlement field should be a boolean\",\"value\":\"\",\"param\":\"serviceNowConnectorEntitlement\"},{\"msg\":\"Salesforce Connector Entitlement field should be a boolean\",\"value\":\"\",\"param\":\"salesforceConnectorEntitlement\"},{\"msg\":\"Maximum Subscribers field cannot be empty\",\"value\":\"\",\"param\":\"numberUsers\"},{\"msg\":\"Subcription Term field cannot be empty\",\"value\":\"\",\"param\":\"subscriptionTerm\"},{\"msg\":\"Instruct Session Purchased should be an Integer\",\"value\":\"\",\"param\":\"instructSessionsPurchased\"},{\"msg\":\"Plan Type field cannot be empty\",\"value\":\"\",\"param\":\"customerPlan\"},{\"msg\":\"Sessions Purchased should be an integer\",\"value\":\"\",\"param\":\"sessionsPurchased\"},{\"msg\":\"Minutes Purchased should be an integer\",\"value\":\"\",\"param\":\"minutesPurchased\"},{\"msg\":\"Tier Level should be an integer\",\"value\":\"\",\"param\":\"tierLevel\"},{\"msg\":\"Number of Video Recording Users should be an integer\",\"value\":\"\",\"param\":\"numberVideoRecordingUsers\"},{\"msg\":\"Invalid Partner Email value\",\"value\":\"\",\"param\":\"partnerContactEmail\"},{\"msg\":\"AI Service Enabled field should be a boolean\",\"value\":\"\",\"param\":\"aiEnabled\"},{\"msg\":\"Image Recognition Entitlement field should be a boolean\",\"value\":\"\",\"param\":\"imageRecognitionEntitlement\"},{\"msg\":\"Email field cannot be empty\",\"value\":\"\",\"param\":\"tenantAdminEmail\"}]}";
  public String updatetenantmanandnonmanasempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"Tenant Name should have minimum length as 1\",\"value\":\"\",\"param\":\"tenantName\"},{\"msg\":\"name field can not be empty\",\"value\":\"\",\"param\":\"name\"},{\"msg\":\"Service Package must have any one of the values Flex, Pro, Premium, PremiumPlus\",\"value\":\"\",\"param\":\"servicePackage\"},{\"msg\":\"Invalid Plan Type. Valid values are 'core', 'enterprise', 'trial' or platform\",\"value\":\"\",\"param\":\"customerPlan\"},{\"msg\":\"Invalid Customer Status. Valid values are 'suspended', 'paying', 'trial' or 'pendingDeletion'\",\"value\":\"\",\"param\":\"customerStatus\"},{\"msg\":\"Please enter valid Contract Effective Date with MM/DD/YYYY format\",\"value\":\"\",\"param\":\"contractEffectiveDate\"},{\"msg\":\"Invalid Created By value. Valid values are 'Zuora','Salesforce','AR Enabled Support','Manual'\",\"value\":\"\",\"param\":\"createdBy\"},{\"msg\":\"Invalid Transaction Reason\",\"value\":\"\",\"param\":\"transactionReason\"},{\"msg\":\"Subcription Term should be an integer greater than 0\",\"value\":\"\",\"param\":\"subscriptionTerm\"},{\"msg\":\"Assist Usage type is not requried when customer plan is not platform\",\"value\":\"\",\"param\":\"assistUsageType\"},{\"msg\":\"Maximum Subscribers should be an integer within 10 to 10000\",\"value\":\"\",\"param\":\"numberUsers\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"\",\"param\":\"disabled\"},{\"msg\":\"Service Now Connector Entitlement field should be a boolean\",\"value\":\"\",\"param\":\"serviceNowConnectorEntitlement\"},{\"msg\":\"Number of Video Recording Users should be an integer\",\"value\":\"\",\"param\":\"numberVideoRecordingUsers\"},{\"msg\":\"Salesforce Connector Entitlement field should be a boolean\",\"value\":\"\",\"param\":\"salesforceConnectorEntitlement\"},{\"msg\":\"Sessions Purchased should be an integer\",\"value\":\"\",\"param\":\"sessionsPurchased\"},{\"msg\":\"Minutes Purchased should be an integer\",\"value\":\"\",\"param\":\"minutesPurchased\"},{\"msg\":\"Instruct Session Purchased should be an Integer\",\"value\":\"\",\"param\":\"instructSessionsPurchased\"},{\"msg\":\"Tier Level should be an integer\",\"value\":\"\",\"param\":\"tierLevel\"},{\"msg\":\"AI Service Enabled field should be a boolean\",\"value\":\"\",\"param\":\"aiEnabled\"},{\"msg\":\"Image Recognition Entitlement field should be a boolean\",\"value\":\"\",\"param\":\"imageRecognitionEntitlement\"}]}";
  public String addexpmanandnonmanasempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Experience Name cannot be empty\",\"value\":\"\",\"param\":\"experienceName\"},{\"msg\":\"Atleast one user group must be selected and no duplicates allowed.\",\"value\":\"\",\"param\":\"userGroups\"},{\"msg\":\"Authenticated flag should be a boolean\",\"value\":\"\",\"param\":\"authenticated\"},{\"msg\":\"Access type is required and must be either public or private.\",\"value\":\"\",\"param\":\"accessType\"}]}";
  public String updateexpmannonasempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Experience Name cannot be empty\",\"value\":\"\",\"param\":\"experienceName\"},{\"msg\":\"Doesn't look like a valid URL. Please, double check\",\"value\":\"\",\"param\":\"bundleLocation\"},{\"msg\":\"Access type is required and must be either public or private.\",\"value\":\"\",\"param\":\"accessType\"},{\"msg\":\"Atleast one user group must be selected and no duplicates allowed.\",\"value\":\"\",\"param\":\"userGroups\"},{\"msg\":\"Authenticated flag should be a boolean\",\"value\":\"\",\"param\":\"authenticated\"}]}";
  public String savepluginmannonmanempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"iName field is required & cannot be empty\",\"value\":\"\",\"param\":\"iName\"}]}";
  public String saveinstructmannonmanempty="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Required fields are missing\"}";
  public String saveinstructmannonmanemptyother="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Insufficient Permission\"}";
  public String updateusermannonmanempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Email field cannot be empty\",\"value\":\"\",\"param\":\"email\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"\",\"param\":\"disabled\"}]}";
    public String setfeaturemannonmanempty="{\"code\":500,\"message\":\"Email is required\"}";
  public String  secretawsmannonmanempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"tenantId field cannot be empty\",\"value\":\"\",\"param\":\"tenantId\"},{\"msg\":\"recordingEnabled should be a boolean\",\"value\":\"\",\"param\":\"recordingEnabled\"}]}";
    public String downmanagesavemannonmanempty="{\"message\":\"Bad request\",\"errors\":[{\"value\":\"\",\"msg\":\"fileLocation is mandatory\",\"param\":\"fileLocation\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"logoURL is mandatory\",\"param\":\"logoURL\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"name is mandatory\",\"param\":\"name\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"platformType is mandatory\",\"param\":\"platformType\",\"location\":\"body\"},{\"value\":\"\",\"msg\":\"versionNumber is mandatory\",\"param\":\"versionNumber\",\"location\":\"body\"}]}";


  //3. man field as invalid value
  public String createtenantmanfieldasinvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Invalid First Name value\",\"value\":\"123\",\"param\":\"tenantAdminFirstName\"},{\"msg\":\"Invalid Last Name value\",\"value\":\"456\",\"param\":\"tenantAdminLastName\"},{\"msg\":\"Please enter valid Contract Effective Date with MM/DD/YYYY format\",\"value\":\"xy/x/zz\",\"param\":\"contractEffectiveDate\"},{\"msg\":\"Invalid Customer Status. Valid values are 'suspended', 'paying', 'trial' or 'pendingDeletion'\",\"value\":\"431\",\"param\":\"customerStatus\"},{\"msg\":\"Maximum Subscribers should be an integer within 10 to 10000\",\"value\":\"no\",\"param\":\"numberUsers\"},{\"msg\":\"Subcription Term should be an integer greater than 0\",\"value\":\"bcd\",\"param\":\"subscriptionTerm\"},{\"msg\":\"Invalid Plan Type. Valid values are 'core', 'enterprise', 'trial' or platform\",\"value\":\"234\",\"param\":\"customerPlan\"}]}";
  public String updatetenantmanfieldinvalid="{\"message\":\"Failed to update the tenant data\",\"error\":\"Not Found\",\"updatedFields\":null,\"status\":404}";
  public String addgroupmanfieldinvalidval="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Group value should have minimum 2 and maximum 16 characters\",\"value\":\"r\",\"param\":\"group\"}]}";
  public String updategroupmanfieldinvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Group value should have minimum 2 and maximum 16 characters\",\"value\":\"t\",\"param\":\"newGroup\"}]}";
  public String fetchkpimanfieldasinvalid="{\"message\":\"Failed to fetch KPI data\",\"error\":\"please add correct date with YYYY/MM/DD format and from date <= to Date\"}";
  public String saveplugininfoinvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"iName field is required & cannot be empty\",\"value\":\"\",\"param\":\"iName\"}]}";
  public String saveplugininfoother="{\"error\":\"Insufficient Permission\",\"message\":\"Failed to authenticate the User\"}";
  public String Saveinstructmaninvalid="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Required fields are missing\"}";
  public String Saveinstructmaninvalidother="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Insufficient Permission\"}";
  public String userupdatemaninvalid="{\"message\":\"Failed to update the user details\",\"error\":\"User does not exist\"}";
  public String setfeaturemaninvalid="{\"code\":500,\"message\":\"Email/User not found\"}";
  public static String secstorenowmaninvalid="{\"message\":\"Failed to store the Tenant's ServiceNow Key\",\"error\":\"Tenant does not exist\"}";
  public String secstorenowmaninvalidother="{\"error\":\"Insufficient Permission\",\"message\":\"Failed to authenticate the User\",\"status\":\"Forbidden\"}";
  public static String secretawsmaninvalid="{\"message\":\"Failed to store the Tenant's Amazon S3 Details\",\"error\":\"Tenant does not exist\"}";
  public String secretawsmaninvalidother="{\"error\":\"Insufficient Permission\",\"message\":\"Failed to authenticate the User\",\"status\":\"Forbidden\"}";
  public static String secretsfdcmaninvalid="{\"message\":\"Failed to store the Tenant's Salesforce Key\",\"error\":\"Tenant does not exist\"}";
  public String secretsfdcmaninvalidother="{\"error\":\"Insufficient Permission\",\"message\":\"Failed to authenticate the User\",\"status\":\"Forbidden\"}";
  public String authloginmaninvalid="{\"message\":\"Failed to Log in\",\"error\":\"Invalid Email or Password\"}";
  public String authrefreshtokeninvalid="{\"message\":\"Failed to refresh the session\",\"status\":400,\"error\":{\"error\":{\"code\":400,\"message\":\"INVALID_REFRESH_TOKEN\",\"status\":\"INVALID_ARGUMENT\"}}}";
  public String downloadmanaupdatemaninvalid="{\"code\":500,\"message\":\"Requesting document does not exist\"}";


  //4. man field and non man field as invalid value
  public String createtenantmanandnonmanasinvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Service Package must have any one of the values Flex, Pro, Premium, PremiumPlus\",\"value\":\"ca\",\"param\":\"servicePackage\"},{\"msg\":\"Invalid First Name value\",\"value\":\"123\",\"param\":\"tenantAdminFirstName\"},{\"msg\":\"Invalid Last Name value\",\"value\":\"456\",\"param\":\"tenantAdminLastName\"},{\"msg\":\"Invalid Created By value. Valid values are 'Zuora','Salesforce','AR Enabled Support','Manual'\",\"value\":\"xcg\",\"param\":\"createdBy\"},{\"msg\":\"Invalid Transaction Reason\",\"value\":\"123\",\"param\":\"transactionReason\"},{\"msg\":\"Assist Usage type is not requried when customer plan is not platform\",\"value\":\"def\",\"param\":\"assistUsageType\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"xcv\",\"param\":\"disabled\"},{\"msg\":\"Service Now Connector Entitlement field should be a boolean\",\"value\":\"sdf\",\"param\":\"serviceNowConnectorEntitlement\"},{\"msg\":\"Salesforce Connector Entitlement field should be a boolean\",\"value\":\"gyt\",\"param\":\"salesforceConnectorEntitlement\"},{\"msg\":\"Instruct Session Purchased should be an Integer\",\"value\":\"wer\",\"param\":\"instructSessionsPurchased\"},{\"msg\":\"Please enter valid Contract Effective Date with MM/DD/YYYY format\",\"value\":\"xy/x/zz\",\"param\":\"contractEffectiveDate\"},{\"msg\":\"Sessions Purchased should be an integer\",\"value\":\"sdf\",\"param\":\"sessionsPurchased\"},{\"msg\":\"Minutes Purchased should be an integer\",\"value\":\"cdf\",\"param\":\"minutesPurchased\"},{\"msg\":\"Tier Level should be an integer\",\"value\":\"wer\",\"param\":\"tierLevel\"},{\"msg\":\"Number of Video Recording Users should be an integer\",\"value\":\"cvb\",\"param\":\"numberVideoRecordingUsers\"},{\"msg\":\"Invalid Partner Email value\",\"value\":\"234\",\"param\":\"partnerContactEmail\"},{\"msg\":\"Invalid Customer Status. Valid values are 'suspended', 'paying', 'trial' or 'pendingDeletion'\",\"value\":\"431\",\"param\":\"customerStatus\"},{\"msg\":\"Maximum Subscribers should be an integer within 10 to 10000\",\"value\":\"no\",\"param\":\"numberUsers\"},{\"msg\":\"Subcription Term should be an integer greater than 0\",\"value\":\"bcd\",\"param\":\"subscriptionTerm\"},{\"msg\":\"AI Service Enabled field should be a boolean\",\"value\":\"vfg\",\"param\":\"aiEnabled\"},{\"msg\":\"Invalid Plan Type. Valid values are 'core', 'enterprise', 'trial' or platform\",\"value\":\"234\",\"param\":\"customerPlan\"},{\"msg\":\"Image Recognition Entitlement field should be a boolean\",\"value\":\"djk\",\"param\":\"imageRecognitionEntitlement\"}]}";
  public String updatetenantmannonmanasinvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Service Package must have any one of the values Flex, Pro, Premium, PremiumPlus\",\"value\":\"34345\",\"param\":\"servicePackage\"},{\"msg\":\"Invalid Plan Type. Valid values are 'core', 'enterprise', 'trial' or platform\",\"value\":\"234\",\"param\":\"customerPlan\"},{\"msg\":\"Invalid Customer Status. Valid values are 'suspended', 'paying', 'trial' or 'pendingDeletion'\",\"value\":\"908\",\"param\":\"customerStatus\"},{\"msg\":\"Please enter valid Contract Effective Date with MM/DD/YYYY format\",\"value\":\"sffv\",\"param\":\"contractEffectiveDate\"},{\"msg\":\"Invalid Created By value. Valid values are 'Zuora','Salesforce','AR Enabled Support','Manual'\",\"value\":\"343\",\"param\":\"createdBy\"},{\"msg\":\"Invalid Transaction Reason\",\"value\":\"455\",\"param\":\"transactionReason\"},{\"msg\":\"Subcription Term should be an integer greater than 0\",\"value\":\"asd\",\"param\":\"subscriptionTerm\"},{\"msg\":\"Assist Usage type is not requried when customer plan is not platform\",\"value\":\"rty\",\"param\":\"assistUsageType\"},{\"msg\":\"Maximum Subscribers should be an integer within 10 to 10000\",\"value\":\"dfg\",\"param\":\"numberUsers\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"234\",\"param\":\"disabled\"},{\"msg\":\"Service Now Connector Entitlement field should be a boolean\",\"value\":\"2345\",\"param\":\"serviceNowConnectorEntitlement\"},{\"msg\":\"Number of Video Recording Users should be an integer\",\"value\":\"zxc\",\"param\":\"numberVideoRecordingUsers\"},{\"msg\":\"Salesforce Connector Entitlement field should be a boolean\",\"value\":\"987675\",\"param\":\"salesforceConnectorEntitlement\"},{\"msg\":\"Sessions Purchased should be an integer\",\"value\":\"gfds\",\"param\":\"sessionsPurchased\"},{\"msg\":\"Minutes Purchased should be an integer\",\"value\":\"sdf\",\"param\":\"minutesPurchased\"},{\"msg\":\"Instruct Session Purchased should be an Integer\",\"value\":\"dssegeg\",\"param\":\"instructSessionsPurchased\"},{\"msg\":\"Tier Level should be an integer\",\"value\":\"wefwefw\",\"param\":\"tierLevel\"},{\"msg\":\"AI Service Enabled field should be a boolean\",\"value\":\"345\",\"param\":\"aiEnabled\"},{\"msg\":\"Image Recognition Entitlement field should be a boolean\",\"value\":\"685\",\"param\":\"imageRecognitionEntitlement\"}]}";
  public String saveplugininfomannonmaninvalid="{\"message\":\"Failed to store the Tenant's Web API Key\",\"error\":\"Tenant does not exist\"}";
  public String saveinstructmannonmaninvalid="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Required fields are missing\"}";
  public static String saveinstructmannonmaninvalidother="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Insufficient Permission\"}";
  public String saveinstructmannonmaninvalidfail="{\"error\":\"Insufficient Permission\",\"message\":\"Failed to authenticate the User\"}";
  public static String userupdatemannonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Invalid Role value. Valid values are 'system_analyst','tenant_admin','partner_creator','analyst','user','content creator'\",\"value\":\"456\",\"param\":\"userType\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"6447\",\"param\":\"disabled\"}]}";
  public String userupdatemannonmaninvalidother="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Invalid Role value. Valid values are 'system_analyst','tenant_admin','partner_creator','analyst','user','content creator'\",\"value\":\"345\",\"param\":\"userType\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"36\",\"param\":\"disabled\"}]}";
    public String setfeaturemannonmaninvalid="{\"code\":500,\"message\":\"Email/User not found\"}";
  public String secretawsmannonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"recordingEnabled should be a boolean\",\"value\":\"908789\",\"param\":\"recordingEnabled\"},{\"msg\":\"Invalid bucketRegion value\",\"value\":\"9087\",\"param\":\"bucketRegion\"}]}";
  public String downloadmanupdatemannonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"value\":\"56\",\"msg\":\"disabled should be boolean\",\"param\":\"disabled\",\"location\":\"body\"}]}";

 //5. man field as invalid and non man field as valid
  public String createtenantmaninvalidnonmanvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Service Package can be set only when customer plan is of type platform.\",\"value\":\"PremiumPlus\",\"param\":\"servicePackage\"},{\"msg\":\"Invalid First Name value\",\"value\":\"123\",\"param\":\"tenantAdminFirstName\"},{\"msg\":\"Invalid Last Name value\",\"value\":\"456\",\"param\":\"tenantAdminLastName\"},{\"msg\":\"Assist Usage type is not requried when customer plan is not platform\",\"value\":\"user\",\"param\":\"assistUsageType\"},{\"msg\":\"Please enter valid Contract Effective Date with MM/DD/YYYY format\",\"value\":\"xy/x/zz\",\"param\":\"contractEffectiveDate\"},{\"msg\":\"Invalid Customer Status. Valid values are 'suspended', 'paying', 'trial' or 'pendingDeletion'\",\"value\":\"431\",\"param\":\"customerStatus\"},{\"msg\":\"Maximum Subscribers should be an integer within 10 to 10000\",\"value\":\"no\",\"param\":\"numberUsers\"},{\"msg\":\"Subcription Term should be an integer greater than 0\",\"value\":\"bcd\",\"param\":\"subscriptionTerm\"},{\"msg\":\"Instruct Session Purchased not required when Plan Type is not equal to platform.\",\"value\":\"100\",\"param\":\"instructSessionsPurchased\"},{\"msg\":\"Invalid Plan Type. Valid values are 'core', 'enterprise', 'trial' or platform\",\"value\":\"234\",\"param\":\"customerPlan\"},{\"msg\":\"Number of Video Recording Users should be less than or equal to Licensed Subscribers\",\"value\":\"0\",\"param\":\"numberVideoRecordingUsers\"},{\"msg\":\"Plan Type should be selected as 'Platform' if AI Service is enabled\",\"value\":\"true\",\"param\":\"aiEnabled\"}]}";
  public String updatetenantmaninvalidnonmanvalid="{\"message\":\"Failed to update the tenant data\",\"error\":\"Not Found\",\"updatedFields\":null,\"status\":404}";
    public String saveplugininfomaninvalidnonmanvalid="{\"message\":\"Failed to store the Tenant's Web API Key\",\"error\":\"Tenant does not exist\"}";
    public String Saveinstructmaninvalidnonmanvalid="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Required fields are missing\"}";
    public String Saveinstructmaninvalidnonmanvalidother="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Insufficient Permission\"}";
     public String userupdatemaninvalidnonmanval="{\"message\":\"Failed to update the user details\",\"error\":\"User does not exist\"}";
    public String setfeaturemaninvalidnonmanvalid="{\"code\":500,\"message\":\"Email/User not found\"}";
    public static String secretmaninvalidnonmanval="{\"message\":\"Failed to store the Tenant's Amazon S3 Details\",\"error\":\"Tenant does not exist\"}";
    public String secretmaninvalidnonmanvalother="{\"error\":\"Insufficient Permission\",\"message\":\"Failed to authenticate the User\",\"status\":\"Forbidden\"}";
    public String downloadmanaupdatemaninvalidnonmanvalid="{\"code\":500,\"message\":\"Requesting document does not exist\"}";

    //6.man field valid and non man field as invalid
  public String createtenantmanvalidnonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Service Package must have any one of the values Flex, Pro, Premium, PremiumPlus\",\"value\":\"3456\",\"param\":\"servicePackage\"},{\"msg\":\"Invalid Created By value. Valid values are 'Zuora','Salesforce','AR Enabled Support','Manual'\",\"value\":\"561\",\"param\":\"createdBy\"},{\"msg\":\"Invalid Transaction Reason\",\"value\":\"2345\",\"param\":\"transactionReason\"},{\"msg\":\"Assist Usage Type should be 'minutes', 'sessions' or 'user'\",\"value\":\"jk\",\"param\":\"assistUsageType\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"564\",\"param\":\"disabled\"},{\"msg\":\"Service Now Connector Entitlement field should be a boolean\",\"value\":\"nbv\",\"param\":\"serviceNowConnectorEntitlement\"},{\"msg\":\"Salesforce Connector Entitlement field should be a boolean\",\"value\":\"4567\",\"param\":\"salesforceConnectorEntitlement\"},{\"msg\":\"Instruct Session Purchased should be an Integer\",\"value\":\"ty\",\"param\":\"instructSessionsPurchased\"},{\"msg\":\"Tier Level should be an integer\",\"value\":\"wer\",\"param\":\"tierLevel\"},{\"msg\":\"Number of Video Recording Users should be an integer\",\"value\":\"njg\",\"param\":\"numberVideoRecordingUsers\"},{\"msg\":\"AI Service Enabled field should be a boolean\",\"value\":\"67\",\"param\":\"aiEnabled\"},{\"msg\":\"Image Recognition Entitlement field should be a boolean\",\"value\":\"890\",\"param\":\"imageRecognitionEntitlement\"}]}";
  public String updatetenantmanvalidnonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Invalid Customer Status. Valid values are 'suspended', 'paying', 'trial' or 'pendingDeletion'\",\"value\":\"123\",\"param\":\"customerStatus\"},{\"msg\":\"Invalid Created By value. Valid values are 'Zuora','Salesforce','AR Enabled Support','Manual'\",\"value\":\"98798\",\"param\":\"createdBy\"},{\"msg\":\"Invalid Transaction Reason\",\"value\":\"876\",\"param\":\"transactionReason\"},{\"msg\":\"Subcription Term should be an integer greater than 0\",\"value\":\"wer\",\"param\":\"subscriptionTerm\"},{\"msg\":\"Maximum Subscribers should be an integer within 10 to 10000\",\"value\":\"asd\",\"param\":\"numberUsers\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"765\",\"param\":\"disabled\"},{\"msg\":\"Service Now Connector Entitlement field should be a boolean\",\"value\":\"2356\",\"param\":\"serviceNowConnectorEntitlement\"},{\"msg\":\"Number of Video Recording Users should be an integer\",\"value\":\"ytr\",\"param\":\"numberVideoRecordingUsers\"},{\"msg\":\"Salesforce Connector Entitlement field should be a boolean\",\"value\":\"233\",\"param\":\"salesforceConnectorEntitlement\"},{\"msg\":\"Tier Level should be an integer\",\"value\":\"ert\",\"param\":\"tierLevel\"}]}";
  public String addexpmanvalidnonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Authenticated flag should be a boolean\",\"value\":\"9676\",\"param\":\"authenticated\"},{\"msg\":\"Atleast one user group must be selected and no duplicates allowed.\",\"value\":\"9\",\"param\":\"userGroups\"}]}";
  public String updateexpmanvalnonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Authenticated flag should be a boolean\",\"value\":\"347\",\"param\":\"authenticated\"},{\"msg\":\"Atleast one user group must be selected and no duplicates allowed.\",\"value\":\"$\",\"param\":\"userGroups\"}]}";
  public String savepluginmanvalidnonmaninvalid="{\"message\":\"Failed to store the Tenant's Web API Key\",\"error\":\"Tenant does not enabled the 4 plugin\"}";
    public String saveinstructmanvalnonmaninvalid="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"tenant does not exist\"}";
    public static String saveinstructmanvalidnonmaninvalidother="{\"message\":\"Failed to add the Instruct builder experience\",\"error\":\"Insufficient Permission\"}";
    public String saveinstructmanvalidnonmaninvalidfail="{\"error\":\"Insufficient Permission\",\"message\":\"Failed to authenticate the User\"}";
    public String userupdatemanvalnonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Invalid Role value. Valid values are 'system_analyst','tenant_admin','partner_creator','analyst','user','content creator'\",\"value\":\"432\",\"param\":\"userType\"},{\"msg\":\"disabled field should be a boolean\",\"value\":\"456\",\"param\":\"disabled\"}]}";
    public String secretawsmanvalnonmaninval="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"recordingEnabled should be a boolean\",\"value\":\"908789\",\"param\":\"recordingEnabled\"},{\"msg\":\"Invalid bucketRegion value\",\"value\":\"9087\",\"param\":\"bucketRegion\"}]}";
    public String downloadmanupdatemanvalidnonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"value\":\"56\",\"msg\":\"disabled should be boolean\",\"param\":\"disabled\",\"location\":\"body\"}]}";



    //7. non man field empty
  public String savenotificationnonmanempty="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Email notification list cannot be empty,must be array of unique valid emails, with min 1 and max 5 value\",\"value\":\"\",\"param\":\"emailNotificationList\"},{\"msg\":\"Reminder one should be valid integer and should be greater than reminder two,three and four\",\"value\":{\"instruct\":{\"sessions\":{\"reminderOne\":\"\",\"reminderThree\":\"\",\"reminderFour\":\"\",\"reminderTwo\":\"\"}},\"assist\":{\"sessions\":{\"reminderOne\":\"\",\"reminderThree\":\"\",\"reminderFour\":\"\",\"reminderTwo\":\"\"},\"minutes\":{\"reminderOne\":\"\",\"reminderThree\":\"\",\"reminderFour\":\"\",\"reminderTwo\":\"\"}}},\"param\":\"notificationSettings\"}]}";
  public String sessionfetchsession="{\"message\":\"Failed to fetch the sessions data\",\"error\":\"mandatory fields are missing\"}";

 //8.non man field invalid
  public String savenotificationnonmaninvalid="{\"message\":\"Bad request\",\"errors\":[{\"msg\":\"Email notification list cannot be empty,must be array of unique valid emails, with min 1 and max 5 value\",\"value\":\"xyz@gmail.com\",\"param\":\"emailNotificationList\"},{\"msg\":\"Reminder one should be valid integer and should be greater than reminder two,three and four\",\"value\":{\"instruct\":{\"sessions\":{\"reminderOne\":\"acs\",\"reminderThree\":\"yui\",\"reminderFour\":\"wds\",\"reminderTwo\":\"ybd\"}},\"assist\":{\"sessions\":{\"reminderOne\":\"we\",\"reminderThree\":\"d\",\"reminderFour\":\"w\",\"reminderTwo\":\"yu\"},\"minutes\":{\"reminderOne\":\"qwe\",\"reminderThree\":\"wds\",\"reminderFour\":\"vb\",\"reminderTwo\":\"qs\"}}},\"param\":\"notificationSettings\"}]}";
  public String sessionfetchsessionnonmaninvalid="{\"message\":\"Failed to fetch the sessions data\",\"error\":\"Please add correct date with YYYY/MM/DD format and from date <= to Date\"}";

  // field invalid --> not available no validation on confluence
  public String updatepluginstatus="{\"message\":\"Failed to save connector status\",\"error\":\"Plug-in status must be true or false\"}";
  public String authactivateuserinvalid="{\"message\":\"Failed to add custom claim\",\"error\":\"Value for argument \\\"documentPath\\\" is not a valid resource path. Path must be a non-empty string.\"}";


  // field as empty --> not available no validation on confluence
  public String updatepluginstatusempty="{\"message\":\"Failed to save connector status\",\"error\":\"Required fields are missing\"}";
  public String authactivateuserempty="{\"message\":\"Failed to add custom claim\",\"error\":\"Value for argument \\\"documentPath\\\" is not a valid resource path. Path must be a non-empty string.\"}";
  public String authgetscoreempty="{\"success\":false,\"error-codes\":[\"invalid-input-response\"]}";

   // 1.Response code
    public String createtenantrescode= "400";
    public String updatetenantrescode="400";
    public String updatetenantmaninvalidrescode="404";
    public String addgroupmanfieldrescode="400";
    public String updategrouprescode="400";
    public String savenotificationrescode="400";
    public String updatepluginstatusrescode="400";
    public String fetchkpirescode="400";
    public String addexperiencesrescode="400";
    public String updateexperiencerescode="400";
    public String saveplugininforescode="400";
    public String saveplugininfootherrescode="403";
    public String saveinstructbuilderrescode="400";
    public String saveinstructbuilderotherrescode="403";
    public String userupdateuserrescode="400";
    public String userupdaterescodeother="500";
    public String setfeaturerescode="400";
    public String setfeaturerescodeother="500";
    public String secretstorenowsecretrescode="400";
    public String secretstorenowsecretrescodeother="403";
    public String secretawsrescode="400";
    public String secretawsrescodeother="403";
    public String secretsfdcrescode="400";
    public String secretsfdcrescodeother="403";
    public String sessionfetchsessionrescode="400";
    public String authloginrescode="400";
    public String authloginrescodeother="401";
    public String authrefreshtokenrescode="400";
    public String authactivateuserrescode="400";
    public String downloadmanasaverescode="400";
    public String downloadmanaupdaterescode="500";
    public String downloadmanaupdaterescodeother="400";

    //1.create tenant Man Field

    public static   List<String> createTenantManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("customerStatus");
        val.add("tenantAdminLastName");
        val.add("contractEffectiveDate");
        val.add("numberUsers");
        val.add("tenantAdminEmail");
        val.add("tenantName");
        val.add("tenantAdminFirstName");
        val.add("subscriptionTerm");
        val.add("customerPlan");
        return val;
    }

    //1.create tenant Non Man Field
    public static List<String> createTenantNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantPhysicalAddress");
        val.add("customerCRMID");
        val.add("disabled");
        val.add("aiEnabled");
        val.add("instructSessionsPurchased");
        val.add("assistUsageType");
        val.add("sessionsPurchased");
        val.add("minutesPurchased");
        val.add("resellerOfRecord");
        val.add("customerSuccessManager");
        val.add("tierLevel");
        val.add("zQuoteID");
        val.add("serviceNowConnectorEntitlement");
        val.add("createdBy");
        val.add("numberVideoRecordingUsers");
        val.add("referralCode");
        val.add("partnerContactEmail");
        val.add("transactionReason");
        val.add("servicePackage");
        val.add("imageRecognitionEntitlement");
        val.add("salesforceConnectorEntitlement");

        return val;
    }

    //1.update tenant man field
    public static   List<String> updateTenantManField(){

    ArrayList<String> val = new ArrayList<String>();
    val.add("tenantId");
    return val;
    }
    //1.update tenant non man field
    public static List<String> updateTenantNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantName");
        val.add("numberUsers");
        val.add("subscriptionTerm");
        val.add("disabled");
        val.add("aiEnabled");
        val.add("customerPlan");
        val.add("customerStatus");
        val.add("name");
        val.add("assistUsageType");
        val.add("sessionsPurchased");
        val.add("minutesPurchased");
        val.add("instructSessionsPurchased");
        val.add("contractEffectiveDate");
        val.add("tierLevel");
        val.add("serviceNowConnectorEntitlement");
        val.add("createdBy");
        val.add("numberVideoRecordingUsers");
        val.add("partnerContactEmail");
        val.add("transactionReason");
        val.add("servicePackage");
        val.add("imageRecognitionEntitlement");
        val.add("salesforceConnectorEntitlement");
        return val;
    }
 //add group man field
 public static   List<String> addGroupManField(){

     ArrayList<String> val = new ArrayList<String>();
     val.add("group");
     val.add("tenantId");
     return val;
 }
    //update group man field
    public static   List<String> updateGroupManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("newGroup");
        val.add("oldGroup");
        val.add("tenantId");
        return val;
    }
    //update group man field
    public static   List<String> saveNotificationNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("emailNotificationList");
        val.add("notificationSettings");
        return val;
    }
    // fetch kpi man filed
    public static   List<String> fetchKpiManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantId");
        val.add("fromDate");
        val.add("toDate");
        return val;
    }

    // Add  exp man filed
    public static   List<String> addExperienceManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("experienceName");
        return val;
    }

    // Add  exp non  man filed
    public static   List<String> addExperienceNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("experienceDescription");
        val.add("authenticated");
        val.add("accessType");
        val.add("userGroups");
        return val;
    }
    // update  exp man filed
    public static   List<String> updateExperienceManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("experienceName");
        return val;
    }

    // update  exp non  man filed
    public static   List<String> updateExperienceNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("bundleLocation");
        val.add("experienceDescription");
        val.add("authenticated");
        val.add("accessType");
        val.add("userGroups");
        return val;
    }

    // save plugin info  man filed
    public static   List<String> savePluginInfoManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantId");
        return val;
    }

    // save plugin info non  man filed
    public static   List<String> savePluginInfoNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("username");
        val.add("password");
        val.add("token");
        val.add("iName");
        val.add("apiURL");
        val.add("fqdn");
        return val;
    }
   //save instruct builder exp man

    // save instruct builder  man filed
    public static   List<String> saveInstructBuilderManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("id");
        val.add("title");
        val.add("pages");
        val.add("edges");
        val.add("version");
        val.add("languageCode");
        val.add("languageCodeList");
        return val;
    }
    // save instruct builder  non  man filed
    public static   List<String> saveInstructBuilderNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantId");
        val.add("navigationNodes");
        val.add("enableSearch");
        val.add("searchIndex");
        val.add("description");
        val.add("mobileAppEnabled");
        val.add("webBrowserEnabled");
        return val;
    }

    // user update user  man filed
    public static   List<String> userupdateuserManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("email");
        return val;
    }

    // user update user non  man filed
    public static   List<String> userupdateusernonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("userType");
        val.add("description");
        val.add("disabled");
        return val;
    }

    // user set feature  man filed
    public static   List<String> usersetFeatureManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("email");
        val.add("featureTeacher");
        return val;
    }
    // user set feature non  man filed
    public static   List<String> usersetFeaturenonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("featureTeacherCompletion");

        return val;
    }
    // secret store now  man filed
    public static List<String> secretmanagerstorenowManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantId");
        val.add("username");
        val.add("password");
        return val;
    }
    // secret aws config  man filed
    public static List<String> secretawsconfigManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantId");
        return val;
    }
    // secret aws config non  man filed
    public static List<String> secretawsconfignonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("recordingEnabled");
        val.add("bucketRegion");
        val.add("awsAccountNumber");
        val.add("bucketName");
        val.add("bucketARN");
        return val;
    }

    // secret Stdc config man filed
    public static List<String> secretsfdcconfignManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("tenantId");
        val.add("clientId");
        val.add("clientSecret");
        val.add("username");
        val.add("password");
        val.add("sfdcToken");
        return val;
    }
    // session  fetch session non man filed
    public static List<String> sessionfetchsessionnonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("email");
        val.add("fromDate");
        val.add("toDate");
        val.add("tenantId");
        return val;
    }
    // auth login man filed
    public static List<String>authloginManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("email");
        val.add("password");
        return val;
    }
    // auth refresh token man filed
    public static List<String>authrefreshtokenManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("refreshToken");
        return val;
    }
   //download mana save man field
   public static List<String>downloadmanageManField(){

       ArrayList<String> val = new ArrayList<String>();
       val.add("fileLocation");
       val.add("logoURL");
       val.add("name");
       val.add("platformType");
       val.add("versionNumber");
       return val;
   }
    //download mana save non man field

    public static List<String>downloadmanageNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("disabled");
        return val;
    }

    //download mana update man field
    public static List<String>downloadmanageupdateManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("docId");
        return val;
    }
    //download mana update non man field
    public static List<String>downloadmanageupdateNonManField(){

        ArrayList<String> val = new ArrayList<String>();
        val.add("fileLocation");
        val.add("logoURL");
        val.add("name");
        val.add("platformType");
        val.add("versionNumber");
        val.add("disabled");
        return val;
    }
}
