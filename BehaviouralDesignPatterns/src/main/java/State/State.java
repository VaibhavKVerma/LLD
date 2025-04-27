package State;

public class State {
    interface FanState {
        void pressButton(FanContext fan);
    }

    static class OffState implements FanState {
        @Override
        public void pressButton(FanContext fan) {
            System.out.println("Fan turned to LOW speed.");
            fan.setState(new LowState());
        }
    }

    static class LowState implements FanState {
        @Override
        public void pressButton(FanContext fan) {
            System.out.println("Fan turned to MEDIUM speed.");
            fan.setState(new MediumState());
        }
    }

    static class MediumState implements FanState {
        @Override
        public void pressButton(FanContext fan) {
            System.out.println("Fan turned to HIGH speed.");
            fan.setState(new HighState());
        }
    }

    static class HighState implements FanState {
        @Override
        public void pressButton(FanContext fan) {
            System.out.println("Fan turned to OFF state.");
            fan.setState(new OffState());
        }
    }

    static class FanContext {
        FanState state;

        public FanContext() {
            state = new OffState();
        }

        public void setState(FanState state) {
            this.state = state;
        }

        public void pressButton() {
            state.pressButton(this);
        }
    }

    public static void main(String [] args) {
        FanContext fan = new FanContext();
        fan.pressButton();
        fan.pressButton();
        fan.pressButton();
        fan.pressButton();
        fan.pressButton();
    }
}
