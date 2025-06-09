# earlyinit
Basic App That Injects Shared Library Before App Constructor

# EarlyInit Android App with Native Startup Security Check (Initial Release)

## 🔐 Key Features

This version of the app was built to demonstrate secure execution of native C/C++ logic **before** any Android Java code (like `Application`) is executed. It is meant to work on a broad range of Android devices and scenarios.

### ✅ Highlights:
- Executes native logic via constructor in `.so` before Java startup
- Uses `ContentProvider` to hook pre-`Application` lifecycle
- Contains OpenSSL-based hashing logic
- Native integrity check of app binary (`base.apk`)
- Logs secure boot check points

---

## 🗂 Project Layout

FinalEarlyInitWithGradle/
├── app/
│ ├── src/main/
│ │ ├── java/com/secure/earlyinit/
│ │ ├── cpp/ # Native C++ code using OpenSSL
│ │ └── AndroidManifest.xml
│ ├── build.gradle
│ └── CMakeLists.txt
├── build.gradle
├── settings.gradle
├── gradle.properties

yaml
Copy
Edit

---

## 🧪 How It Works

1. `ContentProvider` defined in `AndroidManifest.xml` triggers before the `Application` constructor.
2. Native `.so` (`libearlyinit.so`) is loaded inside this provider.
3. A C++ constructor (`__attribute__((constructor))`) runs automatically on `.so` load.
4. Inside that constructor, early integrity checks are performed using OpenSSL:
   - Hashing the APK
   - Optionally checking signature or environment
5. Logs output via `__android_log_print()` before any UI or activity starts.

---

## 🛠 Build & Run

```bash
# Prerequisites:
- Android Studio with NDK and CMake support
- OpenSSL dev libraries for native compilation

# Build steps:
cd FinalEarlyInitWithGradle/
./gradlew clean assembleDebug

# Install:
adb install app/build/outputs/apk/debug/app-debug.apk
