package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.BaseTest;

import java.io.IOException;

import org.testng.Assert;
import Pages.LoginPage;
import Utils.ExcelUtils;
import Utils.ExtentReportManager;
//import jdk.internal.org.jline.utils.Log;
import Utils.log;
public class LoginTest extends BaseTest {
	
	@DataProvider(name="LoginData")//wherever we want to use the data, use this provider
	public Object[][] getLoginData() throws IOException{
		
		String filePath=System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath,"Sheet1");
		int rowCount=ExcelUtils.getRowCount();
		Object[][] data=new Object[rowCount-1][2];
		
		for(int i=1; i<rowCount; i++) {
			data[i-1][0]=ExcelUtils.getCellData(i, 0);//Username
			data[i-1][1]=ExcelUtils.getCellData(i,1); //Password
				
		}
		ExcelUtils.closeExcel();
		return data;
		
	}
	
	
	@DataProvider(name="LoginData2")
	public Object[][] getdata(){
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"admin@yourstore.com","admin"}
			
		};
	}
	
	
    
    //@Test(dataProvider="LoginData")//give the specific dataprovider name to fetch data.
	@Test
	@Parameters({"username","password"})//get parameters from the testng
    public void testValidLogin(String username,String password) {//username and password here comes from dataProvider
    	
    	log.info("Starting the Login Test...");
    	
    	test=ExtentReportManager.createTest("Login Test");
    	
    	test.info("Navigating to the URL");
        LoginPage loginPage = new LoginPage(driver);
        
        
        log.info("Adding Credentials");
        test.info("Adding Credentials");
       // loginPage.enterUsername("admin@yourstore.com");
       // loginPage.enterPassword("admin");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        test.info("Clcking the Login Button");
        loginPage.clickLogin();
        
        System.out.println("Title of the page :"  +driver.getTitle());
       log.info("Verfifing Page Title");
       test.info("Verifing Page Title");
       test.pass("Login Successful");
       Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
       
       
    }
	
	//Invalid credentials from the DataProvider
	@Test(dataProvider="LoginData2")
    public void testLoginwithInvalidCredentials(String username,String password) {//username and password here comes from dataProvider
    	
    	log.info("Starting the Login Test...");
    	
    	test=ExtentReportManager.createTest("Login Test with Invalid credentials");
    	
    	test.info("Navigating to the URL");
        LoginPage loginPage = new LoginPage(driver);
        
        
        log.info("Adding Credentials");
        test.info("Adding Credentials");
       // loginPage.enterUsername("admin@yourstore.com");
       // loginPage.enterPassword("admin");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        test.info("Clcking the Login Button");
        loginPage.clickLogin();
        
        System.out.println("Title of the page :"  +driver.getTitle());
       log.info("Verfifing Page Title");
       test.info("Verifing Page Title");
       test.pass("Login Successful");
       Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
       
       Math.random()
       
       int p1=
       char c1=
       
       senthil
       tenshil
       tlnshie
       
       int p2=
       char c2=
    }
}