package mapper.board.admin.member;

import com.matjo.pickafood.admin.common.dto.ListDTO;
import com.matjo.pickafood.admin.member.domain.MemberVO;
import com.matjo.pickafood.admin.member.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@Log4j2
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class MemberMapperTests {

  @Autowired(required = false)
  private MemberMapper memberMapper;

  @Test
  public void testSelectMembers() {
    ListDTO listDTO = new ListDTO();
    listDTO.setKeyword("gorm");
    listDTO.setType("id");
    List<MemberVO> members = memberMapper.selectMembers(listDTO);
    members.forEach(memberVO -> System.out.println(memberVO));
  }
}
