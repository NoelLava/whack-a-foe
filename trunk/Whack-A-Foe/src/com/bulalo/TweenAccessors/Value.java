//wrapper class for one float. We create this because only 
//Objects can be tweened (primitives cannot). So, to tween a 
//float, we must create a class for it.
 
package com.bulalo.TweenAccessors;

public class Value {

    private float val = 1;

    public float getValue() {
        return val;
    }

    public void setValue(float newVal) {
        val = newVal;
    }

}
