LAUREL RAEANNE TAY
CSC 172 PROJECT 2
LTAY3@U.ROCHESTED.EDU
19 NOVEMBER 2023

LAB SYNOPSIS:
This project implements Huffman coding, a lossless compression algorithm, in Java. The primary focus is on the implementation of encoding and decoding methods using Huffman trees. The program aims to efficiently compress and decompress files using a frequency-based encoding approach.

CONTENTS:
1. `HuffmanSubmit.java` - The main Java class implementing the Huffman coding algorithm.

USAGE:
in my current code, i test encoding and decoding both the image and text files into these specific files:

encode: (input file (decoded), output file (encoded), frequency information)
decode: (input file (encoded), output file (decoded), frequency information)

huffman.encode("alice30.txt", "ur.enc", "freq.txt");
huffman.decode("ur.enc", "alice_dec.txt", "freq.txt");

huffman2.encode("ur.jpg", "ur.enc2", "freq1.txt");
huffman2.decode("ur.enc2", "ur_dec.jpg", "freq1.txt");

ERROR HANDLING:
encode() and decode() Method:
File Not Found Exception:
If the specified freqFile does not exist, a FileNotFoundException is caught.

