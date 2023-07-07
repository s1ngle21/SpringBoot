package app.entity;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigserial")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private double cost;


    public Product() {
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
