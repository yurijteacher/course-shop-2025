package ua.com.kisit.courseshop2025.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.kisit.courseshop2025.entity.Products;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Setter
@Getter

public class Cart {

    List<ItemCart> cart;
    private double totalValue;
    private int sumElInCart;

    public Cart() {
        cart = new ArrayList<>();
        totalValue = 0;
        sumElInCart = 0;
    }

//    public synchronized void addNewItemToCart(Products product, int quantity) {
//
//        boolean logic = true;
//
//        for (ItemCart itemCart : cart) {
//            if (itemCart.getProduct().getId() == product.getId()) {
//                logic = false;
//                itemCart.setQuantity(itemCart.getQuantity() + quantity);
//            }
//        }
//
//        if (logic) cart.add(new ItemCart(product, quantity));
//    }

    public synchronized void addNewItemToCart(Products product, int quantity) {
        for (ItemCart itemCart : cart) {
            if (itemCart.getProduct().getId() == product.getId()) {
                itemCart.setQuantity(itemCart.getQuantity() + quantity);
                return;
            }
        }
        cart.add(new ItemCart(product, quantity)); // Якщо товару не було, додаємо новий
    }



    public synchronized void updateItemInCart(Products product, int quantity) {

        Iterator<ItemCart> iterator = cart.iterator();

        while (iterator.hasNext()) {
            ItemCart itemCart = iterator.next();
            if (itemCart.getProduct().getId() == product.getId()) {
                if(quantity<=0){
                    iterator.remove();
                }
                else {
                    itemCart.setQuantity(quantity);
                }
            }
        }
    }

//        if (quantity <= 0) {
//            for (ItemCart el : cart) {
//                if (el.getProduct().getId() == product.getId()) {
//                    cart.remove(el);
//                    break;
//                }
//            }
//        } else {
//            for (ItemCart itemCart : cart) {
//                if (itemCart.getProduct().getId() == product.getId()) {
//                    itemCart.setQuantity(quantity);
//                }
//            }
//        }



    public synchronized void deleteItemFromCart(Products product) {
        for (ItemCart el : cart) {
            if (el.getProduct().getId() == product.getId()) {
                cart.remove(el);
                break;
            }
        }
    }

    public synchronized void deleteAllItemFromCart() {

        cart.clear();
        totalValue = 0;
        sumElInCart = 0;

    }

    public synchronized double getTotalValue() {

        totalValue = 0;
        for (ItemCart itemCart : cart) {
            totalValue += itemCart.getQuantity() * itemCart.getProduct().getPrice().doubleValue();
        }
        return totalValue;
        
    }

    public synchronized int getSumElInCart() {
        return cart.size();
    }


}
