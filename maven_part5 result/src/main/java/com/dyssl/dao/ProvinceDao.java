package com.dyssl.dao;

import com.vo.ProvinceCity;

import java.util.List;

public interface ProvinceDao {
    List<ProvinceCity> selectProvinceCityList(Integer provinceid);
}
