package com.example.test.weibo;

import android.content.Context;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.test.weibo", appContext.getPackageName());
    }
    @Test
    public void readeImgInPhone(){
        File f =new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"img"+File.separator+"home.png");
       /* File[] files = f.listFiles();
        for (File file:files ) {
            Log.d("LQ",file.getAbsolutePath());
        }*/
       Log.d("LQ",f.getAbsolutePath());

    }
}
