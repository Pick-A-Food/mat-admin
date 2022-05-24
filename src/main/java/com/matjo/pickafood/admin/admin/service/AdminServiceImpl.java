package com.matjo.pickafood.admin.admin.service;

import com.matjo.pickafood.admin.admin.domain.AdminVO;
import com.matjo.pickafood.admin.admin.dto.AdminDTO;
import com.matjo.pickafood.admin.admin.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class AdminServiceImpl implements AdminService{

    private final AdminMapper adminMapper;
    private final ModelMapper modelMapper;

    @Override
    public void update(AdminDTO adminDTO) {

        adminMapper.update(AdminVO.builder()
                .profile(adminDTO.getProfile())
                .nickname(adminDTO.getNickname())
                .build());
    }
}
