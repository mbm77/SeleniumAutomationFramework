package com.mbm.encodedecode;

import java.util.Base64;

public class EncodeDecodeDemo {

	private EncodeDecodeDemo() {
		
	}
	
	public static void main(String[] args) {
		String encodedString = Base64.getEncoder().encodeToString("testing".getBytes());
		String decodedString = new String(Base64.getDecoder().decode(encodedString.getBytes()));
		System.out.println(encodedString+" "+decodedString);
	}

}
