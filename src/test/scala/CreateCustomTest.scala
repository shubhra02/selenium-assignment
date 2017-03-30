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
  }


  "user" should "search for watches category" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.desktop-searchBar")))

    val search: WebElement =driver.findElementByCssSelector("input.desktop-searchBar")
    search.sendKeys("watches")
    driver.findElementByCssSelector("a.desktop-submit").click()
  }

  "user" should "select a watch" in {

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product-base a:nth-child(2)")))
    driver.findElementByCssSelector("li.product-base a:nth-child(2)").click()
  }

  "user" should "be able to add the watch to the cart" in {

    driver.findElementByCssSelector("button.pdp-add-to-bag.pdp-button").click()

  }

  "user" should "be able to verify the products added to cart" in {

    driver.findElementByCssSelector("a.desktop-cart").click()
  }

  "user" should "be able to checkout" in {

    driver.findElementByCssSelector("div.order-total.footer div.place-order.b-white button.btn.primary-btn.btn-continue.m-button.clickable ").click()
    driver.findElementByCssSelector("input.pincode").sendKeys("110096")
    driver.findElementByCssSelector("input.locality").click()
    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.suggestions div.bd button")))
    driver.findElementByCssSelector("div.suggestions div.bd button").click()
    driver.findElementByCssSelector("input.name").sendKeys("Charmy Garg")
    driver.findElementByCssSelector("textarea.address").sendKeys("Sector 36, Noida")
    driver.findElementByCssSelector("input.mobile").sendKeys("9867574838")
    driver.findElementByCssSelector("button.green-button.submit.clickable").click()

    webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.primary-btn.btn-continue.green-button.clickable")))
    driver.findElementByCssSelector("button.btn.primary-btn.btn-continue.green-button.clickable").click()
  }

}