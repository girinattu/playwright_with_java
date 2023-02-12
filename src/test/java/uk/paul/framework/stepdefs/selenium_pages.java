package uk.paul.framework.stepdefs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import uk.paul.framework.pages.SeleniumPages;


public class selenium_pages {
    Playwright playwright = Playwright.create();

    Browser browser = playwright.chromium().launch();
    Page page = browser.newPage();
    SeleniumPages seleniumPages= new SeleniumPages();


    @And("^the user is on selenium.dev page$")
    public void openSeleniumDevPage(){
    page.navigate(seleniumPages.url);
    }

    @And("^the user clicks on (.*) link$")
    public void click_on_links(String linkName){
        String getGenericLink;
        if(linkName.equalsIgnoreCase("Read More")){
            getGenericLink = seleniumPages.generic_links.replace("to_replace/","");
        }
        else {
            getGenericLink = seleniumPages.generic_links.replace("to_replace", linkName);
        }
        page.click(getGenericLink);
    }

    @Then("^the webdriver documentation is opened$")
    public void verify_page_opened(){
        assertThat(page.locator(seleniumPages.webdriver_header)).containsText("WebDriver");
    }


    @Then("^the user is presented with the 'Getting Started' page$")
    public void verify_getting_started_page(){
        assertThat(page.locator(seleniumPages.webdriver_header)).containsText("Getting started");
    }

}
