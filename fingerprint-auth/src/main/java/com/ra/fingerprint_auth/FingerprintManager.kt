package com.ra.fingerprint_auth

import android.annotation.TargetApi
import android.content.Context
import android.content.DialogInterface
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.CancellationSignal

/**
 * Created by Rahul Abrol on 7/1/20.
 */
class FingerprintManager protected constructor(fingerprintBuilder: FingerprintBuilder) : FingerprintManagerV23() {
    protected var mCancellationSignal = CancellationSignal()

    init {
        context = fingerprintBuilder.context
        title = fingerprintBuilder.title
        subtitle = fingerprintBuilder.subtitle
        description = fingerprintBuilder.description
        negativeButtonText = fingerprintBuilder.negativeButtonText
        icLauncher = fingerprintBuilder.icLauncher
    }

    fun authenticate(fingerprintCallback: FingerprintCallback) {
        if (title == null) {
            fingerprintCallback.onBiometricAuthenticationInternalError("Fingerprint Dialog title cannot be null")
            return
        }
        if (subtitle == null) {
            fingerprintCallback.onBiometricAuthenticationInternalError("Fingerprint Dialog subtitle cannot be null")
            return
        }
        if (description == null) {
            fingerprintCallback.onBiometricAuthenticationInternalError("Fingerprint Dialog description cannot be null")
            return
        }
        if (negativeButtonText == null) {
            fingerprintCallback.onBiometricAuthenticationInternalError("Fingerprint Dialog negative button text cannot be null")
            return
        }
        if (!FingerprintUtils.isSdkVersionSupported) {
            fingerprintCallback.onSdkVersionNotSupported()
            return
        }
        if (!FingerprintUtils.isPermissionGranted(context)) {
            fingerprintCallback.onBiometricAuthenticationPermissionNotGranted()
            return
        }
        if (!FingerprintUtils.isHardwareSupported(context)) {
            fingerprintCallback.onBiometricAuthenticationNotSupported()
            return
        }
        if (!FingerprintUtils.isFingerprintAvailable(context)) {
            fingerprintCallback.onBiometricAuthenticationNotAvailable()
            return
        }
        displayFingerprintDialog(fingerprintCallback)
    }

    fun cancelAuthentication() {
        if (FingerprintUtils.isBiometricPromptEnabled) {
            if (!mCancellationSignal.isCanceled) mCancellationSignal.cancel()
        } else {
            if (!mCancellationSignalV23.isCanceled) mCancellationSignalV23.cancel()
        }
    }

    private fun displayFingerprintDialog(fingerprintCallback: FingerprintCallback) {
        if (FingerprintUtils.isBiometricPromptEnabled) {
            displayFingerprintPrompt(fingerprintCallback)
        } else {
            displayFingerprintPromptV23(fingerprintCallback)
        }
    }

    @TargetApi(Build.VERSION_CODES.P)
    private fun displayFingerprintPrompt(fingerprintCallback: FingerprintCallback) {
        BiometricPrompt.Builder(context)
                .setTitle(title!!)
                .setSubtitle(subtitle!!)
                .setDescription(description!!)
                .setNegativeButton(negativeButtonText!!, context!!.mainExecutor,
                        DialogInterface.OnClickListener { _, _ -> fingerprintCallback.onAuthenticationCancelled() })
                .build()
                .authenticate(mCancellationSignal, context!!.mainExecutor,
                        FingerprintCallbackV28(fingerprintCallback))
    }

    class FingerprintBuilder(val context: Context) {
        var title: String = ""
        var subtitle: String = ""
        var description: String = ""
        var negativeButtonText: String = ""
        var icLauncher: Int? = null

        fun setTitle(title: String): FingerprintBuilder {
            this.title = title
            return this
        }

        fun setSubtitle(subtitle: String): FingerprintBuilder {
            this.subtitle = subtitle
            return this
        }

        fun setDescription(description: String): FingerprintBuilder {
            this.description = description
            return this
        }

        fun setNegativeButtonText(negativeButtonText: String): FingerprintBuilder {
            this.negativeButtonText = negativeButtonText
            return this
        }

        fun build(): FingerprintManager {
            return FingerprintManager(this)
        }

        fun setAppIcon(icLauncher: Int): FingerprintBuilder {
            this.icLauncher = icLauncher
            return this
        }

    }
}