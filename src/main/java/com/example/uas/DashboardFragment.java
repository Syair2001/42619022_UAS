package com.example.uas;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DashboardFragment extends Fragment {
    private EditText mShareTextEditText;
    Button share_text_button,open_website_button;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        mShareTextEditText = (EditText) view.findViewById(R.id.sharetext);
        share_text_button = view.findViewById(R.id.button3);
        open_website_button = view.findViewById(R.id.button);

        share_text_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = mShareTextEditText.getText().toString();
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(getActivity())
                        .setType(mimeType)
                        .setChooserTitle("Share this text with: ")
                        .setText(txt)
                        .startChooser();
            }
        });
        open_website_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/Syair2001";
                Uri webpage = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else {
                    Log.d("Implicit Intents", "Cant't handle this!");
                }
            }
        });
        return  view;
    }
}