package reptile;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java爬虫小示例
 * @author : zhaopanqi
 * @date : Created in 2019/12/19
 */
public class ReptileJava {

    public static void main(String[] args){
        /*try {
            // 小说目录地址
            URL url = new URL("https://www.biqudu.com/43_43821/");

            // trust all hosts
            trustAllHosts();
            HttpsURLConnection https = (HttpsURLConnection)url.openConnection();
            // 打开和URL之间的连接
            URLConnection conn = url.openConnection();
            if ("https".equals(url.getProtocol().toLowerCase())) {
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            }
            // 根据URL创建reader
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // 创建本地writer
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:/txt/xiaoshuo.txt"));

            String mainContextReg="<dt>《圣墟》正文</dt>";

            //<dd> <a href="/43_43821/2520338.html">第一章 沙漠中的彼岸花</a></dd>
            //String urlReg="<a[\\s\\S]*>";
            String urlReg = "<dd> <a href=\"/43_43821/2520338.html\">第一章 沙漠中的彼岸花</a></dd>";

            Pattern mainContextPattern= Pattern.compile(mainContextReg);
            Pattern urlPattern=Pattern.compile(urlReg);

            String str;
            //是否是正文
            boolean boo=false;
            while((str = br.readLine()) !=null ){
                System.out.println("读取到的内容为：" + str);
                if(!boo){
                    Matcher mainContextMatcher=mainContextPattern.matcher(str);
                    if(mainContextMatcher.find()){
                        boo=true;
                        System.out.println(str.substring(str.indexOf("<dt>")+4, str.lastIndexOf("</dt>")));
                    }
                }else{
                    Matcher urlmatcher=urlPattern.matcher(str);
                    if(urlmatcher.find()){
                        System.out.println(urlmatcher.group());
                        //<a href="/43_43821/2520338.html">第一章 沙漠中的彼岸花</a></dd>
                        String str1=urlmatcher.group();

                        String acceptUrl="http://www.biqudu.com"+str1.substring(str1.indexOf("<a")+9,str1.lastIndexOf("\">"));
                        System.out.println(str1);
                        System.out.println(url);
                        //zj(acceptUrl,bw);
                    }
                }

            }
            br.close();
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }*/
    }

    /*final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private static void trustAllHosts() {
        final String TAG = "trustAllHosts";
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws java.security.cert.CertificateException {

                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[] {};
                    }
                }
        };
        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
