import processing.core.PApplet;


public class Target extends Block {
	
    public Target(int inrow, int incol) {
    	row = inrow;  	col = incol; w=50; h=20;
    	x = (col-1)*(50+5); y = (row-1)*(20+3);
    	dx = 5; dy=0;
    }
	@Override
	public void update() {
		x = x+dx; 	
	}
	@Override
	public void draw(PApplet p) {
		p.fill(255,0,0);
		p.rect(x, y, w, h);
	}
	@Override
	public boolean collide(Missle m) {
	if (m.x- m.w/2 > this.x + this.w) {return false;}  //left
	if (m.x+ m.w/2 < this.x  ) {return false;}  //right
	if (m.y- m.h/2 > this.y + this.h) {return false;}  //bottom
	if (m.y+ m.w/2 < this.y  ) {return false;}  //top
	return true;
	}
}
