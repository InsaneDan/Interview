package Lesson1.CarsCodeReview;

class LightWeightCar extends Car implements Moveable {

    // расширение видимости метода родительского класса
    @Override
    public void start() {
        super.start();
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}

