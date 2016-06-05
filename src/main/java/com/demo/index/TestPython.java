package com.demo.index;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class TestPython {
	public static String execPython(String filName, String args[]) {
		try {
			System.out.println("start");
			Process pr = Runtime.getRuntime().exec("python "+filName);
			BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static void main(String[] args) {
		String [] arg = {"3","6"}; 
		TestPython.execPython("E:\\project\\JavaExePython\test.py", arg);
	}
}
