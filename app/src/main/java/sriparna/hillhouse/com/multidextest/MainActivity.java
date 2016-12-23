

package sriparna.hillhouse.com.multidextest;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

import dalvik.system.DexClassLoader;

public class MainActivity extends Activity {
    private static final String FIELD = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClassLoader classLoader = MainActivity.class.getClassLoader();
                try {
                    Class myClass = classLoader.loadClass("sriparna.hillhouse.com.multidextest.Sample");
                    try {
                        String name = (String)myClass.getDeclaredField(FIELD).get(null);
                        Toast.makeText(MainActivity.this,
                                "the provided value is : "+name,Toast.LENGTH_LONG).show();

                    }catch (NoSuchFieldException e){
                        e.printStackTrace();
                    }catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
