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

@WebServlet("/addPost")
public class AddPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        String content = request.getParameter("content");
        String demand = request.getParameter("demand");
        String describe = request.getParameter("describe");
        Post post = new Post(name, Integer.parseInt(dept), content, demand, describe);
        
        System.out.println("添加新岗位：" + post);

        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        PostMapper mapper = sqlSession.getMapper(PostMapper.class);

        int i = mapper.addPost(post);

        if(i != 0) {
            System.out.println("添加成功");
            response.getWriter().print(true);
        } else {
            System.out.println("添加失败");
            response.getWriter().print(false);
        }

        sqlSession.commit();
        sqlSession.close();
        System.out.println("===========================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
