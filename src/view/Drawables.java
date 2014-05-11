package view;

import java.awt.Graphics;
import java.util.ArrayList;

public class Drawables {

	ArrayList<BaseView> drawableArray;
	static Drawables drawables;
	Graphics g;
	private int mapSize;

	private Drawables() {
		drawableArray = new ArrayList<BaseView>();
	}

	public static Drawables getInstance() {
		if (drawables == null)
			drawables = new Drawables();
		return drawables;
	}

	public synchronized void add(BaseView v) {
		drawableArray.add(v);
		Window.getPanel().repaint();

	}
	
	public void remove(BaseView v) {
		drawableArray.remove(v);
		Window.getPanel().repaint();

	}

	public void remove(int i) {
		drawableArray.remove(i);
		Window.getPanel().repaint();

	}

	public BaseView get(int i) {
		return drawableArray.get(i);
	}

	public void setGraphics(Graphics graphics) {
		g = graphics;

	}

	public Graphics getGraphics() {
		return g;
	}

	public int getSize() {
		return (drawableArray.size());
	}

	public void setMapSize(int size) {
		mapSize = size;
		
	}
	
	public int getMapSize(){
		return mapSize;
	}

	public void add(int i, BaseView v) {
		drawableArray.add(i, v);
		Window.getPanel().repaint();
		
	}
}
