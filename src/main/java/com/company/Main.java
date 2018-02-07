package com.company;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.*;

import okhttp3.*;


import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class Main {


    public static void main(String[] args) throws IOException {
        List<RestaurantMenuItem> menu = new ArrayList<RestaurantMenuItem>();
        menu.add(new RestaurantMenuItem("Spaghetti", 7.99f));
        menu.add(new RestaurantMenuItem("Steak", 12.99f));
        menu.add(new RestaurantMenuItem("Salad", 5.99f));

        Gson gson = new Gson();
        String menuJson = gson.toJson(menu);
        System.out.println(menuJson);
        Type founderListType = new TypeToken<ArrayList<RestaurantMenuItem>>(){}.getType();
        List<RestaurantMenuItem> menu2 = new ArrayList<RestaurantMenuItem>();
        menu2=gson.fromJson(menuJson,founderListType);

        System.out.println(menu2.get(0).description);

        String founderJson = "[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]";


        List<Founder> founderList = gson.fromJson(founderJson, founderListType);




//        GetBody gb = new GetBody();
//        String body;
//        Gson gson = new Gson();
//
//
//        try {
//            body=gb.run("https://api.mlab.com/api/1/databases/evotor_base/collections/ReceiptDiscount?apiKey=lqnYbFBA_7ot9ePXX3B9Dvwx-B6daWNI");
//            String jsonString = "{\"_id\":\"N95\",\"Discount\":\"WP\"}";
//            Phone fooFromJson = gson.fromJson(jsonString, Phone.class);
//            System.out.print(fooFromJson.Discount);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        repos.enqueue(new Callback<ResponseBody>() {
//            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//                System.out.print(response.isSuccessful());
//
//            }
//
//            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
//                System.out.print(321);
//
//            }
//        });



    }
};

class GetBody {



    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body());

        return response.body().string();
    }
}

class Phone {
    public String _id;
    public String Discount;
}
 class RestaurantMenuItem {
    String description;
    float price;

     public RestaurantMenuItem(String description, float price) {
         this.description = description;
         this.price = price;
     }
 }
 class RestaurantWithMenu {
    String name;

    List<RestaurantMenuItem> menu;

     public RestaurantWithMenu(String name, List<RestaurantMenuItem> menu) {
         this.menu = menu;
         this.name = name;
     }
     //RestaurantMenuItem[] menu; // alternative, either one is fine
}

class Founder {
    String name;
    int flowerCount;
}


