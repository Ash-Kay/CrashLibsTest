package io.ashkay.crashlibstest

import android.app.Application
import com.instabug.library.Instabug
import com.instabug.library.invocation.InstabugInvocationEvent

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
}