package com.lovo.service.mybaits.studentCheck.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.service.mybaits.studentCheck.dao.IStudentCheckDao;
import com.lovo.service.mybaits.studentCheck.entity.TCheck;
import com.lovo.service.mybaits.studentCheck.entity.TStudent;
import com.lovo.service.mybaits.studentCheck.service.IStudentCheckService;
import com.lovo.service.mybaits.studentCheck.util.GetSession;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StduentCheckServiceImpl implements IStudentCheckService {
    @Override
    public void regster(TStudent student) {

    }

    @Override
    public TStudent login(String userName, String userPwd) {
        return null;
    }

    @Override
    public String findCheckItem(Map<String,Object> map) throws Exception{
        SqlSession session= GetSession.creatSession();
        IStudentCheckDao dao=  session.getMapper(IStudentCheckDao.class);
        //查询出分页后的集合
        List<TCheck> list=dao.findCheckItem(map);
        //查询出总行数
        int pageNum=dao.getCheckListPageNum(map);
        //创建一个Map集合
        Map<String,Object> mapJson=new HashMap();
        //分也后的集合+总行数=放入到Map集合
        mapJson.put("list",list);
        mapJson.put("pageNum",pageNum);
        //把map集合转换为json字符串
        ObjectMapper mapper=new ObjectMapper();
        String josn=  mapper.writeValueAsString(mapJson);
        return josn;
    }
    @Override
    public void addCheck(TCheck check){
    }
}
