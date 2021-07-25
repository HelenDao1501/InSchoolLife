/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testautomationdemo.TestAutomationDemo;

/**
 *
 * @author giao-lang
 */
public class TravelSiteTest {
    
    @Test
    public void testLogin() {
        String exePath = "C:\\Users\\giao-lang\\Desktop\\code.truong.lang\\SWT301_F2\\TestAutomationDemo\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();

        //connect to a website, load the 1st Page
        driver.get("https://www.phptravels.net/login");

        //maximize the browse
        driver.manage().window().maximize();
        
        WebElement user = driver.findElement(By.name("username"));
        user.sendKeys("user@phptravels.com");
        
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("demouser");
        
        //tìm nút login, nó lại ko xài name, id luôn 
        //tìm qua đặc tính class btn btn-primary btn-lg btn-block loginbtn
        WebElement btnLogin = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']"));
        btnLogin.click();
        
        //sau lệnh click() trang Welcome đã xuất hiện 
        //có lời chào Hello FullName của gã login vào
        //và ta cần kiểm tra có đúng chào FullName hay ko, nếu ko đúng coi
        //như là 1 bug mà dev cần sửa
        
        //ta tiếp tục đi tìm Web element chứa dòng text Hello FullName gì đó
        //lấy text ra, so coi có đúng mình cần hay ko
        try {
            //ta đi tìm chỗ chào, tức là thẻ h3
            //coi chừng trang sau màn hình login chưa kịp lên do có quá nhiều
            //component phải xử lí, load về, ta cần wait 1 chút
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestAutomationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        WebElement h3 = driver.findElement(By.xpath("//div[@class='row align-items-center']//h3"));
        assertEquals("Hi, Demo User", h3.getText());
    }
    
}
