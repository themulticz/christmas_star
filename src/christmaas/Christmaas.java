package christmaas;

public class Christmaas {

    public static void main(String[] args) {
        Star s = new Star();
        s.run();
    }
    
    public static int func(int x){
        return (int)(22.88971 + (0.07887291 - 22.88971)/(1 + Math.pow((x/32.22455),1.038756)));
    }
    
}
