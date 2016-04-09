
public class StringHandler {

	public String word;
	private char[] chars;


	public StringHandler(String word){
		this.word = word;
		this.chars = word.toCharArray();
	}

	public void changeWord(String s){
		this.word = s;
		this.chars = s.toCharArray();
	}

	public void removePunctuation(){
		boolean hadPunct = true;
		int count = 0;
		while(hadPunct == true && count < 6){
			hadPunct = false;
			count++;
			if(word.contains(",")){
				word.replaceAll(",", " ");
				this.word = word.trim();
				this.chars = word.toCharArray();
				hadPunct = true;
			}
			if(word.endsWith(".")){
				chars[word.length()-1] = ' ';
				this.word = new String(chars);
				this.word = word.trim();
				this.chars = word.toCharArray();
				hadPunct = true;
			}
			if(word.endsWith(",")){
				chars[word.length()-1] = ' ';
				this.word = new String(chars);
				this.word = word.trim();
				this.chars = word.toCharArray();
				hadPunct = true;
			}
			if(word.contains("\"")){
				word.replaceAll("\"", " ");
				this.word = word.trim();
				this.chars = word.toCharArray();
				hadPunct = true;
			}
		}

	}

	public boolean checkStep1(){
		if(Character.isLetter(chars[0]) && Character.isUpperCase(chars[0])){
			return true;
		}
		return false;
	}

	/**
	 * Uncapatalize first letter.
	 * @return
	 */
	public String step1(){
		return(word.replaceFirst(Character.toString(chars[0]), Character.toString((char)(chars[0]+32))));
	}

	public boolean checkStep2(){
		return word.endsWith("'s");
	}

	/**
	 * remove 's
	 */
	public String step2(){
		return word.substring(0, word.length()-2);
	}

	public boolean checkStep3(){
		return word.endsWith("s");
	}

	/**
	 * remove 's'
	 * @return
	 */
	public String step3(){
		return word.substring(0, word.length()-1);
	}

	public boolean checkStep4(){
		return word.endsWith("es");
	}

	/**
	 * remove 'es'
	 * @return
	 */
	public String step4(){
		return word.substring(0, word.length()-2);
	}

	public boolean checkStep5(){
		return word.endsWith("ed");
	}

	/**
	 * remove 'ed'
	 * @return
	 */
	public String step5(){
		return word.substring(0, word.length()-2);
	}

	public boolean checkStep6(){
		return word.endsWith("d");
	}

	/**
	 * remove 'd'
	 * @return
	 */
	public String step6(){
		return word.substring(0, word.length()-1);
	}


	public boolean checkStep7(){
		return word.endsWith("er");
	}

	/**
	 * removes 'er'
	 */
	public String step7(){
		return word.substring(0, word.length()-2);
	}

	public boolean checkStep8(){
		return word.endsWith("r");
	}

	/**
	 * removes 'r'
	 */
	public String step8(){
		return word.substring(0, word.length()-1);
	}

	public boolean checkStep910(){
		return word.endsWith("ing");
	}

	/**
	 * removes 'ing'
	 */
	public String step9(){
		return word.substring(0, word.length()-3);
	}

	/**
	 * replaces 'ing' with 'e'
	 */
	public String step10(){
		return step9()+"e";
	}

	public boolean checkStep11(){
		return word.endsWith("ly");
	}

	/**
	 * removes 'ly'
	 */
	public String step11(){
		return word.substring(0, word.length()-2);
	}
}
