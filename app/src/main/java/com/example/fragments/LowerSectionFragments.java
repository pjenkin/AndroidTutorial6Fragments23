package com.example.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class LowerSectionFragments extends Fragment {

    private static EditText upperMemeText;  // = findByViewId(R.id.upper_text)
    private static EditText lowerMemeText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);

        upperMemeText = view.findViewById(R.id.upper_text);
        lowerMemeText = view.findViewById(R.id.lower_text);

        return view;
    }

    // bespoke function
    public void setMemeText(String top, String bottom)
    {
        upperMemeText.setText(top);
        lowerMemeText.setText(bottom);
    }

}
