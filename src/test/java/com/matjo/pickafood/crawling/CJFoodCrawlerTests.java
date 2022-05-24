package com.matjo.pickafood.crawling;

import com.matjo.pickafood.admin.food.dto.FoodDTO;
import com.matjo.pickafood.admin.food.service.FoodService;
import com.matjo.pickafood.crawling.cj.CJFoodCrawler;
import com.matjo.pickafood.crawling.config.SeleniumConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@Log4j2
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class CJFoodCrawlerTests {

  private CJFoodCrawler crawler;
  @Autowired(required = false)
  private FoodService foodService;

  @BeforeEach
  public void ready() {
    String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    String WEB_DRIVER_PATH = "C:\\Users\\effir\\chromedriver.exe"; // 드라이버 경로
    System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
    SeleniumConfig config =
            new SeleniumConfig(WEB_DRIVER_ID, WEB_DRIVER_PATH);
    crawler = new CJFoodCrawler(config.getDriver());
  }

  @Test
  public void testCrawlFoodList() throws Exception {

    List<FoodDTO> foodDTOList = crawler.crawlFoodList();

    foodDTOList.forEach(foodDTO -> {
              System.out.println(foodDTO);
//      foodService.insert(foodDTO);
            });

//    for (int i = 0; i < foodDTOList.size() ; i++) {
//      foodService.insert(foodDTOList.get(i));
//      }
    }

    @Test
    public void testFoodService () {
      FoodDTO food = new FoodDTO();
      food.setCompany("삼양");
      food.setIngredient("튀긴면, 라면스프");
      food.setName("삼양라면");
      foodService.insert(food);
    }
  }
