package Function.Login;

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

@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取登录页面输入的账号密码
        String Account = request.getParameter("userAccount");
        String password = request.getParameter("password");
        System.out.println("正在尝试登录 === 账号：" + Account + "   密码：" + password);
        User user = new User();
        user.setAccount(Account);
        user.setPassword(password);

        try {
            // 加载mybatis核心配置文件，获取SqlSessionFactory
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            UserMapper mapper = ss.getMapper(UserMapper.class);

            // 查询数据库中的对应的用户，返回id
            User getUser = mapper.checkUserExist(user);
            String userJSON = JSON.toJSONString(getUser);

            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(userJSON);


            System.out.println("登录成功：" + userJSON);
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
