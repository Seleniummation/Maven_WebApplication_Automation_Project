package amazon.pages.stepdefinition;


import amazon.driverman.aDriver;
import amazon.objects.SignIn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AccountTest extends aDriver {

    @Given("^User is on amazon homepage$")
    public void Homepage() throws Throwable {

        baseURL();

    }

    @When("^I select account tab on homepage$")
    public void ShouldSelectAccountTab() throws Throwable {


        SignIn loginPg = new SignIn(driver);
        loginPg.getSignInPage();
    }

    @When("^Fill in \\\"([^\\\"]*)\\\" and \\\"([^\\\"]*)\\\" credential$")
    public void ShouldCompleteEmailAndPasswordFields(String email, String password) throws Throwable {

        {
            try {
                // Open the Excel file
                FileInputStream fis = new FileInputStream(System.getProperty("user.directory") + "//" + "src//main//resources//AmazonTestData.xls");
                // Access the required test data sheet
                HSSFWorkbook wb = new HSSFWorkbook(fis);
                HSSFSheet sheet = wb.getSheet("Login");
                // Loop through all rows in the sheet
                // Start at row 1 as row 0 is our mainmenu row
                for (int count = 1; count <= sheet.getLastRowNum(); count++) {
                    HSSFRow row = sheet.getRow(count);
                    System.out.println("Running test case " + row.getCell(0).toString());
                    // Run the test for the current test data row
                    runTest(row.getCell(1).toString(), row.getCell(2).toString());
                }
                fis.close();
            } catch (IOException e) {
                System.out.println("Test data file not found");

            }
        }

    }

    private static SignIn runTest(String email, String password) throws IOException {

        SignIn loginPg = new SignIn(driver);
        loginPg.setEmailAndPasswordAs(email,password);

        return new SignIn();

    }

    @When("^Submit sign in form$")
    public void ShouldClickSignInButton() throws Throwable {


        SignIn loginPg = new SignIn(driver);
        loginPg.submitForm();
    }


    @Then("^Sign in page displays customers username$")
    public SignIn ShouldDisplayUsername() throws Throwable {

        SignIn loginPg = new SignIn(driver);
        String username=loginPg.getUsername();
        assertEquals(username,loginPg.getUsername());

        return new SignIn();
    }




    }

