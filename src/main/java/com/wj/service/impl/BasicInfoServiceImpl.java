package com.wj.service.impl;

import com.wj.dao.BasicInfoMapper;
import com.wj.pojo.BasicInfo.Depart;
import com.wj.pojo.BasicInfo.Sit;
import com.wj.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicInfoServiceImpl implements BasicInfoService{
    @Autowired
    private BasicInfoMapper basicInfoMapper;
    /* 查询所有院系信息 */
    @Override
    public List<Depart> selAllDepart() {
        return basicInfoMapper.selAllDepart();
    }
    /* 添加院系 */
    @Override
    public void insDepart(Depart depart) {
        basicInfoMapper.insDepart(depart);
    }
    /* 查询所有职称信息 */
    @Override
    public List<Sit> selAllSit() {
        return basicInfoMapper.selAllSit();
    }
    /* 添加职称*/
    @Override
    public void insSit(Sit sit) {
        basicInfoMapper.insSit(sit);
    }
}
