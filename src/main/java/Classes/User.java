package Classes;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class User {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Integer id;           // 员工id
    private String name;          // 姓名
    private Integer gender;       // 性别
    private String account;       // 账号
    private String password;      // 密码
    private Integer age;          // 年龄
    private Integer politics;     // 政治面貌
    private Integer eduLevel;     // 学历
    private String school;        // 毕业学校
    private String telNum;        // 电话号码
    private String emil;          // 邮箱
    private String pro;           // 省份
    private String city;          // 城市
    private String address;       // 住址
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date induction;       // 入职日期
    private Integer deptId;       // 部门id
    private Integer titleId;      // 职称id
    private Integer postId;       // 岗位id
    private Integer status;       // 状态
    private Integer salary;       // 薪水

    private Integer ageMin;       // 查询用
    private Integer ageMax;       // 查询用
    private Integer salaryMin;    // 查询用
    private Integer salaryMax;    // 查询用
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateMin;         // 查询用
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateMax;         // 查询用


    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPolitics() {
        return politics;
    }

    public void setPolitics(Integer politics) {
        this.politics = politics;
    }

    public Integer getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Integer eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getInduction() {
        return induction;
    }

    public void setInduction(Date induction) {
        this.induction = induction;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Date getDateMin() {
        return dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }

    public Date getDateMax() {
        return dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }

    @Override
    public String toString() {
        String user = "User{";
        if(name!=null){user += "name='" + name + '\'';}
        if(id!=null){user += ", id=" + id;}
        if(account!=null){user += ", account=" + account + '\'';}
        if(password!=null){user += ", password=" + password + '\'';}
        if(gender!=null) {user += ", gender=" + gender;}
        if(age!=null){user += ", age=" + age;}
        if(politics!=null){user += ", politics=" + politics;}
        if(eduLevel!=null){user += ", eduLevel=" + eduLevel;}
        if(school!=null){user += ", school='" + school + '\'';}
        if(telNum!=null){user += ", telNum='" + telNum + '\'';}
        if(emil!=null){user += ", emil='" + emil + '\'';}
        if(pro!=null){user += ", pro='" + pro + '\'';}
        if(city!=null){user += ", city='" + city + '\'';}
        if(address!=null){user += ", address='" + address + '\'';}
        if(salary!=null){user += ", salary=" + salary;}
        if(induction!=null){user += ", induction='" + induction + '\'';}
        if(deptId!=null){user += ", deptId=" + deptId;}
        if(titleId!=null){user += ", titleId=" + titleId;}
        if(postId!=null){user += ", postId=" + postId;}
        if(status!=null){user += ", status=" + status;}

        if(ageMin!=null){user += ", ageMin=" + ageMin + '\'';}
        if(ageMax!=null){user += ", ageMax=" + ageMax + '\'';}
        if(salaryMin!=null){user += ", salaryMin=" + salaryMin + '\'';}
        if(salaryMax!=null){user += ", salaryMax=" + salaryMax + '\'';}
        if(dateMin!=null){user += ", dateMin=" + dateMin + '\'';}
        if(dateMax!=null){user += ", dateMax=" + dateMax + '\'';}
        user += "}";
        return user;
    }
}
