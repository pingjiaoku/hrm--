package Function.Employee;

import Classes.Department;
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

@WebServlet("/getDeptBox")
public class GetDeptBox extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Department> depList = mapper.getDepList();
        String s = JSON.toJSONString(depList);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(s);

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
