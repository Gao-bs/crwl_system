package com.system.util.bayes;

/**
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Home
 * 
 */
public class NBMain {

	/**
	 * @param args
	 */

	static List<String[]> dataList = new ArrayList<String[]>(); // 训练集词集合
	static List<float[]> vectorList = new ArrayList<float[]>(); // 训练集词向量
	static List<String> vocabList = new ArrayList<String>(); // 词典
	static float[] trainCategory; // 训练集类别trainCategory=[0,1,0,1,0,1]
	static int numTrainDocs = 0; // 训练集文本数量
	static int numwords = 0; // 词典size

	static String xiaojiFile = "/Users/mac/Desktop/crwldemo/crwl_system/负面情绪词.txt";
	static String jijiFile = "/Users/mac/Desktop/crwldemo/crwl_system/正面情绪词.txt";
	static MathM mm = new MathM();
	
	static {
		List<String> list = new ArrayList<String>();
		String txt1 = getTxt(xiaojiFile);
		String txt2 = getTxt(jijiFile);
		list.add(txt1 + "0");
		list.add(txt2 + "1");
		vocabList = loadDataSet(list);
	}

	public static void main(String[] args) throws IOException {
		List<String> words = new ArrayList<String>();
		words.add("干劲");
		words.add("坚定不移12");
		words.add("世故");
		int tenology = tenology(words);
		System.err.println(tenology);

	}
	public static int tenology(List<String> words) throws IOException {

		// 加载数据集
		Model model = trainBayes();
		/*
		 * System.out.println(Arrays.toString(model.p0Vect));
		 * System.out.println(Arrays.toString(model.p1Vect));
		 */
		Object[] test1 = words.toArray();
		int classifyNB = classifyNB(setofWords2Vec(vocabList, test1, test1.length), model);
		return classifyNB;
	}

	public static String getTxt(String path) {
		StringBuffer content = new StringBuffer();
		FileInputStream fin;
		try {
			fin = new FileInputStream(path);
			InputStreamReader reader = new InputStreamReader(fin);
			BufferedReader buffReader = new BufferedReader(reader);
			String strTmp = "";
			while ((strTmp = buffReader.readLine()) != null) {
				content.append(strTmp);
				content.append(",");
			}
			buffReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public static int classifyNB(float[] vec2Classify, Model model) {
		double p1 = mm.multiply(vec2Classify, model.p1Vect) + Math.log(model.pAbusive);
		double p0 = mm.multiply(vec2Classify, model.p0Vect) + Math.log(1 - model.pAbusive);
		if (p1 > p0)
			return 1;
		else
			return 0;
	}

	public static List<String> loadDataSet(List<String> txt)  {
		for (String line : txt) {

			String[] info = line.split(",");
			dataList.add(info);
		}
		numTrainDocs = dataList.size();
		List<String> vocabList = new ArrayList<String>();
		trainCategory = new float[dataList.size()];
		int j = 0;
		for (String[] str : dataList) {
			for (int i = 0; i < str.length - 1; i++)
				if (!vocabList.contains(str[i]))
					vocabList.add(str[i]);
			trainCategory[j] = Integer.parseInt(str[str.length - 1]);
			j++;
		}
		Collections.sort(vocabList);

		for (String[] str : dataList) {
			float[] temp = setofWords2Vec(vocabList, str, str.length - 1);
			vectorList.add(temp);
		}
		numwords = vocabList.size();
		return vocabList;
	}

	public static float[] setofWords2Vec(List<String> vocabList, Object[] postingDoc, int n) {
		// 根据词典和词转化为词向量（onehot编码）
		float[] temp = new float[vocabList.size()];
		int index = -1;
		for (int i = 0; i < n; i++) {
			index = vocabList.indexOf(postingDoc[i]);
			if(index!=-1) {
				try {
					temp[index] = 1.0f;
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		}

		return temp;
	}

	/*
	 * 1.首先计算属于侮辱性文档（class=1）的概率，即p(c1);p(c0) = 1-p(c1); 2.计算p(wi|c1)以及p(wi|c0)
	 * 
	 * List<String[]> dataList,List<Integer[]> vectorList
	 */

	public static Model trainBayes() {

		float pAbusive = (float) (mm.sum(trainCategory) / numTrainDocs);
		float[] p0Num = new float[numwords];
		float[] p1Num = new float[numwords];
		Arrays.fill(p0Num, 1);
		Arrays.fill(p1Num, 1);
		// 因为很多词出现次数为0，为使概率不为0.将所有词初始化为1，分母初始化为2
		float p0Denom = 2.0f;
		float p1Denom = 2.0f;
		for (int i = 0; i < numTrainDocs; i++) {
			float[] temp = vectorList.get(i);
			if (trainCategory[i] == 1) {
				p1Num = mm.dot(p1Num, temp);
				p1Denom += mm.sum(temp);

			} else {
				p0Num = mm.dot(p0Num, temp);
				p0Denom += mm.sum(temp);
			}
		}
		// 下溢出：由于p(w|c)很小，相乘为下溢出或得不到正确答案。方法对乘积取自然对数（ln(a*b) = ln(a)+ln(b)）
		float[] p1Vect = mm.fVect(p1Num, p1Denom);
		float[] p0Vect = mm.fVect(p0Num, p0Denom);
		Model m = new Model(p0Vect, p1Vect, pAbusive);
		return m;
	}
}
