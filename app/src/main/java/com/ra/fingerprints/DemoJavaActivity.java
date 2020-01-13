//package com.ra.fingerprints;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.ra.fingerprint_auth.FingerprintCallback;
//import com.ra.fingerprint_auth.FingerprintManager;
//
//import org.jetbrains.annotations.Nullable;
//
//public class DemoJavaActivity extends AppCompatActivity implements FingerprintCallback {
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        new FingerprintManager.FingerprintBuilder(this)
//                .setTitle("asa")
//                .setSubtitle("")
//                .setDescription("")
//                .setNegativeButtonText("Cancel")
//                .build().authenticate(this);
//    }
//
//    @Override
//    public void onSdkVersionNotSupported() {
//
//    }
//
//    @Override
//    public void onBiometricAuthenticationNotSupported() {
//
//    }
//
//    @Override
//    public void onBiometricAuthenticationNotAvailable() {
//
//    }
//
//    @Override
//    public void onBiometricAuthenticationPermissionNotGranted() {
//
//    }
//
//    @Override
//    public void onBiometricAuthenticationInternalError(@Nullable String error) {
//
//    }
//
//    @Override
//    public void onAuthenticationFailed() {
//
//    }
//
//    @Override
//    public void onAuthenticationCancelled() {
//
//    }
//
//    @Override
//    public void onAuthenticationSuccessful() {
//
//    }
//
//    @Override
//    public void onAuthenticationHelp(int helpCode, @Nullable CharSequence helpString) {
//
//    }
//
//    @Override
//    public void onAuthenticationError(int errorCode, @Nullable CharSequence errString) {
//
//    }
//}
