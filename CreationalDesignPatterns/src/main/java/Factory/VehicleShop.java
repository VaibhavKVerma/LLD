package Factory;

import java.util.Map;

public class VehicleShop {
    interface Vehicle {
        void assemble();
        void paint(String color);
        void addFeatures(String engine, String fuel);
    }

    class Car implements Vehicle {
        @Override
        public void assemble() {
            System.out.println("Assembling Car");
        }

        @Override
        public void paint(String color) {
            System.out.println("Painting Car : " + color);
        }

        @Override
        public void addFeatures(String engine, String fuel) {
            System.out.println("Adding features to Car : " + engine + " " + fuel);
        }
    }

    class Truck implements Vehicle {
        @Override
        public void assemble() {
            System.out.println("Assembling Truck");
        }

        @Override
        public void paint(String color) {
            System.out.println("Painting Truck : " + color);
        }

        @Override
        public void addFeatures(String engine, String fuel) {
            System.out.println("Adding features to Truck : " + engine + " " + fuel);
        }
    }

    class Motorcycle implements Vehicle {
        @Override
        public void assemble() {
            System.out.println("Assembling Motorcycle");
        }

        @Override
        public void paint(String color) {
            System.out.println("Painting Motorcycle : " + color);
        }

        @Override
        public void addFeatures(String engine, String fuel) {
            System.out.println("Adding features to Motorcycle : " + engine + " " + fuel);
        }
    }

    class VehicleFactory {
        public Vehicle getVehicle(Map<String, String> config) {
            String type = config.get("type");
            switch (type) {
                case "car":
                    return new CarFactory().getVehicle();
                case "truck":
                    return new TruckFactory().getVehicle();
                case "motorcycle":
                    return new MotorcycleFactory().getVehicle();
                default:
                    return null;
            }
        }
    }

    class CarFactory {
        public Vehicle getVehicle() {
            return new Car();
        }
    }

    class TruckFactory {
        public Vehicle getVehicle() {
            return new Truck();
        }
    }

    class MotorcycleFactory {
        public Vehicle getVehicle() {
            return new Motorcycle();
        }
    }

    public static void main(String [] args) {

    }
}
