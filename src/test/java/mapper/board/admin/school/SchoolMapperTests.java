package mapper.board.admin.school;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matjo.pickafood.admin.meal.domain.SchoolVO;
import com.matjo.pickafood.admin.meal.dto.SchoolDTO;
import com.matjo.pickafood.admin.meal.dto.SchoolDTOList;
import com.matjo.pickafood.admin.meal.mapper.SchoolMapper;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

@ExtendWith(SpringExtension.class)
@Log4j2
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class SchoolMapperTests {

  @Autowired(required = false)
  private SchoolMapper schoolMapper;

  @Test
  public void testSelectAll() {
    List<SchoolVO> schoolVOList = schoolMapper.selectAll();
    int i = 0;
    for (SchoolVO schoolVO : schoolVOList) {
      System.out.println(schoolVO);
      i++;
      if (i == 100) break;
    }
  }

  @Test
  public void inputDataToDB() {
    String schoolCode = "7010057";
    String regionCode = "B10";
    String start = "20220501";
    String end = "20220531";

    String OPEN_API_URL = "http://open.neis.go.kr/hub";
    String MEAL_API = "/mealServiceDietInfo";
    String KEY = "2e191712000e470dac71cace19e334d9";
    String fixedParams = String.format("KEY=%s&TYPE=json&pIndex=%d&pSize=%d", KEY, 1, 1000);
    String unfixedParams = String.format("SD_SCHUL_CODE=%s&ATPT_OFCDC_SC_CODE=%s&MLSV_FROM_YMD=%s&MLSV_TO_YMD=%s", schoolCode, regionCode, start, end);
    HttpURLConnection con = null;
    try {
      URL requestURL = new URL(String.format("%s%s?%s&%s", OPEN_API_URL, MEAL_API, fixedParams, unfixedParams));
      con = (HttpURLConnection) requestURL.openConnection();
      con.setRequestProperty("accept", "application/json");
      con.setRequestMethod("GET");
//      InputStream responseStream = con.getInputStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;

      while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
        sb.append(line);
      }
      System.out.println(sb);
      JSONObject obj = new JSONObject("{" + sb + "}"); // json으로 변경 (역직렬화)
      System.out.println("code= " + obj.getInt("code") + " / message= " + obj.getString("message"));

    } catch (Exception e) {
      e.printStackTrace();
      Scanner scanner = new Scanner(con.getErrorStream());
      while (scanner.hasNext()) {
        System.out.println(scanner.next());
      }
    }
  }
}

//      ObjectMapper mapper = new ObjectMapper();
//      SchoolDTOList schoolDTOList = mapper.readValue(responseStream, SchoolDTOList.class);
//      System.out.println(schoolDTOList.getSchoolDTOList());
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
//
//  }
//
//}
