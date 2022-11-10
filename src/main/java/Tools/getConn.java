package Tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class getConn {
    // 获取
    private static SqlSessionFactory ssf;

    static {
        try {
            String resource = "mybatis-config.xml"; // 在resource文件夹下直接写文件名
            InputStream inputStream = Resources.getResourceAsStream(resource);
            ssf = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSsf(){
        return ssf;
    }
}
