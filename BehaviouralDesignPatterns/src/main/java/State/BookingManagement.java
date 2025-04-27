package State;

public class BookingManagement {

    interface BookingState {
        void available(BookingContext bookingContext);
        void booked(BookingContext bookingContext);
        void cancelled(BookingContext bookingContext);
        void expired(BookingContext bookingContext);
    }

    static class Available implements BookingState {
        @Override
        public void available(BookingContext bookingContext) {
            System.out.println("Already Available");
        }

        @Override
        public void booked(BookingContext bookingContext) {
            System.out.println("Booking the available ticket");
            bookingContext.setBookingState(new Booked());
        }

        @Override
        public void cancelled(BookingContext bookingContext) {
            System.out.println("Cannot be cancelled");
        }

        @Override
        public void expired(BookingContext bookingContext) {
            System.out.println("Cannot be expired");
        }
    }

    static class Booked implements BookingState {
        @Override
        public void available(BookingContext bookingContext) {
            System.out.println("Ticket Booked, Not available");
        }

        @Override
        public void booked(BookingContext bookingContext) {
            System.out.println("Already Booked");
        }

        @Override
        public void cancelled(BookingContext bookingContext) {
            System.out.println("Cancelling the booked ticket");
            bookingContext.setBookingState(new Cancelled());
        }

        @Override
        public void expired(BookingContext bookingContext) {
            System.out.println("Booked ticket expired");
            bookingContext.setBookingState(new Expired());
        }
    }

    static class Cancelled implements BookingState {
        @Override
        public void available(BookingContext bookingContext) {
            System.out.println("Ticket is Cancelled");
        }

        @Override
        public void booked(BookingContext bookingContext) {
            System.out.println("Ticket is Cancelled");
        }

        @Override
        public void cancelled(BookingContext bookingContext) {
            System.out.println("Ticket is Cancelled");
        }

        @Override
        public void expired(BookingContext bookingContext) {
            System.out.println("Ticket is Cancelled");
        }
    }

    static class Expired implements BookingState {
        @Override
        public void available(BookingContext bookingContext) {
            System.out.println("Ticket is Expired");
        }

        @Override
        public void booked(BookingContext bookingContext) {
            System.out.println("Ticket is Expired");
        }

        @Override
        public void cancelled(BookingContext bookingContext) {
            System.out.println("Ticket is Expired");
        }

        @Override
        public void expired(BookingContext bookingContext) {
            System.out.println("Ticket is Expired");
        }
    }


    static class BookingContext {
        private BookingState bookingState;

        public BookingContext() {
            this.bookingState = new Available();
        }

        public void setBookingState(BookingState bookingState) {
            this.bookingState = bookingState;
        }

        public void available() {
            this.bookingState.available(this);
        }

        public void booked() {
            this.bookingState.booked(this);
        }

        public void cancelled() {
            this.bookingState.cancelled(this);
        }

        public void expired() {
            this.bookingState.expired(this);
        }
    }

    public static void main(String []args) {
        BookingContext bookingContext = new BookingContext();
        bookingContext.available();
        bookingContext.booked();
        bookingContext.cancelled();
        bookingContext.available();
        bookingContext.expired();
    }
}
