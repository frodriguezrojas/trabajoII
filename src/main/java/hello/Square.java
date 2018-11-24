package hello;

public class Square {
    private final long id;
    private int base;
    private int area;
    
    public Square(long id, int base) {
        this.id = id;
        this.base = base;
        this.area = base*base;
    }

    public long getId() {
        return id;
    }

    public int getBase() {
        return base;
    }
    
    public double getArea() {
    	return area;
    }

	public void changeBase(int base2) {
		base = base2;
		area = base*base;
	}
}
