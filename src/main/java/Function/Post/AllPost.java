package Function.Post;

import Classes.Post;
import Tools.getConn;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

// 获取所有岗位信息
@WebServlet("/allPost")
public class AllPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("正在查询所有岗位~");

        try {
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession sqlSession = ssf.openSession();
            PostMapper mapper = sqlSession.getMapper(PostMapper.class);

            List<Post> posts = mapper.allPost(); // mybatis自动封装，将查询到的数据自动封装到list集合中

            String s = JSON.toJSONString(posts); // 将获取的岗位信息转化为json字符串

            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(s); // 向前端响应

            System.out.println(s);
            System.out.println("============================");
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
