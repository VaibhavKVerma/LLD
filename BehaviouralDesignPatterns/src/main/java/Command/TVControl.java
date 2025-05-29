package Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TVControl {
    public interface Command {
        void execute();
    }

    static public class TurnOnCommand implements Command {
        private TV tv;
        public TurnOnCommand(TV tv) {
            this.tv = tv;
        }
        @Override
        public void execute() {
            tv.turnOn();
        }
    }
    static public class TurnOffCommand implements Command {
        private TV tv;
        public TurnOffCommand(TV tv) {
            this.tv = tv;
        }
        @Override
        public void execute() {
            tv.turnOff();
        }
    }
    static public class ChangeChannelCommand implements Command {
        private TV tv;
        private int channel;
        public ChangeChannelCommand(TV tv, int channel) {
            this.tv = tv;
            this.channel = channel;
        }
        @Override
        public void execute() {
            tv.changeChannel(channel);
        }
    }
    static public class AdjustVolumeCommand implements Command {
        private TV tv;
        private int volume;
        public AdjustVolumeCommand(TV tv, int volume) {
            this.tv = tv;
            this.volume = volume;
        }
        @Override
        public void execute() {
            tv.adjustVolume(volume);
        }
    }

    static public class RemoteControl {
        private Command onCommand;
        private Command offCommand;
        public void setOnCommand(Command onCommand) {
            this.onCommand = onCommand;
        }
        public void setOffCommand(Command offCommand) {
            this.offCommand = offCommand;
        }
        public void pressOnButton() {
            onCommand.execute();
        }
        public void pressOffButton() {
            offCommand.execute();
        }
    }

    static public class TV {
        public void turnOn() {
            System.out.println("TV is ON");
        }
        public void turnOff() {
            System.out.println("TV is OFF");
        }
        public void changeChannel(int channel) {
            System.out.println("Channel changed to " + channel);
        }
        public void adjustVolume(int volume) {
            System.out.println("Volume set to " + volume);
        }
    }

    public static void main(String[] args) {
        TV tv = new TV();
        // Create commands
        Command turnOn = new TurnOnCommand(tv);
        Command turnOff = new TurnOffCommand(tv);
        Command changeChannel = new ChangeChannelCommand(tv, 5);
        Command adjustVolume = new AdjustVolumeCommand(tv, 20);
        // Create remote control
        RemoteControl remote = new RemoteControl();
        remote.setOnCommand(turnOn);
        remote.setOffCommand(turnOff);
        remote.pressOnButton(); // Turn on the TV
        remote.pressOffButton(); // Turn off the TV
        // Execute other commands
        changeChannel.execute(); // Change the channel
        adjustVolume.execute(); // Adjust the volume
    }
}
