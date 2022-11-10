import Classes.Post;
import Classes.Title;
import Classes.User;
import Tools.*;
import com.alibaba.fastjson.JSON;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Date;
import java.util.List;


public class test {
    public static void main(String[] args) {
        SqlSessionFactory ssf = getConn.getSsf();
        SqlSession sqlSession = ssf.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Title> postList = mapper.titleBox();
        String s = JSON.toJSONString(postList);

        System.out.println(s);

        sqlSession.close();

    }

}
