package grail;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;

import mp.ImageShape;
import mp.Line;
import mp.StringShape;
import util.models.PropertyListenerRegisterer;

public interface BridgeSceneView {
	 public void propertyChange(PropertyChangeEvent arg0);
	 public void paint(Graphics g);
	 public void draw(Graphics2D g, BridgeScene model);
	 public void draw(Graphics2D g, StringShape aLabel);
	 public  void draw(Graphics2D g, ImageShape anImage);
	 public void draw(Graphics2D g, Line aLine);
}
