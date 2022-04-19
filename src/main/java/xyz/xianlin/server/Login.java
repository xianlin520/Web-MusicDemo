package xyz.xianlin.server;

import org.apache.ibatis.session.SqlSession;
import xyz.xianlin.mapper.UserDataMapper;
import xyz.xianlin.pojo.UserData;
import xyz.xianlin.tool.SQLSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = SQLSingleton.getSqlSessionFactory().openSession();
        UserData UserLogin = new UserData(request.getParameter("userQQ"), request.getParameter("userPassword"));
        UserDataMapper mapper = sqlSession.getMapper(UserDataMapper.class);
        UserData loginBool = mapper.selectByUserQQAndUserPassword(UserLogin);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
//        System.out.println(loginBool);
        if (loginBool != null) {
            writer.println("200");
            sqlSession.commit();
    
        }else {
            writer.println("404");
            sqlSession.commit();
        }
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
