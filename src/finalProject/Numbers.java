package finalProject;

public class Numbers {
    public static int width = Game.screenW;


    public static void draw0(int[] pixels, int x, int y) {
        for(int i = 1; i < 4; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+4)*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+i)*(width) + x] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+i)*(width) + x + 4] = -1;
        }
    }
    public static void draw1(int[] pixels, int x, int y) {
        for(int i = 0; i < 3; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 0; i < 5; i++) {
            pixels[(y+4)*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+i)*(width) + x + 2] = -1;
        }
    }
    public static void draw2(int[] pixels, int x, int y) {
        for(int i = 1; i < 4; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 0; i < 5; i++) {
            pixels[(y+4)*(width) + x + i] = -1;
        }
        pixels[(y+1)*(width) + x] = -1;
        pixels[(y+1)*(width) + x + 4] = -1;
        pixels[(y+2)*(width) + x + 3] = -1;
        pixels[(y+3)*(width) + x + 1] = -1;
        pixels[(y+3)*(width) + x + 2] = -1;
    }
    public static void draw3(int[] pixels, int x, int y) {
        for(int i = 0; i < 4; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 0; i < 4; i++) {
            pixels[(y+4)*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+2)*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+i)*(width) + x + 4] = -1;
        }
    }
    public static void draw4(int[] pixels, int x, int y) {
        for(int i = 0; i < 5; i++) {
            pixels[(y+i)*(width) + x + 4] = -1;
        }
        for(int i = 0; i < 2; i++) {
            pixels[(y+i)*(width) + x] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+2)*(width) + x + i] = -1;
        }
    }
    public static void draw5(int[] pixels, int x, int y) {
        for(int i = 0; i < 5; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 0; i < 5; i++) {
            pixels[(y+2)*(width) + x + i] = -1;
        }
        for(int i = 0; i < 4; i++) {
            pixels[(y+4)*(width) + x + i] = -1;
        }
        pixels[(y+1)*(width) + x] = -1;
        pixels[(y+3)*(width) + x + 4] = -1;
    }
    public static void draw6(int[] pixels, int x, int y) {
        for(int i = 0; i < 4; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 0; i < 4; i++) {
            pixels[(y+2)*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+4)*(width) + x + i] = -1;
        }
        pixels[(y+1)*(width) + x] = -1;
        pixels[(y+3)*(width) + x] = -1;
        pixels[(y+3)*(width) + x + 4] = -1;
    }
    public static void draw7(int[] pixels, int x, int y) {
        for(int i = 0; i < 4; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        pixels[(y+1)*(width) + x + 4] = -1;
        pixels[(y+2)*(width) + x + 3] = -1;
        pixels[(y+3)*(width) + x + 2] = -1;
        pixels[(y+4)*(width) + x + 2] = -1;
    }
    public static void draw8(int[] pixels, int x, int y) {
        for(int i = 1; i < 4; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+2)*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+4)*(width) + x + i] = -1;
        }
        pixels[(y+1)*(width) + x] = -1;
        pixels[(y+1)*(width) + x + 4] = -1;
        pixels[(y+3)*(width) + x] = -1;
        pixels[(y+3)*(width) + x + 4] = -1;
    }
    public static void draw9(int[] pixels, int x, int y) {
        for(int i = 0; i < 5; i++) {
            pixels[(y+i)*(width) + x + 4] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[y*(width) + x + i] = -1;
        }
        for(int i = 1; i < 4; i++) {
            pixels[(y+2)*(width) + x + i] = -1;
        }
        pixels[(y+1)*(width) + x] = -1;
    }
}
