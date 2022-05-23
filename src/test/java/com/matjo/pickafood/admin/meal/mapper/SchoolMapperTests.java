package com.matjo.pickafood.admin.meal.mapper;

import com.matjo.pickafood.admin.meal.domain.SchoolVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class SchoolMapperTests {

  @Autowired(required = false)
  private SchoolMapper schoolMapper;

  @Test
  public void testSelectRegionAndName() {
    String regionCode = "B10";
    String schoolName = "교동";

    List<SchoolVO> schoolVOList = schoolMapper.selectRegionAndName(regionCode, schoolName);
    schoolVOList.forEach(schoolVO -> {
      log.info(schoolVO);
    });
  }

  @Test
  public void testInsert() {
    SchoolVO schoolVO = new SchoolVO("테스트", "테스트", "테스트", "테스트", "테스트");
  }

}
