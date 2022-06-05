package com.company;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class HtmlResponseTest {

    public static void main(String[] args) {


        GoogleService s = new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(GoogleService.class);

        Response<String> r = null;
        try {
            r = s.getHomePageHtml().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (r != null && r.isSuccessful()) {
            System.out.println(r.body());

        } else if (r != null) {
            try {
                System.out.println(r.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}



