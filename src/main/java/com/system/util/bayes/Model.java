package com.system.util.bayes;

/**
 *模型构造方法 
 */

/**
 * @author Home
 *
 */
public class Model {
	float[] p0Vect;
	float[] p1Vect;
	float pAbusive;
	public float[] getP0Vect() {
		return p0Vect;
	}
	public float[] getP1Vect() {
		return p1Vect;
	}
	public void setP1Vect(float[] p1Vect) {
		this.p1Vect = p1Vect;
	}
	public float getmodel() {
		return pAbusive;
	}
	public void setpAbusive(float pAbusive) {
		this.pAbusive = pAbusive;
	}
	public void setP0Vect(float[] p0Vect) {
		this.p0Vect = p0Vect;
	}
	public Model(float[] p0Vect,float[] p1Vect,float pAbusive) {
		this.p0Vect = p0Vect;
		this.p1Vect = p1Vect;
		this.pAbusive = pAbusive;
	}
	
}

