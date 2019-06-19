package com.lovo.service.web.testWeb;

import com.lovo.service.tImg.GetSession;
import com.lovo.service.tImg.IImgDao;
import com.lovo.service.tImg.UploadUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          //获得页面的文件和表单文本map
        UploadUtil uploadUtil=new UploadUtil();
        try {
            Map<String, List<FileItem>> map= uploadUtil.getFileItem(request);
            //获得表单集合
            List<FileItem> listForm=   map.get("listForm");
            //获得文件集合
            List<FileItem> listFile=   map.get("listFile");
            //打印出表单数据
            for (FileItem form:listForm) {
               String filedName= form.getFieldName();
               String val= form.getString("UTF-8");
               if(null!=val&&""!=val) {
                   System.out.println(filedName + ":" + val);
               }
            }
         //获得文件
            for (FileItem file:listFile) {
                String str=file.getName();
                if(!"".equals(str)) {
                    int start = str.lastIndexOf(".") + 1;
                    String r = str.substring(start);
                    if ("jpg" .equals( r) || "png" .equals( r)) {
                        OutputStream out = new FileOutputStream("E:/测试/" + file.getName());
                        InputStream in = file.getInputStream();
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = in.read(bytes)) > 0) {
                            //写
                            out.write(bytes, 0, len);
                        }
                        out.close();
                        in.close();
                        SqlSession session= GetSession.creatSession();
                        IImgDao dao=session.getMapper(IImgDao.class);
                        String imgStr=request.getScheme()+"://"+request.getServerName()+":/t"+file.getName();
                        dao.addImg(imgStr);
                        session.commit();
                        session.close();
                    } else {
                        request.getRequestDispatcher("file.jsp").forward(request, response);
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
