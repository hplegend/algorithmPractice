package com.hplegend.leetcode537;


//
//Given two strings representing two complex numbers.
//
//
//You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
//
//
// Example 1:
//
//Input: "1+1i", "1+1i"
//Output: "0+2i"
//Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
//
//
//
// Example 2:
//
//Input: "1+-1i", "1+-1i"
//Output: "0+-2i"
//Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
//
//
//
// Note:
//
// The input strings will not have extra blank.
// The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
//
// Related Topics Math String


/**
 * @author hp.he
 * @date 2019/11/20 10:04
 */
public class LeetCode537 {

	public String complexNumberMultiply(String a, String b) {
		int []x = getVal(a);
		int []y = getVal(b);

		int xVal = x[0];
		int xCom = x[1];

		int yVal = y[0];
		int yCom = y[1];

		String res = String.valueOf(xVal*yVal - xCom*yCom) + "+" + String.valueOf(xVal*yCom + yVal * xCom) + "i";
		return res;
	}


	public int [] getVal(String str) {
		String [] s = str.split("\\+");
		int [] val = new int [2];
		val[0] = Integer.parseInt(s[0]);
		val[1] = Integer.parseInt(s.replace("i",""));
		return val;
	}





}
