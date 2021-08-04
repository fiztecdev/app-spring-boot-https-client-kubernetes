package io.app.fiztec;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.io.IOException;

@RestController
public class ApiClient {

    @GetMapping("/api")
    public String getApiClient() throws IOException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        OkHttpClient client = new OkHttpClient();
        client=builder.build();


        Request request = new Request.Builder()
                .url("https://172.22.144.1/")
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String data=response.toString();
        return data;
    }
}
