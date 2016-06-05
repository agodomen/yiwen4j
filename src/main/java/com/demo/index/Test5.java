package com.demo.index;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test5 {
	public static void main(String[] args) {
		try {
			System.out.println("start");
			Process pr = Runtime.getRuntime().exec("python E:\\project\\JavaExePython\test.py");

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
	}
}