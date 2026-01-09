package com.example.bayinnah;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ScoreFragment extends Fragment {
    private TextView scoreText;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView scoreImage;
    private ImageView scoreImage2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScoreFragment newInstance(String param1, String param2) {
        ScoreFragment fragment = new ScoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.congrats);
        MediaPlayer mediaPlayer2 = MediaPlayer.create(getActivity(), R.raw.badscore);
        Button backButton = view.findViewById(R.id.button2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the current fragment and navigate back to the previous fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(ScoreFragment.this).commit();
                fragmentManager.popBackStack();
            }


        });

        Button homeButton = view.findViewById(R.id.button3);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the current fragment and navigate back to the previous fragment
                Intent i = new Intent(getActivity(), MainPageActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });


        scoreText = view.findViewById(R.id.score_text_view);
        scoreImage = view.findViewById(R.id.score_view);
        scoreImage2 = view.findViewById(R.id.imageView3);

        // Get the score from the arguments
        int score = getArguments().getInt("score");

        // Display the score
        scoreText.setText("" + score);
        if (score == 0) {
            scoreImage.setImageResource(R.drawable.stars0);
        } else if (score >= 1 && score <= 5) {
            scoreImage.setImageResource(R.drawable.stars1);
        } else if (score >= 6 && score <= 9) {
            scoreImage.setImageResource(R.drawable.stars2);
        } else if (score == 10) {
            scoreImage.setImageResource(R.drawable.stars3);
        }
        // Add the onClickListener to the button
        if (score >= 6) {
            mediaPlayer.start();
            scoreImage2.setImageResource(R.drawable.congrats);
        } else {scoreImage2.setImageResource(R.drawable.crybad); mediaPlayer2.start();}

        // Return the inflated view with the score and button
        return view;
    }
}