package xyz.xianlin.server;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xyz.xianlin.mapper.UserDataMapper;
import xyz.xianlin.pojo.UserData;
import xyz.xianlin.tool.SQLSingleton;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/enroll")
public class Enroll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SQLSingleton.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDataMapper mapper = sqlSession.getMapper(UserDataMapper.class);
        String userQQ = request.getParameter("userQQ");
        String userPassword = request.getParameter("userPassword");
        String userName = request.getParameter("userName");
//        String userName = "";
        // 将前端传进的userName转换成UTF-8编码,并用try-catch捕获异常
        try {
            userName = new String(request.getParameter("userName").getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
//            e.printStackTrace();
        }
//        userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
        UserData loginBool = mapper.selectByUserQQ(userQQ);
        System.out.println("注册审核:"+loginBool);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (loginBool != null) {
            writer.println("200");
        }else if (userPassword!=null&&userName!=null&&userQQ!=null){
            System.out.println("注册用户名:"+userName);
            UserData userData = new UserData(userQQ, userName,userPassword);
            System.out.println("新注册数据"+userData);
            mapper.insert(userData);
            sqlSession.commit();
        }else {
            writer.println("400");
            sqlSession.commit();
        }
        // 手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
