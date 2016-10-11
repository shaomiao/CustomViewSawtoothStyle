package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by shaomiao on 2016/10/11.
 */

public class DemoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        BezierTestView testview= (BezierTestView) findViewById(R.id.testview);
        //testview.setScreenWidth(500);
        //testview.setFirst_x(20);
    }
}
