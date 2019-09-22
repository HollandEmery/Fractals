import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public KeyHandler(){
		System.out.println("pls");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char whichKey=e.getKeyChar();
		int s = e.isShiftDown()? -1 : 1;
		System.out.println("hello");
		switch(whichKey){
		
			case 'i'://iterations
				jpanel.iterations += s*20;
				break;
			case 's'://incriment
				jpanel.incriment *= Math.pow(1.1, s); 
				break;
			case 'x'://xShift
				jpanel.xShift += jpanel.incriment*s*5;
				break;
			case 'y'://yShift
				jpanel.yShift += jpanel.incriment*s*5;
				break;
			case 'r'://range
				jpanel.range *= Math.pow(1.1, s);
				jpanel.incriment *= Math.pow(1.1, s);
				break;
			case 'c'://realc
				jpanel.realc += jpanel.incriment*s*5;
				break;
			case 'v'://imc
				jpanel.imc += jpanel.incriment*s*5;
				break;

				
				
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("release");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("type");
	}

}