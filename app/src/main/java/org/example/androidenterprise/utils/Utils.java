package org.example.androidenterprise.utils;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rikka on 2016/3/26.
 */
public class Utils {
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static File writeStreamToFile(InputStream inputStream, String path) {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.getParentFile().mkdirs();
        }
        try {
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();

            FileOutputStream outputStream = new FileOutputStream(path);

            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void objectToJsonFile(Object element, String outName) {
        InputStream is = new ByteArrayInputStream(new Gson().toJson(element).getBytes());

        File file = new File(outName);
        if (!file.getParentFile().exists()) {
            //noinspection ResultOfMethodCallIgnored
            file.getParentFile().mkdirs();
        }

        try
        {
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();

            FileOutputStream outputStream = new FileOutputStream(outName);

            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = is.read(buffer)) != -1)
            {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static int stringToInt(String in) {
        try {
            if (in.contains("+")) {
                return Integer.parseInt(in.replace(" ", "").replace("+", ""));
            } else {
                return Integer.parseInt(in.replace(" ", ""));
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static InputStream getUrlStream(String url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        return con.getInputStream();
    }
}
