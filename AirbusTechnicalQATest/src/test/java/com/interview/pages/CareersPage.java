package com.interview.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {
    
    private WebDriver driver;

    //Locating the Explore Opportunities portal button
    private By portalButton = By.cssSelector(".awx-button.awx-button--icon-after.awx-button--icon-after-chevron-right.awx-button--icon--animated"); 


     //Constructor for page object
    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    
    //Clicking the Explore opportunites button
    public void clickPortalButton() {
        driver.findElement(portalButton).click(); 
    }


}






