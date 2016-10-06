package org.example.androidenterprise.utils;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by sdlds on 2016/6/6.
 */
public class Base64Encrypt {
    public static byte[] ImageToByte(String value) throws Exception{
        try
        {
            byte[] data = null;
            URL url = new URL(value);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream in = con.getInputStream();
            //in = new FileInputStream(value);
            data = new byte[in.available()];
            in.read(data);
            in.close();
            return data;
        }
        catch(Exception e){
            return null;
        }
    }

    public static boolean ByteToImage(String filename, byte[] data) throws Exception{
        try
        {
            InputStream in = new ByteArrayInputStream(data);
            OutputStream out = new FileOutputStream(filename);
            byte[] cache = new byte[1024];
            int len = 0;
            while ((len = in.read(cache)) != -1) {
                out.write(cache, 0, len);
                out.flush();
            }
            out.close();
            in.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static String encodeBase64(byte[] input) throws Exception {
        Class clazz = Class.forName("com.sun.org.apache.xml.internal.security.utils.Base64");
        Method mainMethod = clazz.getMethod("encode",byte[].class);
        mainMethod.setAccessible(true);
        Object obj = mainMethod.invoke(null,input);
        return (String)obj;
    }

    public static byte[] decodeBase64(String input) throws Exception{
        input = input.replaceAll("\n","")
                     .replaceAll("\r","");
        Class clazz = Class.forName("com.sun.org.apache.xml.internal.security.utils.Base64");
        Method mainMethod = clazz.getMethod("decode",String.class);
        mainMethod.setAccessible(true);
        Object obj = mainMethod.invoke(null,input);
        return (byte[])obj;
    }
}
