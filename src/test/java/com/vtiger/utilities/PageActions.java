package com.vtiger.utilities;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.Data;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Logger;

public class PageActions {

    public WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest logger;

    public PageActions(WebDriver driver, ExtentTest logger )
    {
        this.driver = driver;
        this.logger = logger;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void setInput(WebElement elm, String val, String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
            logger.pass(msg);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter text into Textbox due to error message"+e.getMessage());
        }
    }

    public void setInput(String str, String val, String msg)
    {
        try
        {
            WebElement elm = driver.findElement(By.xpath(str));
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
            logger.pass(msg);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter text into Textbox due to error message"+e.getMessage());

        }
    }

    public void setInput(By elmtxt, String val,String msg)
    {
        try
        {
            WebElement elm = driver.findElement(elmtxt);
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
            logger.pass(msg);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter text into Textbox due to error message"+e.getMessage());

        }
    }


    public void clickElement(WebElement elm,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            logger.pass(msg);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to click on element due to error message"+e.getMessage());

        }
    }

    public void ElementExist(WebElement elm,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.isDisplayed();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to find the element due to error message"+e.getMessage());

        }
    }

    public void selectVisibleText(WebElement elm, String val,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            Select sel = new Select(elm);
            sel.selectByVisibleText(val);
            logger.pass(msg);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to select value from dropdown due to error message"+e.getMessage());

        }
    }

    public String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String FileName = ft.format(d);
        String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshot/"+FileName+".png";
        TakesScreenshot ts =((TakesScreenshot) driver);
        File Srcfile = ts.getScreenshotAs(OutputType.FILE);
        //move image to new destination
        File DestFile =  new File(path);
        //copy file at destination
        try
        {
            FileUtils.copyFile(Srcfile, DestFile);
        }
        catch (Exception e)
        {
            //to do auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }




}
