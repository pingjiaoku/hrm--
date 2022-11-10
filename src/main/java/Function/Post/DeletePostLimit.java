package Function.Post;

import Tools.getConn;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.tools.Tool;
import java.io.IOException;

@WebServlet("/deletePostLimit")
public class DeletePostLimit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        PostMapper mapper = sqlSession.getMapper(PostMapper.class);

        int i = mapper.deletePostLimit(Integer.parseInt(id)); // 返回该岗位的人数

        response.getWriter().print(i);

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
