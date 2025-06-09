
#include <jni.h>
#include <android/log.h>

#define TAG "early_init"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__)

__attribute__((constructor))
void early_init() {
    LOGI("Native early_init constructor called before Application");
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_com_secure_earlyinit_EarlyInitProvider_nativeCheckSecureBoot(JNIEnv *, jclass) {
    LOGI("JNI secure boot check running...");
    return JNI_TRUE;
}
