package com.lovo.service.mybaits.studentCheck.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lovo.service.mybaits.studentCheck.entity.TCheck;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface IStudentCheckService {
    /**
     * 注册
     * @param student 学生--用户对象
     */
    public void regster(TStudent student);
    /**
     * 登录
     * @param userName 用户名
     * @param userPwd 密码
     * @return 学生--用户对象
     */
    public TStudent login(String userName, String userPwd);
    /**
     * 按学生姓名，考勤类型，记录时间动态查询考勤记录
     * @param map 动态条件map集合
     * @return 考勤集合
     */
    public String findCheckItem(Map<String,Object> map) throws Exception;
    /**
     * 添加考勤记录
     * @param check 考勤记录
     */
    public void addCheck(TCheck check);
}
