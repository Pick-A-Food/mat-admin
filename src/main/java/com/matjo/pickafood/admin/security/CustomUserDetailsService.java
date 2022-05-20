package com.matjo.pickafood.admin.security;

import com.matjo.pickafood.admin.admin.domain.AdminVO;
import com.matjo.pickafood.admin.admin.dto.AdminDTO;
import com.matjo.pickafood.admin.admin.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminVO admin = adminMapper.selectOne(username);

        List<SimpleGrantedAuthority> authList = admin.getAuthList().stream()
                .map(auth -> new SimpleGrantedAuthority("ROLE_"+auth.getRolename()))
                .collect(Collectors.toList());

        AdminDTO adminDTO = new AdminDTO(admin.getId(), admin.getPw(), authList);
        adminDTO.setName(admin.getName());
        adminDTO.setNickname(admin.getNickname());
        adminDTO.setPosition(admin.getPosition());
        adminDTO.setProfile(admin.getProfile());

        return adminDTO;
    }
}
