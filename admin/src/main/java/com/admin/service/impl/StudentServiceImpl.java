package com.admin.service.impl;

import com.admin.mapper.StudentMapper;
import com.admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020/1/24
 */

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper ;

    @Override
    public String selectVersion() {
        return studentMapper.selectVersion();
    }
}
