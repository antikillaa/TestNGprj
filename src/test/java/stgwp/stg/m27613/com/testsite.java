package stgwp.stg.m27613.com;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class testsite {

    public String baseUrl = "https://test-site.stg.m27613.com/";
    public WebDriver driver;
    private static final String driverPath = FilenameUtils.separatorsToSystem( "webdriver//chromedriver" );
    public String credentials = "{\n" +
            "  \"secretKey\": \"a6fcffac-4270-47a9-a821-299a883bd8be\",\n" +
            "  \"username\": \"swftest2_USER\",\n" +
            "  \"password\": \"123456qaB\"\n" +
            "}";
    public String username = "Testeri4";
    public String password = "Password!1";

    @BeforeMethod
    public void OpenUrl() {

        System.setProperty( "webdriver.chrome.driver", driverPath );
        driver = new ChromeDriver();
        driver.get( baseUrl );
        driver.manage().window().setSize( new Dimension( 1920, 1080 ) );
    }

    @AfterMethod
    public void cleanup() {

        driver.quit();
        System.out.println( "Browser closed" );
    }

    public void login() {

    driver.findElement( By.id( "api_credential" ) ).clear();

    driver.findElement( By.id( "api_credential" ) ).sendKeys(credentials);


        driver.findElement( By.xpath( "//*[@id='settings']/div[3]/button[2]" )).click();

        try {
            Thread.sleep( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    driver.findElement( By.xpath( "//*[@id='sign_before']/button" ) ).click();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    driver.findElement( By.id( "sign_username" ) ).sendKeys( username );

    driver.findElement( By.id( "sign_password" ) ).clear();

    driver.findElement( By.id( "sign_password" ) ).sendKeys( password );

    driver.findElement( By.xpath( "//*[@id='sign']/div/div/div[4]/div[2]/button" ) ).click();

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void checkGame(String title) {

        ArrayList<String> tabs1 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs1.get( 1 ) );

        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actual = driver.getTitle();
        Assert.assertEquals( actual, title );

        checkservererror();

        driver.close();

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 1 ) );

        try {
            Thread.sleep( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String actual2 = driver.getTitle();
        Assert.assertEquals( actual2, title );

        checkservererror();

        System.out.println( "Game popup closed" );
        driver.switchTo().window( tabs2.get( 0 ) );
        System.out.println( "Site builder tab closed" );
        driver.close();
    }

    public void checkservererror() {

        Boolean isPresent = driver.findElements(By.xpath( "//div[@class='wrapper-popup']//p[@class='popup-description']" )).size() > 0;
        Assert.assertFalse( isPresent);

    }

    @Test(priority = 1)
    public void Turtles() throws InterruptedException {
        String title = "888turtles";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_888t') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_888t') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void FuBaoBao() throws InterruptedException {
        String title = "Fu Bao Bao";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_fbb') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_fbb') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void FuFish() throws InterruptedException {
        String title = "Fu Fish";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_fufish_intw') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_fufish_intw') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

    @Test(priority = 1)
    public void LegendofDragonKoi() throws InterruptedException {
        String title = "Legend of Dragon Koi";

        login();

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-default btn-xs' and contains(@data-gamecode, 'sw_lodk') and contains(@data-playmode, 'fun')]" ) ).click( );

        ArrayList<String> tabs2 = new ArrayList<String>( driver.getWindowHandles() );
        driver.switchTo().window( tabs2.get( 0 ) );

        driver.findElement( By.xpath( "//*[@id='list_games']" +
                "/*[@class='game list-group-item col-lg-4 col-sm-6']" +
                "/a[@class='open_game btn btn-primary btn-xs' and contains(@data-gamecode, 'sw_lodk') and contains(@data-playmode, 'real')]" ) ).click( );

        checkGame(title);
    }

}