import processing.core.PApplet;


public class Base extends Block {
    public Base() {
    	x = 600; y=500; w=50;h=10;
    }
	@Override
	public void draw(PApplet p) {
		p.fill(0,255,0);
		p.rect(x, y, w, h);		
	}

	@Override
	public boolean collide(Missle m) {
		 return true;
	}

	@Override
	public void update() {
		
	}

}
