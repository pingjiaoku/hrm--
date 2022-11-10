package Function.Title;

import Classes.Title;
import Tools.getConn;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.TitleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

@WebServlet("/titleInfo")
public class TitleInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("正在查询职称信息：id=" + id);

        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession ss = ssf.openSession();
        TitleMapper mapper = ss.getMapper(TitleMapper.class);

        Title title = mapper.titleInfo(Integer.parseInt(id));

        String s;
        if(title != null) {
            int count = mapper.EmpCountOfTitle(Integer.parseInt(id));
            title.setCount(count);

            s = JSON.toJSONString(title);
        } else {
            s = "false";
        }

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(s);

        ss.close();
        System.out.println("查询到：" + s);
        System.out.println("========================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
