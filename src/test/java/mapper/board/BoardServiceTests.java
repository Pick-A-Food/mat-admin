package mapper.board;

import com.matjo.pickafood.admin.board.dto.BoardDTO;
import com.matjo.pickafood.admin.board.service.BoardService;
import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.common.dto.ListResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardServiceTests {

    @Autowired(required = false)
    private BoardService boardService;

    @Test
    public void testExist() {   //  BoardService 객체가 제대로 주입이 가능한지 확인

        log.info(boardService);
        assertNotNull(boardService);
        //정상적으로 BoardService 객체가 생성되고 BoardMapper 가 주입되었다면 아래와 같이
        //BoardService 객체와 데이터베이스 관련 로그가 같이 출력

    }

    @Test
    public void testSelectList() {

        ListDTO listDTO = new ListDTO();
        listDTO.setType("t");
        listDTO.setKeyword("오이");

        ListResponseDTO<BoardDTO> listResponseDTO = boardService.getList(listDTO);
        listResponseDTO.getDtoList().forEach(boardDTO -> log.info(boardDTO));
        // listResponseDTO에 @Data가 있기 때문에 따로 만들지 않아도 get 메소드 getDtoList를 쓸 수 있음
        // forEach - boardDTO 변수

    }

    @Test
    public void testRegister() {

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("등록한다");
        boardDTO.setContent("등록한다~");
        boardDTO.setId("kim");
        boardDTO.setNickname("연느짱");

//        BoardDTO boardDTO = BoardDTO.builder()
//                .title("들어가라~23")
//                .content("들어가자~23")
//                .writer("드가자~23")
//                .build();

        boardService.register(boardDTO);
        log.info(boardDTO.getBoardSeq());

    }

    @Test
    public void testGetOne(){
        Integer boardSeq = 40;
        BoardDTO boardDTO = boardService.getOne(boardSeq);
        log.info(boardDTO);
    }

    @Test
    public void testUpdate(){
        Integer bno = 40;
        BoardDTO boardDTO = boardService.getOne(bno);

        if(boardDTO == null){return;}

        boardDTO.setTitle("수정한다!!!!!!!!!!!!!");
        boardService.update(boardDTO);
        log.info(boardDTO);
    }

    @Test
    public void testRemove(){
        Integer boardSeq = 20;
        boardService.remove(
                boardSeq);
    }
}