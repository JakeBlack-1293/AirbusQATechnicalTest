package com.interview.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class CareersPortal {
    
    private WebDriver driver;

    //Locating all the different elements we need to interact with on the page
    private By SearchTextField = By.cssSelector("input[data-automation-id='keywordSearchInput']");
    private By LocationDropdown = By.cssSelector("svg[class='wd-icon-caret-down-small wd-icon']");
    private By LocationText = By.cssSelector("input[data-automation-id='searchInput']");
    private By UnitedKingdomLocator = By.xpath("//*[contains(text(), 'United Kingdom')]"); //Had to use Xpath here as was only way I could locate element
    private By ViewJobsButton = By.cssSelector("button[data-automation-id='viewAllJobsButton']");
    private By SearchButton = By.cssSelector("button[data-automation-id='keywordSearchButton']");
    private By TestManagerRole = By.linkText("Test Manager");
    private By ApplyButton = By.linkText("Apply");
    

    
    


    //Constructor for page object
    public CareersPortal(WebDriver driver) {
        this.driver = driver;
    }

    
    //Entering a passed in paramater to the search text field and then pressing enter. This makes the portal search for the entered role. Could also use SearchButton as defined above.
    public void enterSearchText(String jobTitle) {
        driver.findElement(SearchTextField).sendKeys(jobTitle, Keys.ENTER);
    
    }

    //Selects location dropdown. Enters a passed in parameter to the location field, selects location from dropdown and then click view jobs button
    public void enterLocation(String location) {
        driver.findElement(LocationDropdown).click();
        driver.findElement(LocationText).sendKeys(location);
        
        driver.findElement(UnitedKingdomLocator).click();
        driver.findElement(ViewJobsButton).click();
    
    }


    public void viewJobs(){
        driver.findElement(ViewJobsButton).click();
    }


    public void searchJobs(){
        driver.findElement(SearchButton).click();
    }

    public void selectRoleTestManager(){
        driver.findElement(TestManagerRole).click();
    }

    public void Apply(){
        driver.findElement(ApplyButton).click();
    }

}

