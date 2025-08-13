# Full Interface PiP for FYT devices

LSPosed module for FYT devices that blocks front app from entering minimal UI.

Google Maps switches its UI to minimal whenever user enters the Picture in Picture mode. FYT ROM offers a method that forces apps into PiP mode to display them on top of the launcher's main screen. It allows to "window" most of the apps, even these that do not support PiP at all. The negative aspect of this function is that it doesn't provide essential entry points maintaining the "full screen UI" for apps that do support the PiP mode.

The only reliable way I have found to prevent Google Maps (and similar) from switching its UI to minimal requires installed root, LSPosed and this LSPosed module. It successfully forces the app to maintain its full UI inside FYT's Picture in Picture.

Check this [XDA thread](https://xdaforums.com/t/kernel-fyt-7862-s-8581-optimized-root-prepared-magisk-edition.4610985/) if you want to root your device. Always do the full backup (AllAppUpdate.bin, config.txt etc.) before flashing anything!