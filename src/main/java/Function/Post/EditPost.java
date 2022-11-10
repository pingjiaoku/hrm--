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

@WebServlet("/editPost")
public class EditPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String content = request.getParameter("content");
        String demand = request.getParameter("demand");
        String remark = request.getParameter("remark");
        Post post = new Post(Integer.parseInt(id),name,Integer.parseInt(dept),content,demand,remark);

        System.out.println("正在修改岗位：" + post);

        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        PostMapper mapper = sqlSession.getMapper(PostMapper.class);

        int i = mapper.editPost(post);
        sqlSession.commit();

        response.getWriter().print(i);

        System.out.println("========================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
