package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class UpperSectionFragments extends Fragment {       // extends Fragment (to use fragment layout)

    private static EditText upperTextInput;
    private static EditText lowerTextInput;

    // interface & implementation for a listener for transferring data to activity and thence maybe another fragment (i.e. not directly!)
    UpperSectionListener activityCommander;     // interface UpperSectionListener defined inline below

    public interface UpperSectionListener
    {
        public void createMeme(String upper, String lower);
        // 'promise' to create a method to accept text and transfer data to activity & other fragment
        // nested interface - association
        // implementation of createMeme found in main activity
        // ... which is now set to be implementing UpperSectionListener
    }

    // Alt+Insert to code-generate/start override implentation


    @Override
    public void onAttach(Context context) {
        // called when fragment first attached to activity - Context is a superclass of Activity (see doc link below)
        // NB main activity implements'ing UpperSectionFragments.UpperSectionListener - cf 29
        super.onAttach(context);
//        try
//        {
//            activityCommander = (UpperSectionListener) activity;
//        }
//        catch (ClassCastException e)
//        {
//            throw new ClassCastException(activity.toString());
//        }
        // NB onAttach(Activity activity) deprecated, replaced by onAttach(Context context)
        // as per https://developer.android.com/reference/android/support/v4/app/Fragment.html#onattach_1

        // edited from video original as per YouTube comment (!)

        if (context instanceof UpperSectionListener)
        {
            activityCommander = (UpperSectionListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.top_section_rel_fragment, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);     // this part was boilerplate

        upperTextInput = view.findViewById(R.id.upperTextInput);
        lowerTextInput = view.findViewById(R.id.lowerTextInput);
        final Button button = view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener()      // NB capital case!
                {
                    public void onClick(View v) // NB camel case!
                    {
                        buttonClicked(v);       // use our bespoke function/method
                    }
                }
        );

        return view;        // return fragment layout defined in design or in xml
    }

    // bespoke function/method to call when listener detected button clicked
    public void buttonClicked(View view)
    {
        activityCommander.createMeme(upperTextInput.getText().toString(), lowerTextInput.getText().toString());     // communicating activity/fragment
    }




}
