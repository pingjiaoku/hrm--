package Function.Employee;

import Classes.User;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import Tools.*;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/empInfo")
public class EmpInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        System.out.println("查看员工详细信息：id=" + id);

        try {
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            UserMapper mapper = ss.getMapper(UserMapper.class);

            User user = mapper.selectUserById(id);
            // String s = JSON.toJSONString(user);
            String s = JSON.toJSONStringWithDateFormat(user,"yyyy-MM-dd");

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(s);

            System.out.println("查看结果：" + s);
            System.out.println("查看结果：" + user);
            System.out.println("============================");

            ss.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
