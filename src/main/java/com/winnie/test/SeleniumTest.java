package com.winnie.test;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class SeleniumTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://34.16.4.251:8080/Rental");

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='username']"));
        WebElement password = driver.findElement( By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement( By.xpath("//button[normalize-space()='Login']"));


        username.sendKeys("njeri.com");
        password.sendKeys("1995");
        loginButton.click();


        WebElement houseLink  =driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/ul/li[2]/a"));
        houseLink.click();
        WebElement addHouse= driver.findElement(By.className("addHouseButton"));
        addHouse.click();

        WebElement addHouseNo= driver.findElement(By.id("houseNo"));
        WebElement addHouseName= driver.findElement(By.id("houseName"));
        WebElement addHouseNStatus= driver.findElement(By.id("houseStatus"));
        WebElement addHouseDescrption= driver.findElement(By.id("houseDescription"));
        WebElement addHouseType= driver.findElement(By.id("houseType"));
        WebElement addHouseLocation= driver.findElement(By.id("houseLocation"));
        WebElement addHousePrice= driver.findElement(By.id("housePrice"));
        WebElement addHouseButton= driver.findElement(By.xpath("//*[@id=\"panelBodyItemlist\"]/div/div/div/form/input[7]"));

        addHouseNo.sendKeys("0090A");
        addHouseName.sendKeys("vinny's apartment");
        addHouseNStatus.sendKeys("available");
        addHouseDescrption.sendKeys("located few kilometres from the road,with water backup");
        addHouseType.sendKeys("AIRBNB");
        addHouseLocation.sendKeys("Limuru");
        addHousePrice.sendKeys("200000");

        addHouseButton.click();



        String addedHouseName = driver.findElement(By.xpath("//tbody/tr[7]/td[2]")).getText();

        String addedHouseLocation = driver.findElement(By.xpath("(//td[contains(text(),'Limuru')])[1]]")).getText();
        String addedHousePrice = driver.findElement(By.xpath("///tbody/tr[7]/td[2]")).getText();
       // Asserting details of the added house
        Assert.assertEquals("Winnie's apartment",addedHouseName );/*
        Assert.assertEquals(addedHouseLocation, "Limuru",addedHouseLocation );*//*
        Assert.assertEquals(String.valueOf(addedHousePrice), "20000",addedHousePrice  );*/


//        driver.quit();
    }
}
