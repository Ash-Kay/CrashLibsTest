package io.ashkay.crashlibstest

import android.app.Application
import android.content.Context
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent
import org.acra.BuildConfig
import org.acra.config.toast
import org.acra.data.StringFormat
import org.acra.ktx.initAcra

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Instabug.Builder(this, "ccd11c1342dce33bf0752b737bf85e36")
            .setInvocationEvents(
                InstabugInvocationEvent.SHAKE,
                InstabugInvocationEvent.FLOATING_BUTTON
            )
            .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

        initAcra {
            //core configuration:
            buildConfigClass = BuildConfig::class.java
            reportFormat = StringFormat.JSON
            //each plugin you chose above can be configured in a block like this:
            toast {
                text = getString(R.string.acra_toast_text)
            }
        }
    }
}