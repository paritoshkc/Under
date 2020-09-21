# Under
## Overview

This is an Journey Sharing Application developed by Group 4 of CS7NS3 2019-2020 at Trinity College, Dublin.

## Requirements

- Android Studio (recommended: v3.6.2)
- Android SDK (minimum version: 22)
- Java Development Kit (minimum version: 1.8, optional*)

Both the above requirements can be obtained [here](https://developer.android.com/studio).

Please ensure that you have all required dependencies installed and can run a sample "Hello, World!"
application before continuing.

* Note: Android Studio includes a bundled JDK, but can be configured to use a different one if necessary.

## Building and running in Android Studio (recommended)
 - Open the project in Android Studio.
 - Ensure the Gradle dependencies are updated. This may take a while.
 - The application can be started by:
    - Connecting the target device to the system
    - Selecting it in Android Studio in the top-right menu
    - Clicking the "run" option

The application will be automatically started on the device.

If an emulator is used as target option it should have been configured and then selected as
target before building the application.

Please also note that this application uses libraries which require physical devices to function properly,
and may therefore not function as intended in an emulated environment.

The application is supported on devices running Android version 5.1 and above (API level 22).


## Building without Android Studio

*Note: the below steps can also be accomplished in e.g. Android Studio* 

 - Clone the git repository:
 ```shell script
git clone gitlab.com:ase-under/under
``` 

 - Run the unit tests:
 ```shell script
./gradlew clean test
```

 - Build the APK (written to `./app/build/outputs/apk/debug/app-debug.apk`):
 ```shell script
./gradlew assembleDebug
``` 

 - Install the APK on a connected device:
 ```shell script
./gradlew installDebug
```
 
## Authors

- [Paritosh Chauhan](mailto:chauhapa@tcd.ie)
- [Chavvi Chandani](mailto:chandanc@tcd.ie)
- [Kanika Ghiloria](mailto:ghilorik@tcd.ie)
- [Cian Johnston](mailto:johnstc@tcd.ie)
- [Vishal Kumar](mailto:kumarv1@tcd.ie)
- [Piyush Mankad](mailto:mankadp@tcd.ie)
- [Stefan Spirkl](mailto:spirkls@tcd.ie)
- [Ashwin Sundareswaran](mailto:ramasuba@tcd.ie)
