package mapper;

import Classes.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DepMapper {
    @Select("select depName,depID,parentDepID from dept")
    List<Department> getDepList(); // 获取部门列表信息，用于显示部门jsTree

    @Select("select depName, depID, parentDepID, depType, depAddress, depPostCode, depPhoneNumber, depTelePhone, depEmail from dept where depID = #{id};")
    Department getInfo(String id); // 获取对应id的部门信息

    @Select("select count(*) from emp where dept_id = #{id}")
    int getEmpCnt(String id); // 获取该部门的员工信息，用于删除部门前，若部门中有员工就不能删除

    @Delete("delete from dept where depID = #{id};")
    int deleteDep(int id); // 删除部门

    @Insert("insert into dept(depID,depName,parentDepID,depType,depAddress,depPostCode,depPhoneNumber,depTelePhone,depEmail) values (#{depID},#{depName},#{parentDepID},#{depType},#{depAddress},#{depPostCode},#{depPhoneNumber},#{depTelePhone},#{depEmail})")
    int addDep(Department department); // 添加部门

    @Update("update dept set depName = #{depName},parentDepID = #{parentDepID},depType = #{depType},depAddress = #{depAddress},depPostCode = #{depPostCode},depPhoneNumber=#{depPhoneNumber},depTelePhone=#{depTelePhone},depEmail = #{depEmail} where depID = #{depID}")
    int updateDep(Department department); // 修改部门

}
