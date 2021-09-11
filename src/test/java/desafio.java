import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.annotation.This;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class desafio {

    private WebDriver driver;

    @Before
    public void main(){
        System.setProperty("webdriver.gecko.driver", "C:/drive/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

    }

    @Test
    public void fluxPrincipal(){

        driver.findElement(By.name("username")).sendKeys("Aluno1");

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("22 Password");

        WebElement commentBox =  driver.findElement(By.name("comments"));
        commentBox.clear();
        commentBox.sendKeys("Texto");


        commentBox.sendKeys("TextoInterativo");

        driver.findElement(By.xpath("//input[@value='cb1']")).click();

        driver.findElement(By.xpath("//input[@value='cb2']")).click();

        driver.findElement(By.xpath("//input[@value='submit']")).click();

        Assert.assertEquals("Aluno1", driver.findElement(By.id("_valueusername")).getText());
        Assert.assertEquals("22 Password", driver.findElement(By.id("_valuepassword")).getText());
        Assert.assertEquals("Texto", driver.findElement(By.id("_valuecomments")).getText());
        Assert.assertEquals("cb1", driver.findElement(By.id("_valuecheckboxes0")).getText());
        Assert.assertEquals("cb2", driver.findElement(By.id("_valuecheckboxes1")).getText());
        Assert.assertEquals("cb3", driver.findElement(By.id("_valuecheckboxes2")).getText());
        Assert.assertEquals("rd2", driver.findElement(By.id("_valueradioval")).getText());
        Assert.assertEquals("ns4", driver.findElement(By.id("_valuemultipleselect0")).getText());
        Assert.assertEquals("ddb", driver.findElement(By.id("_valueradioval")).getText());





    }

    @Test
    public void fluxSegundario(){

        WebElement commentBox =  driver.findElement(By.name("comments"));
        commentBox.clear();

        driver.findElement(By.xpath("//input[@value='submit']")).click();

        Assert.assertEquals("No Value for username", driver.findElement(By.id("")).getText());
        Assert.assertEquals("No Value for password", driver.findElement(By.id("")).getText());
        Assert.assertEquals("No Value for comments", driver.findElement(By.id("")).getText());





    }

}



