package Function.department;

import Classes.Department;
import Tools.getConn;
import com.alibaba.fastjson.JSON;
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
 * @description: 添加部门信息
 */
@WebServlet("/addDep")
public class addDep extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = 0;
        try {
            //System.out.println("收到了");
            Department department = new Department();
            department.setDepID(Integer.parseInt(req.getParameter("depID")));
            department.setParentDepID(Integer.parseInt(req.getParameter("parentDepID")));
            department.setDepType(Integer.parseInt(req.getParameter("depType")));
            department.setDepName(req.getParameter("depName"));
            department.setDepAddress(req.getParameter("depAddress"));
            department.setDepPostCode(req.getParameter("depPostCode"));
            department.setDepPhoneNumber(req.getParameter("depPhoneNumber"));
            department.setDepTelePhone(req.getParameter("depTelePhone"));
            department.setDepEmail(req.getParameter("depEmail"));
            System.out.println(JSON.toJSONString(department));
            SqlSessionFactory ssf = getConn.getSsf();
            SqlSession ss = ssf.openSession();
            DepMapper mapper = ss.getMapper(DepMapper.class);
            i = mapper.addDep(department);//获取结果
            //System.out.println(i);
            ss.commit();
            ss.close();
            resp.setContentType("text/html;charset=utf-8;");

        }
        catch (Exception e){
            System.out.println("故障");
        }
        finally {
            resp.getWriter().print(i);
        }

    }
}