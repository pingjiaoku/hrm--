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
import java.io.PrintWriter;

/**
 * @description: 添加职称时检查职称名是否已存在
 */
@WebServlet("/titleNameExist")
public class TitleNameExist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession ss = ssf.openSession();
        TitleMapper mapper = ss.getMapper(TitleMapper.class);
        Title title = mapper.titleNameExist(name);

        PrintWriter writer = response.getWriter();

        if(title == null){
            writer.print(0);
        }else{
            writer.print(1);
        }

        ss.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
