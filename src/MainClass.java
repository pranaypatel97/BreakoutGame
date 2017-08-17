import java.util.ArrayList;

import processing.core.PApplet;

public class MainClass extends PApplet {
	public int nCols = 1200, nRows = 600;
	ArrayList<Entity> entities = new ArrayList<Entity>();
	Block b; Target t; Missle m; Barrier barr; Base base;
	public void setup(){
	size(nCols,nRows);
	for (int row  =1; row<=5; row++ ) {
		for (int col  =1; col<=10; col++ ) {
	         t= new Target(row,col);
	         entities.add(t);
	    }
	}
	for (int row  =1; row<=6; row++ ) {
	    barr= new Barrier(row);  
	    entities.add(barr);
	}
	base = new Base();
	m = new Missle(base,nCols,nRows);
	entities.add(base);
	entities.add(m);
	}// end setup
	public void draw(){ 
		   System.out.println("jo");
		EdgeCheck();  // blocks change direction when hitting edge
		for (Entity myentity: entities) {// for an arraylist returns items in index order
		     {myentity.update() ;}
		}
		for (Entity myentity: entities) {
			if (myentity instanceof  Block  )  {
		    	b = (Block) myentity;
		        if (b.collide(m)) {
		        	if (b instanceof Target) {entities.remove(myentity);
		        	if (m.dy <0) {m.setOnBase();
		        	} else {m.dy=-m.dy; }
		        	break; 
		        	}
		        	if (b instanceof Barrier) {m.dx = -m.dx; m.dy=-m.dy;}
		        }
		    }
		}
		background(200);
		for (Entity myentity: entities) {
		    myentity.draw(this) ;
		}
	}
	public void mouseClicked(){
         
		}
		public void keyPressed(){ 
		if (keyCode == UP) {
			m.fired = true;}			 
		if (keyCode == RIGHT) {
			base.x+= 5;
			if (!m.fired) {m.x+=5;}}
		if (keyCode == LEFT) {
			base.x-= 5;
			if (!m.fired) {m.x-=5;}}
			}
					 
				
	public void EdgeCheck() {
		boolean edgeflag = false;
		for (Entity myentity: entities) {
		    if (myentity instanceof  Block  )  {
		    	b = (Block) myentity;
		        if ( b.x + b.w > nCols) {edgeflag = true;break;}
		        if ( b.x <0) {edgeflag = true;break;}
		    }	
	    }
		if (edgeflag) {
			for (Entity myentity: entities) {
			    if (myentity instanceof  Target )  {
			    	b = (Block) myentity;
			    	b.dx = -b.dx;  b.y +=5;
			    }	
		    }
		}
	}
}
