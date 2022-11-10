package Function.Post;

import Tools.getConn;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

@WebServlet("/deletePost")
public class DeletePost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("正在删除岗位：id=" + id);

        // 获取SqlSessionFactory，相当于数据库连接池
        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        PostMapper mapper = sqlSession.getMapper(PostMapper.class);

        int i = mapper.deletePost(Integer.parseInt(id));

        // 向前端响应结果
        response.getWriter().print(i);

        sqlSession.commit(); // 进行数据库修改、添加、删除操作后，必须手动提交

        System.out.println("===========================");
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
