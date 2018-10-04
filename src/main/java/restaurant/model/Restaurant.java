package restaurant.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {
    @Column(name = "dish", nullable = false)
    private String dish;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "vote")
    private int vote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Restaurant() {
    }

    public Restaurant(String name, String dish, int price, int vote) {
        this(null, name, dish, price, vote);
    }

    public Restaurant(Integer id, String name, String dish, int price, int vote) {
        super(id, name);
        this.dish = dish;
        this.price = price;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "dish='" + dish + '\'' +
                ", price=" + price +
                ", vote=" + vote +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
