package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_demo).setOnClickListener(this);
        findViewById(R.id.btn_demo2).setOnClickListener(this);
        findViewById(R.id.btn_demo3).setOnClickListener(this);
        findViewById(R.id.btn_demo4).setOnClickListener(this);
        findViewById(R.id.btn_demo5).setOnClickListener(this);
        findViewById(R.id.btn_demo6).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_demo:
                startActivity(new Intent(MainActivity.this, DemoActivity.class));
                break;
            case R.id.btn_demo2:
                startActivity(new Intent(MainActivity.this,DemoActivity2.class));
                break;
            case R.id.btn_demo3:
                startActivity(new Intent(MainActivity.this,DemoAcivity3.class));
                break;
            case R.id.btn_demo4:
                startActivity(new Intent(MainActivity.this,DemoActivity4.class));
                break;
            case R.id.btn_demo5:
                startActivity(new Intent(MainActivity.this,DemoActivity5.class));
                break;
            case R.id.btn_demo6:
                startActivity(new Intent(MainActivity.this,DemoActivity6.class));
                break;
        }
    }
    public void startCamera(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}
