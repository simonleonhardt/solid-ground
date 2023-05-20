package finalProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	public int mapWidth = 15;
	public int mapHeight = 15;
	private Thread thread;
	private boolean running;
	private BufferedImage image;
	public int[] pixels;
	public static int[][] map1 = 
		{
			{1,1,1,1,1,1,1,1,2,2,2,2,2,2,2},
			{1,0,0,0,0,0,0,0,2,0,0,0,0,0,2},
			{1,0,3,3,3,3,3,0,0,0,0,0,0,0,2},
			{1,0,3,0,0,0,3,0,2,0,0,0,0,0,2},
			{1,0,3,0,0,0,3,0,2,2,2,0,2,2,2},
			{1,0,3,0,0,0,3,0,2,0,0,0,0,0,2},
			{1,0,3,3,0,3,3,0,2,0,0,0,0,0,2},
			{1,0,0,0,0,0,0,0,2,0,0,0,0,0,2},
			{1,1,1,1,1,1,1,1,4,4,4,1,4,4,4},
			{1,0,0,0,0,0,1,4,0,0,0,0,0,0,4},
			{1,0,0,0,0,0,1,4,0,0,0,0,0,0,4},
			{1,0,0,5,0,0,1,4,0,3,3,3,3,0,4},
			{1,0,0,0,0,0,1,4,0,3,3,3,3,0,4},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,4},
			{1,1,1,1,1,1,1,4,4,4,4,4,4,4,4}
		};
	public static int[][] map2 = 
		{
			{4,4,4,4,4,4,4,4,3,3,3,3,3,3,3},
			{4,0,0,0,0,0,0,0,3,0,0,0,0,0,3},
			{4,0,2,2,2,2,2,0,0,0,0,0,0,0,3},
			{4,0,2,0,0,0,2,0,3,0,0,0,0,0,3},
			{4,0,2,0,0,0,2,0,3,3,3,1,3,3,3},
			{4,0,2,0,0,0,2,0,3,0,0,0,0,0,3},
			{4,0,2,2,0,2,2,0,3,0,0,0,0,0,3},
			{4,0,0,0,0,0,0,0,3,0,0,0,0,0,3},
			{4,4,4,4,4,4,4,4,1,1,1,0,1,1,1},
			{4,0,0,0,0,0,4,1,0,0,0,0,0,0,1},
			{4,0,0,0,0,0,4,1,0,0,0,0,0,0,1},
			{4,0,0,5,0,0,4,1,0,0,0,0,0,0,1},
			{4,0,0,0,0,0,4,1,0,0,0,0,0,0,1},
			{4,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{4,4,4,4,4,4,4,1,1,1,1,1,1,1,1}
		};
	public static int[][] map;
	public static int[][][] maps = {map1, map2};
	public static int mapCycle = 0;
	
	public ArrayList<Texture> textures;
	
	
	public Camera camera;
	public Screen screen;

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int screenW = (int)screenSize.getWidth();
	public static int screenH = (int)screenSize.getHeight();

	public static int score = 0;
	
	public Game() {
		thread = new Thread(this);
		image = new BufferedImage(screenW, screenH, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		map = map1;
		textures = new ArrayList<Texture>();
		textures.add(Texture.texture1);
		textures.add(Texture.texture2);
		textures.add(Texture.texture3);
		textures.add(Texture.texture4);
		textures.add(Texture.textureCoin);
		setSize(screenW, screenH);
		setResizable(false);
		setTitle("Solid Ground");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.black);
		setLocationRelativeTo(null);
		setVisible(true);
		start();
		
		camera = new Camera(4.5, 4.5, 1, 0, 0, -.66);
		addKeyListener(camera);
		
		screen = new Screen(map, mapWidth, mapHeight, textures, screenW, screenH, score);
	}
	
	private synchronized void start() {
		running = true;
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		bs.show();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0 / 60.0;//60 times per second
		double delta = 0;
		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta = delta + ((now-lastTime) / ns);
			lastTime = now;
			while (delta >= 1)//Make sure update is only happening 60 times a second
			{
				//handles all of the logic restricted time
				screen.update(camera, pixels, map, score);
				camera.update(map);
				delta--;
			}
			render();//displays to the screen unrestricted time
		}
		
		
	}
	
	public static void swapMap(int mapX, int mapY, int mapChange) {
		if(mapChange == -1) {
			mapCycle++;
			if(mapCycle == maps.length) mapCycle = 0;
			if (maps[mapCycle][mapX][mapY] == 0) {
				map = maps[mapCycle];
			} else {
				mapCycle--;
				if(mapCycle == -1) mapCycle = maps.length - 1;
			}
		} else if (maps[mapChange][mapX][mapY] == 0) {
			mapCycle = mapChange;
			map = maps[mapChange];
		}
	}

	public static void pickUpCoin(int mapX, int mapY) {
		map[mapX][mapY] = 0;
		score++;
	}
	
	public static void main(String [] args) {
		Game game = new Game();
	}
	
}