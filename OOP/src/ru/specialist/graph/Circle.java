package ru.specialist.graph;

import java.io.Serializable;

public class Circle extends Shape 
	implements Scaleable, Serializable {
	private int x;
	private int y;
	private int r;

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
	
	public int getR() {
		return r;
	}
	
	public void setR(int r) {
		if(r>0)
			this.r = r;
		else
			throw new RuntimeException("radius < 0");
	}
	
	public Circle(int x, int y, int r, String color) {
		super(color);
		this.x = x;
		this.y = y;
		setR(r);
	}

	public void scale(double factor) {
		//r = (int) (factor * r);
		setR((int) (factor * getR()));
	}
	
	@Override
	public String toString() {
		return String.format("Circle (%d, %d) R: %d Color: %s\n", x, y, getR(), color);
	} 
	@Override
	public void draw() {
		System.out.println(this);
	}
}
