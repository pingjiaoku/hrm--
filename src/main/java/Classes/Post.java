package Classes;

public class Post {
    private Integer id;       // id
    private String name;      // 名字
    private Integer deptId;   // 所属部门id
    private String content;   // 工作内容
    private String demand;    // 需求
    private String remark;    // 备注

    public Post() {

    }

    public Post(String name, Integer deptId, String content, String demand, String remark) {
        this.name = name;
        this.deptId = deptId;
        this.content = content;
        this.demand = demand;
        this.remark = remark;
    }

    public Post(Integer id, String name, Integer deptId, String content, String demand, String remark) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.content = content;
        this.demand = demand;
        this.remark = remark;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                ", content='" + content + '\'' +
                ", demand='" + demand + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
