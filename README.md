# Fingerprint-Auth-Sample
Add Fingerprint Authentication to Android application</br>

This kotlin library provides an easy way to implement fingerprint authentication without having to deal with all the boilerplate stuff going on inside.

<img src="https://img.shields.io/badge/API-23%2B-blue.svg?style=flat" style="max-width:100%;" alt="API" data-canonical-src="https://img.shields.io/badge/API-23%2B-blue.svg?style=flat" style="max-width:100%;">


<p><a href="https://github.com/rahulabrol/Android-Fingerprint/blob/master/screenshots/image.jpeg" target="_blank"><img src="https://github.com/rahulabrol/Android-Fingerprint/blob/master/screenshots/image.jpeg" width="250" style="max-width:100%;"></a></p>
</br></br></br>



<h2>How to integrate the library in your app?</h2>
<b>Gradle Dependency</b></br>

```gradle
dependencies {
        implementation 'com.github.rahulabrol:Android-Fingerprint:1.0.2'
}
```

<h2>Usage</h2>

```
FingerprintManager.FingerprintBuilder(this)
                    .setTitle(Add your title)
                    .setSubtitle(Add your subtitle)
                    .setDescription(Add your description)
                    .setNegativeButtonText(Add button text)
                    .build().authenticate(this)
```

The ```FingerprintCallback``` class has the following callback methods:

```
object :FingerprintCallback{
                override fun onSdkVersionNotSupported() {
                    /*
                     *  Will be called if the device sdk version does not support Fingerprint authentication
                     */
                }

                override fun onBiometricAuthenticationNotSupported() {
                     /*
                      *  Will be called if the device does not contain any fingerprint sensors
                      */
                }

                override fun onBiometricAuthenticationNotAvailable() {
                    /*
                     *  The device does not have any fingerprint registered in the device.
                     */
                }

                override fun onBiometricAuthenticationPermissionNotGranted() {
                      /*
                       *  android.permission.USE_BIOMETRIC permission is not granted to the app
                       */
                }

                override fun onBiometricAuthenticationInternalError(error: String?) {
                     /*
                      *  This method is called if one of the fields such as the title, subtitle,
                      * description or the negative button text is empty
                      */
                }

                override fun onAuthenticationFailed() {
                      /*
                       * When the fingerprint doesn’t match with any of the fingerprints registered on the device,
                       * then this callback will be triggered.
                       */
                }

                override fun onAuthenticationCancelled() {
                       /*
                        * The authentication is cancelled by the user.
                        */
                }

                override fun onAuthenticationSuccessful() {
                        /*
                         * When the fingerprint is has been successfully matched with one of the fingerprints
                         * registered on the device, then this callback will be triggered.
                         */
                }

                override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                         /*
                          * This method is called when a non-fatal error has occurred during the authentication
                          * process. The callback will be provided with an help code to identify the cause of the
                          * error, along with a help message.
                          */
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                         /*
                          * When an unrecoverable error has been encountered and the authentication process has
                          * completed without success, then this callback will be triggered. The callback is provided
                          * with an error code to identify the cause of the error, along with the error message.
                          */
                }
            }

```


