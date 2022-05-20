package mapper;

import com.matjo.pickafood.admin.admin.domain.AdminVO;
import com.matjo.pickafood.admin.admin.domain.Auth;
import com.matjo.pickafood.admin.admin.mapper.AdminMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/root-context.xml"
        ,"file:src/main/webapp/WEB-INF/security-context.xml"
        ,"file:src/main/webapp/WEB-INF/servlet-context.xml"
})
public class AdminMapperTest {

    @Autowired(required = false)
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testInsert() {

        AdminVO adminVo = AdminVO.builder()
                .id("kim")
                .pw(passwordEncoder.encode("aaa"))
                .name("김이슬")
                .nickname("하이")
                .position("매니저")
                .build();

        log.debug("adminVo: {}", adminVo);
        log.debug("pw byte: {}", "$2a$10$TJSqFtRd/WBnY/tiRRcx4OQ32kAFQsSLUTSSxrdA12vBWw4VwLW7q".getBytes().length);

        adminMapper.register(adminVo);
// nn
        Auth auth = Auth.builder()
                .id("kim")
                .rolename("ADMIN") /* ROLE_ 는 자동으로 붙는 접두사임 */
                .build();

        adminMapper.addAuth(auth);

    }

}
