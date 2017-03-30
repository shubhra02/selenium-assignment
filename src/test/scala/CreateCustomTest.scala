package selenium

import java.util.concurrent.TimeUnit

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.FlatSpec
import org.openqa.selenium.support.ui.Select

class CreateCustomTest extends FlatSpec with TestSetUp {

  "A user" should "visit on jabong.com" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)
    val title = driver.getTitle()
    val page_source = driver.getPageSource().length
    if (driver.getCurrentUrl == BASE_URL) {
      println("WELCOME TO MYNTRA.com with title : " + title)
      println("the length of the pagesource is: " + page_source)
    } else {
      println("something went wrong")
    }
  }

  "user" should "fail to login with invalid credentials" in {

    driver.manage().window().maximize()
    driver.get(BASE_URL)

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys("abc@gmail.com")

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys("xyz")

    driver.findElementByCssSelector("button.login-login-button").click()
  }


  "user" should "be logged in " in {

    val dropDown = driver.findElementByCssSelector("div.desktop-user")
    val mouseHover = new Actions(driver)
    mouseHover.moveToElement(dropDown)
    mouseHover.build().perform()

    driver.findElementByCssSelector("div.desktop-getUserInLinks.desktop-getInLinks a:nth-child(2)").click()

    driver.findElementByCssSelector("input.login-user-input-email.login-user-input").sendKeys(EMAIl)

    driver.findElementByCssSelector("input.login-user-input-password.login-user-input").sendKeys(password)

    driver.findElementByCssSelector("button.login-login-button").click()
    Thread.sleep(1000)
  }


  "user" should "search for bags category" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.desktop-searchBar")))

    val search: WebElement =driver.findElementByCssSelector("input.desktop-searchBar")
    search.sendKeys("bags")
    driver.findElementByCssSelector("a.desktop-submit").click()
  }

 "user" should "select a bag" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.results-base > li.product-base")))
    driver.findElementByCssSelector("ul.results-base > li.product-base").click()
  }

  "user" should "be able to add the bag to the cart" in {

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()

  }

   "user" should "be able to verify the products added to cart" in {

    driver.findElementByCssSelector("a.desktop-cart").click()
  }

  "user" should "Add a mailing address" in {

    driver.findElementByCssSelector("div.order-total.footer div.place-order.b-white button.btn.primary-btn.btn-continue.m-button.clickable ").click()
    driver.findElementById("pincode").sendKeys("201301")
    driver.findElementById("locality").click()
    Thread.sleep(3000)
    driver.findElementById("locality").click()
    driver.findElementByCssSelector(".bd button:nth-child(2)").click()
    driver.findElementById("name").sendKeys("Shubhra Sharma")
    driver.findElementById("address").sendKeys("Noida")
    driver.findElementById("mobile").sendKeys("9753257891")
    driver.findElementByCssSelector(".white-row.buttons .green-button.submit.clickable").click()
    Thread.sleep(3000)

  }

  "user" should "place order at mailing address" in {

    driver.findElementByCssSelector("button.btn.primary-btn.btn-continue.green-button.clickable").click()
    Thread.sleep(3000)
    driver.close()


  }


}