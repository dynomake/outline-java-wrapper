package me.dynomake.outline.implementation;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import me.dynomake.outline.OutlineWrapper;
import me.dynomake.outline.gson.GsonUtil;
import me.dynomake.outline.implementation.model.Name;
import me.dynomake.outline.model.OutlineKey;
import me.dynomake.outline.model.OutlineKeyList;
import me.dynomake.outline.model.OutlineServer;
import me.dynomake.outline.implementation.model.Response;

import javax.net.ssl.*;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Outline Java Wrapper written by dynomake developer.
 * Distributed by MIT License.
 */
@AllArgsConstructor
public class RealOutlineWrapper implements OutlineWrapper {

    private String apiAddress;

    @Override
    public OutlineKeyList getKeys() {
        return GsonUtil.unparseJson(getResponse("/access-keys", "GET", null).responseString, OutlineKeyList.class);
    }

    @Override
    public OutlineKey generateKey() {
        return GsonUtil.unparseJson(getResponse("/access-keys", "POST", null).responseString, OutlineKey.class);
    }

    @Override
    public OutlineKey getKey(int keyIdentifier) {
        return GsonUtil.unparseJson(getResponse("/access-keys/" + keyIdentifier, "GET", null).responseString, OutlineKey.class);
    }

    @Override
    public void renameKey(int keyIdentifier, @NonNull String name) {
        getResponse("/access-keys/" + keyIdentifier +  "/name", "PUT", GsonUtil.parseJson(new Name(name)));
    }

    @Override
    public boolean removeKey(int keyIdentifier) {
        return getResponse("/access-keys/" + keyIdentifier, "DELETE", null).responseCode == 204;
    }


    @Override
    public OutlineServer getServerInformation() {
        return GsonUtil.unparseJson(getResponse("/server", "GET", null).responseString, OutlineServer.class);
    }

    private Response getResponse(@NonNull String requestAddress, @NonNull String method, String writableJson) {
        try {
            URL url = new URL(apiAddress + requestAddress);

            HttpsURLConnection httpConn = (HttpsURLConnection) url.openConnection();

            httpConn.setRequestMethod(method);
            removeSSLVerifier(httpConn);
            if (writableJson != null) {
                httpConn.setDoOutput(true);
                httpConn.setRequestProperty("Content-Type", "application/json");
                OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
                writer.write(writableJson);
                writer.flush();
                writer.close();
                httpConn.getOutputStream().close();
            }

            InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                    ? httpConn.getInputStream()
                    : httpConn.getErrorStream();
            Scanner s = new Scanner(responseStream).useDelimiter("\\A");
            String response = s.hasNext() ? s.next() : "";

            return new Response(httpConn.getResponseCode(), response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void removeSSLVerifier(@NonNull HttpsURLConnection connection) {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                            throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                            throws CertificateException {
                    }
                }
        };

        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("SSL");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        try {
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (KeyManagementException e) {
            System.out.println(e.getMessage());
        }
        connection.setSSLSocketFactory(sc.getSocketFactory());

        HostnameVerifier validHosts = (arg0, arg1) -> true;

        connection.setHostnameVerifier(validHosts);
    }
}
