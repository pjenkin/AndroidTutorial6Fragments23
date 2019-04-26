package com.example.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UpperSectionFragments extends Fragment {       // extends Fragment (to use fragment layout)


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.top_section_rel_fragment, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);     // this part was boilerplate
        return view;        // return fragment layout defined in design or in xml
    }




}
