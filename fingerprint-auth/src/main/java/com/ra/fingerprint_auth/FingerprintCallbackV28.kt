package com.ra.fingerprint_auth

import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Created by Rahul Abrol on 7/1/20.
 */
@RequiresApi(api = Build.VERSION_CODES.P)
class FingerprintCallbackV28(private val fingerprintCallback: FingerprintCallback) : BiometricPrompt.AuthenticationCallback() {
    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
        super.onAuthenticationSucceeded(result)
        fingerprintCallback.onAuthenticationSuccessful()
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
        super.onAuthenticationHelp(helpCode, helpString)
        fingerprintCallback.onAuthenticationHelp(helpCode, helpString)
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        super.onAuthenticationError(errorCode, errString)
        fingerprintCallback.onAuthenticationError(errorCode, errString)
    }

    override fun onAuthenticationFailed() {
        super.onAuthenticationFailed()
        fingerprintCallback.onAuthenticationFailed()
    }

}