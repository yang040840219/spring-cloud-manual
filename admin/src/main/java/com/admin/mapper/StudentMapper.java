package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 2020/1/24
 */


@Mapper // springboot 扫描后动态代理
public interface StudentMapper {

    String selectVersion();

}
