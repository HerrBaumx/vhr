package org.jxiao.vhrself.mapper;

import org.apache.ibatis.annotations.Param;
import org.jxiao.vhrself.model.Hr;
import org.jxiao.vhrself.model.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);

    Integer updateHrPasswd(@Param("hrid") Integer hrid, @Param("encodePass") String encodePass);

    Integer updateHrUserface(@Param("url") String url, @Param("id") Integer id);
}