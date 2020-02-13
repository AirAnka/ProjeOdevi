package com.selenium.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class SetUp {

        private WebDriver driver;
        public String webSiteUrl = "https://www.n11.com/";
        public String selectedCartProduct;
        public String selectedItemPrice;
        public String cartPrice;
        public String pieceNumber;
        public boolean deletedCart=false;
        public int favoriesCount=0;
        public int willDeleteCart=0;

    @BeforeClass
    public void setUp() {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\AnkaGenc\\IdeaProjects\\seleniumn11project\\driver\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }



}




