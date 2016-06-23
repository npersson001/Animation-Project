package grail;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import main.CommandInterpreter;
import mp.ImageShape;
import mp.Line;
import mp.Rectangle;
import mp.StringShape;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags("InheritingBridgeScenePainter")
public class ABridgeSceneView extends Component implements PropertyChangeListener, BridgeSceneView{
	BridgeScene model;
	CommandInterpreter command;
	public static final int FIVE = 5;
	BasicStroke stroke = new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 
            5f);
	Graphics g;
	
	public ABridgeSceneView(BridgeScene aBridgeScene){
		model = aBridgeScene;
		registerWithModel();
	}
	
	public ABridgeSceneView(BridgeScene aBridgeScene, CommandInterpreter aCommand){
		model = aBridgeScene;
		command = aCommand;
		registerWithModel();
	}
	
	void registerWithModel() {
		
		command.addPropertyChangeListener(this);
		
		model.addPropertyChangeListener(this);
		
		model.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		model.getArthur().getHead().addPropertyChangeListener(this);
		model.getArthur().getTorso().addPropertyChangeListener(this);
		model.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getArthur().getText().addPropertyChangeListener(this);
		
		model.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		model.getLancelot().getHead().addPropertyChangeListener(this);
		model.getLancelot().getTorso().addPropertyChangeListener(this);
		model.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getLancelot().getText().addPropertyChangeListener(this);
		
		model.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		model.getRobin().getHead().addPropertyChangeListener(this);
		model.getRobin().getTorso().addPropertyChangeListener(this);
		model.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getRobin().getText().addPropertyChangeListener(this);
		
		model.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		model.getGalahad().getHead().addPropertyChangeListener(this);
		model.getGalahad().getTorso().addPropertyChangeListener(this);
		model.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getGalahad().getText().addPropertyChangeListener(this);
		
		model.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		model.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		model.getGuard().getHead().addPropertyChangeListener(this);
		model.getGuard().getTorso().addPropertyChangeListener(this);
		model.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		model.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
		model.getGuard().getText().addPropertyChangeListener(this);
		
		model.getGorge().getLeftLine().addPropertyChangeListener(this);
		model.getGorge().getRightLine().addPropertyChangeListener(this);
		model.getGorge().getBridge().addPropertyChangeListener(this);
		
		model.getGuardArea().addPropertyChangeListener(this);
		model.getKnightArea().addPropertyChangeListener(this);
	}
	
	 public void paint(Graphics g) {
	    super.paint(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(stroke);
	    g.setColor(Color.BLACK);
	    draw(g2, model);
	    }
	 
	 public void draw(Graphics2D g, BridgeScene model) {
	        draw(g, model.getArthur().getArms().getLeftLine());
        	draw(g, model.getArthur().getArms().getRightLine());
	    	draw(g, model.getArthur().getHead());
	    	draw(g, model.getArthur().getTorso());
	    	draw(g, model.getArthur().getLegs().getLeftLine());
	    	draw(g, model.getArthur().getLegs().getRightLine());
	    	draw(g, model.getArthur().getText());
	    	
	    	draw(g, model.getGalahad().getArms().getLeftLine());
	    	draw(g, model.getGalahad().getArms().getRightLine());
	    	draw(g, model.getGalahad().getHead());
	    	draw(g, model.getGalahad().getTorso());
	    	draw(g, model.getGalahad().getLegs().getLeftLine());
	    	draw(g, model.getGalahad().getLegs().getRightLine());
	    	draw(g, model.getGalahad().getText());
	    	
	    	draw(g, model.getRobin().getArms().getLeftLine());
	    	draw(g, model.getRobin().getArms().getRightLine());
	    	draw(g, model.getRobin().getHead());
	    	draw(g, model.getRobin().getTorso());
	    	draw(g, model.getRobin().getLegs().getLeftLine());
	    	draw(g, model.getRobin().getLegs().getRightLine());
	    	draw(g, model.getRobin().getText());
	    	
	    	draw(g, model.getLancelot().getArms().getLeftLine());
	    	draw(g, model.getLancelot().getArms().getRightLine());
	    	draw(g, model.getLancelot().getHead());
	    	draw(g, model.getLancelot().getTorso());
	    	draw(g, model.getLancelot().getLegs().getLeftLine());
	    	draw(g, model.getLancelot().getLegs().getRightLine());
	    	draw(g, model.getLancelot().getText());
	    	
	    	draw(g, model.getGuard().getArms().getLeftLine());
	    	draw(g, model.getGuard().getArms().getRightLine());
	    	draw(g, model.getGuard().getHead());
	    	draw(g, model.getGuard().getTorso());
	    	draw(g, model.getGuard().getLegs().getLeftLine());
	    	draw(g, model.getGuard().getLegs().getRightLine());
	    	draw(g, model.getGuard().getText());
	    	
	    	draw(g, model.getGorge().getBridge());
	    	draw(g, model.getGorge().getLeftLine());
	    	draw(g, model.getGorge().getRightLine());
	    	
	    	draw(g, model.getGuardArea());
	    	draw(g, model.getKnightArea());
	 }
	 
	 public void draw(Graphics2D g, StringShape aLabel) {
	     String s = aLabel.getText();
	     g.drawString(s, aLabel.getX(), aLabel.getY());      
	 }
	    
	 public  void draw(Graphics2D g, ImageShape anImage) {
	     Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
	     g.drawImage(img, anImage.getX(), anImage.getY(), this);     
	 }
	    
	 public void draw(Graphics2D g, Line aLine){
		 g.drawLine(aLine.getX(),aLine.getY(),aLine.getX()+aLine.getWidth(),aLine.getY()+aLine.getHeight());
	 }
	 
	 public void draw(Graphics2D g, Rectangle aRectangle){
		 g.drawRect(aRectangle.getX(), aRectangle.getY(), aRectangle.getWidth(), aRectangle.getHeight());
	 }
	
	 public void propertyChange(PropertyChangeEvent arg0) {
		repaint();
	 }

}
