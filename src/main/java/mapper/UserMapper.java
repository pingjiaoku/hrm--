package mapper;

import Classes.Department;
import Classes.Post;
import Classes.Title;
import Classes.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select id, name, dept_id deptId from emp where account = #{account} and password = #{password};")
    User checkUserExist(User user); // 登录用于检测用户

    @Select("select name from emp where account = #{acc};")
    String selectAccountExist(String acc); // 添加时检测账号是否已存在

    User selectUserById(int id);  // 查看单个用户信息

    int insertEmp(User user); // 添加用户

    @Delete("delete from emp where id = #{id};")
    int deleteById(int id); // 删除用户

    int updateUser(User user); // 修改用户

    List<User> selectAllUser(); // 查看所有用户

    List<User> searchUser(String data); // 搜索框，By name or id

    List<User> selectUser(User user); // 查询用户，详细

    @Select("select id, name titleName from title Order By id desc;")
    List<Title> titleBox(); // 获取职称id、名称列表，用于生成职称下拉框

    @Select("select name from title where id = #{id};")
    String getTitleName(int id); // 获取职称名

    List<Department> getDepList();

    List<Post> getPostList();

}
