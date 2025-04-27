package Factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CoffeeShop {

    static class CoffeeShopOrderService {
        interface Coffee {
            void prepare();
            void addExtras();
        }

        class SmallCoffee implements Coffee {
            @Override
            public void prepare() {
                System.out.println("Preparing small coffee");
            }
            @Override
            public void addExtras() {
                System.out.println("Adding milk and sugar");
            }
        }

        class LargeCoffee implements Coffee {
            @Override
            public void prepare() {
                System.out.println("Preparing large coffee");
            }
            @Override
            public void addExtras() {
                System.out.println("Adding milk and sugar");
            }
        }

        class MediumCoffee implements Coffee {
            @Override
            public void prepare() {
                System.out.println("Preparing Medium coffee");
            }

            @Override
            public void addExtras() {
                System.out.println("Adding milk and sugar");
            }
        }

        class CoffeeFactory {
            public Coffee getCoffee(String size) {
                if (size.equals("SMALL")) {
                    return new SmallCoffee();
                } else if (size.equals("MEDIUM")) {
                    return new MediumCoffee();
                } else if (size.equals("LARGE")) {
                    return new LargeCoffee();
                }
                return null;
            }
        }

        public void placeOrder(String size) {
            Coffee coffee = new CoffeeFactory().getCoffee(size);
            if(coffee == null) {
                System.out.println("Invalid size: " + size);
                return;
            }
            coffee.prepare();
            coffee.addExtras();
        }
    }

    public static void main(String [] args) {
        CoffeeShopOrderService coffeeShopOrderService = new CoffeeShopOrderService();
        coffeeShopOrderService.placeOrder("SMALL");
        coffeeShopOrderService.placeOrder("MEDIUM");
        coffeeShopOrderService.placeOrder("LARGE");
    }
}
