import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Hasher {

	public static int probes = 0;
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int size = 31511;
		HashTable hashTable = new HashTable(size);

		hashTable = new HashTable(size);

		System.out.println("Enter the input file location: ");

		Scanner sc = new Scanner(System.in);
		String inputFileLocation = sc.nextLine();
		System.out.println("Enter the output file location: ");
		String outputFileLocation = sc.nextLine();
		System.out.println("Enter the dictionary file location: ");
		String dictionaryFileLocation = sc.nextLine();

		File inputFile = new File(inputFileLocation);
		if (!inputFile.exists()) {
			System.out.println("Input file specified does not exist");
			return;
		}

		File dictionaryFile = new File(dictionaryFileLocation);
		if (!inputFile.exists()) {
			System.out.println("Dictionary file specified does not exist");
			return;
		}

		File outputFile = new File(outputFileLocation);

		if (outputFile.exists()) {
			outputFile.delete();
			/*
			 * System.out.println(
			 * "That file already exists, please choose a different location");
			 * return;
			 */
		}

		outputFile.createNewFile();
		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));

		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		BufferedReader dictIn = new BufferedReader(new FileReader(dictionaryFile));

		int dictWords = 0;
		// Populate dictionary hash table
		String line = null;
		while ((line = dictIn.readLine()) != null) {
			//String[] strArray = line.split("\n");
			//for (int i = 0; i < strArray.length; i++) {
				hashTable.insert(line);
				dictWords++;
			//}
		}

		int inputWords = 0;
		int misspelled = 0;
		// spell check input file
		while ((line = in.readLine()) != null) {
			if (line.equals("\n") || line.equals("")) {
				continue;
			}
			String[] strArray = line.split(" ");
			inputWords += strArray.length;
			for (int i = 0; i < strArray.length; i++) {
				StringHandler sh = new StringHandler(strArray[i].trim());
				sh.removePunctuation();
				//System.out.println("word: \"" + sh.word + "\"\n");
				if (hashTable.contains(sh.word)) {
					// do stuff
				} else {
					boolean correct = spellCheck(sh.word, hashTable);
					if (correct) {
						// do some stuff
					} else {
						out.write("Incorrect: " + sh.word + "\n");
						misspelled++;
					}
				}
			}
		}
		
		out.write("num of words in dictionary: " + dictWords + "\n");
		out.write("num of words in input: " + inputWords + "\n");
		out.write("num of words misspelled: " + misspelled + "\n");
		out.write("num of probes: " + Hasher.probes + "\n");
		double avg = (double)Hasher.probes/(double)inputWords;
		out.write("avg probes per word: "+ avg + "\n");

		dictIn.close();
		in.close();
		out.flush();
		sc.close();
	}

	private static boolean spellCheck(String s, HashTable table) {
		StringHandler sh = new StringHandler(s);
		while (true) {
			if (sh.checkStep1()) {
				if (table.contains(sh.step1())) {
					return true;
				}
				break;
			}
			if (sh.checkStep2()) {
				if (table.contains(sh.step2())) {
					return true;
				}
				break;
			}
			if (sh.checkStep3()) {
				if (table.contains(sh.step3())) {
					return true;
				}
				break;
			}
			if (sh.checkStep4()) {
				if (table.contains(sh.step4())) {
					return true;
				}
				break;
			}
			if (sh.checkStep5()) {
				if (table.contains(sh.step5())) {
					return true;
				}
				break;
			}
			if (sh.checkStep6()) {
				if (table.contains(sh.step6())) {
					return true;
				}
				break;
			}
			if (sh.checkStep7()) {
				if (table.contains(sh.step7())) {
					return true;
				}
				break;
			}
			if (sh.checkStep8()) {
				if (table.contains(sh.step8())) {
					return true;
				}
				break;
			}
			if (sh.checkStep910()) {
				if (table.contains(sh.step9())) {
					return true;
				}
				break;
			}
			if (sh.checkStep910()) {
				if (table.contains(sh.step10())) {
					return true;
				}
				break;
			}
			if (sh.checkStep11()) {
				if (table.contains(sh.step11())) {
					return true;
				}
			}
			break;
		}

		if (sh.checkStep1()) {
			String temp = sh.step1();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep2()) {
			String temp = sh.step2();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep3()) {
			String temp = sh.step3();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep4()) {
			String temp = sh.step4();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep5()) {
			String temp = sh.step5();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep6()) {
			String temp = sh.step6();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep7()) {
			String temp = sh.step7();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep8()) {
			String temp = sh.step8();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep910()) {
			String temp = sh.step9();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep910()) {
			String temp = sh.step10();
			if (spellCheck(temp, table)) {
				return true;
			}

		}
		if (sh.checkStep11()) {
			String temp = sh.step11();
			if (spellCheck(temp, table)) {
				return true;
			}

		}

		return false;
	}

}
