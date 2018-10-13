
package com.cx.bank.util;
public class MD5
{
	  public String encode(byte[] source) {  
        String s = null;  
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
        try {  
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");  
            md.update(source);  
            byte tmp[] = md.digest();   
            char str[] = new char[16 * 2];   
            int k = 0;   
            for (int i = 0; i < 16; i++) {   
                byte byte0 = tmp[i];   
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];   
                str[k++] = hexDigits[byte0 & 0xf];   
            }  
            s = new String(str);   
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return s;  
    }  
      
    public String getMD5(String source) {  
        return (source == null || "".equals(source)) ? "" : encode(source.getBytes());  
    }  
}