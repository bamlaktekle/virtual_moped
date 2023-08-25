package edu.nyu.cs;

import java.util.Arrays;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {
    private String orientation = "south"; //starting orientation
    private int gasLevel = 100; //1 gallons = 100 gallons
    private static final int gas_per_block = 5; // 5 = 1/20 x 100
    private int[] location = {10,5}; //the location sets the array as [street, avenue] starting position (10th street, fifth ave)

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */

    public void setOrientation(String orientation) {
    this.orientation = orientation.toLowerCase();

    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return orientation;     //returns the previous orientation 
    }
    
    private String getStreetSuffix(int street) {
        if (street % 100 ==11 || street % 100 ==12|| street %100==13){
            return "th";
        } else if (street % 10==1){
            return "st";
        } else if (street % 10==2){
            return "nd";
        }else if (street % 10==3){
            return "rd";
        }else{
            return "th";
        }
    }
    private String getAvenueSuffix(int avenue){
        int lastDigit = avenue %10;
        switch (lastDigit){
            case 1: 
            return "st";
            case 2:
            return "nd";
            case 3:
            return"rd";
            default:
            return "th";
        }
    }
/**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        int street = this.location[0];
        int avenue = this.location[1];

        String streetSuffix = getStreetSuffix(street);
        String avenueSuffix = getAvenueSuffix(avenue);
        String ad ="";
        if (street ==79 && avenue==8){
            ad = "Did you know the American Museum of Natural History has over 30 million specimen?";
        } else if (street ==74 && avenue ==1){
            ad = "Did you know the Memorial Sloan Kettering is the World's oldest and largest private cancer cente?";
        } else if (street ==56 && avenue ==3){
            ad = "Did you know Tina's Cuban Cuisine has been serving authentic Cuban food for over 20 years?";
        } else if (street ==12 && avenue ==4){
            ad = "Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?"; 
        }
        System.out.println("Now at " + street + streetSuffix + " St. and " + avenue + avenueSuffix + " Ave, facing " + orientation + ". " + ad);
    }

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
            if(gasLevel >= 5) {
                gasLevel -= 5;
                    if(orientation.equals("north")){
                        orientation = "west";
                    }
                    else if(orientation.equals("south")){
                        orientation = "east";
                    }
                    else if(orientation.equals("east")){
                        orientation = "north";
                    }
                    else if(orientation.equals("west")){
                        orientation = "south";
                    }
                    
                    if (location[1] <10  && this.orientation.equals("west")) {
                        location[1]++;
                    }
                    else if(location[0] < 200 && this.orientation.equals("north")) {
                        location[0]++;
                    }
                    else if(location[1] > 1 && this.orientation.equals("east")) {
                        location[1]--;
                    }
                    else if(location[0] > 1 && this.orientation.equals("south")) {
                        location[0]--;
                    }
                    if ((location[1] == 10 && this.orientation.equals("west")) ||
                            (location[0] == 200 && this.orientation.equals("north")) ||
                            (location[1] == 1 && this.orientation.equals("east")) ||
                            (location[0] == 1 && this.orientation.equals("south"))) {
                            gasLevel += 5; // Add back the gas used for turning
                        }
                    }
            else {
                if(orientation.equals("north")){
                    orientation = "west";
                }
                else if(orientation.equals("south")){
                    orientation = "east";
                }
                else if(orientation.equals("east")){
                    orientation = "north";
                }
                else if(orientation.equals("west")){
                    orientation = "south";
                }
            }
        
}
    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        if(gasLevel >= 5) {
                gasLevel -= 5;
            if(orientation.equals("north")){
                orientation = "east";
            }
            else if(orientation.equals("south")){
                orientation = "west";
            }
            else if(orientation.equals("east")){
                orientation = "south";
            }
            else if(orientation.equals("west")){
                orientation = "north";
            }
            
            if (location[1] <10 && this.orientation.equals("west")) {
                location[1] ++;
            }
            else if(location[0] < 200 && this.orientation.equals("north")) {
                location[0] ++;
            }
            else if(location[1] > 1 && this.orientation.equals("east")) {
                location[1] --;
            }
            else if(location[0] > 1 && this.orientation.equals("south")) {
                location[0] --;
            }
            if ((location[1] == 10 && this.orientation.equals("west")) ||
                    (location[0] == 200 && this.orientation.equals("north")) ||
                    (location[1] == 1 && this.orientation.equals("east")) ||
                    (location[0] == 1 && this.orientation.equals("south"))) {
                    gasLevel += 5; // Add back the gas used for turning
                }
        }
        else {
            //System.out.println("Not enough gas");
            if(orientation.equals("north")) {
                orientation = "east";
            }
            else if(orientation.equals("west")) {
                orientation = "north";
            }
            else if(orientation.equals("south")) {
                orientation = "west";
            }
            else if(orientation.equals("east")) {
                orientation = "south";
            }
        }
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        if (gasLevel>0){
            if(orientation.equals("west") && location[1]<10){
                location[1]++;
            }
            else if (orientation.equals("east") && location[1]>1){
                location[1]--;
            }
            else if (orientation.equals("north") && location[0]<200){
                location[0]++;
            }
            else if (orientation.equals("south") && location[0]>1){
                location[0]--;
            }
            gasLevel -= gas_per_block;
        }
        
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        
        if(gasLevel > 0) {
            if (orientation.equals("north") && location[0] > 1) {
                location[0]--;
            }
            else if (this.orientation.equals("east") && location[1] <10){
                location[1]++;
            }
            else if (this.orientation.equals("west") && location[1] > 1) {
                location[1]--;
            }
            else if (this.orientation.equals("south") && location[0] < 200) {
                location[0]++;
            }
            gasLevel -= gas_per_block;
        }
    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return gasLevel; // placeholder only... delete this!
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        if (gasLevel == 0){
            System.out.println("We have run out of gas. Bye bye!");
            System.exit(0);
        }
        else {
            System.out.print("The gas tank is currently "+ gasLevel+"% full.");
        }
    }
        
    

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        int maxGas = 100;
        gasLevel = maxGas;
    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.out.println("We have parked");
        System.exit(0);
    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        int xianStreet = 15;
        int xianAve = 8;
        
        if (location[0] != xianStreet){
            if (location[0]> xianStreet){
            if (orientation.equals("west")){
                if (gasLevel ==0){
                    fillGas();
                }
                goLeft();
                printLocation();
                while (location[0] != xianStreet){
                    
                    goStraight();
                printLocation();
                }
            
            }
            else if(orientation.equals("east")){
                goRight();
                printLocation();
                while (location[0] != xianStreet){
                    if (gasLevel ==0){
                        fillGas();
                    }
                goStraight();
                printLocation();
                }
            }
            else if (orientation.equals("north")){
                while (location[0] != xianStreet){
                    if (gasLevel ==0){
                        fillGas();
                    }
                goBackwards();
                printLocation();
                }
            }
            else if (orientation.equals("south")){
                while (location[0] != xianStreet){
                    if (gasLevel ==0){
                        fillGas();
                    }
                    goStraight();
                    printLocation();
                }
            }
          
        }
        else if (location[0] < xianStreet){
            if (orientation.equals("south")){
                while (location[0] != xianStreet){
                    if (gasLevel==0){
                        fillGas();
                    }
                    goBackwards();
                    printLocation();
                }
            }
            else if (orientation.equals("north")){
                while (location[0] != xianStreet){
                    if (gasLevel==0){
                        fillGas();
                    }
                    goStraight();
                    printLocation();
                }
            }
            else if (orientation.equals("east")){
                goLeft();
                while (location[0] != xianStreet){
                    if (gasLevel==0){
                        fillGas();
                    }
                    goStraight();
                    printLocation();
                }
            }
            else if (orientation.equals("west")){
                goRight();
                while(location[0] != xianStreet){
                    if (gasLevel==0){
                        fillGas();
                    }
                    goStraight();
                    printLocation();
                }
            }
        }
       
      if (location[1] != xianAve){
        if(location[1] > xianAve){
            if (orientation.equals("north")){
                goLeft();
                printLocation();
                while(location[1] != xianAve){
                    if (gasLevel ==0){
                        fillGas();
                    }
                    goBackwards();
                    printLocation();
                }
            }
            else if (orientation.equals("south")){
                goRight();
                printLocation();
                while(location[1] != xianAve){
                    if (gasLevel ==0){
                        fillGas();
                    }
                    goBackwards();
                    printLocation();
                }
            }
        }
        else if (location[1]<xianAve){
            if (orientation.equals("north")){
                goRight();
                printLocation();
                while(location[1] != xianAve){
                    if (gasLevel ==0){
                        fillGas();
                    } 
                    goBackwards();
                    printLocation();
                }
            }
            else if (orientation.equals("south")){
                goLeft();
                printLocation();
                while(location[1] != xianAve){
                    if (gasLevel ==0){
                        fillGas();
                    }
                    goBackwards();
                    printLocation();
                }
            }
        }
      }
      }
    }
        
        
   

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        String help_com = "Here are the commands you can use to control the moped:\n";
        help_com += "  go left\n";
        help_com += "  go right\n";
        help_com += "  straight on \n";
        help_com += "  back up\n";
        help_com += "  how we doin'?\n";
        help_com += "  fill it up\n";
        help_com += "  park\n";
        help_com += "  go to Xi'an Famous Foods\n";
        return help_com;        
    }

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
        this.location[0] = location[0];
        this.location[1] = location[1];
    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        return location;
    }

}
