package vasyl.fullinterfacepip;

import android.os.SystemProperties;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class HookEntry implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        // Hook will apply only for the front app
        if (lpparam.packageName.contains("com.android.launcher66")) {
            return; 
        }

        String pipAppPackageName = SystemProperties.get("persist.launcher.packagename", "");
        if (pipAppPackageName.isEmpty() || !pipAppPackageName.equals(lpparam.packageName)) {
            return;
        }

        if (!"com.google.android.apps.maps".equals(lpparam.packageName)) {
            return;
        }
        
        XposedBridge.log("HookEntry: Hook active for " + lpparam.packageName);

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "enterPictureInPictureMode",
                XC_MethodReplacement.returnConstant(false)
            );
            XposedBridge.log("HookEntry: Hooked enterPictureInPictureMode()");
        } catch (Throwable t) {
            XposedBridge.log("HookEntry: Failed hooking enterPictureInPictureMode: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "onPictureInPictureRequested",
                XC_MethodReplacement.returnConstant(false)
            );
            XposedBridge.log("HookEntry: Hooked onPictureInPictureRequested()");
        } catch (Throwable t) {
            XposedBridge.log("HookEntry: Failed hooking onPictureInPictureRequested: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "isInPictureInPictureMode",
                XC_MethodReplacement.returnConstant(false)
            );
            XposedBridge.log("HookEntry: Hooked isInPictureInPictureMode()");
        } catch (Throwable t) {
            XposedBridge.log("HookEntry: Failed hooking isInPictureInPictureMode: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "onPictureInPictureModeChanged",
                boolean.class,
                XC_MethodReplacement.DO_NOTHING
            );
            XposedBridge.log("HookEntry: Hooked onPictureInPictureModeChanged()");
        } catch (Throwable t) {
            XposedBridge.log("HookEntry: Failed hooking onPictureInPictureModeChanged: " + t);
        }

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.Activity",
                lpparam.classLoader,
                "onUserLeaveHint",
                XC_MethodReplacement.DO_NOTHING
            );
            XposedBridge.log("HookEntry: Hooked onUserLeaveHint()");
        } catch (Throwable t) {
            XposedBridge.log("HookEntry: Failed hooking onUserLeaveHint: " + t);
        }
    }
}