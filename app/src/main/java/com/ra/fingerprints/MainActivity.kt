package com.ra.fingerprints

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ra.fingerprint_auth.FingerprintCallback
import com.ra.fingerprint_auth.FingerprintManager

/**
 * Created by Rahul Abrol on 7/1/20.
 */
class MainActivity : AppCompatActivity(), FingerprintCallback {

    private var fingerprintAuth: FingerprintManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_authenticate).setOnClickListener {
            fingerprintAuth = FingerprintManager.FingerprintBuilder(this@MainActivity)
                    .setTitle(getString(R.string.fingerprint_title))
                    .setSubtitle(getString(R.string.fingerprint_subtitle))
                    .setDescription(getString(R.string.fingerprint_description))
                    .setNegativeButtonText(getString(R.string.fingerprint_negative_button_text))
                    .build()
            //start authentication
            fingerprintAuth?.authenticate(object :FingerprintCallback{
                override fun onSdkVersionNotSupported() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onBiometricAuthenticationNotSupported() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onBiometricAuthenticationNotAvailable() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onBiometricAuthenticationPermissionNotGranted() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onBiometricAuthenticationInternalError(error: String?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAuthenticationFailed() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAuthenticationCancelled() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAuthenticationSuccessful() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
    }

    override fun onSdkVersionNotSupported() {
        Toast.makeText(applicationContext, getString(R.string.fingerprint_error_sdk_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(applicationContext, getString(R.string.fingerprint_error_hardware_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotAvailable() {
        Toast.makeText(applicationContext, getString(R.string.fingerprint_error_fingerprint_not_available), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(applicationContext, getString(R.string.fingerprint_error_permission_not_granted), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationInternalError(error: String?) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationFailed() {
        //        Toast.makeText(getApplicationContext(), getString(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationCancelled() {
        Toast.makeText(applicationContext, getString(R.string.fingerprint_cancelled), Toast.LENGTH_LONG).show()
        fingerprintAuth?.cancelAuthentication()
    }

    override fun onAuthenticationSuccessful() {
        Toast.makeText(applicationContext, getString(R.string.fingerprint_success), Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
        //        Toast.makeText(getApplicationContext(), helpString, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
        //        Toast.makeText(getApplicationContext(), errString, Toast.LENGTH_LONG).show();
    }
}