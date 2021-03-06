package com.wj.service.impl;

import com.wj.dao.BasicInfoMapper;
import com.wj.pojo.BasicInfo.*;
import com.wj.pojo.Student;
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
    /* 修改院系名称 */
    @Override
    public void updDepart(Depart depart) {
        basicInfoMapper.updateDepart(depart);
    }
    /* 删除院系 */
    @Override
    public void delDepart(long id) {
        basicInfoMapper.deleteDepart(id);
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
    /* 修改职称 */
    @Override
    public void updSit(Sit sit) {
        basicInfoMapper.updSit(sit);
    }
    /* 删除职称 */
    @Override
    public void delSit(long id) {
        basicInfoMapper.delSit(id);
    }
    /* 查询所有学期信息 */
    @Override
    public List<Semester> findAllSemester() {
        return basicInfoMapper.findAllSemester();
    }
    /* 添加学期信息 */
    @Override
    public void insSemester(Semester semester) {
        basicInfoMapper.insSemester(semester);
    }
    /* 修改学期 */
    @Override
    public void updSemester(Semester semester) {
        basicInfoMapper.updSemester(semester);
    }
    /* 查询所有专业 */
    @Override
    public List<Major> selAllMajor(long seid) {
        return basicInfoMapper.selAllMajor(seid);
    }
    /* 添加专业 */
    @Override
    public void insMajor(Major major) {
        basicInfoMapper.insMajor(major);
    }
    /* 修改专业信息 */
    @Override
    public void updMajor(Major major) {
        basicInfoMapper.updMajor(major);
    }
    /* 查询班级信息 */
    @Override
    public List<Blass> selByMaid(long maid) {
        return basicInfoMapper.selByMaid(maid);
    }
    /* 添加班级 */
    @Override
    public void insClass(Blass blass) {
        basicInfoMapper.insClass(blass);
    }
    /* 查询班级内所有学生 */
    @Override
    public List<Student> selByCname(String cname) {
        return basicInfoMapper.selByCname(cname);
    }
    /* 添加学生信息 */
    @Override
    public void insStudent(Student student) {
        basicInfoMapper.insStudent(student);
    }


}
