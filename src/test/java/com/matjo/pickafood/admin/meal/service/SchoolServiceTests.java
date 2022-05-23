package com.matjo.pickafood.admin.meal.service;

import com.matjo.pickafood.admin.meal.dto.SchoolDTO;
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
public class SchoolServiceTests {

  @Autowired(required = false)
  SchoolService schoolService;

  @Test
  public void test() {
    String regionCode = "B10";
    String schoolName = "교동";
    List<SchoolDTO> schoolDTOList = schoolService.selectSchoolsByRegionAndName(regionCode, schoolName);
    schoolDTOList.forEach(schoolDTO -> {
      log.info(schoolDTO);
    });
  }
}
