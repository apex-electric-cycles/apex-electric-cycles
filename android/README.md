# Apex Electric Cycles for Android

Trusted Web Activity for https://apexelectriccycles.com/ using Google's Android Browser Helper 2.7.4. App ID: `com.apexelectriccycles.app`. Version 1.0.0, target SDK 36, minimum Android 7.0/API 24.

The installed app opens the current public website in a supporting browser without browser controls after Digital Asset Links verification. A browser without TWA support falls back to Custom Tabs. Email and external links remain handled by the browser/device. This does not add a booking backend, offline records or notifications. The website's request tools still prepare an email that the visitor must send.

## Build

Use JDK 17 or 21, the Android SDK (platform 36 and build-tools 36.0.0) and Gradle 8.13. With Android Studio, open this folder. From a shell, set ANDROID_HOME to your SDK and run `gradle assembleDebug` for a development APK.

For signed release builds, supply `APEX_KEYSTORE`, `APEX_STORE_PASSWORD`, `APEX_KEY_ALIAS` and `APEX_KEY_PASSWORD` in your environment, then run `gradle assembleRelease bundleRelease`. Never commit the signing key or passwords. Back them up privately; future direct APK updates require the same signing key and a higher versionCode.

## Website association

The public `dist/.well-known/assetlinks.json` contains the signing certificate fingerprint for the first directly installable release. Serve it as JSON on both apex and www hosts, over HTTPS without a redirect at this file path.

For Google Play App Signing, add the **app signing certificate** SHA-256 fingerprint from Play Console to the JSON in addition to the direct-install certificate. An upload-key certificate alone does not verify Play-installed apps. Redeploy and test before publishing. Do not use a Chrome verification-bypass flag as a release test.

## Validation and publishing

Build and signature checks are automated during preparation. Test the APK on a physical Android phone: launcher icon; root and www association; service menu; request generation; copy; email handoff; Facebook/Messenger; Back; rotation; offline notice and reconnect. Verify the site has been loaded online once before expecting its offline notice.

The AAB is a signed upload candidate, not an approved Play Store release. Complete account verification, store listing/screenshots, privacy policy and Data Safety declaration reflecting the live website, content rating and required testing. Assess Google's current functionality policies for this service website before submission. No Play account or publishing step is included in the build.
