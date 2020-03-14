package com.example.ngcommunityapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.ngcommunityapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InviteToLiveFragment extends Fragment {

    public InviteToLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invite_to_live, container, false);
    }
}
