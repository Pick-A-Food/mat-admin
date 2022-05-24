package com.matjo.pickafood.crawling.config;

import lombok.Data;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@Data
public class SeleniumConfig {

  private final String WEB_DRIVER_ID; // 드라이버 ID
  private final String WEB_DRIVER_PATH; // 드라이버 경로

  private final WebDriver driver;

  public SeleniumConfig(String WEB_DRIVER_ID, String WEB_DRIVER_PATH) {
    this.WEB_DRIVER_ID = WEB_DRIVER_ID;
    this.WEB_DRIVER_PATH = WEB_DRIVER_PATH;
    ChromeOptions options = new ChromeOptions();

    this.driver = new ChromeDriver(options);

//    DesiredCapabilities capabilities = new DesiredCapabilities();
//    capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
    // options.addArguments("headless"); // 브라우저 안 보이기
//    this.driver = new ChromeDriver(capabilities);
  }
}
