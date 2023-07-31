package com.example.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

public class MyService  extends AccessibilityService {
    private static final String TAG = "MyService";
    boolean control = false;
    
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Log.d(TAG, "onAccessibilityEvent: ");

        if (accessibilityEvent.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {

            AccessibilityNodeInfo interactedNodeInfo = accessibilityEvent.getSource();
            System.out.println("interacted node info : " + interactedNodeInfo);
            CharSequence textClickedButton = interactedNodeInfo.getText();

            if (interactedNodeInfo.getText().equals("POWER") && interactedNodeInfo.getClassName().equals("android.widget.Button")){
                performGlobalAction(AccessibilityService.GLOBAL_ACTION_POWER_DIALOG);
            }
        }
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "onInterrupt: ");


    }

}

