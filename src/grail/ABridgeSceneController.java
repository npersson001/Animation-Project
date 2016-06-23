package grail;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import mp.Avatar;
import util.annotations.Tags;

@Tags("BridgeSceneController")
public class ABridgeSceneController implements BridgeSceneController {
	ABridgeSceneView view;
	BridgeScene model;
	Avatar selectedAvatar;
	private final static int RIGHT_X = 250, LEFT_X = 100, UPPER_Y = 100, LOWER_Y = 300;
	
	public ABridgeSceneController(BridgeScene aScene, ABridgeSceneView aView){
		model = aScene;
		view = aView;
		view.addMouseListener(this);
		view.addKeyListener(this);
		view.setFocusable(true);
	}
	
	public void keyTyped(KeyEvent e){
		char keyPressed = e.getKeyChar();
		switch(keyPressed){
		case 'a':
			selectedAvatar = model.getArthur();
			break;
		case 'g':
			selectedAvatar = model.getGalahad();
			break;
		case 'l':
			selectedAvatar = model.getLancelot();
			break;
		case 'r':
			selectedAvatar = model.getRobin();
			break;
		case 'o':
			model.getArthur().moveAvatar(RIGHT_X - model.getArthur().getHead().getX(), LOWER_Y - model.getArthur().getHead().getY());
			model.getLancelot().moveAvatar(RIGHT_X - model.getLancelot().getHead().getX(), UPPER_Y - model.getLancelot().getHead().getY());
			model.getGalahad().moveAvatar(LEFT_X - model.getGalahad().getHead().getX(), LOWER_Y - model.getGalahad().getHead().getY());
			model.getRobin().moveAvatar(LEFT_X - model.getRobin().getHead().getX(), UPPER_Y - model.getRobin().getHead().getY());
			break;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		selectedAvatar.moveAvatar(e.getX() - selectedAvatar.getHead().getX(), e.getY() - selectedAvatar.getHead().getY());	
    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}   
	
}
