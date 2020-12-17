package tools;

public class MenuDrawingLibrary {
    
    public static void drawMenu(String[] radky){
        int offset = 3;
        int length = nejdelsiString(radky)+offset+1;
        
        drawLine(length+offset);
        int temp;
        for(String s : radky){
            temp = s.length();
            System.out.format("* %s*%n",s+generujMezeru(length-temp));
        }
        drawLine(length+offset);
    }
    
    private static String generujMezeru(int n){
        String s = "";
        for (int i = 0; i < n; i++) {
            s+=" ";
        }
        return s;
    }
    
    public static void drawLine(int lenght){
        for (int i = 0; i < lenght; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
    
    private static int nejdelsiString(String[] radky){
        int count = 0;
        int temp;
        for(String s : radky){
            temp = s.length();
            if(temp > count){
                count = temp;
            }
        }
        return count;
    }
    
}