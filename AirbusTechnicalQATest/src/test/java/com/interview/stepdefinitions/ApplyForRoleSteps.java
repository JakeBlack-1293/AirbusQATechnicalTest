package com.interview.stepdefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import com.interview.pages.CareersPage;
import com.interview.pages.CareersPortal;

public class ApplyForRoleSteps {
    
    private WebDriver driver;
    private CareersPage careersPage; //Declares reference to page object
    private CareersPortal careersPortal; //Declares reference to page object

    @Given("the user is on the Careers page")
    public void the_user_is_on_the_careers_page() {
        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //consider using sleep if wait insn't working?
        driver.manage().window().maximize();
        driver.get("https://www.airbus.com/en/careers");
        
        //Pass the driver instance to initialize Page Object
        careersPage = new CareersPage(driver);
    }

    @When("the user clicks the explore opportunities button")
    public void the_user_clicks_on_explore_opportunities_button() {
        
        careersPage.clickPortalButton();

        //Get all open window handles
        java.util.Set<String> allWindows = driver.getWindowHandles();
    
        //Loop through them and switch to the newest one
        for (String windowHandle : allWindows) {
        driver.switchTo().window(windowHandle);
    }
    
        
    }

    @Then("the user is taken to the careers portal")
    public void the_user_is_sent_to_the_workday_careers_portal() {
        //Assertions always live in step definitions, keeping page objects purely structural
        
        String expectedUrl = "https://ag.wd3.myworkdayjobs.com/Airbus";
        String actualUrl =  driver.getCurrentUrl();

        //Checking to see if the URL we are on matches the URL we are expecting. If not, throw an error and fail test.
        Assert.assertEquals("Couldn't access the careers workday portal", expectedUrl, actualUrl);
        
        // Ensure browser is destroyed post-execution
        driver.quit();
    }

    @Given("the user is on the Careers Portal")
    public void the_user_is_on_the_careers_portal() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //consider using sleep
        driver.manage().window().maximize();
        driver.get("https://ag.wd3.myworkdayjobs.com/Airbus");
        
    
        careersPortal = new CareersPortal(driver);
    }

    @When("the user enters the role of Test Manager in the job search field")
    public void the_user_enters_search_term() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        careersPortal.enterSearchText("Test Manager");

    
        
    }

    @And("the user has selected United Kingdom from the location dropdown")
    public void the_user_selects_location() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        careersPortal.searchJobs();
        careersPortal.enterLocation("United Kingdom");
        

    
        
    }

    @Then("the user should be able to click on the Test Manager role")
    public void the_user_can_click_test_manager_role() {
        
    careersPortal.selectRoleTestManager();
    driver.quit();
    
    }


    @Given("the user has searched for the role of Test Manager")
    public void the_user_has_searched_for_Test_Manager() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //consider using sleep
        driver.manage().window().maximize();
        driver.get("https://ag.wd3.myworkdayjobs.com/Airbus");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        careersPortal = new CareersPortal(driver);

        careersPortal.enterSearchText("Test Manager");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        careersPortal.searchJobs();
        careersPortal.enterLocation("United Kingdom");

        
    }

    @When("the user selects the role")
    public void the_user_has_selected_role(){
        careersPortal.selectRoleTestManager();
        
    }

    @And("the user clicks Apply on the right hand pane")
    public void the_user_has_clicked_apply(){
        careersPortal.Apply();
    }

    @Then("the user should see a Start your Application popup")
    public void the_user_can_see_start_application_popup(){
        
        driver.findElement(By.cssSelector("div[aria-label='Start Your Application']"));
        driver.quit();
    }


}
