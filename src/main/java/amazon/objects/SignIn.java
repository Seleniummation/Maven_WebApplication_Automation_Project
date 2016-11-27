package amazon.objects;



import amazon.driverman.aDriver;
import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn extends aDriver {
    public SignIn(WebDriver driver) {
        super();
    }

    public SignIn (){

    }

    public SignIn getSignInPage(){
        //yourAccountBtn

       new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nav-link-yourAccount']/span[2]/span")));

        WebElement mail2 = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[2]/span"));
        mail2.click();
        return new SignIn();
    }

    public SignIn setEmailAndPasswordAs(java.lang.String email, java.lang.String password){

        new WebDriverWait(driver, 80).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ap_email")));


        WebElement mail = driver.findElement(By.cssSelector("#ap_email"));
        mail.clear();
        mail.sendKeys(email);

        WebElement passWrd = driver.findElement(By.cssSelector("#ap_password"));
        passWrd.clear();
        passWrd.sendKeys(password);

        return new SignIn();

    }

    public SignIn submitForm (){

        java.lang.String customerId="";

        WebElement signInBtn = driver.findElement(By.cssSelector("#signInSubmit"));
        signInBtn.click();

        return new SignIn();


    }

    public java.lang.String getUsername(){

        new WebDriverWait(driver,80).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]")));


            WebElement usrNamFld = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']/span[1]"));
            usrNamFld.getText();

            System.out.println(usrNamFld.getText());



        return new java.lang.String();
    }


    public SignIn signOut() throws InterruptedException {

      new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/gp/flex/sign-out.html/ref=nav_youraccount_signout?ie=UTF8&action=sign-out&path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1']")));


        WebElement logout=driver.findElement(By.cssSelector("a[href='/gp/flex/sign-out.html/ref=nav_youraccount_signout?ie=UTF8&action=sign-out&path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1']"));
        logout.click();
        //System.out.println(logout.getText());






        return new SignIn();
    }
}




