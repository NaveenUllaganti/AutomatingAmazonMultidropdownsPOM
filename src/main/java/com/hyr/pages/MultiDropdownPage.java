package com.hyr.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MultiDropdownPage {

   protected WebDriver driver;
   protected Select multiDropdown;

    @FindBy(id = "ide")
    public WebElement dropDown;

    public MultiDropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.multiDropdown = new Select(dropDown);
    }

    public void selectByIndex(int index) {
        multiDropdown.selectByIndex(index);
    }

    public void selectByValue(String value) {
        multiDropdown.selectByValue(value);
    }

    public void selectByVisibleText(String text) {
        multiDropdown.selectByVisibleText(text);
    }

    public void deselectByIndex(int index) {
        multiDropdown.deselectByIndex(index);
    }

    public void deselectAll() {
        multiDropdown.deselectAll();
    }

    public List<WebElement> getAllSelectedOptions() {
        return multiDropdown.getAllSelectedOptions();
    }

    public WebElement getFirstSelectedOption() {
        return multiDropdown.getFirstSelectedOption();
    }

    public List<WebElement> getOptions() {
        return multiDropdown.getOptions();
    }
}
