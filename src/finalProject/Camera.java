package finalProject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Camera implements KeyListener{
	public double xPos, yPos, xDir, yDir, xPlane, yPlane;
	public int mapX, mapY;
	public boolean left, right, forward, back;
	public final double MOVE_SPEED = .08;
	public final double ROTATION_SPEED = .045;
	
	public Camera(double x, double y, double xd, double yd, double xp, double yp) 
	{	
		xPos = x;
		yPos = y;
		xDir = xd;
		yDir = yd;
		xPlane = xp;
		yPlane = yp;
		mapX = (int)x;
		mapY = (int)y;
	}
	
	public void update(int[][] map) {
		mapX = (int)xPos;
		mapY = (int)yPos;
		// check empty tile
		if(forward) {
			if(map[(int)(xPos + xDir * MOVE_SPEED)][(int)yPos] == 0 || map[(int)(xPos + xDir * MOVE_SPEED)][(int)yPos] == 5) 
				xPos+=xDir*MOVE_SPEED;
			if(map[(int)xPos][(int)(yPos + yDir * MOVE_SPEED)] == 0 || map[(int)xPos][(int)(yPos + yDir * MOVE_SPEED)] == 5)
				yPos+=yDir*MOVE_SPEED;
		}
		if(back) {
			if(map[(int)(xPos - xDir * MOVE_SPEED)][(int)yPos] == 0 || map[(int)(xPos - xDir * MOVE_SPEED)][(int)yPos] == 5)
				xPos-=xDir*MOVE_SPEED;
			if(map[(int)xPos][(int)(yPos - yDir * MOVE_SPEED)] == 0 || map[(int)xPos][(int)(yPos - yDir * MOVE_SPEED)] == 5)
				yPos-=yDir*MOVE_SPEED;
		}
		if(right) {
			double oldxDir=xDir;
			xDir=xDir*Math.cos(-ROTATION_SPEED) - yDir*Math.sin(-ROTATION_SPEED);
			yDir=oldxDir*Math.sin(-ROTATION_SPEED) + yDir*Math.cos(-ROTATION_SPEED);
			double oldxPlane = xPlane;
			xPlane=xPlane*Math.cos(-ROTATION_SPEED) - yPlane*Math.sin(-ROTATION_SPEED);
			yPlane=oldxPlane*Math.sin(-ROTATION_SPEED) + yPlane*Math.cos(-ROTATION_SPEED);
		}
		if(left) {
			double oldxDir=xDir;
			xDir=xDir*Math.cos(ROTATION_SPEED) - yDir*Math.sin(ROTATION_SPEED);
			yDir=oldxDir*Math.sin(ROTATION_SPEED) + yDir*Math.cos(ROTATION_SPEED);
			double oldxPlane = xPlane;
			xPlane=xPlane*Math.cos(ROTATION_SPEED) - yPlane*Math.sin(ROTATION_SPEED);
			yPlane=oldxPlane*Math.sin(ROTATION_SPEED) + yPlane*Math.cos(ROTATION_SPEED);
		}
		if(map[mapX][mapY] == 5) {
			Game.pickUpCoin(mapX, mapY);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)
			left = true;
		if(e.getKeyCode() == KeyEvent.VK_D)
			right = true;
		if(e.getKeyCode() == KeyEvent.VK_W)
			forward = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			back = true;
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Game.swapMap(mapX, mapY, -1);
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A)
			left = false;
		if(e.getKeyCode() == KeyEvent.VK_D)
			right = false;
		if(e.getKeyCode() == KeyEvent.VK_W)
			forward = false;
		if(e.getKeyCode() == KeyEvent.VK_S)
			back = false;
	}
}
