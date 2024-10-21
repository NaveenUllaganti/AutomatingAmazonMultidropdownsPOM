package com.hyr.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hyr.base.Base;
import com.hyr.pages.MultiDropdownPage;

public class MultiDropdownTest extends Base {

    MultiDropdownPage multiDropdownPage;

    @Test(priority = 1)
    public void testMultiDropdownSelections() {
        multiDropdownPage = new MultiDropdownPage(driver);

        wait.until(ExpectedConditions.visibilityOf(multiDropdownPage.dropDown));

        multiDropdownPage.selectByIndex(3);
        multiDropdownPage.selectByValue("ij");

        // Get all selected options
        List<WebElement> selectedOptions = multiDropdownPage.getAllSelectedOptions();
        System.out.println("Selected Options:");
        for (WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Assert the selected options count
        Assert.assertEquals(selectedOptions.size(), 2);
        Assert.assertEquals(selectedOptions.get(0).getText(), "IntelliJ IDEA");
    }

    @Test(priority = 2)
    public void testDeselectAndSelectNewOption() {
        multiDropdownPage = new MultiDropdownPage(driver);

        wait.until(ExpectedConditions.visibilityOf(multiDropdownPage.dropDown));

        multiDropdownPage.selectByIndex(3);
        multiDropdownPage.deselectByIndex(3);
        multiDropdownPage.selectByVisibleText("Eclipse");

        // Get the first selected option
        WebElement firstSelected = multiDropdownPage.getFirstSelectedOption();
        System.out.println("First Selected Option: " + firstSelected.getText());

        // Assert the first selected option
        Assert.assertEquals(firstSelected.getText(), "Eclipse");
    }

    @Test(priority = 3)
    public void testDeselectAllAndPrintAvailableOptions() {
        multiDropdownPage = new MultiDropdownPage(driver);

        wait.until(ExpectedConditions.visibilityOf(multiDropdownPage.dropDown));

        multiDropdownPage.selectByIndex(2);
        multiDropdownPage.selectByVisibleText("Eclipse");
        multiDropdownPage.deselectAll();

        // Get all selected options (should be empty after deselectAll)
        List<WebElement> selectedOptions = multiDropdownPage.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.isEmpty());

        // Get and print all available options in the dropdown
        List<WebElement> allOptions = multiDropdownPage.getOptions();
        System.out.println("All Available Options:");
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
    }
}
