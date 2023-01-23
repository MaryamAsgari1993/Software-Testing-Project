/*
 * This class READ the Command that user entered and based on the that trigger other class and function

 */
package input;
import generator.ArraySheet;
import generator.Robot;
import generator.Simulator;
import util.Command;
import java.util.ArrayList;
import java.util.Scanner;

import errortracker.BugReporter;

public class InputReader {

	protected Simulator createRobotSimulator(int row,int column) {
		ArraySheet table = new ArraySheet(row, column);
		Robot robot = new Robot();
		simulator = new Simulator();
		simulator.initSimulator(robot, table);
		return simulator;
	}
	
	 Simulator simulator;
	public  void readInput() {
			    
	    while (true) {
			ArrayList<String> result = new ArrayList<>();
	    	System.out.println("Enter Command: ");
		    Scanner input = new Scanner(System.in);
		    String line = input.nextLine();
    	    String[] commandArgs = line.split(" ");
    	    Command command;
    	    if (!Command.isCommand(commandArgs[0])){
    	    	System.out.println(commandArgs[0]);
    	    }
    	    try {
    	    	command = Command.valueOf(commandArgs[0].toUpperCase());
    	    	} catch (Exception ex) {
	            throw new BugReporter("Invalid Command");
	            }
	        if (command==Command.Q) {
	        	break;
	        	}
	        else  if (command == Command.I) {
	        	int xyValue=Integer.parseInt(commandArgs[1]);
	            simulator = createRobotSimulator(xyValue,xyValue);
	            simulator.placeCommand(commandArgs[1]);
	            }
	        else if (command == Command.M) {
	        	simulator.moveCommand(Integer.parseInt(commandArgs[1]));
	        	}
	        else {
	        	result=simulator.executeCommand(line);
	        	}
	        }
	    }
	}
	