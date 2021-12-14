import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class techTest {
    public static void main(String[] args) {
        techTest t = new techTest();
        int[] firstRow = {23, 50, 63, 90, 10, 30, 155, 23, 18};
        int[] secondRow = {133, 60, 23, 92, 6, 7, 168, 16, 19};
        int[] thirdRow = {30, 43, 29, 10, 50, 40, 99, 51, 12};

        System.setProperty("webdriver.chrome.driver","/techTest/seleniumJava/src/utils/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setCapability(ChromeOptions.CAPABILITY, options);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Wait wait = new FluentWait(driver);
        String baseUrl = "http://localhost:3000/";

        driver.get(baseUrl);
        driver.findElement(By.cssSelector("[data-test-id=\"render-challenge\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table tbody")));
        driver.findElement(By.cssSelector("[data-test-id=\"submit-1\"]")).sendKeys(t.middleIndex(firstRow));
        driver.findElement(By.cssSelector("[data-test-id=\"submit-2\"]")).sendKeys(t.middleIndex(secondRow));
        driver.findElement(By.cssSelector("[data-test-id=\"submit-3\"]")).sendKeys(t.middleIndex(thirdRow));
        driver.findElement(By.cssSelector("[data-test-id=\"submit-4\"]")).sendKeys("Chris");
        driver.findElement(By.xpath("//button//*[text()='Submit Answers']")).click();
        driver.close();

//        System.out.println(t.middleIndex(firstRow));
//        System.out.println(t.middleIndex(secondRow));
//        System.out.println(t.middleIndex(thirdRow));
    }

    public int sum(int startPosition, int endPosition, int[] arr) {
        int sum = 0;
        for (int i = startPosition; i < endPosition; i++)
            sum += arr[i];
        return sum;
    }

    public String middleIndex(int[] arr) {
        int sum1 = 0, sum2 = 0;
        int mid = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                //{23, 50, 63, 90, 10, 30, 155, 23, 18};
                sum1 = sum(0, mid, arr);
                sum2 = sum(mid + 1, arr.length, arr);
            } if (sum1 > sum2 && i > 0) {
                mid = mid - i;
                sum1 = sum(0, mid, arr);
                sum2 = sum(mid + 1, arr.length, arr);
            } else if (sum1 < sum2 && i > 0) {
                mid = mid + i;
                sum1 = sum(0, mid, arr);
                sum2 = sum(mid + 1, arr.length, arr);
            }
            if (sum1 == sum2) {
                System.out.println("Middle element index is: " + mid);
                return String.valueOf(mid);
            }
        }
        return null;
    }

}
