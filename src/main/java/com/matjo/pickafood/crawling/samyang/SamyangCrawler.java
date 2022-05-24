//package com.matjo.pickafood.crawling.samyang;
//
//import com.matjo.pickafood.admin.food.domain.FoodVO;
//import com.matjo.pickafood.admin.food.dto.FoodDTO;
//import com.matjo.pickafood.admin.food.mapper.FoodMapper;
//import com.matjo.pickafood.admin.food.service.FoodService;
//import com.matjo.pickafood.crawling.config.SeleniumConfig;
//import lombok.RequiredArgsConstructor;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.seleniumhq.jetty9.util.IO;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SamyangCrawler {
//
//  private final WebDriver driver;
//  private final String mainUrl = "https://www.samyangfoods.com/kor/brand/list.do";
//
//  public SamyangCrawler(WebDriver driver) {
//    this.driver = driver;
//  }
//
//  public static void main(String[] args) {
//    SeleniumConfig config = new SeleniumConfig(
//            "webdriver.chrome.driver",
//            "/Users/suhong/Downloads/chromedriver"
//    );
//    SamyangCrawler crawler = new SamyangCrawler(config.getDriver());
//
//
//  }
//
//  public List<FoodDTO> crawlFoodList() throws Exception {
//    driver.get(mainUrl);
//    Thread.sleep(5000);
//
//    int pageNum = driver.findElement(By.className("paging")).findElement(By.tagName("p")).findElements(By.tagName("a")).size();
//
//    List<FoodDTO> result = new ArrayList<>();
//    for (int i = 0; i < pageNum; i++){
//      List<FoodDTO> foodListOfPage = new ArrayList<>();
//      List<WebElement> pages = driver.findElement(By.className("paging")).findElement(By.tagName("p")).findElements(By.tagName("a"));
//      pages.get(i).click();
//
//      Thread.sleep(1000);
//
//      List<WebElement> foodList = driver.findElement(By.className("product-list")).findElements(By.tagName("li"));
//
//
//      foodList.forEach(foodLi -> {
//        FoodDTO food = new FoodDTO();
//        food.setName(foodLi.findElements(By.tagName("div")).get(1).getText());
//        String strContainingNum = foodLi.findElement(By.tagName("a")).getAttribute("onclick");
//        // strContainingNum = "javascript:fnView('./view.do','545')"
//        String temp1 = strContainingNum.substring(0, strContainingNum.lastIndexOf("'"));
//        // temp1 = "javascript:fnView('./view.do','545"
//        String temp2 = temp1.substring(temp1.lastIndexOf("'") + 1);
//        // temp2 = "545"
//        food.setUrl("https://www.samyangfoods.com/kor/brand/view.do?seq=" + temp2);
//        food.setMainImage(foodLi.findElement(By.tagName("img")).getAttribute("src"));
//        foodListOfPage.add(food);
//      });
//
//      Thread.sleep(3000);
//
//      foodListOfPage.forEach(food -> {
//        driver.get(food.getUrl());
//        try {
//          Thread.sleep(1000);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//
//        List<WebElement> pTags = driver.findElements(By.className("product-view-text")).get(1).findElements(By.tagName("p"));
//        StringBuilder builder = new StringBuilder();
//        pTags.forEach(p -> {
//          String current = p.getText();
//          current.replaceFirst("면*:", "");
//          current.replaceFirst("스프*:", "");
//          current.replaceFirst(".", ",");
//          builder.append(p.getText());
//        });
//
//        food.setIngredient(builder.toString());
//        food.setCompany("삼양");
//        food.setCompanyCategory("40003");
//        result.add(food);
//      });
//      driver.get(mainUrl);
//      Thread.sleep(3000);
//    }
//
////    result.forEach(food -> {
////      System.out.println(food.getIngredient());
////    });
////
////    System.out.println(result.size());
//    driver.close();
//    driver.quit();
//    return result;
//  }
//}
