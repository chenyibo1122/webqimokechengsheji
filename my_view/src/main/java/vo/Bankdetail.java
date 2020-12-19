package main.java.vo;

public class Bankdetail {
    private Integer id;

    private String inorout;

    private Double money;

    private Double sum;

    private String time;

    private String byorto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInorout() {
        return inorout;
    }

    public void setInorout(String inorout) {
        this.inorout = inorout == null ? null : inorout.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getByorto() {
        return byorto;
    }

    public void setByorto(String byorto) {
        this.byorto = byorto == null ? null : byorto.trim();
    }
}