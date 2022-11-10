package Function.department;

import Classes.Department;
import Tools.getConn;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.DepMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/*
 * @description: 获取对应id的部门信息
 */
@WebServlet("/getInfo")
public class GetInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        DepMapper mapper = sqlSession.getMapper(DepMapper.class);//获取mapper
        String id = req.getParameter("id");//接受id
        Department info = mapper.getInfo(id);//根据id获取信息
        String s = JSON.toJSONString(info);
//        System.out.println(s);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(s);

    }
}