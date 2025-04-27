package kz.sapasoft.emark.app.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import com.example.decompiledapk.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class UsbReceiver(private val activity: MainActivity) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        Log.e("SCAN_MARKER", "action ----> $action")
        Log.e("SCAN_MARKER", "data ----> ${intent.data}")
        when (action) {
            activity.ACTION_USB_PERMISSION -> {
                if (intent.getBooleanExtra("permission", false)) {
                    Log.e("SCAN_MARKER", "EXTRA_PERMISSION_GRANTED ----> onNewDeviceAttached")
                    activity.deviceListener?.onNewDeviceAttached()
                } else {
                    Log.e("SCAN_MARKER", "EXTRA_PERMISSION_NOT_GRANTED ----> usb_permission_rejected")
                    val navView = activity.findViewById<BottomNavigationView>(R.id.nav_view)
                    Snackbar.make(
                        navView as View,
                        activity.getString(kz.ss.emark.R.string.usb_permission_rejected),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }

            "android.hardware.usb.action.USB_DEVICE_ATTACHED" -> {
                Log.e("SCAN_MARKER", "ACTION_USB_DEVICE_ATTACHED")
                activity.requestPermission()
            }

            "android.hardware.usb.action.USB_DEVICE_DETACHED" -> {
                Log.e("SCAN_MARKER", "ACTION_USB_DEVICE_DETACHED")
            }
        }
    }
}