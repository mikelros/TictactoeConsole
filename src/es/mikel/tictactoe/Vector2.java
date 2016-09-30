package es.mikel.tictactoe;

/**
 * @author Mikel
 *
 */
public class Vector2 	{
	private int x;
	private int y;
	private String value;
	
	public Vector2() {
		
	}
	
	public Vector2(int x, int y, String value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2){
            Vector2 vector = (Vector2) obj;
            return vector.getX() == getX() && vector.getY() == getY();
        }
        return (this == obj);
    }
}
