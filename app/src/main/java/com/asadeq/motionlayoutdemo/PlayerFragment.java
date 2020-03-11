package com.asadeq.motionlayoutdemo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


public class PlayerFragment extends Fragment {


    private RecyclerView collapseView;

    public PlayerFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player, container, false);
    }
    MotionLayout motionLayout;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        collapseView = view.findViewById(R.id.collapseView);
        motionLayout = view.findViewById(R.id.motionLayout);
        motionLayout.loadLayoutDescription(R.xml.motion_scene);
        motionLayout.callOnClick();

        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {
                //Toast.makeText(getContext(), "onTransitionStarted", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
                //Toast.makeText(getContext(), "onTransitionChange", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                if (motionLayout.getCurrentState() == motionLayout.getEndState()){
                    Toast.makeText(getContext(), "Motion End State", Toast.LENGTH_SHORT).show();
                } else if (motionLayout.getCurrentState() == motionLayout.getStartState()){
                    Toast.makeText(getContext(), "Motion Start State", Toast.LENGTH_SHORT).show();
                    onMotionLayoutTransitionToStart();
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {
                Toast.makeText(getContext(), "onTransitionTrigger", Toast.LENGTH_SHORT).show();
               /* motionLayout.setLayoutParams(new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.MATCH_PARENT,
                        ConstraintLayout.LayoutParams.MATCH_PARENT));*/

            }
        });
        //final GestureDetector gestureDetector = new GestureDetector(getContext(), new OnSwipeGesture(this));

        OnSwipeGesture.getInstance(collapseView, new OnSwipeGesture.OnSwipeGestureListener() {
            @Override
            public void onSwipeUp() {
                Toast.makeText(getContext(), "Swipe to up", Toast.LENGTH_SHORT).show();
                onMotionLayoutTransitionToEnd();
            }
            @Override
            public void onClicked() {
                Toast.makeText(getContext(), "Single tap Confirmed.", Toast.LENGTH_SHORT).show();
                onMotionLayoutTransitionToEnd();
            }
            @Override
            public void onSwipeDown() {
                Toast.makeText(getContext(), "Swipe to down", Toast.LENGTH_SHORT).show();
                onMotionLayoutTransitionToStart();
            }
            @Override
            public void onDoubleClicked() {
                Toast.makeText(getContext(), "Double tap occurred.", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSwipeRight() {
                Toast.makeText(getContext(), "Swipe to right", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSwipeLeft() {
                Toast.makeText(getContext(), "Swipe to left", Toast.LENGTH_SHORT).show();
            }
        });

       /* collapseView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View mView, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    // single tap
//                    FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(FrameLayout.
//                            LayoutParams.MATCH_PARENT,71, Gravity.BOTTOM);
//                    params1.bottomMargin = 71;
//                    motionLayout.setLayoutParams(params1);
                    return true;
                } else {
                    // your code for move and drag
                    //Toast.makeText(getContext(), "onTouch recycler", Toast.LENGTH_SHORT).show();

//                    motionLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.
//                            LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.BOTTOM));
                }
                return false;
            }
        });*/
    }

    private void onMotionLayoutTransitionToEnd() {
        motionLayout.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT,
                Gravity.BOTTOM));
        motionLayout.setTransitionDuration(900);
        motionLayout.transitionToEnd();
    }
    private void onMotionLayoutTransitionToStart() {
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(collapseView.
                getMeasuredWidth(), collapseView.getMeasuredHeight(), Gravity.BOTTOM);
        params1.bottomMargin = 0;
        motionLayout.setLayoutParams(params1);
        //motionLayout.transitionToStart();
    }

  /*  @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
