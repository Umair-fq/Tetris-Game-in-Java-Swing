package ShapesPackage;

import GamePackage.Shapes;

public class I extends Shapes{

	public I() {
		super(new int[][] {{1,1,1,1}});
		// TODO Auto-generated constructor stub
	}

	@Override
	public void rotate() {
		
		super.rotate();
		
		if(this.getWidth() == 1) {
			this.setAxisX(this.getAxisX() + 1);
			this.setAxisY(this.getAxisY() - 1);
		}
		
		else {
			this.setAxisX(this.getAxisX() - 1);
			this.setAxisY(this.getAxisY() + 1);
		}
	}
}
