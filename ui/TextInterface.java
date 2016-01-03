// Basic ASCI, in-terminal user interface

package ui;
import java.util.Scanner;


public class TextInterface implements UI {

    private Scanner kb;


    public TextInterface() {
	kb = new Scanner(System.in);
    } //end


    public void simpleMessage(String message) {
	System.out.println(message);
    } //end


    public void errorMessage(String message) {
	System.err.println("ERROR: " + message);
    } //end errorMessage


    public void onBegin() {
	// Do nothing.
    } //end onBegin


    public void onTurnEnd() {
	/* ** */kb.nextLine();
    } //end


} //end class
