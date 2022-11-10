package Function.Title;

import Classes.Title;
import Tools.getConn;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.TitleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

@WebServlet("/editTitle")
public class EditTitle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String rank = request.getParameter("rank");
            String describe = request.getParameter("describe");
            Title title = new Title(Integer.parseInt(id), name, Integer.parseInt(rank), describe);
            System.out.println("正在修改职称信息：" + title);

            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession sqlSession = ssf.openSession();
            TitleMapper mapper = sqlSession.getMapper(TitleMapper.class);

            int i = mapper.updateTitle(title);

            response.getWriter().print(i);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("========================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
