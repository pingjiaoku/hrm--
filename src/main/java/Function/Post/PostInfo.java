package Function.Post;

import Classes.Post;
import Tools.getConn;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.PostMapper;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

// 通过id获取对应的岗位信息
@WebServlet("/postInfo")
public class PostInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SqlSessionFactory ssf = getConn.getSsf();
        PostMapper mapper = ssf.openSession().getMapper(PostMapper.class);

        Post post = mapper.postInfo(Integer.parseInt(id));

        String s = JSON.toJSONString(post);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
