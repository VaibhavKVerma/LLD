package State;

public class OrderManagement {
    public interface OrderState {
        void next(OrderContext orderContext);
        String getState();
    }

    public interface OrderContextActions {
        void next();
    }

    static public class OrderPlaced implements OrderState {
        @Override
        public void next(OrderContext orderContext) {
            System.out.println("Order placed. Moving to Preparing.");
            orderContext.setOrderState(new Preparing());
        }

        @Override
        public String getState() {
            return "OrderPlaced";
        }
    }

    static public class Preparing implements OrderState {
        @Override
        public void next(OrderContext orderContext) {
            System.out.println("Order is being prepared. Moving to Ready For Pickup.");
            orderContext.setOrderState(new ReadyForPickup());
        }

        @Override
        public String getState() {
            return "Preparing";
        }
    }

    static public class ReadyForPickup implements OrderState {
        @Override
        public void next(OrderContext orderContext) {
            System.out.println("Order is ready for pickup. Moving to Out For Delivery.");
            orderContext.setOrderState(new OutForDelivery());
        }

        @Override
        public String getState() {
            return "ReadyForPickup";
        }
    }

    static public class OutForDelivery implements OrderState {
        @Override
        public void next(OrderContext orderContext) {
            System.out.println("Order is out for delivery. Moving to Delivered.");
            orderContext.setOrderState(new Delivered());
        }

        @Override
        public String getState() {
            return "OutForDelivery";
        }
    }

    static public class Delivered implements OrderState {
        @Override
        public void next(OrderContext orderContext) {
            if(orderContext.getPrevState().equals("Delivered")) {
                System.out.println("Order already delivered. No further actions.");
            } else {
                System.out.println("Order delivered successfully.");
                orderContext.setOrderState(new Delivered());
            }
        }

        @Override
        public String getState() {
            return "Delivered";
        }
    }

    static public class OrderContext implements OrderContextActions {
        private OrderState orderState;
        private OrderState prevOrderState;

        OrderContext() {
            this.orderState = new OrderPlaced();
            this.prevOrderState = null;
        }

        @Override
        public void next() {
            orderState.next(this);
        }

        public void setOrderState(OrderState orderState) {
            this.prevOrderState = this.orderState;
            this.orderState = orderState;
        }

        public String getState() {
            return orderState.getState();
        }

        public String getPrevState() {
            return prevOrderState.getState();
        }
    }

    public static void main(String []args) {
        OrderContext orderContext = new OrderContext();
        orderContext.next();
        orderContext.next();
        orderContext.next();
        orderContext.next();
        orderContext.next();
        orderContext.next();
        orderContext.next();
    }
}
