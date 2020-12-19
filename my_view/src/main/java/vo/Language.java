package main.java.vo;

public class Language {
    private Integer id;

    private String charname;

    private String name;

    private String groupid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharname() {
        return charname;
    }

    public void setCharname(String charname) {
        this.charname = charname == null ? null : charname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }
}