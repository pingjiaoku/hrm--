package Function.department;

import Tools.getConn;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.DepMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/*
 * @description: 删除部门信息
 */
@WebServlet("/delDep")
public class DeleteDep extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int i = 0;
        System.out.println("删除部门信息：id=" + id);
        try {
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            DepMapper mapper = ss.getMapper(DepMapper.class);
            if(mapper.getEmpCnt(id+"")==0){//如果没有成员了，就可以删除
                i = mapper.deleteDep(id);
                ss.commit();//必须要提交，否则数据库里不会更新！！！
                ss.close();
            }else {
                i=-1;//还有成员，0为删除失败，大于0为删除成功
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resp.getWriter().print(i);
        }
    }

}
