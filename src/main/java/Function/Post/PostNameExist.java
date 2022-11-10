package Function.Post;

import Classes.Post;
import Tools.getConn;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

@WebServlet("/postNameExist")
public class PostNameExist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        PostMapper mapper = sqlSession.getMapper(PostMapper.class);

        Post post = mapper.postNameExist(name);

        if(post == null) { // 没有查询到该岗位名称的岗位，
            response.getWriter().print(0);
        }else {
            response.getWriter().print(1);
        }

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
