# Jstr - Programming joke teller
Jstr is multi-project app for Android 4.0.3 (API 15) or newer that displays programming jokes retrieved from Google Cloud Endpoints server. The goal of this project is to demonstrate use of Gradle build tools to configure and compile an app that offers multiple flavours and uses multiple libraries.

**Project structure:**
<p align="center">
<img src="https://user-images.githubusercontent.com/15446842/32072335-23423668-ba8a-11e7-88df-b5f7eee995cf.png" width="66%" align="center"/>
</p>
The project consists of following modules:

1. A Java library that provides jokes
2. A Google Cloud Endpoints (GCE) project that serves those jokes
3. An Android Library containing an activity for displaying jokes
4. An Android app that fetches jokes from the GCE module and passes them to the Android Library for display

**Main Features:**
* The app offers two product flavours:
  - Free version that shows banner and interstitial ads
  - Paid version with no ads and no unnecessary dependencies
* Jokes are loaded from Google Cloud Endpoints module via an `AsyncTask`
* Reusable functionality is factored into Android and Java libraries

## Try it out
To install the app on a connected device or running emulator, run:

```gradle
git clone https://github.com/mattwiduch/Jstr.git
cd Jstr
./gradlew appengineDeploy
./gradlew installFreeDebug
```

## License
```
Copyright (C) 2016 Mateusz Widuch

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
