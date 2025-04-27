Factory Design Pattern

The Factory Design Pattern is a creational pattern that provides an interface for creating objects in a superclass.

Used when we have a superclass that is responsible for creating objects of its subclasses.

Use Cases:
- You’re building a Notification System. Based on the type (EMAIL, SMS, PUSH), you need to send notifications.
- Payment Gateway integration. Based on mode (UPI, CARD, WALLET), payment flow differs
- File upload feature. Based on file extension (csv, json, xml) you return a different parser.
- Messaging Queue Handler types	Kafka / RabbitMQ / Redis choose using QueueHandler.
- 

✅ Rule of Thumb
- If the main job is to hide object creation logic → Factory.
- If the main job is to vary behavior → Strategy.
- Often, Factory returns a Strategy.