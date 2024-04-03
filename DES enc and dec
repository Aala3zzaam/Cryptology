package Main;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

class DES{

    int[] IP = {58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
    int[] IPinverse = {40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,25};
    int[] E = {32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
    int[] P ={16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
    int[] PC1 = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
    int[] PC2 = {14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
    int[][][] S_BOXES = {
            // S-box 1
            {
                    {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                    {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
            },
            // S-box 2
            {
                    {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                    {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                    {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                    {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
            },
            // S-box 3
            {
                    {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                    {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                    {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                    {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
            },
            // S-box 4
            {
                    {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                    {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                    {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                    {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
            },
            // S-box 5
            {
                    {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                    {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                    {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                    {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
            },
            // S-box 6
            {
                    {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                    {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                    {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                    {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
            },
            // S-box 7
            {
                    {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                    {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                    {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                    {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
            },
            // S-box 8
            {
                    {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                    {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                    {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                    {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
            }
    };



    public String ToBinary(String key){
        int i=0;
        int len = key.length();
        char[] hexDigit = key.toCharArray();
        StringBuilder binaryStringBuilder = new StringBuilder();
        while(i<len)
        {

            switch(hexDigit[i])
            {
                        case '0':
                            binaryStringBuilder.append("0000");
                            break;
                        case '1':
                            binaryStringBuilder.append("0001");
                            break;
                        case '2':
                            binaryStringBuilder.append("0010");
                            break;
                        case '3':
                            binaryStringBuilder.append("0011");
                            break;
                        case '4':
                            binaryStringBuilder.append("0100");
                            break;
                        case '5':
                            binaryStringBuilder.append("0101");
                            break;
                        case '6':
                            binaryStringBuilder.append("0110");
                            break;
                        case '7':
                            binaryStringBuilder.append("0111");
                            break;
                        case '8':
                            binaryStringBuilder.append("1000");
                            break;
                        case '9':
                            binaryStringBuilder.append("1001");
                            break;
                        case 'a':
                        case 'A':
                            binaryStringBuilder.append("1010");
                            break;
                        case 'b':
                        case 'B':
                            binaryStringBuilder.append("1011");
                            break;
                        case 'c':
                        case 'C':
                            binaryStringBuilder.append("1100");
                            break;
                        case 'd':
                        case 'D':
                            binaryStringBuilder.append("1101");
                            break;
                        case 'e':
                        case 'E':
                            binaryStringBuilder.append("1110");
                            break;
                        case 'f':
                        case 'F':
                            binaryStringBuilder.append("1111");
                            break;
                        default:
                            return "Invalid";
            }
            i++;
        }

        return binaryStringBuilder.toString();

    }
        public String binaryToHexadecimal(String binary) {
            StringBuilder hex = new StringBuilder();

            for (int i = 0; i < binary.length(); i += 4) {
                String group = binary.substring(i, i + 4);
                int decimal = Integer.parseInt(group, 2);
                String hexDigit = Integer.toHexString(decimal);
                hex.append(hexDigit.toUpperCase());
            }
            return hex.toString();
        }
//    public String rightshift(String S,int amount){
//        int index = S.length() - amount;
//        String S1 = S.substring(0,index);
//        String S2 = S.substring(index);
//        return S2 + S1;
//    }
    public String leftshift(String S, int amount){
        String S1 = S.substring(amount);
        String S2 = S.substring(0,amount);
        return S1 + S2;
    }

    public String[] KeyGen(String key){

        String binarykey = ToBinary(key);
        StringBuilder pc1result = new StringBuilder();

        //Applying PC1 on the binary

        for(int i=0;i<56;i++){
            pc1result.append(binarykey.charAt(PC1[i]-1));
        }

        //Split the String into 2 strings of 28 char

        String C0 = pc1result.substring(0,28);
        String D0 = pc1result.substring(28);

        String[] C = new String[16];
        String[] D = new String[16];
        C[0] = leftshift(C0,1);
        D[0] = leftshift(D0,1);
        for(int i=1;i<C.length;i++){
            if(i==1 ||i==8||i==15){
                C[i] = leftshift(C[i-1],1);
                D[i] = leftshift(D[i-1],1);
            }
            else{
                C[i] = leftshift(C[i-1],2);
                D[i] = leftshift(D[i-1],2);
            }
        }
        String[] keyinit = new String[16];
        for(int i =0;i<16;i++){
            keyinit[i] = C[i]+D[i];
            //System.out.println(keyinit[i]);
        }
        String[] pc2result = new String[16];
        for(int i=0;i<16;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<48;j++){
                temp.append(keyinit[i].charAt(PC2[j]-1));
            }
            pc2result[i] = temp.toString();
            //System.out.println(pc2result[i]);

        }
        return pc2result;
    }
    public String xor(String str1, String str2) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            result.append(char1 ^ char2);
        }

        return result.toString();
    }
    public String encrypt(String S, String key) {
        S = S.replaceAll("[^A-Za-z0-9]", "");
        String[] Key = KeyGen(key);
        String plain = ToBinary(S);
        StringBuilder IPresult = new StringBuilder();
        for (int i = 0; i < 64; i++) {
            IPresult.append(plain.charAt(IP[i] - 1));
        }
        String[] R = new String[17];
        String[] L = new String[17];
        String[] ExpR = new String[16];
        String[] Xored = new String[16];
        String[] Sboxed = new String[16];
        L[0] = IPresult.substring(0, 32);
        R[0] = IPresult.substring(32);
        for (int i = 0; i < 16; i++) {
            ExpR[i] = expand(R[i]);
//            if(i==5){
//                System.out.println("exp"+ExpR[i]);
//            }
            Xored[i] = xor(ExpR[i], Key[i]);
//            if(i==5){
//                System.out.println("xor"+Xored[i]);
//            }
            StringBuilder substitutedResult = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                String block = Xored[i].substring(j * 6, (j + 1) * 6);
                int row = Integer.parseInt("" + block.charAt(0) + block.charAt(5), 2);
                int col = Integer.parseInt(block.substring(1, 5), 2);
                int substitutedValue = S_BOXES[j][row][col];
                String substitutedBinary = String.format("%4s", Integer.toBinaryString(substitutedValue)).replace(' ', '0');
                substitutedResult.append(substitutedBinary);
            }
//            if(i==5){
//                System.out.println("subs"+substitutedResult);
//            }
            StringBuilder permutedResult = new StringBuilder();
            for (int k = 0; k < P.length; k++) {
                permutedResult.append(substitutedResult.charAt(P[k] - 1));
            }
            String finals = xor(L[i], permutedResult.toString());
            L[i + 1] = R[i];
            R[i + 1] = finals;
//            if(i==5){
//                System.out.println("per"+permutedResult);
//            }
        }

        System.out.println(L[16]);
        System.out.println(R[16]);
        StringBuilder finalresult = new StringBuilder();
        finalresult.append(R[16]);
        finalresult.append(L[16]);
        StringBuilder finalfinal = new StringBuilder();
        for(int i=0;i<64;i++){
            finalfinal.append(finalresult.charAt(IPinverse[i]-1));
        }
        return binaryToHexadecimal(finalfinal.toString());
    }
    public String expand(String R) {
        StringBuilder expandedResult = new StringBuilder();
        for (int i = 0; i < 48; i++) {
            expandedResult.append(R.charAt(E[i] - 1));
        }
        return expandedResult.toString();
    }
    public String Xor(String S, String K){
        StringBuilder xored = new StringBuilder();
        for(int i=0;i<48;i++){
            if(S.charAt(i)==K.charAt(i)){
                xored.append('0');
            }
            else{
                xored.append('1');
            }
        }
        return xored.toString();
    }

    public String decrypt(String text,String key){
        text = text.replaceAll("[^A-Za-z0-9]", "");
        String[] Key = KeyGen(key);
        String cipher = ToBinary(text);
        StringBuilder permutedcipher = new StringBuilder();
        for(int i=0;i<64;i++){
            permutedcipher.append(cipher.charAt(IP[i]-1));
        }
        //System.out.println(permutedcipher.toString());
        String[] R = new String[17];
        String[] L = new String[17];
        String[] ExpR = new String[16];
        String[] Xored = new String[16];
        String[] Sboxed = new String[16];
        L[0] = permutedcipher.substring(0,32);
        R[0] = permutedcipher.substring(32);
        for (int i = 0; i < 16; i++) {
            int keyIndex = 15 - i;
            ExpR[i] = expand(R[i]);
//            if(i==5){
//                System.out.println("exp"+ExpR[i]);
//            }
            Xored[i] = xor(ExpR[i], Key[keyIndex]);
//            if(i==5){
//                System.out.println("xor"+Xored[i]);
//            }
            StringBuilder substitutedResult = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                String block = Xored[i].substring(j * 6, (j + 1) * 6);
                int row = Integer.parseInt("" + block.charAt(0) + block.charAt(5), 2);
                int col = Integer.parseInt(block.substring(1, 5), 2);
                int substitutedValue = S_BOXES[j][row][col];
                String substitutedBinary = String.format("%4s", Integer.toBinaryString(substitutedValue)).replace(' ', '0');
                substitutedResult.append(substitutedBinary);
            }
//            if(i==5){
//                System.out.println("subs"+substitutedResult);
//            }
            StringBuilder permutedResult = new StringBuilder();
            for (int k = 0; k < P.length; k++) {
                permutedResult.append(substitutedResult.charAt(P[k] - 1));
            }
            String finals = xor(L[i], permutedResult.toString());
            L[i + 1] = R[i];
            R[i + 1] = finals;
//            if(i==5){
//                System.out.println("per"+permutedResult);
//            }
        }
        StringBuilder finals = new StringBuilder();
        finals.append(R[16]);
        finals.append(L[16]);
        StringBuilder finalresult = new StringBuilder();
        for(int i=0;i<64;i++){
            finalresult.append(finals.charAt(IPinverse[i]-1));
        }

        return binaryToHexadecimal(finalresult.toString());
    }



    public static void main(String[] args){
        DES x = new DES();
        System.out.println(x.encrypt("02468ACEECA86420","0f1571c947d9e859"));
        System.out.println(x.decrypt("DA02CE3A89ECAC3B","0f1571c947d9e859"));
    }
}
