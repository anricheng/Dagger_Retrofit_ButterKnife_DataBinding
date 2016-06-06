package com.example.aric.databinding;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aric.databinding.Event.ClickEvent;
import com.example.aric.databinding.Model.ManhuaList;
import com.example.aric.databinding.Service.APIService;
import com.example.aric.databinding.Service.LoggerI;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity implements ClickEvent {
    private Unbinder unbinder;
    private static final String TAG = "MainActivity";
    TextView viewById;

    @Override
    public void onclick(View view) {
        Toast.makeText(MainActivity.this, "onclick has been clicked", Toast.LENGTH_SHORT).show();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new LoggerI()).build();
        String ENDPOINT = "http://route.showapi.com/";
        Retrofit retrofit= new Retrofit.Builder().client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIService apiService = retrofit.create(APIService.class);
        Observable<ManhuaList> manhuaListObservable = apiService.loadsStudent("20124", "11e3a2b96eaa4c69944cd7dabd1cbbfb", 2);
        manhuaListObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ManhuaList>() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this, "it's been finish", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ManhuaList manhuaList) {
                viewById.setText(manhuaList.getShowapi_res_code());
                viewById.setText("chen");


            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewById = (TextView) findViewById(R.id.tv_chou);
        setContentView(R.layout.main_activity);
        Button button = (Button) findViewById(R.id.bt_onclik);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick(v);
            }
        });
        //MainActivityBinding mainActivityBinding = (MainActivityBinding) DataBindingUtil.setContentView(MainActivity.this, R.layout.main_activity);
        MyApplication myApplication = MyApplication.get(this);
        AppComponent appComponent = myApplication.getAppComponent();
        appComponent.inject(this);
        unbinder = ButterKnife.bind(this);



        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        try {
            mToolbar.setTitle("zhou");
            setSupportActionBar(mToolbar);
            mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_settings:
                            Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.action_share:
                            Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }



}

