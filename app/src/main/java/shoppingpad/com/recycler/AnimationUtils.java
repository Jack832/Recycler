package shoppingpad.com.recycler;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by bridgelabz5 on 1/2/16.
 */
public class AnimationUtils {

//    private static int counter = 0;

//    public static void scaleXY(RecyclerView.ViewHolder holder) {
//        holder.itemView.setScaleX(0);
//        holder.itemView.setScaleY(0);
//
//        PropertyValuesHolder propx = PropertyValuesHolder.ofFloat("scaleX", 1);
//        PropertyValuesHolder propy = PropertyValuesHolder.ofFloat("scaleY", 1);
//
//        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(holder.itemView, propx, propy);
//
//
//        animator.setDuration(800);
//        animator.start();
//    }

    public static void animate(RecyclerView.ViewHolder holder,boolean goesDown) {

       AnimatorSet animatorSet = new AnimatorSet();

/*        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true
                                                ?300:-300,0);
        animatorTranslateY.setDuration(1000);
        animatorTranslateY.start();*/

        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(holder.itemView, "scaleX" ,0.5F, 0.8F, 1.0F);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(holder.itemView, "scaleY", 0.5F, 0.8F, 1.0F);
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown == true ? 300 : -300, 0);
        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", -50, 50, -30, 30, -20, 20, -5, 5, 0);
        animatorSet.playTogether(animatorTranslateX, animatorTranslateY, animatorScaleX, animatorScaleY);
        animatorSet.setInterpolator(new AnticipateInterpolator());
        animatorSet.setDuration(1000);
        animatorSet.start();

    }

    public static void animateToolbarDroppingDown(View containerToolbar) {

        containerToolbar.setRotationX(-90);
        containerToolbar.setAlpha(0.2F);
        containerToolbar.setPivotX(0.0F);
        containerToolbar.setPivotY(0.0F);
        Animator alpha = ObjectAnimator.ofFloat(containerToolbar, "alpha", 0.2F, 0.4F, 0.6F, 0.8F, 1.0F).setDuration(2000);
        Animator rotationX = ObjectAnimator.ofFloat(containerToolbar, "rotationX", -90, 60, -45, 45, -10, 30, 0, 20, 0, 5, 0).setDuration(2500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AnticipateInterpolator());
        animatorSet.playTogether(alpha, rotationX);
        animatorSet.start();
    }

}
