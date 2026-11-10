package com.apexelectriccycles.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import com.google.androidbrowserhelper.trusted.ManageDataLauncherActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class StartupSmokeTest {
    @Test
    public void siteSettingsStartupWorksWithoutBrowser() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        // This invokes the startup path which threw IllegalArgumentException in 1.0.0:
        // the browser helper disables its settings Activity when the browser is unavailable.
        InstrumentationRegistry.getInstrumentation().runOnMainSync(
            () -> ManageDataLauncherActivity.addSiteSettingsShortcut(context, null));
    }

    @Test
    public void launcherStartsWithoutUncaughtException() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent launch = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        assertNotNull(launch);
        launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Activity activity = InstrumentationRegistry.getInstrumentation().startActivitySync(launch);
        assertNotNull(activity);
        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
        SystemClock.sleep(2000);
        InstrumentationRegistry.getInstrumentation().runOnMainSync(activity::finish);
    }
}
