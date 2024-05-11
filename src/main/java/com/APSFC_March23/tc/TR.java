package com.APSFC_March23.tc;

public class TR {

	public static void main(String[] args) {

		String s="QI : 20";
		//s = s.replaceAll("[^0-9]", "");
		s = s.replaceAll("[\\s]", "");
		System.out.println(s);

	}

}
