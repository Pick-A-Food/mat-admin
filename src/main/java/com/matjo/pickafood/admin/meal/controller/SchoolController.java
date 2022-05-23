package com.matjo.pickafood.admin.meal.controller;

import com.matjo.pickafood.admin.meal.dto.SchoolDTO;
import com.matjo.pickafood.admin.meal.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/school")
@Log4j2
@RestController
public class SchoolController {

  private final SchoolService schoolService;

  //  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
  @PostMapping(value = "/update")
  public void updatePOST(@RequestBody List<SchoolDTO> schoolDTOList) {
//    log.info(string);
    log.info(schoolDTOList);
    schoolService.insertAll(schoolDTOList);

  }

  @GetMapping(value = "/list")
  public @ResponseBody List<SchoolDTO> listAll() {
    return schoolService.selectAll();
  }

  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<SchoolDTO> listOfRegion(String regionCode, String schoolName) {
//    return schoolService.selectSchoolsOfRegion(regionCode);
    return schoolService.selectSchoolsByRegionAndName(regionCode, schoolName);
  }

}


