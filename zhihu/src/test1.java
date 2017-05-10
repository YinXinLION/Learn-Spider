import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

/**
 * Created by 殷鑫 on 2017/5/10.
 */
public class test1 {
    public static void main(String[] args) {
        //定义即将访问的链接
        String url = "http://www.baidu.com";
        //定义一个字符串存储网页内容
        String result = "";
        //定义一个缓冲字符输入流
        BufferedReader in = null;

        try {
            //将String转成url对象
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            //开始链接
            connection.connect();
            //初始化bufferreader输入流来读取URL
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //临时存储每一行
            String line;
            while ((line = in.readLine()) != null) {
                //遍历抓取到的每一行并将其存储到result里面
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 使用finally来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println(result);
    }
}
