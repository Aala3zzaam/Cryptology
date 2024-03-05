package Main;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.lang.Math;
import java.util.Arrays;


class Transposition {

    public int index(int[] key,int t){
        int len = key.length;
        int i=0;

        while(i<len){
            if(key[i]==t){
                return i;
            }
            else{
                i++;
            }
        }
        return i;
    }

    public String encryption(String key,String text,int n){
        text = text.replaceAll("[^a-zA-Z]","");

        String[] key1 = key.split(" ");
        int Key[] = new int[key1.length];
        for(int i=0;i<key1.length;i++){
            Key[i] = Integer.parseInt(key1[i]);
        }
        System.out.println(Arrays.toString(Key));
        int columns = Key.length;
        int rows = (int) Math.ceil((double)text.length()/columns);
        //System.out.println(columns);
        char plain[][] = new char[rows][columns];

        //Padding the plaintext
        while(text.length()!= (rows*columns)){
            text = text +"x";
        }
        //System.out.println(text);

        //putting plaintext into a matrix
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                plain[i][j] = text.charAt(count);
                count++;
            }
        }
        //printing the plain matrix
        for(int i=0;i<rows;i++){
            System.out.println(plain[i]);
        }

        //encryption

        String enc="";
        for(int i=0;i<columns;i++){
            for(int j=0;j<rows;j++){
                int index = index(Key,i+1);
                enc = enc + plain[j][index];
            }
        }
        String cipher="";
        while(n>1){
            enc = encryption(key,enc,1);
            n--;
        }
        return enc;
    }

    public String decryption(String key,String ciphertext,int n){
        ciphertext = ciphertext.replaceAll("[^a-zA-Z]","");
        String[] key1 = key.split(" ");
        int Key[] = new int[key1.length];
        for(int i=0;i<key1.length;i++){
            Key[i] = Integer.parseInt(key1[i]);
        }
        System.out.println(Arrays.toString(Key));
        int rows = ciphertext.length()/Key.length;
        int columns = Key.length;
        char[][] cipher = new char[rows][columns];

        int count =0;

        for(int j=0;j<columns;j++){
            for(int i=0;i<rows;i++){
                cipher[i][j] = ciphertext.charAt(count++);
            }
        }
        for(int i=0;i<rows;i++){
            System.out.println(cipher[i]);
        }

        char[][] plain = new char[rows][columns];
        String plaintext = "";


        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                plain[i][j] = cipher[i][Key[j]-1];
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                plaintext+= plain[i][j];
            }
        }
        while(n>1){
            plaintext = decryption(key,plaintext,1);
            n--;
        }

        return plaintext;
    }

        public static void main(String[] args) {

            Transposition cipher = new Transposition();
            System.out.println(cipher.encryption("4 3 1 2 5 6 7","attackpostponeduntiltwoam",2));
            System.out.println(cipher.decryption("4 3 1 2 5 6 7","nscxauopttwltmdnaoiepaxttokx",2));
        }

}
