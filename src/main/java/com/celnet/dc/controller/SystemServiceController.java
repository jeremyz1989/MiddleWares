package com.celnet.dc.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.celnet.dc.domain.api.request.RequestJson;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 请求外部接口配置（callout）
 * @author loki
 *
 */
public class SystemServiceController {
	
	ObjectMapper mapper = new ObjectMapper();
    public String doSFDC(RequestJson requestJson) throws Exception{
        String httpsURL = "https://smsandbox-shimaoapi.cs57.force.com/services/apexrest/apiService";//设置外部的请求连接
        URL url;
        HttpsURLConnection urlConn;
//调用时，给RequestJson 赋值
//        RequestJson rj = new RequestJson();
//        rj.setMethod(method);
//        rj.setEntry(requestString);
//        rj.setAuthorizedApp(app_key);
//        rj.setApiVersion("1.0");
        String json_str = mapper.writeValueAsString(requestJson);
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);

        url = new URL(httpsURL);
        urlConn = (HttpsURLConnection)url.openConnection();
        urlConn.setRequestMethod("POST");
        urlConn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        urlConn.setDoInput(true);
        urlConn.setUseCaches(false);
        urlConn.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream());
        //wr.writeBytes (new String(json_str.toString().getBytes("UTF-8")));
        //wr.writeUTF(json_str);
        wr.write(json_str.getBytes());
        wr.flush ();
        wr.close ();
        //Get Response
        InputStream is = urlConn.getInputStream();
        BufferedReader reqBR = new BufferedReader(new InputStreamReader(is));
        StringBuffer res = new StringBuffer();
        String line = "";
        while((line = reqBR.readLine()) != null) {
            res.append(line);
            //res.append('\n');
        }
        return res.toString();
    }

    public static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs)
        {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs)
        {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException
        {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) throws java.security.cert.CertificateException
        {
            return;
        }
    }

    private static void trustAllHttpsCertificates() throws Exception
    {
        //  Create a trust manager that does not validate certificate chains:
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

}
