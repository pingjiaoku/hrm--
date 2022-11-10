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
import java.util.List;

@WebServlet("/allTitle")
public class AllTitle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("正在获取职称信息列表");
        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();

        TitleMapper mapper = sqlSession.getMapper(TitleMapper.class);
        List<Title> titles = mapper.titleList();

        for (int i = 0; i < titles.size(); i++) {
            int count = mapper.EmpCountOfTitle(titles.get(i).getId());
            titles.get(i).setCount(count);
        }

        System.out.println(titles);
        String s = JSON.toJSONString(titles);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(s);

        sqlSession.close();
        System.out.println("==========================");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
