package mapper.board;


import com.matjo.pickafood.admin.file.dto.FileDTO;
import com.matjo.pickafood.admin.file.mapper.FileMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/root-context.xml",
        "file:src/main/webapp/WEB-INF/servlet-context.xml"})
public class BoardControllerTests {

    @Autowired(required = false)
    private WebApplicationContext ctx;

    @Autowired(required = false)
    private FileMapper fileMapper;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void list() throws Exception {
        log.info(
                mockMvc.perform(
                                MockMvcRequestBuilders.get("/board/list"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap());
    }

    @Test
    public void testRegister() throws Exception {
        //YARC! 로 테스트 완료
    }

    @Test
    public void testModify() throws Exception {
        String resultPage = mockMvc
                .perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("bno", "1")
                        .param("title", "수정된 테스트 새글 제목")
                        .param("content", "수정된 테스트 새글 내용"))
                .andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }

    @Test
    public void testRemove()throws Exception{
        String resultPage = mockMvc
                .perform(MockMvcRequestBuilders.post("/board/remove")
                .param("bno", "88"))
                .andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }


    @Test
    public void testGetReadFileList() {

        List<FileDTO> fileList = fileMapper.getReadFiles(87);
        fileList.forEach(fileVO -> log.info(fileVO));

    }



}