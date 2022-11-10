package mapper;
import Classes.Title;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TitleMapper {
    @Insert("insert into title (name, `rank`, `describe`) values (#{titleName}, #{rank}, #{describe});")
    int addTitle(Title title); // 添加职称信息

    @Select("select id, name, `rank`, `describe` from title where name = #{name};")
    Title titleNameExist(String name); // 添加职称信息前，判断该职称名称是否以存在

    @Select("select id, name titleName, `rank`, `describe` from title;")
    List<Title> titleList(); // 获取职称信息列表

    @Select("select count(*) from emp where title_id = #{titleId};")
    int EmpCountOfTitle(int titleId); // 显示得到该职称的员工人数

    @Select("select id, name titleName, `rank`, `describe` from title where id = #{id};")
    Title titleInfo(int id); // 获取对应id的职称信息

    @Update("update title set name=#{titleName}, `rank`=#{rank}, `describe`=#{describe} where id=#{id};")
    int updateTitle(Title title); // 修改职称信息

    @Delete("delete from title where id = #{id};")
    int deleteTitle(int id); // 删除职称信息

    @Select("select count(*) from emp where title_id = #{id};")
    int deleteTitleLimit(int id); // 删除职称时检查是否正在使用中
}
