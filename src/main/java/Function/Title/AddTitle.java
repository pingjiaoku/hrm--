package Function.Title;

import Tools.getConn;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.TitleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.PrintWriter;

import Classes.Title;

@WebServlet("/addTitle")
public class AddTitle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("正在进行职称信息添加");
        Title title = new Title();
        try {
            String name = request.getParameter("name");
            String rank = request.getParameter("rank");
            String describe = request.getParameter("describe");
            title.setTitleName(name);
            title.setRank(Integer.parseInt(rank));
            title.setDescribe(describe);
            System.out.println(title);
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            TitleMapper mapper = ss.getMapper(TitleMapper.class);
            int i = mapper.addTitle(title);

            PrintWriter writer = response.getWriter();
            if (i != 0) {
                System.out.println("添加成功");
                writer.print(true);
            } else {
                System.out.println("添加失败");
                writer.print(false);
            }
            ss.commit();
            ss.close();
            System.out.println("============================");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
