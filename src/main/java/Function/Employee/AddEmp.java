package Function.Employee;

import Classes.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import Tools.*;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/addEmp")
public class AddEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flag = 0;
        try {
            User user = getRequestUser.getUser(request);

            System.out.println("添加员工信息：" + user);

            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            UserMapper mapper = ss.getMapper(UserMapper.class);

            mapper.insertEmp(user);

            ss.commit();

            System.out.println("添加成功...");
            System.out.println("============================");

            ss.close();

            flag = 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            response.getWriter().print(flag);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }



}
