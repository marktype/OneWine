package com.wine.onewine.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wine.onewine.R;
import com.wine.onewine.basepage.BaseActivity;

public class MyInfoActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        initWidget();
    }

    private void initWidget(){
        RelativeLayout mAlterName = (RelativeLayout) findViewById(R.id.alter_name_relat);
        ImageView mBackImg = (ImageView) findViewById(R.id.back_img);
        RelativeLayout mAlterPassword = (RelativeLayout) findViewById(R.id.alter_password_relat);
        RelativeLayout mGetAddress = (RelativeLayout) findViewById(R.id.get_address_lin);




        mGetAddress.setOnClickListener(this);
        mAlterPassword.setOnClickListener(this);
        mBackImg.setOnClickListener(this);
        mAlterName.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alter_name_relat:
                Intent intent = new Intent(this,AlterNameActivity.class);
                startActivity(intent);
                break;
            case R.id.back_img:
                finish();
                break;
            case R.id.alter_password_relat:
                intent = new Intent(this,AlterPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.get_address_lin:
                intent = new Intent(this,AddressListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
