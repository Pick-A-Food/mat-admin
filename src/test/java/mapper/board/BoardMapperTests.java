package mapper.board;

import com.matjo.pickafood.admin.board.vo.BoardVO;
import com.matjo.pickafood.admin.board.mapper.BoardMapper;
import com.matjo.pickafood.admin.common.dto.ListDTO;
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
public class BoardMapperTests {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    public void testInsert() {

        BoardVO board = BoardVO.builder()
                .title("테테테")
                .content("스스스")
                .id("kim")
                .nickname("연느짱")
                .build();

        boardMapper.insert(board);
        log.info(board);
    }

    @Test
    public void testSelectList() {
        ListDTO listDTO = new ListDTO();
        listDTO.setType("t");
        listDTO.setKeyword("오이");

        List<BoardVO> boardList = boardMapper.selectList(listDTO);

        boardList.forEach(board -> log.info(board));

    }

    @Test
    public void testSelectOne() {

        int boardSeq = 1;

        BoardVO board = boardMapper.selectOne(boardSeq);

        log.info(board);
    }

    @Test
    public void testDelete(){  //
        int boardSeq = 10;

        boardMapper.delete(boardSeq);

    }

    @Test
    public void testGetBoardTotal() {

        ListDTO listDTO = new ListDTO();
        listDTO.setType("t");
        listDTO.setKeyword("오이");
        int total = boardMapper.getBoardTotal(listDTO);
        log.info(total);

    }

    }