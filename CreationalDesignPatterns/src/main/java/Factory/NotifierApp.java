package Factory;

public class NotifierApp {
    static class NotificationService {
        interface Notifier {
            void send(String message);
        }

        class EmailNotifier implements Notifier {
            @Override
            public void send(String message) {
                System.out.println("Sending Email: " + message);
            }
        }

        class SMSNotifier implements Notifier {
            @Override
            public void send(String message) {
                System.out.println("Sending SMS: " + message);
            }
        }

        class PushNotifier implements Notifier {
            @Override
            public void send(String message) {
                System.out.println("Sending Push: " + message);
            }
        }

        class NotifierFactory {
            public Notifier getNotifier(String type) {
                if(type.equalsIgnoreCase("email")) {
                    return new EmailNotifier();
                } else if(type.equalsIgnoreCase("sms")) {
                    return new SMSNotifier();
                } else if(type.equalsIgnoreCase("push")) {
                    return new PushNotifier();
                }
                return null;
            }
        }

        public void sendNotification(String type, String message) {
            Notifier notifier = new NotifierFactory().getNotifier(type);
            if(notifier == null) {
                System.out.println("Invalid notification type: " + type);
                return;
            }
            notifier.send(message);
        }
    }

    public static void main(String [] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("email", "Hello World!");
        notificationService.sendNotification("sms", "Hello World!");
        notificationService.sendNotification("push", "Hello World!");
    }
}
