package com.dating.app.idateu.Homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dating.app.idateu.R;

public class Pop_up_bio extends Fragment {

    int bioIndex;
    TextView bio;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bio_pop_up, container, false);
        bio = view.findViewById(R.id.bio_txt);
        bio.setText(R.string.bio_1);

    return view;}
}
