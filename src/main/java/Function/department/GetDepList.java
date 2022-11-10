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
import java.util.List;

/*
 * @description: 获取部门信息列表，用于生成部门结构树
 */
@WebServlet("/getList")
public class GetDepList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        DepMapper mapper = sqlSession.getMapper(DepMapper.class);
        List<Department> list = mapper.getDepList();//获取列表
        String s = JSON.toJSONString(list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(s);

    }
}
