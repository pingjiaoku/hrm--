package mapper;

import Classes.Post;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PostMapper {
    @Select("select * from post where name = #{name};")
    Post postNameExist(String name); // 添加岗位前，判断该岗位名是否已经存在

    @Insert("insert into post (name, deptId, content, demand, remark) values(#{name}, #{deptId}, #{content}, #{demand}, #{remark});")
    int addPost(Post post); // 添加岗位

    @Select("select * from post;")
    List<Post> allPost(); // 获取岗位信息列表

    @Select("select count(*) from emp where post_id = #{id};")
    int deletePostLimit(int id); // 删除岗位前判断岗位中是否还有员工

    @Delete("delete from post where id = #{id};")
    int deletePost(int id); // 删除岗位

    @Select("select * from post where id = #{id};")
    Post postInfo(int id); // 获取岗位信息

    @Update("update post set name=#{name},deptId=#{deptId},content=#{content},demand=#{demand},remark=#{remark} where id=#{id};")
    int editPost(Post post); // 修改岗位信息

    @Select("select depName from dept where depID = #{id};")
    String getDepName(int id); // 通过id显示所属部门名称
}
