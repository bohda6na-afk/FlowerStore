package ua.edu.ucu.flower_store;

import lombok.Data;

@Data
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public double getPrice(){
        return flower.getPrice() * quantity;
    }

    public FlowerPack(Flower flower, int quantity){
        this.flower = new Flower(flower);
        this.quantity = quantity;
    }

    public void setFlower(Flower flower){
        this.flower = new Flower(flower);
    }

}
