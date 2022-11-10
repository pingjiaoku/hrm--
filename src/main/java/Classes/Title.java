package Classes;

public class Title {
    private Integer id;
    private String titleName;
    private Integer rank;
    private Integer count;
    private String describe;

    public Title() {
    }

    public Title(Integer id, String titleName, Integer rank, String describe) {
        this.id = id;
        this.titleName = titleName;
        this.rank = rank;
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                ", rank=" + rank +
                ", count=" + count +
                ", describe='" + describe + '\'' +
                '}';
    }
}
