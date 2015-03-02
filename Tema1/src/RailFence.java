/**
 * Created by Diana.Alexandru on 02.03.2015.
 */
public class RailFence {

    String encrypt(String plainText,int depth)throws Exception
    {
        int r = depth;
        int len = plainText.length();
        int c = (int)Math.ceil((double)len/(double)depth);
        char mat[][] = new char[r][c];
        int k = 0;

        String cipherText = "";

        for(int i = 0;i < c;i++)
        {
            for(int j = 0;j < r;j++)
            {
                if(k != len)
                    mat[j][i] = plainText.charAt(k++);
                else
                    mat[j][i] = 'X';
            }
        }
        for(int i = 0;i < r;i++)
        {
            for(int j = 0;j < c;j++)
            {
                if(mat[i][j] != 'X')
                    cipherText += mat[i][j];
            }
        }
        return cipherText;
    }


    String decrypt(String cipherText,int depth)throws Exception
    {
        int r = depth;
        int len = cipherText.length();
        int c = (int)Math.ceil((double)len/(double)depth);
        char mat[][] = new char[r][c];
        int k = 0;

        String plainText = "";


        for(int i = 0;i < r;i++)
        {
            for(int j = 0;j < c;j++)
            {
                if(k != len)
                     mat[i][j] = cipherText.charAt(k++);
            }
        }
        for(int i = 0;i < c;i++)
        {
            for(int j = 0;j < r;j++)
            {
                plainText += mat[j][i];
            }
        }

        return plainText;
    }

    public static void main(String[] args) throws Exception {
        RailFence crypt = new RailFence();
        String text = "The Rail Fence Cipher involves writing messages so that alternate letters are written on separate upper and lower lines";
        String encryption = crypt.encrypt(text, 3);
        String decryption = crypt.decrypt(encryption, 3);

        System.out.println("\nText to encrypt and decrypt with Rail Fence: \n" + text + "\n");
        System.out.println("Encrypt: " + encryption);
        System.out.println("Decrypt: " + decryption);

    }

}
