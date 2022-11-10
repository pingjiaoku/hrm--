package Function.Title;

import Tools.getConn;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.TitleMapper;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

@WebServlet("/deleteTitleLimit")
public class DeleteTitleLimit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        TitleMapper mapper = sqlSession.getMapper(TitleMapper.class);
        int i = mapper.deleteTitleLimit(Integer.parseInt(id));

        response.getWriter().print(i);
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
