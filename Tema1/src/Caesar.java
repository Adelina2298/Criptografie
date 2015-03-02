/**
 * Created by Diana.Alexandru on 02.03.2015.
 */
public class Caesar {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public String encrypt(String plainText,int shiftKey)
    {
        plainText = plainText.toLowerCase();
        String cipherText="";
        for(int i=0;i<plainText.length();i++)
        {
            if(plainText.charAt(i) == ' '){
                cipherText += ' ';
            }
            else{
                int charPosition = ALPHABET.indexOf(plainText.charAt(i));
                int keyVal = (shiftKey+charPosition)%26;
                char replaceVal = this.ALPHABET.charAt(keyVal);
                cipherText += replaceVal;
            }

        }
        return cipherText;
    }
    public String decrypt(String cipherText, int shiftKey)
    {
        cipherText = cipherText.toLowerCase();
        String plainText="";
        for(int i=0;i<cipherText.length();i++)
        {
            if(cipherText.charAt(i) == ' '){
                plainText += ' ';
            }
            else{
                int charPosition = this.ALPHABET.indexOf(cipherText.charAt(i));
                int keyVal = (charPosition-shiftKey)%26;
                if(keyVal<0)
                {
                    keyVal = this.ALPHABET.length() + keyVal;
                }
                char replaceVal = this.ALPHABET.charAt(keyVal);
                plainText += replaceVal;
            }

        }
        return plainText;
    }

    public static void main(String[] args){
        Caesar crypt = new Caesar();
        String text = "According to Suetonius, Caesar simply replaced each letter in a message with the letter that is three places further down the alphabet";
        String encryption = crypt.encrypt(text, 3);
        String decryption = crypt.decrypt(encryption, 3);

        System.out.println("\nText to encrypt and decrypt with Caesar: \n" + text + "\n");
        System.out.println("Encrypt: " + encryption);
        System.out.println("Decrypt: " + decryption);
    }

}
