package com.lovo.service.mybaits.test6_1.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lovo.service.mybaits.test6_1.dao.IJurisdiction;
import com.lovo.service.mybaits.test6_1.entity.GetSession;
import com.lovo.service.mybaits.test6_1.entity.RoleDTO;
import com.lovo.service.mybaits.test6_1.service.IJurisdictionService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class JurisdictionServiceImpl implements IJurisdictionService {
    @Override
    public String findJurisdictionByUserName(String userName) {
        SqlSession session= GetSession.creatSession();
        IJurisdiction jurisdictionDao=  session.getMapper(IJurisdiction.class);

        List<RoleDTO> list=  jurisdictionDao.findJurisdictionByUserName(userName);
        String jsonStr="[";
        for(int i=0;i<list.size();i++){
            jsonStr+="{'jurisdictionId':'"+list.get(i).getjId()+"','jurisdictionName':'"+list.get(i).getjName()+"','jurisdictionUrl':'"+list.get(i).getjUrl()+"'},";
        }
        jsonStr=jsonStr.substring(0,jsonStr.length()-1);
        jsonStr+="]";
//        ObjectMapper objectMapper=new ObjectMapper();
//        String jsonStr=objectMapper.writeValueAsString(list);
        return jsonStr;
    }
}
