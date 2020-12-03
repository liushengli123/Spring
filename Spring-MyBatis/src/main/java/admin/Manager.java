package admin;

import java.util.List;

public class Manager {
    private int id;
    private String name;
    private String sex;
    private int age;
    private List<Order> orderlist;
    public Manager() {
    }

    public List<Order> getOrderlist() {
        return orderlist;
    }

    public void setOrderList(List<Order> orderlist) {
        this.orderlist = orderlist;
    }

    public Manager(int id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", orderList=" + orderlist +
                '}';
    }
}
