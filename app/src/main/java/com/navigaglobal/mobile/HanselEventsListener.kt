package com.navigaglobal.mobile
import com.netcore.android.Smartech
import io.hansel.ujmtracker.HanselInternalEventsListener
import java.lang.ref.WeakReference
import com.google.firebase.analytics.FirebaseAnalytics
import android.content.Context
import android.os.Bundle

class HanselEventsListener() : HanselInternalEventsListener {

    // Implements
    override fun onEvent(eventName: String?, datafromhansel: HashMap<*, *>?) {
        val context = datafromhansel?.get("context") as? android.content.Context

        val firebaseAnalytics = context?.let { FirebaseAnalytics.getInstance(it) }

        when (eventName) {

            "hansel_nudge_show_event" -> {
                Smartech.getInstance(WeakReference(context)).trackEvent(eventName, datafromhansel as HashMap<String, Any>?)
                // Log event to Firebase Analytics
                if (firebaseAnalytics != null) {

                    firebaseAnalytics.logEvent(eventName, hashMapToBundle(datafromhansel as HashMap<String, Any>?))
                }
            }
            "hansel_nudge_event" -> {
                Smartech.getInstance(WeakReference(context)).trackEvent(eventName, datafromhansel as HashMap<String, Any>?)
                // Log event to Firebase Analytics
                if (firebaseAnalytics != null) {


                    firebaseAnalytics.logEvent(eventName, hashMapToBundle(datafromhansel as HashMap<String, Any>?))

                }
            }
            "hansel_branch_tracker" -> {
                Smartech.getInstance(WeakReference(context)).trackEvent(eventName, datafromhansel as HashMap<String, Any>?)
                // Log event to Firebase Analytics
                if (firebaseAnalytics != null) {

                    firebaseAnalytics.logEvent(eventName, hashMapToBundle(datafromhansel as HashMap<String, Any>?))
                }
            }
        }
    }

    private fun hashMapToBundle(data: HashMap<String, Any>?): Bundle {
        val bundle = Bundle()
        if (data != null) {
            for ((key, value) in data) {
                if (key is String && value is String) {
                    bundle.putString(key, value)
                }
            }
        }
        return bundle
    }
}

