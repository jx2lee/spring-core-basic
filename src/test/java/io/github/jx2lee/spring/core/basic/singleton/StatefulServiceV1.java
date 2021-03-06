package io.github.jx2lee.spring.core.basic.singleton;

public class StatefulServiceV1 {

    private int price; // 상태 유지 field

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
