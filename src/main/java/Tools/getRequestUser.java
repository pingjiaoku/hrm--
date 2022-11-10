package Tools;

import Classes.User;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;

public class getRequestUser {
    public static User getUser(HttpServletRequest re){
        String id = re.getParameter("id");
        String name = re.getParameter("name");
        String account = re.getParameter("account");
        String password = re.getParameter("password");
        String salary = re.getParameter("salary");
        String tel = re.getParameter("tel");
        String emil = re.getParameter("emil");
        String gender = re.getParameter("gender");
        String politics = re.getParameter("politics");
        String school = re.getParameter("school");
        String eduLevel = re.getParameter("eduLevel");
        String pro = re.getParameter("pro");
        String city = re.getParameter("city");
        String address = re.getParameter("address");
        String age = re.getParameter("age");
        String dept = re.getParameter("dept");
        String title = re.getParameter("title");
        String post = re.getParameter("post");
        String status = re.getParameter("status");

        String ageMin = re.getParameter("ageMin");
        String ageMax = re.getParameter("ageMax");
        String salaryMin = re.getParameter("salaryMin");
        String salaryMax = re.getParameter("salaryMax");
        String dateMin = re.getParameter("dateMin");
        String dateMax = re.getParameter("dateMax");

        User user = new User();
        if(id!=null) {user.setId(Integer.parseInt(id));}
        if(name!=null) {user.setName(name);}
        if(account!=null) {user.setAccount(account);}
        if(password!=null) {user.setPassword(password);}
        if(salary!=null) {user.setSalary(Integer.parseInt(salary));}
        if(tel!=null) {user.setTelNum(tel);}
        if(emil!=null) {user.setEmil(emil);}
        if(gender!=null) {user.setGender(Integer.parseInt(gender));}
        if(politics!=null) {user.setPolitics(Integer.parseInt(politics));}
        if(school!=null) {user.setSchool(school);}
        if(eduLevel!=null) {user.setEduLevel(Integer.parseInt(eduLevel));}
        if(pro!=null) {user.setPro(pro);}
        if(city!=null) {user.setCity(city);}
        if(address!=null) {user.setAddress(address);}
        if(age!=null) {user.setAge(Integer.parseInt(age));}
        if(dept!=null) {user.setDeptId(Integer.parseInt(dept));}
        if(title!=null) {user.setTitleId(Integer.parseInt(title));}
        if(post!=null) {user.setPostId(Integer.parseInt(post));}
        if(status!=null) {user.setStatus(Integer.parseInt(status));}
//        user.setInduction(getNowDate()); // 获取当前年月日

        if(ageMin!=null) {user.setAgeMin(Integer.parseInt(ageMin));}
        if(ageMax!=null) {user.setAgeMax(Integer.parseInt(ageMax));}
        if(salaryMin!=null) {user.setSalaryMin(Integer.parseInt(salaryMin));}
        if(salaryMax!=null) {user.setSalaryMax(Integer.parseInt(salaryMax));}
        if(dateMin!=null) {user.setDateMin(Date.valueOf(dateMin));}
        if(dateMax!=null) {user.setDateMax(Date.valueOf(dateMax));}

        return user;
    }

/*    public static Date getNowDate() {
        Date time = new java.sql.Date(new java.util.Date().getTime());
        return time;
    }*/
}
