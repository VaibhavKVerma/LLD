What is Command Pattern?
- Command Pattern is used to encapsulate a request as an object.
- It separates the object that invokes the operation from the one that knows how to perform it.
- Helps in parameterizing objects with different operations, queueing requests, logging, and undo operations.

Structure:
- Command Interface → has a method like execute().
- Concrete Commands → implement the execute() method.
- Receiver → the real object that knows how to perform the action.
- Invoker → triggers the command (e.g., button click, remote control).
- Client → configures which command to use.


![Command](https://cwa-prod.s3.ap-south-1.amazonaws.com/1742352517671-Frame-250.png)

```java
// Step 1: Command Interface
interface Command {
    void execute();
}

// Step 2: Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Step 3: Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }
}

// Step 4: Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Step 5: Client
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
    
        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);

        remote.pressButton(); // Output: Light is ON
    }
}
```