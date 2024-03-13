// LAUREL RAEANNE TAY
// CSC 172 PROJECT 2
// LTAY3@U.ROCHESTED.EDU
// 19 NOVEMBER 2023

import java.util.HashMap;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HuffmanSubmit implements Huffman{

    int count;                                  
    char ch;                                   
    HashMap<Character, Integer> charFrequency;  
    HashMap <Character, String> map;           
    HashMap<String,Character> mapswap;         

    public HuffmanSubmit(){     
	// Initialize variables and data structures               
        count = 0;
        ch = 'a';
        charFrequency = new HashMap<>();
        map = new HashMap<>();
        mapswap = new HashMap<>();
    }

    public void encode(String inputFile, String outputFile, String freqFile){   

		// BinaryIn to read from inputFile
        BinaryIn in = new BinaryIn(inputFile);  
		// BinaryOut to read from inputFile   
		BinaryOut out = new BinaryOut(outputFile); 

        // Count the frequency of each character in the inputFile
        while (!in.isEmpty()) {
			char c = in.readChar();
			charFrequency.put(c, 0);
		}

		// Count the actual frequency of each character in the inputFile
		in = new BinaryIn(inputFile);                 

        while (!in.isEmpty()) {
			char c = in.readChar();
			count += 1;
            charFrequency.put(c, charFrequency.get(c)+1);
		}

		// Write the frequency of each character to freqFile
        try {
			PrintWriter printWriter = new PrintWriter(freqFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        BufferedWriter outWriter = null;

        try {
            outWriter = new BufferedWriter (new FileWriter(freqFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

        for (char c:charFrequency.keySet()) {
			try {
				String temp = Integer.toBinaryString(c);
				while (temp.length() < 8) {     
					temp = "0" + temp;
				}
				outWriter.write(temp + ":" + charFrequency.get(c));
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				outWriter.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        try {
			outWriter.flush();  
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			outWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Node root = makeQueue();
		codeTree(root,"");

		in=new BinaryIn(inputFile);
		out.write(count);

		while (!in.isEmpty()) {
			char c = in.readChar();
			String binary = map.get(c);
			char[] bin = binary.toCharArray();
			for (char temp:bin) {
				if (temp == '0') {
					out.write(false);
				}else if (temp == '1') {
					out.write(true);
				}
			}

		}

		out.flush();
		// from BinaryOut.java
    }

   public void decode(String inputFile, String outputFile, String freqFile){

       BinaryIn in = new BinaryIn(inputFile);
       BinaryOut out=new BinaryOut(outputFile);
       HashMap<Character,Integer> map = new HashMap<>();
       BufferedReader buffRead = null;
       FileReader fileRead = null;

       try {
           fileRead = new FileReader(freqFile);
           buffRead = new BufferedReader(fileRead);
           String temp; 

			// Read frequency file and populate the map
           while ((temp = buffRead.readLine()) != null){
				String[] array = temp.split(":");
				map.put((char)Integer.parseInt(array[0],2), Integer.parseInt(array[1]));
			}
            charFrequency = map;
			map = new HashMap<>();
			codeTree(makeQueue(),"");

            in = new BinaryIn(inputFile);
			String st = "";
			boolean a = true;
			int count = 0;
			int size = in.readInt();

			// Decode and write to output file
            while(count<size){
				while (!this.mapswap.containsKey(st)){
					a = in.readBoolean();
					if(a == true) {
						st = st + "1";
					}
                    else if(a == false){
                        st = st + "0";
					}
				}
				out.write(mapswap.get(st));
				st = "";
				count += 1;
			}
            out.flush(); 


       } catch(IOException e){
           e.printStackTrace();
       }

   }

   public void codeTree(Node n, String str) {
		if (n.left==null && n.right==null) {
			// Leaf node, map the character to its Huffman code and vice versa
			map.put(n.getChar(), str);
			mapswap.put(str, n.getChar());
			return;
		}
		codeTree(n.left, str + "0");
		codeTree(n.right, str + "1");
	}

    public Node makeQueue() {
        // Create a priority queue of nodes based on character frequency
		PriorityQueue<Node> o = new PriorityQueue<>();

		for (char key: this.charFrequency.keySet()){
			Node node = new Node(charFrequency.get(key),key);
			o.offer(node);
		}

		while (o.size()>1){
			// Build the Huffman tree by merging nodes with the lowest frequency
			Node node1 = o.poll();
			Node node2 = o.poll();
			Node temp = new Node(node1.getFreq() + node2.getFreq());
			temp.left = node1;
			temp.right = node2;
			o.offer(temp);
		}

		return o.poll(); // The root of the Huffman tree
	}

   public static void main(String[] args){
       Huffman huffman = new HuffmanSubmit();
       huffman.encode("alice30.txt", "ur.enc", "freq.txt");
       huffman.decode("ur.enc", "alice_dec.txt", "freq.txt");

	   Huffman huffman2 = new HuffmanSubmit();
	   huffman2.encode("ur.jpg", "ur.enc2", "freq1.txt");
       huffman2.decode("ur.enc2", "ur_dec.jpg", "freq1.txt");
   }

}


class Node implements Comparable<Node>{
    Node left;
    Node right;
    int freq;
    char ch;

    public Node(){
        this.freq = 0;
        this.left = null;
        this.right = null;
    }

    public Node(int freq){
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    public Node(int freq, char ch){
        this.freq = freq;
        this.ch = ch;
        this.left = null;
        this.right = null;
    }

    public char getChar(){
        return this.ch;
    }

    public int getFreq(){
        return this.freq;
    }

    @Override
	public int compareTo(Node o) {
		return this.freq - o.freq;
	}

}