/*
 * This class instantiate a robot and place the robot in a predefined location and based on the command trigger the robot movement.
 */
package generator;

import java.util.ArrayList;

import errortracker.BugReporter;
import util.Command;
import util.Heading;
import util.Mode;

public class Simulator {
    private Robot bot;
    private ArraySheet sheet;

    public void initSimulator(Robot robot, ArraySheet sheet) {
        this.bot = robot;
        this.sheet = sheet;
    }

    public void placeCommand(String commands) {
        int xValue = 0;
        int yValue = 0;
 //       String[] commandArgs = commands.split(" ");
        try {
            xValue = Integer.parseInt(commands);
            yValue = Integer.parseInt(commands);
        
        } catch (Exception ex) {
            throw new BugReporter("Invalid argument");
        }
        if (xValue>100 || xValue<2) {
            throw new BugReporter(("100"));
        }
        Heading direction = Heading.from("NORTH");
        Mode mode = Mode.from("up");
        ArraySheet.floor= sheet.initializeLocation();
        Location position = new Location(0, 0, direction, mode, sheet);
        bot.placeRobot(position, sheet);
      
    }
    public void moveCommand(int step){
        	bot.move(step);
        	}
    public ArrayList<String> otherCommand(Command currentCommand) {
       // String output = "";
        ArrayList<String> output = new ArrayList<>();
        if (bot.getLocation() == null) {
            return output;
        }
        if (currentCommand == null) {
            throw new BugReporter("Command not found");
        }
        switch (currentCommand) {
     
            case L:
            	bot.left();
                break;
            case R:
            	bot.right();
                break;
            case U:
            	bot.up();
                break;
            case D:
            	bot.down();
                break;
            case P:
              output=bot.print();
                break;
            case C:
                output =bot.report();
                break;
        }
        return output;
    }

    public ArrayList<String> executeCommand(String commandLine) {
        String[] commandArgs = commandLine.split(" ");
        ArrayList<String> output=new ArrayList<>();
        try {
	           Command command = Command.valueOf(commandArgs[0]);
            if (command == Command.I) {
                placeCommand(commandArgs[1]);
            } else {
                output = otherCommand(command);
            }
        } catch (IllegalArgumentException ex) {
            throw new BugReporter("Invalid command");
        }
        return output;
    }

    public Robot getRobot() {
        return bot;
    }
}