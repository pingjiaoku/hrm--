package Function.Employee;

import Classes.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

import Tools.*;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/selectEmpInfo")
public class selectEmpInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = getRequestUser.getUser(request);
        System.out.println("详细查询：" + user);

        try {
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            UserMapper mapper = ss.getMapper(UserMapper.class);

            List<User> users = mapper.selectUser(user);
//            String s = JSON.toJSONString(users);
            String s = JSON.toJSONStringWithDateFormat(users,"yyyy-MM-dd");

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(s);

            System.out.println("查询结果：" + s);
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
