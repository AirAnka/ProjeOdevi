package com.selenium.webdriver;

import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testing extends com.selenium.webdriver.Page {
    WebDriverWait wait= new WebDriverWait(driver, 1000);

    @Test
    public void WebSiteTest(){
        driver.get(webSiteUrl);
        waitForPageLoad();
        Assert.assertTrue(driver.getTitle().equals("n11.com - Alışverişin Uğurlu Adresi"));
        System.out.println("Giriş Başarılı!");
    }

    @Test
    public void loginTest(){
        findByClassName("btnSignIn").click();
        findById("email").sendKeys("caleigha.aithana@eellee.org");
        findById("password").sendKeys("Testinium123*");
        findById("loginButton").click();
        waitForPageLoad();
        Assert.assertTrue(!findByClassName("username").getText().equals(""));
        System.out.println("Giriş Başarılı!");
}

    @Test
    public void searchTest(){
        wait.until(elementClickableById("searchData"));
        findById("searchData").sendKeys("bilgisayar");
        findByClassName("searchBtn").click();
        wait.until(elementClickableByClassName("pagination"));
        String resultOk=findByXpath("//section[2]/div/div").getText();
        Assert.assertTrue(resultOk.contains("sonuç bulundu."));
        System.out.println("Arama Başarılı!");
    }

    @Test
    public void page2Test(){
        findByXpath("//*[@class='pagination']/a[2]").click();
        waitForPageLoad();
        Assert.assertTrue(driver.getTitle().contains("bilgisayar - n11.com - 2/"));
        System.out.println("Sayfa 2 Açıldı!");
    }

    @Test
    public void addItemTest(){

        wait.until(elementClickableByXpath("//section[2]/div/div"));
        selectedCartProduct=getElementTextByXpath("//*[@id=\"p-400361774\"]/div[1]/a/h3");
        findByXpath("//*[@id=\"p-400361774\"]/div[1]/a/h3").click();
        System.out.println("Sepete Eklenen Ürün Adı : "+selectedCartProduct);
    }

    @Test
    public void equalPriceTest(){
    selectedItemPrice = getElementTextByXpath("//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[2]/div/div[1]/div/ins");
    findByClassName("myBasketList").click();
    cartPrice = getElementTextByXpath("//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[3]/div[2]/div/span");
    Assert.assertEquals(selectedItemPrice,cartPrice);
    System.out.println("Fiyat Doğru!");
    }

    @Test
    public void increasePieceTo2(){
        findByClassName("spinnerUp spinnerArrow").click();
        pieceNumber =  getElementTextByXpath("//*[@id=\"quantity_126795927481\"]");
        Assert.assertEquals(pieceNumber,"2");
        System.out.println("Adet Sayısı Doğru!");
    }

    @Test
    public void deleteSelectedCart(){
        findByXpath("//table[@id='watchList']/tbody/tr['"+willDeleteCart+"']/td/a").click();
        waitForPageLoad();
    }

    @Test
    public void empthCartTest(){

        boolean isThereProduct=false;
        List<WebElement> productTitles= findListByXpath("//*[@class='productTitle']/p/a");
        for (WebElement productTitle : productTitles) {
            String watchesProduct=productTitle.getText();
            if (watchesProduct.equals(selectedCartProduct)) {
                isThereProduct=true;
            }
        }
        Assert.assertFalse(isThereProduct);
        System.out.println("Sepette boş!");
    }
}