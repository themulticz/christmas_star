package christmaas;

import tools.ShapeDrawingLibrary;
import java.util.Scanner;

public class Star {
    
    private int size;
    private int frequency;
    private UserInterface ui;
    
    public Star(){
        ui = new UserInterface();
        
        askForSettings();
    }
    
    private void askForSettings(){
        ui.showBanner(new String[]{"Prosím napište velikost hvězdy (min 1) a frekvenci animace (v milisekundách, min 50)","Př: 6 300"});
        boolean cond;
        do{
            size = ui.getInteger();
            frequency = ui.getInteger();
            cond = size > 0 && frequency >= 100;
            if(!cond){
                System.out.println("Neplatný formát!");
            }
        }while(!cond);
    }
    
    
    public void run(){
        //Pro screenshot?
        ShapeDrawingLibrary.drawChristmasStar(size,size);

//        int count = 0;
//        boolean direction = true;
//        while(true){
//            drawClean();
//            ShapeDrawingLibrary.drawChristmasStar(count+1,size);
//            for (int i = 0; i < (2*size+1-(2*(count+1)+1))/2+1; i++) {
//                System.out.println("");
//            }
//            
//            if(direction){
//                count++;
//            }else{
//                count--;
//            }
//            try {
//                Thread.sleep(frequency);
//                
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            
//            if(count == 0 || count == size){
//                direction = !direction;
//            }
//        }
        
    }
    
    private void drawClean(){
        String s = "";
        for (int i = 0; i < 90; i++) {
            s+="\r\n";
        }
        System.out.println(s);
    }
    
}