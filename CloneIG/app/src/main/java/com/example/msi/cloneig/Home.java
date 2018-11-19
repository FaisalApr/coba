package com.example.msi.cloneig;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;


public class Home extends Activity {
    ImageButton ButProf,ButHome;
    public static final String TAG="MainActivity";
    RecyclerView re;
    private ArrayList<user> mUser = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrl = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        ButProf = (ImageButton) findViewById(R.id.btnProfil);
        ButHome = (ImageButton) findViewById(R.id.btnHome);

        ButProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ten = new Intent(getApplicationContext(), detailProfil.class);
                startActivity(ten);
            }
        });

        ButHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tent = new Intent(getApplicationContext(), Home.class);
                startActivity(tent);
            }
        });

        getImages();
        initHorizontalPostAdapter();
    }

    private void getImages(){

        mImagesUrl.add("https://vignette.wikia.nocookie.net/boboiboy/images/7/76/Logo_BoBoiBoy.png/revision/latest?cb=20170131095525&path-prefix=id");
        mNames.add("Akbar");
        mUser.add(new user("nana","ohdude","http://cdn2.tstatic.net/tribunnews/foto/bank/images/lucinta-luna_20180526_103150.jpg","https://mobilelegends.gcube.id/wp-content/uploads/sites/6/2017/12/Mobile-Legends-Tips.jpg"));

//        mImagesUrl.add("https://https://www.mmogames.com/wp-content/uploads/2009/12/mmo-games-lost-saga-hero-screenshot.jpg");
//        mNames.add("I_Love_LS");
        mUser.add(new user("nani","Ben","https://cdn.brilio.net/news/2017/04/12/124286/10-fakta-unik-ini-bukti-orang-dengan-lesung-pipit-itu-spesial-170412e.jpg","https://cdn2.unrealengine.com/Fortnite%2Fbattle-royale%2Fseason6-social-1920x1080-0a72ec2f35dfe5be6cf8a77ec16063cca4db7046.jpg"));

        mImagesUrl.add("https://i.ytimg.com/vi/d4P9P07hLX4/maxresdefault.jpg");
        mNames.add("SF");
        mUser.add(new user("nano","BBBBBBB","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg","http://2.bp.blogspot.com/-BGMR-Bx5KAo/UWxT3eNaiXI/AAAAAAAABJA/lovsM9y5FPc/s400/gambar-walpapper-sedih-06.jpg"));

//        mImagesUrl.add("https://http://img-cdn.redwolfairsoft.com/upload/product/img/MSR-020-1L.jpg");
//        mNames.add("Blank");
        mUser.add(new user("nane","Ayy",
                "https://i.ytimg.com/vi/zKH3MvcRDTU/maxresdefault.jpg","https://s3-us-west-2.amazonaws.com/marcato.west/artists_files/web_photos/499652/original.jpg"));

        mImagesUrl.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("MahatmaGhandi");
        mUser.add(new user("nanoi","kuy","https://cdn1-production-images-kly.akamaized.net/guWzE0tGIkLZOYcxwq430rnFJvs=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/1838664/original/028738000_1516427062-aryani.JPG","https://i.ytimg.com/vi/q74KwrEDS3Y/maxresdefault.jpg"));

        mImagesUrl.add("data:image/jpeg;base64,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");
        mNames.add("Frozen Lake");
        mUser.add(new user("nanaa","Crown","https://4.bp.blogspot.com/-sQt57R5WEsI/VpYq4Eg-upI/AAAAAAAAISU/tsloEU2ZD04/s320/kenapa_orang_suka_selfie.jpg","https://logos.textgiraffe.com/logos/logo-name/Faisal-designstyle-i-love-m.png"));

        mImagesUrl.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");
        mUser.add(new user("nanp","Pubg","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg","https://tangerangonline.id/wp-content/uploads/2016/04/EzyWatermark321NUUU.jpg"));

        mImagesUrl.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");
        mUser.add(new user("nanaaaa","Tia mo","https://waktuku.com/wp-content/uploads/2017/03/humoris.jpg","https://4.bp.blogspot.com/-drCIkGp59Wc/WQATKD3sZfI/AAAAAAAAdbQ/zpcfiTkiUokKiVSjezZHMfV1Kj_JNxYvgCLcB/s1600/HTI%2BDITOLAK.PNG"));

        mImagesUrl.add("https://pmcvariety.files.wordpress.com/2018/06/pubg.jpg?w=1000&h=563&crop=1");
        mNames.add("Washington");
        mUser.add(new user("kulah","wazolsky","http://cdn1.theweek.co.uk/sites/theweek/files/styles/16x8_465/public/2018/09/momo_challenge.jpg?itok=OzjiRAA0","https://www.imcnews.id/po-content/uploads/images_(9)_1.jpg"));
    }
    private void initHorizontalPostAdapter(){
        LinearLayoutManager lay = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerV = findViewById(R.id.Horizontal);
        recyclerV.setLayoutManager(lay);

        HorizontalPostAdapter adapter = new HorizontalPostAdapter(mNames,mImagesUrl,this);
        recyclerV.setAdapter(adapter);

        RecyclerView recyclerViewMain = findViewById(R.id.main_view_rcy);
        recyclerViewMain.setHasFixedSize(true);

        lay = new LinearLayoutManager(this);
        recyclerViewMain.setLayoutManager(lay);

        VerticalPostAdapter madapter = new VerticalPostAdapter(this,mUser,mImagesUrl);
        recyclerViewMain.setAdapter(madapter);
    }
}
