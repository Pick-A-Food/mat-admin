package com.matjo.pickafood.crawling.cj;

import com.matjo.pickafood.admin.food.dto.FoodDTO;
import com.matjo.pickafood.crawling.config.SeleniumConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CJFoodCrawler2 {

    private final WebDriver driver;
    private final String mainUrl = "https://www.cjthemarket.com/pc/ctg/ctgList?ctgrId=0022";

    public CJFoodCrawler2(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) {
        SeleniumConfig config = new SeleniumConfig(
                "webdriver.chrome.driver",
                "C:\\Users\\effir\\chromedriver.exe"
        );
        CJFoodCrawler crawler = new CJFoodCrawler(config.getDriver());
    }

    public List<FoodDTO> crawlFoodList() throws Exception {
        driver.get(mainUrl);
        Thread.sleep(5000);

        List<FoodDTO> productObjs = new ArrayList<>();

        int prdCount = driver.findElement(By.id("prodListArea")).findElements(By.className("product-item")).size();
        List<WebElement> productList = driver.findElement(By.id("prodListArea")).findElements(By.className("product-item"));

        productList.forEach(productLi -> {
            FoodDTO product = new FoodDTO();
            String aTagData = productLi.findElement(By.tagName("a")).getAttribute("data-gatraceinfo");

            int underBar = aTagData.indexOf("_");
            String prdNum = aTagData.substring(underBar - 8, underBar);
            String prdName = aTagData.substring(underBar + 1, aTagData.lastIndexOf("\""));

            product.setNum(Integer.parseInt(prdNum));
            product.setName(prdName);
            productObjs.add(product);

            if(prdName.contains("]")){
                int start = prdName.indexOf("[");
                int end = prdName.lastIndexOf("]");
                String prdNameResult = (prdName.substring(0, start)) + (prdName.substring(end+1, prdName.length()));
                product.setName(prdNameResult);
            }

        }); // productList
//    } // for

//    System.out.println(productObjs);
//    System.out.println(productObjs.size());
        System.out.println(prdCount);
        System.out.println("===============================================");

        Thread.sleep(2000);

        for (int i = 0; i < prdCount; i++) {
//    for (int i = 0; i < productObjs.size(); i++) {
            driver.get("https://www.cjthemarket.com/pc/prod/prodDetail?prdCd=" + productObjs.get(i).getNum() + "&ctgrId=0018&plnId=&giftSetEvntId=");
            Thread.sleep(1500);

            while (true) {
                if(ExpectedConditions.alertIsPresent().apply(driver)==null){
                    driver.findElement(By.xpath("//*[@id=\"prdInfoArea\"]/ul/li[1]/a")).click();

                    Thread.sleep(3000);

                    List<WebElement> allergyInfo = driver.findElement(By.className("table-default")).findElements(By.tagName("tr"));
                    String allergy = allergyInfo.get(6).getText();
                    String sameFactory = null;
                    String ingredient = null;

                    String[] temp1 = allergyInfo.get(5).getText().split("\n");  // 원재료
                    try{
                        String temp1Result = temp1[0].toString();
                        ingredient = temp1Result.substring(temp1Result.indexOf("원재료 및 함량") + 9, temp1Result.length());
                    }

                    catch(Exception e) {
                        String temp1Result = temp1[1].toString();
                        ingredient = temp1Result.substring(0, temp1Result.length());
                    }

                    if(ingredient.contains("■")){
                        ingredient = ingredient.substring(ingredient.indexOf("■")+2, ingredient.length());
                    }

                    if(allergy.contains("이 제품은")) {
                        int start = allergy.indexOf("이 제품은");

                        if(allergy.contains("혼입")){
                            int end = allergy.indexOf("혼입");
                            sameFactory = allergy.substring(start + 6, end - 1);
                        }

                        if(allergy.contains("사용한")){
                            int end = allergy.indexOf("사용");
                            sameFactory = allergy.substring(start + 6, end - 2);
                        }
                        else {
                            int end = allergy.indexOf("제품과");
                            sameFactory = allergy.substring(start + 6, end - 6);
                        }

                        allergy = allergy.substring(0, start-2);
                        productObjs.get(i).setSame_factory(sameFactory);
                    } // if (sameFactory) - 알레르기 물질 함유

                    if(allergy.contains("알레르기 유발물질 함유")){
                        allergy = allergy.substring(allergy.indexOf("알레르기 유발물질 함유") +13, allergy.length());
                    }

                    String temp2 = allergyInfo.get(9).getText(); //

                    if(temp2.contains("이 제품은")) {
                        int start = temp2.indexOf("이 제품은");

                        if(temp2.contains("혼입")){
                            int end = temp2.indexOf("혼입");
                            sameFactory = temp2.substring(start + 6, end - 1);
                        }

                        if(temp2.contains("사용한")){
                            int end = temp2.indexOf("사용한");
                            sameFactory = temp2.substring(start + 6, end - 2);
                        }

                        else {
                            int end = temp2.indexOf("제품과");
                            sameFactory = temp2.substring(start + 6, end - 6);
                        }
                        productObjs.get(i).setSame_factory(sameFactory);
                    } // if (sameFactory) - 소비자 주의사항

                    productObjs.get(i).setIngredient(ingredient);
                    productObjs.get(i).setAllergy_ingredient(allergy);
                    productObjs.get(i).setCompany("CJ");
                    productObjs.get(i).setCompanyCategory("40004");

                    List<WebElement> imgElements = driver.findElement(By.className("product-images"))
                            .findElement(By.className("product-images-item"))
                            .findElements(By.tagName("img"));

                    Thread.sleep(1500);

                    for (WebElement img : imgElements) {
                        String src = img.getAttribute("src");

                        if (src.contains("//img.cjthemarket.com/images/file/product/") == false) {
                            continue;
                        }

                        productObjs.get(i).setMainImage(src);
                    }//for

                    System.out.println(productObjs.get(i));

                    break;

                } else{ //알림창이 존재하면 알림창 확인을 누를것
                    Alert alert = driver.switchTo().alert();
                    String alertText = alert.getText();
                    System.out.println("Alert data: " + alertText);
                    alert.accept();
                }
            }//while
        }//for

        Thread.sleep(3000);

        System.out.println("====================================");
        System.out.println(productObjs.size());

        driver.close();
        driver.quit();
        return productObjs;

    } // crawlFoodList
} // class
