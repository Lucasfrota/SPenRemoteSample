package com.example.remoteactions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.ScrollView;
import android.widget.TextView;

public class SampleActivity1 extends Activity {
    private ScrollView mScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sample_activity1);

        mScrollView = (ScrollView) findViewById(R.id.scroll_view);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if  (keyCode == KeyEvent.KEYCODE_PAGE_DOWN) {
            // PAGE_DOWN
            mScrollView.smoothScrollBy(0, 500);
        } else if  (keyCode == KeyEvent.KEYCODE_PAGE_UP) {
            // PAGE_UP
            mScrollView.smoothScrollBy(0, -500);
        } else if ((event.getMetaState() & KeyEvent.META_CTRL_ON) != 0
                && (event.getMetaState() & KeyEvent.META_SHIFT_ON) == 0
                && (event.getMetaState() & KeyEvent.META_ALT_ON) == 0
                && keyCode == KeyEvent.KEYCODE_N) {
            // CTRL_LEFT+N
            Intent intent = new Intent(this, SampleActivity2.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }
}
