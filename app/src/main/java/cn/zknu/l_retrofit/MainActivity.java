package cn.zknu.l_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button mBtnGet;
    private Button mBtnPost;

    private TextView mShowMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        init();
    }

    private void init() {
        mBtnGet.setOnClickListener(this);
        mBtnPost.setOnClickListener(this);
    }

    private void initView() {
        mBtnGet=(Button)findViewById(R.id.btn_get);
        mBtnPost=(Button)findViewById(R.id.btn_post);
        mShowMsg=(TextView)findViewById(R.id.tv_show_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get:
                httpGet();
                break;
            case R.id.btn_post:
                httpPost();
                break;
        }
    }

    private void httpPost() {
        RetrofitUtil.requestPost(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                mShowMsg.setText("Get方法获取数据--->"+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mShowMsg.setText(t.getMessage());
            }
        });
    }

    private void httpGet() {
        RetrofitUtil.requestGet(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
              mShowMsg.setText("Get方法获取数据--->"+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mShowMsg.setText(t.getMessage());
            }
        });
    }
}
