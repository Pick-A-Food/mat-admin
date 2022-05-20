package mapper.board.admin.notice.mapper;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.file.mapper.FileMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Log4j2
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class FileMapperTests {

    @Autowired(required = false)
    private FileMapper fileMapper;

    @Test
    public void testGetList() {
      /*  List<String> list = new ArrayList();

        list = fileMapper.getList(87);*/


        //list.forEach(list -> System.out.println(list));
    }

}
