/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testautomationdemo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author giao-lang
 */
public class TestAutomationDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //viết đoạn code demo thao tác người dùng test FAP (web app)
        //1. mở trình duyệt
        //2. đưa vào cái url fap.fpt.edu.vn
        //3. thấy đc login
        //4. ...
        
        //ta cần:
        //webdriver, bộ thu gọn của trình duyệt mình xài, cho phép gọi
        //các hàm của trình duyệt để yc trình duyệt làm những điều mà 
        //user xài trình duyệt - viết code giả người dùng xài trình duyệt
        
        //cần bộ thư viện kết nối với webdriver (.jar) giống y chang
        //jdbc....jar để kết nối csdl
        
        //viết code gọi hàm của thư viện móc tới webdriver
        
        //run
        
        //...
        //testTwoPagesOfASampleSite();
        testTravelSite();
       
    }
    
    public static void testTwoPagesOfASampleSite() {
         //lauch the browser
        String exePath = "C:\\Users\\giao-lang\\Desktop\\code.truong.lang\\SWT301_F2\\TestAutomationDemo\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();

        //connect to a website, load the 1st Page
        driver.get("http://toolsqa.com/automation-practice-form/");

        //maximize the browse
        driver.manage().window().maximize();

        //find an HTML element to get its data 
        //check if the 1st Page is loaded sucessfully
        WebElement pageHeaderElement = driver.findElement(By.xpath("//div[@class='page-title-head hgroup']"));
        String header1 = pageHeaderElement.getText();
        if (!header1.equals("Automation Practice Form")) {
            System.out.println("Ahuhu, this not not my page as I need. Wrong title!!!");
        }
        else
            System.out.println("1st page is correct!!!");

//        //assertEquals("Demo Form for practicing Selenium Automation", driver.getTitle());
//        //click on Link Test
//        driver.findElement(By.xpath("//a[@title='Automation Practice Table']")).click();
//        //check if 2nd Page is loaded
//        String header2 = driver.findElement(By.xpath("//div[@class='page-title-head hgroup']")).getText();
//        //or can use this statement: String header2 = pageHeaderElement.getText();
//
//        if (!header2.equals("Automation Practice Table")) {
//            flag = false;
//            System.out.println("Can't see the Table");
//            Logger.getAnonymousLogger().log(Level.ALL, "Can't see the Table");
//        }
    }
    
    public static void testTravelSite() {
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
        System.out.println(h3.getText());        
        
        
    }
    
}
