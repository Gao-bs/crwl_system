package com.system.util.bayes;

/*
 *自定义方法
 * */

public class MathM {
	
	public  float sum(float[] R) {
		float sum = 0;
		for (float i : R)
			sum += i;
		return sum;
	}

	public  float[] dot(float A[], float B[]) {
		float C[] = new float[A.length];
		for (int i = 0; i < C.length; i++)
			C[i] = A[i] + B[i];
		return C;
	}

	public  float[] fVect(float[] A, float pDenom) {
		float[] fvect = new float[A.length];
		for (int i = 0; i < A.length; i++) {
			fvect[i] = (float) Math.log(A[i] / pDenom);//A[i] / pDenom;//
		}
		return fvect;
	}
	public  double multiply(float[] A,float[] B){
		double C = 0;
		for(int i=0;i<A.length;i++){
			C+= A[i]*B[i];
		}
		return C;
			
	}
}

