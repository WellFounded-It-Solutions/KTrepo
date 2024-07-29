package com.navigaglobal.mobile

import com.chartbeat.androidsdk.Tracker
import com.netcore.android.Smartech
import dagger.hilt.android.HiltAndroidApp
import io.hansel.core.logger.HSLLogLevel
import io.hansel.ujmtracker.HanselTracker
import se.infomaker.frt.CoreApp
import java.lang.ref.WeakReference
import android.content.Context
import com.applovin.sdk.AppLovinMediationProvider
import com.applovin.sdk.AppLovinSdk
import com.applovin.sdk.AppLovinSdkInitializationConfiguration
//import com.applovin.sdk.AppLovinUserSegment

/**
 * Custom Application class to trigger Hilt code generation using the [HiltAndroidApp] annotation.
 */
//@HiltAndroidApp
//class App : CoreApp()

@HiltAndroidApp
class App : CoreApp() {

    override fun onCreate() {

        super.onCreate()

        initializeSmartechSdk()
//        initializeChartbeat()
        initializeFreestar()
    }

    private fun initializeChartbeat() {
        val chartbeatAccountId = "66153"
        val chartbeatSiteId = "khaleejtimes.com"

        Tracker.setupTracker(chartbeatAccountId, chartbeatSiteId, this);

        Tracker.trackView(
            baseContext, // Context for the current view
            "main_activity", // View ID
            "Main Activity", // View Title
        );
    }

    private fun initializeFreestar() {
        val initConfig = AppLovinSdkInitializationConfiguration.builder("hO52kFtMvEo_AoeRzED0_XXfS1B1VQp9GW50yudJO-eUUTOmRBLl3c-2GyTevLNspll_fN5PLTbAHOakoTuHuP", this)
            .setMediationProvider(AppLovinMediationProvider.MAX)
            .build()

        AppLovinSdk.getInstance(this).initialize(initConfig) { sdkConfig ->
            // Start loading ads
        }
    }

    private fun initializeSmartechSdk() {
        Smartech.getInstance(WeakReference(applicationContext)).initializeSdk(this)

        Smartech.getInstance(WeakReference(applicationContext)).trackAppInstallUpdateBySmartech()

        Smartech.getInstance(WeakReference(applicationContext)).setDebugLevel(9)
        HSLLogLevel.all.isEnabled = true
        HSLLogLevel.mid.isEnabled = true
        HSLLogLevel.debug.isEnabled = true

        var hanseltracker = HanselEventsListener()

        HanselTracker.registerListener(hanseltracker)
    }
}