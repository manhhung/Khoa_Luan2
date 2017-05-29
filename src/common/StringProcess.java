package common;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;


public class StringProcess {

	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * 
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if (s == null)
			return "";
		return s;
	}

	/**
	 * Ham kiem tra xau rong hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	public static boolean notVaildNgay(String ngay) {
		if (ngay == null || ngay.length() == 0)
			return true;

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(false);

		try {

			// if not valid, it will throw ParseException
			Date date = sdf.parse(ngay);
			System.out.println(date);

		} catch (ParseException e) {

			e.printStackTrace();
			return true;
		}
		return false;

	}

	public static boolean stringNotNull(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	public static boolean ValidString(String s) {
		String regex = "[0-9]+";
		if (s.matches(regex))
			return true;
		return false;
	}

	public static boolean notValidNumber(String s) {
		String regex = "[0-9]+";
		if (s.matches(regex))
			return false;
		return true;
	}
	public static boolean hasSpecialCharacters(String s) {
		String regex = ("^[a-zA-Z0-9]*$");
		if (s.matches(regex)) return false;
		return true;
	}
	
	public static boolean notVaildS(String s){
		if(s==null || s.length()==0) return true;
		return false;
	}
	
	public static boolean notVaildN(int s){
		if((Integer.toString(s).length()==0)) return true;
		return false;
	}
	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(int s){
		String regex = "[0-9]+"; 
		if((Integer.toString(s)).matches(regex)) return false;
		return true;
	}
	
	public static boolean notVaildString(String s){
		String regex = "[a-z]+"; 
		if(s.matches(regex)) return false;
		return true;
	}

	public static boolean notVaildS(String[] s) {
		if(s==null || s.length==0) return true;
		return false;
	}
}
