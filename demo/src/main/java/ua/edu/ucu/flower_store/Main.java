package ua.edu.ucu.flower_store;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Flower flower = new Flower();
        flower.setColor(FlowerColor.RED);
        flower.setPrice(100);
        flower.setSepalLength(10);
        flower.setFlowerType(FlowerType.ROSE);
        System.out.println(flower);


        FlowerPack flowerPack = new FlowerPack(flower, 11);
        flowerPack.setFlower(flower);
        flowerPack.setQuantity(11);

        FlowerBucket flowerBucket = new FlowerBucket();
        flowerBucket.addFlowerPack(flowerPack);
        System.out.println(flowerBucket.getPrice());


        
    }
}