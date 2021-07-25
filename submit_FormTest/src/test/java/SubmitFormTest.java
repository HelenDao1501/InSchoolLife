import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;

public class SubmitFormTest {
    private String url = "https://demoqa.com/automation-practice-form";
    private WebDriver driver;
    private String sheetName = "Sheet1";
    private String filePath = ".\\src\\testData.xlsx\\";
    private final String webDriverUrl = "D:/JAVA API/chromedriver.exe";

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:/JAVA API/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void close() {
        driver.quit();
    }

    @DataProvider(name = "formData")
    public Object[][] getData() throws Exception {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int colCount = 12;
        Object[][] inputData = new String[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);

            int n = row.getLastCellNum();
            for (int j = 1; j < n; j++) {
                inputData[i - 1][j - 1] = row.getCell(j).toString();

            }
        }


        return inputData;

    }

    @Test(dataProvider = "formData")
    public void testSubmitForm(String firstName, String lastName, String email, String gender, String mobile,
                               String dateOBirth, String subject, String hobbies, String currentAddress, String stateAndCiry, String picture, String expected) {

        driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        WebElement genderButton = driver.findElement(By.xpath("//*[@name='gender' and @value='" + gender + "']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click()", genderButton);
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(mobile);
        WebElement birthdateInput = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        jse.executeScript("arguments[0].value='" + dateOBirth + "';", birthdateInput);
        driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys(subject);
        driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(currentAddress);
        driver.findElement(By.xpath("//*[@id='uploadPicture']")).sendKeys(picture);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id='submit']"));
        if (hobbies.equalsIgnoreCase("Sports")) {
            WebElement cbHobbie = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
            jse.executeScript("arguments[0].click()", cbHobbie);
        } else if (hobbies.equalsIgnoreCase("Reading")) {
            WebElement cbHobbie = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
            jse.executeScript("arguments[0].click()", cbHobbie);
        } else {
            WebElement cbHobbie = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
            jse.executeScript("arguments[0].click()", cbHobbie);
        }

        jse.executeScript("arguments[0].click()", submitButton);

        WebElement succsessPopup = driver.findElement(By.xpath("//div[@role='document']"));
        if(expected.equalsIgnoreCase("Pass")){
            Assert.assertNotNull(succsessPopup);
        }
        else{
            Assert.assertNull(succsessPopup);
        }



    }
}
