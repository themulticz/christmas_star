package tools;

public class ShapeDrawingLibrary {

    
    public static final String YELLOW = "\u001b[43m";
    public static final String RESET = "\u001B[0m";
    public static final String GRAY = "\u001b[47;1m";
    public static final String RED = "\u001b[41m";
    public static final String BLACK = "\u001b[47m";
    public static final String sign = YELLOW+"@"+RESET;

    public static void drawChristmasStar(int point, int size) {
        int length = size * 2 + 1;
        int borders[];
        int[] lines;
        int[][] temp;

        if (point <= 3) {
            temp = drawSmall(point);
        } else {
            temp = drawBig(point);
        }
        
        if (temp[0] == null) {
            System.out.println("Nelze vykreslit obrázek!");
            return;
        }
        
        lines = temp[0];
        borders = temp[1];

        

        inMiddle(length, sign, 1, true);

        String s;
        String border;
        for (int i = 0; i < lines.length; i++) {
            border = getLine(sign, borders[i],false);
            s = getLine("*", lines[i],true);
            inMiddle(length, border + s + border, getStringLengthWithoutANSI(border + s + border), true);
        }

        if (lines.length != 0) {
            inMiddle(length, sign, 1, true);
        }
    }

    private static String getSign(String sign) {
        float treshold = 0.05f;

        return (Math.random() <= treshold ? RED : GRAY) + sign + RESET;
    }

    private static int[][] drawSmall(int x) {
        if (x > 3) {
            return null;
        }

        if (x == 0) {
            return new int[][]{};
        }

        int[] sizes = new int[x * 2 - 1];
        int[] borders = new int[x * 2 - 1];

        //Půlka
        for (int i = 0; i < x - 1; i++) {
            sizes[i] = i * 2 + 1;
            sizes[2 * x - 2 - i] = i * 2 + 1;

            borders[i] = 1;
            borders[2 * x - 2 - i] = 1;
        }

        //Střed
        sizes[x - 1] = x * 2 - 1;
        borders[x - 1] = 1;

        return new int[][]{sizes, borders};
    }

    private static int[][] drawBig(int x) {
        if (x < 4) {
            return null;
        }

        int middle = x * 2 - 1;
        int[] sizes = new int[middle];
        int[] borders = new int[middle];
        int small = (x + 1) / 2;

        //Úzká část
        for (int i = 0; i < small; i++) {
            sizes[i] = 1;
            sizes[2 * x - 2 - i] = 1;

            borders[i] = 1;
            borders[2 * x - 2 - i] = 1;
        }

        //Lichá do středu
        int temp;
        for (int i = 0; i < x / 2 - 1; i++) {
            temp = (i + 1) * 2 + 1;
            sizes[small + i] = temp;
            sizes[2 * x - 2 - i - small] = temp;

            if (i != (x / 2 - 2)) {
                borders[small + i] = 1;
                borders[2 * x - 2 - i - small] = 1;
            } else {
                temp = (int) Math.ceil(x / 2);
                borders[small + i] = temp;
                borders[2 * x - 2 - i - small] = temp;
            }
        }

        //Prostředek
        sizes[middle / 2] = middle;
        borders[middle / 2] = 1;

        return new int[][]{sizes, borders};
    }

    private static void inMiddle(int length, String s, int strSize, boolean newLine) {
        for (int i = 0; i < (length - strSize) / 2+1; i++) {
            System.out.print(" ");
        }
        drawLine(s, 1, newLine);
    }

    private static int getStringLengthWithoutANSI(String str) {
        return str.replaceAll("(\\x9B|\\x1B\\[)[0-?]*[ -\\/]*[@-~]", "").length();
    }

    public static void drawLine(String c, int length, boolean newLine) {
        System.out.print(getLine(c, length,false));
        if (newLine) {
            System.out.println("");
        }
    }

    private static String getLine(String c, int length,boolean change) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += (change && Math.random() <= 0.01 ? RED : YELLOW)+ c + RESET;
        }
        return s;
    }

}
