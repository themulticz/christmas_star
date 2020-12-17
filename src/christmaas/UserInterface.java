package christmaas;

import tools.MenuDrawingLibrary;
import java.util.Scanner;

public class UserInterface {
    
    private Scanner sc = new Scanner(System.in);
    
    public void showBanner(String[] lines){
        MenuDrawingLibrary.drawMenu(lines);
    }
    
    public int getInteger(){
        return sc.nextInt(); 
    }
    
    public String getString(){
        try {
            return sc.next();
        } catch (Exception e) {
            return "";
        }
        
    }
    
    public float getFloat(){
        try {
            return sc.nextFloat();
        } catch (Exception e) {
            return 1.0f;
        }
        
    }
    
    public boolean getBoolean(){
        try {
            return sc.nextBoolean();
        } catch (Exception e) {
            return false;
        }
    }
}