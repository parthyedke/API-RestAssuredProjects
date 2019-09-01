package apiProjects;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomeContents {
	
	public static void main(String[] args) {
		
		String generatedString= RandomStringUtils.randomAlphabetic(12);
		System.out.println(generatedString);
		
		
		String generatedNumeric= RandomStringUtils.randomNumeric(10);
		System.out.println(generatedNumeric);
		
		String generatedAlphaNumaric= RandomStringUtils.randomAlphanumeric(10);
		System.out.println(generatedAlphaNumaric);
		
		
	}

}
