

import java.util.Arrays;

class Vigenere {

    public String encrypt(String key,String plain){
        plain =plain.toUpperCase().replaceAll("[^A-Z]","");
        String cipher = "";
        int[] c = new int[plain.length()];
        int[] k = new int[key.length()];
        int[] p = new int[plain.length()];

        for(int i=0;i<plain.length();i++){
            if(Character.isUpperCase(plain.charAt(i))){
            p[i] = plain.charAt(i) -'A';
        }
            if(Character.isLowerCase(plain.charAt(i))){
                p[i] = plain.charAt(i) -'a';
            }
        }
        for(int i=0;i<key.length();i++){
            k[i] = key.charAt(i) -97;
        }

        for(int i=0;i<p.length;i++){
            c[i] = (p[i] + k[i% key.length()]) %26;
        }
        for (int i = 0; i < c.length; i++) {
            cipher += (char) ((c[i] + 'A'));
        }

        return cipher;

    }

    public String decrypt(String key, String text){
        String plain = "";
        int[] c = new int[text.length()];
        int[] k = new int[key.length()];
        int[] p = new int[text.length()];

        for(int i=0;i<text.length();i++){
            p[i] = text.charAt(i) -97;
        }
        for(int i=0;i<key.length();i++){
            k[i] = key.charAt(i) -97;
        }

        for(int i=0;i<p.length;i++){
            c[i] = (p[i] - k[i% key.length()]+26) %26;
        }
        for (int i = 0; i < c.length; i++) {
            plain += (char) ((c[i] + 97));
        }
        return plain;

    }

        public static void main(String[] args)
        {
            Vigenere x = new Vigenere();
            int[][] a = {
                    {17, 17 , 5} ,{21 , 18 , 21} ,{2 , 2 ,19}
            };
            int[][] b = {
                    {9,8,7},{6,5,4},{3,2,1}
            };
            int det = (a[0][0]*(a[1][1]*a[2][2] - a[1][2]*a[2][1]) - a[0][1]*(a[1][0]*a[2][2]-a[1][2]*a[2][0]) + a[0][2]*(a[1][0]*a[2][1]-a[1][1]*a[2][0]) );
            System.out.println(x.encrypt("deceptive","we402arediscoveredsav//eyourself//"));
            System.out.println(x.decrypt("deceptive","zicvtwqngrzgvtwavzhcqyglmgj"));

            System.out.println();
        }
    }
