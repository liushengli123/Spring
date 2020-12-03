package admin;

import java.util.Date;

public class Order {
    private int id;
    private Date datetime;
    private double total;
    private Manager manager;

    public Order() {
    }

    public Order(int id, Date datetime, double total, Manager manager) {
        this.id = id;
        this.datetime = datetime;
        this.total = total;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", total=" + total +
                ", manager=" + manager +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
