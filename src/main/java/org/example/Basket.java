package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Basket {

    private Map<String, Integer> basket = new ConcurrentHashMap<>();

    public void addProduct(String product, int quantity) {
        basket.putIfAbsent(product, quantity);
    }

    public void removeProduct(String product) {
        basket.remove(product);
    }

    public void updateProductQuantity(String product, int quantity) {
        basket.computeIfPresent(product, (k, v) -> v = quantity);
    }

    public void clear() {
        basket.clear();
    }

    List<String> getProducts() {
        return new ArrayList<>(basket.keySet());
    }

    int getProductQuantity(String product) {
        return basket.get(product);
    }
}
