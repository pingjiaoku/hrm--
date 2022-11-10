package Function.Employee;

import Classes.User;
import Tools.getConn;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/allInfoEmp")
public class AllInfoEmp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("查询所有员工信息...");

        try {
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            UserMapper mapper = ss.getMapper(UserMapper.class);

            List<User> users = mapper.selectAllUser();

            // String s = JSON.toJSONString(users);
            String s = JSON.toJSONStringWithDateFormat(users,"yyyy-MM-dd");
            response.setContentType("text/html;charset=utf-8");

            response.getWriter().print(s);

            System.out.println("查看结果：" + s);
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
