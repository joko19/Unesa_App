package com.example.unesa.ui.developers;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.unesa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class developersFragment extends Fragment implements  View.OnClickListener{

    public developersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_developers, container, false);
        Button btnInstagram= v.findViewById(R.id.btn_instagram);
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.instagram.com"));
                startActivity(intent);
            }
        });

        Button btnGmail= v.findViewById(R.id.btn_gmail);
        btnGmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"joko.18030@mhs.unesa.ac.id"});

                try {
                    startActivity(Intent.createChooser(intent, "Want to Send Email ?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    //do something else
                }
            }
        });

        Button btnLinkedin= v.findViewById(R.id.btn_linkedin);
        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.linkedin.com/"));
                startActivity(intent);
            }
        });

        Button btnGithub= v.findViewById(R.id.btn_github);
        btnGithub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/joko19"));
                startActivity(intent);
            }
        });




        Button btnLinkedin2= v.findViewById(R.id.btn_linkedin2);
        btnLinkedin2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.linkedin.com/in/mar-atul-bariroh-979073189/"));
                startActivity(intent);
            }
        });

        Button btnGithub2= v.findViewById(R.id.btn_github2);
        btnGithub2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://github.com/missmb"));
                startActivity(intent);
            }
        });

        Button btnInstagram2= v.findViewById(R.id.btn_instagram2);
        btnInstagram2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/maratulbariroh3630/?hl=id"));
                startActivity(intent);
            }
        });

        Button btnGmail2= v.findViewById(R.id.btn_gmail2);
        btnGmail2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"maratul.18016@mhs.unesa.ac.id"});

                try {
                    startActivity(Intent.createChooser(intent, "Want to Send Email ?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    //do something else
                }
            }
        });

        return v;
    }

    @Override
    public void onClick(View view) {

    }
}
