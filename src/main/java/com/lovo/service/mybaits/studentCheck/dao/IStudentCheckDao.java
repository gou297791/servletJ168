package com.lovo.service.mybaits.studentCheck.dao;

import com.lovo.service.mybaits.studentCheck.entity.TCheck;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface IStudentCheckDao {
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
    public TStudent login(String userName,String userPwd);
    /**
     * 按学生姓名，考勤类型，记录时间动态查询考勤记录
     * @param map 动态条件map集合
     * @return 考勤集合
     */
    public List<TCheck> findCheckItem(Map<String,Object> map);
    /**
     * 查询考勤记录行数
     * @param map 条件
     * @return 考勤记录行数
     */
    public int getCheckListPageNum(Map<String,Object> map);
    /**
     * 添加考勤记录
     * @param check 考勤记录
     */
    public void addCheck(TCheck check);
    /**
     * 按学生姓名查找学生对象
     * @param studentName 学生性名
     * @return 学生--用户对象
     */
    public TStudent findStudentByStudentName(String studentName);
}
