/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


class HillCipher {


    public String KeyWord        = new String();

    //public int   matrix_arr[][] ;
    public int mdim =3;

    private static void isValidMatrix(int[][] keyMatrix) {
        int det = keyMatrix[0][0] * keyMatrix[1][1] - keyMatrix[0][1] * keyMatrix[1][0];
        // If det=0, throw exception and terminate
        if(det == 0) {
            throw new java.lang.Error("Det equals to zero, invalid key matrix!");
        }
    }


    public int[][] KeyGen(String key) {

        String[] tokens = key.split(" ");
        if (tokens.length != 9) {
            throw new IllegalArgumentException("Key length must match matrix dimension squared!");
        }
        int[][] Keymatrix = new int[3][3];
        int index =0;

        for (int i = 0; i < 3; i++) {
            for(int j=0;j<3;j++){
            Keymatrix[i][j] = Integer.parseInt(tokens[index]);
            index++;
        }}

        //for (int i = 0; i < 3; i++) {
        //    System.out.println(Arrays.toString(Keymatrix[i]));
       // }
        return Keymatrix;
    }

        public String padding(String plaintext){
        int size = plaintext.length();
        for(int i=0;i<3;i++){
        if(size%3!=0){
            plaintext += 'x';
            size++;
        }}

        return plaintext;
        }

        public String[] Dividpairs(String text){
        int size = text.length();

            String[] x = new String[size / mdim];

            for (int i = 0; i < size / mdim; i++)
            {
                x[i] = text.substring(i * mdim, (i+1)* mdim);

            }
            return x;
        }

    public String encrypt(String key, String text) {
        text =text.toUpperCase().replaceAll("[^A-Z]","");
        String plaintext = padding(text);
        int[][] keyword = KeyGen(key);
        StringBuilder ciphertext = new StringBuilder();

        for (String block : Dividpairs(plaintext)) {
            int[] plain = new int[mdim];
            for (int i = 0; i < mdim; i++) {
                char ch = block.charAt(i);
                if (Character.isUpperCase(ch)) {
                    plain[i] = ch - 'A'; // Uppercase letters mapped to 0 to 25
                } else if (Character.isLowerCase(ch)) {
                    plain[i] = ch - 'a'; // Lowercase letters mapped to 0 to 25
                } else {
                    throw new IllegalArgumentException("Input contains non-alphabetic characters!");
                }
            }
            int[] result = new int[mdim];
            for (int i = 0; i < mdim; i++) {
                for (int j = 0; j < mdim; j++) {
                    result[i] += plain[j] * keyword[j][i];
                }
                result[i] %= 26;
            }
            for (int j : result) {
                ciphertext.append((char) (j + 'a'));
            }
        }
        //System.out.println(ciphertext);
        //String ciphertext2 = ciphertext.toString().toUpperCase().replaceAll("[^A-Z]","");
        return ciphertext.toString();
    }

    //Decryption code
    public int InverseDet(int a[][]){
        int det=0;
        det = (a[0][0]*(a[1][1]*a[2][2] - a[1][2]*a[2][1]) - a[0][1]*(a[1][0]*a[2][2]-a[1][2]*a[2][0]) + a[0][2]*(a[1][0]*a[2][1]-a[1][1]*a[2][0]) ) %26;
        if(det<0){
            det+=26;
        }
        int newDet=0;
        for(int i=0;i<26;i++){
            if((  (det)  *i  )%26==1){
                newDet =i;
            }
        }
        //System.out.println(newDet);
        return newDet;
    }

    public int[][] InverseMatrix(int matrix[][]){
        int Det = InverseDet(matrix);
        if(Det == 0) {
            throw new java.lang.Error("Det equals to zero, invalid key matrix!");
        }
        int[][] inverseMatrix = new int[3][3];
        inverseMatrix[0][0] = (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])  * Det %26;
        inverseMatrix[0][1] = (matrix[0][2] * matrix[2][1] - matrix[0][1] * matrix[2][2])  * Det %26;
        inverseMatrix[0][2] = (matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1])  * Det%26;
        inverseMatrix[1][0] = (matrix[1][2] * matrix[2][0] - matrix[1][0] * matrix[2][2])  * Det%26;
        inverseMatrix[1][1] = (matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0])  * Det%26;
        inverseMatrix[1][2] = (matrix[0][2] * matrix[1][0] - matrix[0][0] * matrix[1][2])  * Det%26;
        inverseMatrix[2][0] = (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0])  * Det%26;
        inverseMatrix[2][1] = (matrix[0][1] * matrix[2][0] - matrix[0][0] * matrix[2][1])  * Det%26;
        inverseMatrix[2][2] = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0])  * Det%26;
        for(int i=0;i<mdim;i++){
           for(int j=0;j<mdim;j++){
        if (inverseMatrix[i][j]<0){
                    inverseMatrix[i][j]+=26;
               }
            }
        }
        return inverseMatrix;
    }
    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += (matrix1[i][k] * matrix2[k][j]);
                    result[i][j] %= 26; // Ensure result is within the range [0, 25]
                }
            }
        }
        return result;
    }

    public String decryption(String key, String ciphertext) {

        int[][] new_key = InverseMatrix(KeyGen(key));
        int[][] cipher = new int[ciphertext.length()/mdim][mdim];
        char[][] plain = new char[ciphertext.length()/mdim][mdim];
        String plaintext = "";

        // Insert characters into the matrix
        int index = 0;
        for (int i = 0; i < ciphertext.length()/3; i++) {
            for(int j=0;j< 3;j++){
                cipher[i][j] = ciphertext.charAt(index)-97;
                index++;
            }
        }
        int[][] result = multiplyMatrices(cipher,new_key);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                plain[i][j] = (char) (result[i][j]+97);
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                plain[i][j] = (char) (result[i][j]+97);
            }
            plaintext += new String(plain[i]); // Concatenate the entire row once per iteration of i
        }
        return plaintext;
        //for(int i=0;i< mdim;i++){
        //    System.out.println(Arrays.toString(cipher[i]));

       // }

    }
    public int[][] attack(String plain, String cipher){
        int[][] key = new int[3][3];
        int[][] cipher3 = new int[3][3];
        int[][] plain3 = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                cipher3[i][j]= cipher.charAt(i+j)-'a';
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                plain3[i][j]= plain.charAt(i+j)-'a';
            }
        }
        int[][] inverse_plain = InverseMatrix(plain3);
        int det = InverseDet(plain3);
        if(det==0){
            //error
        }
        key = multiplyMatrices(inverse_plain,cipher3);
        //for(int i=0;i<3;i++){
        //    System.out.println(Arrays.toString(plain3[i]));
        //}
        return key;
    }

        public static void main(String[] args)
        {
            HillCipher x = new HillCipher();
            int[][] a = {
                    {17, 17 , 5} ,{21 , 18 , 21} ,{2 , 2 ,19}
            };
            int[][] b = {
                    {9,8,7},{6,5,4},{3,2,1}
            };
            int det = (a[0][0]*(a[1][1]*a[2][2] - a[1][2]*a[2][1]) - a[0][1]*(a[1][0]*a[2][2]-a[1][2]*a[2][0]) + a[0][2]*(a[1][0]*a[2][1]-a[1][1]*a[2][0]) );
            x.KeyGen("1 2 3 4 5 6 7 8 9");
            String key = "17 17 5 21 18 21 2 2 19";
            String[] tokens = key.split(" ");
            System.out.println(tokens.length);
            System.out.println(x.encrypt(key,"paYmoremoney402"));
            System.out.println(x.decryption(key,"rrlmwbkaspdh"));
            x.attack("asdfghjkl","12345689cz");


            //System.out.println("Encryption: " + x.encryptMessage(key_input));
            System.out.println();

            //sc.close();
        }
    }
