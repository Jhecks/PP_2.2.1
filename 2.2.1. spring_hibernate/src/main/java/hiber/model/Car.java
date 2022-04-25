package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int series;

    @Column
    private String model;

    @OneToOne
    @MapsId
    private User user;

    public Car() {}

    public Car(int series, String model, User user) {
        this.series = series;
        this.model = model;
        this.user = user;
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "\033[0;36m" + "Car:\n\t{" +
                "id=" + id +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}' + "\033[0m";
    }
}
