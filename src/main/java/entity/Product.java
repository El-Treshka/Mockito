package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private float value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(Brand brand, String name,
                   float value, Unit unit,
                   Category category) {
        this.brand = brand;
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.category = category;
    }

}