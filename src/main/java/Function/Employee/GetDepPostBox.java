package Function.Employee;

import Classes.Department;
import Classes.Post;
import Tools.getConn;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/getDepPostBox")
public class GetDepPostBox extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession ss = ssf.openSession();
        UserMapper mapper = ss.getMapper(UserMapper.class);

        List<Department> departmentList = mapper.getDepList();
        List<Post> postList = mapper.getPostList();

        String str = "{";
        // js 写入数据，格式：t[索引]=["部门id","岗位id1|岗位id2..."]
        for (int i = 0; i < departmentList.size(); i++) {
            str += "\"" + departmentList.get(i).getDepID() + "\":\"";
            boolean flag = false; // 判断部门下有没有岗位，false没有，true有

            for (int j = 0; j < postList.size(); j++) {
                if(postList.get(j).getDeptId() == departmentList.get(i).getDepID()) { // 该岗位中的所属部门id与当前部门id相同
                    flag = true;
                    str += postList.get(j).getId(); // 添加岗位id
                    str += "|";
                }
            }
            if(flag) // 若该部门中有岗位id，说明最后有一个|，需要删除
                str = str.substring(0, str.length() - 1); // 去除最后一个 |
            str += "\",";

        }
        str = str.substring(0, str.length() - 1); // 去除最后一个,
        str += "}";
        System.out.println(str);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
