package Main;
import java.util.Random;


class OneTimePad {
    Random rand = new Random();
    String cipher="";

    public int[] KeyGen(int size){
        int[] Key = new int[size];
        for(int i=0;i<size;i++){
            Key[i] = rand.nextInt(26);
            //System.out.println(Key[i]);
        }
        return Key;
    }

    public String encrypt(String plaintext){
        plaintext = plaintext.replaceAll("[^a-zA-Z]", "");
        int Key[] = KeyGen(plaintext.length());
        int cipher1[] = new int[plaintext.length()];
        int plain1[] = new int[plaintext.length()];
        for(int i=0;i<plaintext.length();i++){
            System.out.println(Key[i]);
        }

        for(int i=0;i<plaintext.length();i++){
            plain1[i] = plaintext.charAt(i);
            if(Character.isLowerCase(plain1[i])){
                plain1[i]-='a';
            }
            if(Character.isUpperCase(plain1[i])){
                plain1[i] -= 'A';
            }
            //System.out.println(plain1[i]);
        }
        for(int i=0;i<plaintext.length();i++){
            cipher1[i] = (plain1[i] + Key[i])%26;
        }

        for (int i = 0; i < plaintext.length(); i++) {
                cipher = cipher + (char) ((cipher1[i] + 'a'));
        }
        this.cipher = cipher;


        return cipher;
    }

    public String decrypt(String ciphertext,int[] key){
        String plain ="";
        ciphertext = ciphertext.replaceAll("[^a-zA-Z]", "");
        int x = key.length;
        int plain1[] = new int[x];
        int cipher[] = new int[x];

        for(int i=0;i<x;i++){
            cipher[i] = ciphertext.charAt(i) -'a';
        }

        for(int i=0;i<x;i++){
            plain1[i] = ((cipher[i]-key[i])+26)%26;
            plain = plain + (char) (plain1[i]+'a');
        }

        return plain;
    }

    public static void main(String[] args)
    {
        System.out.println();

    }
}
