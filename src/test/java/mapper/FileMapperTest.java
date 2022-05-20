package mapper;


import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.file.dto.FileDTO;
import com.matjo.pickafood.admin.file.mapper.FileMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class FileMapperTest {

    @Autowired(required = false)
    private FileMapper fileMapper;

    @Test
    public void testGetReadFileList() {

        List<FileDTO> fileList = fileMapper.getReadFiles(87);
        fileList.forEach(fileVO -> log.info(fileVO));

    }

}
