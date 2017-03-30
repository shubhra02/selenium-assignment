package selenium

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.WebDriverWait

trait TestSetUp {

  val BASE_URL = "http://www.myntra.com/"
  val EMAIl = "shubhra.sharma93@gmail.com"
  val password = "22feb93"
  System.setProperty("webdriver.chrome.driver", "/home/knoldus/chromedriver")
  val capabilities = DesiredCapabilities.chrome()
  val driver = new ChromeDriver(capabilities)
  val webdriverwait = new WebDriverWait(driver, 10)



}