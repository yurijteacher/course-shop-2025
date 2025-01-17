package ua.com.kisit.courseshop2025.bl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kisit.courseshop2025.entity.Products;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ItemCart {

    private Products product;
    private int quantity;

}
