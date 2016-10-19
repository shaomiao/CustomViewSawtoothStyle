package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DemoActivity4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4);
        SawtoothBlackView sawtooth1= (SawtoothBlackView) findViewById(R.id.sawtooth1);
        sawtooth1.setState(false);
        sawtooth1.setBig_heigth(100);
    }
}
