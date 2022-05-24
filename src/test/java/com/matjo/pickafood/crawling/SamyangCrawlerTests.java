//package com.matjo.pickafood.crawling;
//
//import com.matjo.pickafood.admin.food.dto.FoodDTO;
//import com.matjo.pickafood.admin.food.service.FoodService;
//import com.matjo.pickafood.crawling.cj.CJFoodCrawler;
//import com.matjo.pickafood.crawling.config.SeleniumConfig;
//import com.matjo.pickafood.crawling.samyang.SamyangCrawler;
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@Log4j2
//@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
//public class SamyangCrawlerTests {
//
//  private SamyangCrawler crawler;
//  @Autowired(required = false)
//  private FoodService foodService;
//
//  @BeforeEach
//  public void ready() {
//    String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
//    String WEB_DRIVER_PATH = "/Users/suhong/Downloads/chromedriver"; // 드라이버 경로
//    System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
//    SeleniumConfig config =
//            new SeleniumConfig(WEB_DRIVER_ID,WEB_DRIVER_PATH);
//    crawler = new SamyangCrawler(config.getDriver());
//  }
//
//  @Test
//  public void testCrawlFoodList() throws Exception{
//
//    List<FoodDTO> foodDTOList = crawler.crawlFoodList();
//    foodDTOList.forEach(foodDTO -> {
//      foodService.insert(foodDTO);
//    });
//
//  }
//
//  @Test
//  public void testFoodService() {
//    FoodDTO food = new FoodDTO();
//    food.setCompany("삼양");
//    food.setIngredient("튀긴면, 라면스프");
//    food.setName("삼양라면");
//    foodService.insert(food);
//  }
//}
