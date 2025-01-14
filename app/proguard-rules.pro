# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-keepattributes Signature
-keepattributes Annotation
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep class com.insurtech.kanguro.domain** { *; }
-keep class com.insurtech.kanguro.core.api** { *; }

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}

-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# Haroldadmin Adapter
-keep class com.haroldadmin.cnradapter** { *; }

# Moshi
-keep class com.insurtech.kanguro.networking.di.MoshiJWTAdapter { *; }

-keepclassmembers class * {
  @com.squareup.moshi.FromJson *;
  @com.squareup.moshi.ToJson *;
}

# Gson
-dontwarn com.auth0.android.jwt.JWT$**
-keep class com.auth0.** { *; }
-keep class com.google.gson.** { *; }

-keep class androidx.constraintlayout.motion.widget.** { *; }
