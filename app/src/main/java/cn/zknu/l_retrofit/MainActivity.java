package cn.zknu.l_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        RetrofitUtil.requestGet(new ResponseData() {
            @Override
            public void _onResponse(String data) {
                mShowMsg.setText("Post--->"+data);
            }
        });
    }

    private void httpGet() {
        RetrofitUtil.requestGet(new ResponseData() {
            @Override
            public void _onResponse(String data) {
                mShowMsg.setText("Get--->"+data);
            }
        });
    }
}
