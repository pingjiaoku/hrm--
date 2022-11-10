package Function.Employee;

import Classes.User;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

import Tools.*;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/searchUser")
public class EmpByNameOrId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");

        System.out.println("通过查询框查询：" + data);

        try {
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            UserMapper mapper = ss.getMapper(UserMapper.class);

            List<User> users = mapper.searchUser(data);
            String s = JSON.toJSONString(users);

            response.getWriter().print(s);

            System.out.println("查询结果：" + s);
            System.out.println("============================");

            ss.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
