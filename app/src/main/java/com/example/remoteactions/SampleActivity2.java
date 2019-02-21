package com.example.remoteactions;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class SampleActivity2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sample_activity2);
        Button closeButton = (Button) findViewById(R.id.button);

        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo("com.samsung.android.stickercenter", 0);
            String version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ApplicationInfo ai = getPackageManager().getApplicationInfo("com.samsung.android.stickercenter",
                    PackageManager.GET_META_DATA);
            if (ai.metaData != null) {
                int apiVersion = ai.metaData.getInt("com.samsung.android.stickercenter.api.version");
                int providerVersion = ai.metaData.getInt("com.samsung.android.stickercenter.provider.version");
            }
        } catch (PackageManager.NameNotFoundException e) {
            // there is no StickerCenter.
        }

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
