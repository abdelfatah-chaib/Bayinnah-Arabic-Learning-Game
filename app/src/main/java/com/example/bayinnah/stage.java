package com.example.bayinnah;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link stage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class stage extends Fragment {
    private int score1;
    private ImageView lockImage;
    private ImageView lockImage3;
    private ImageView lockImage4;
    private ImageView lockImage5;
    private ImageView lockImage6;
    private ImageView lockImage7;


    private int score2;
    private int score3;
    private int score4;
    private int score5;
    private int score6;
    private int score7;
    private Cursor cursor;
    private SQLiteDatabase quizDb;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public stage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment stage.
     */
    // TODO: Rename and change types and number of parameters
    public static stage newInstance(String param1, String param2) {
        stage fragment = new stage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stage, container, false);
        lockImage = view.findViewById(R.id.imageView2);
        lockImage3 = view.findViewById(R.id.imageView9);
        lockImage4 = view.findViewById(R.id.imageView5);
        lockImage5 = view.findViewById(R.id.imageView10);
        lockImage6 = view.findViewById(R.id.imageView7);
        lockImage7 = view.findViewById(R.id.imageView11);
        QuizDatabaseHelper quizDbHelper = new QuizDatabaseHelper(getActivity());
        quizDb = quizDbHelper.getWritableDatabase();
        // Get a reference to the SQLite database
        SQLiteDatabase db = quizDbHelper.getReadableDatabase();

        // Define the query to retrieve the score where stage=1
        String query = "SELECT score FROM level_score WHERE stage=1";

        // Execute the query and get a cursor to the results
        cursor = db.rawQuery(query, null);

        // Check if the cursor has any results
        if (cursor.moveToFirst()) {
            // Retrieve the score value from the cursor
            score1 = cursor.getInt(0);
            // Do something with the score1 value here
        }


        String query2 = "SELECT score FROM level_score WHERE stage=2";

        // Execute the query and get a cursor to the results
        cursor = db.rawQuery(query2, null);

        // Check if the cursor has any results
        if (cursor.moveToFirst()) {
            // Retrieve the score value from the cursor
            score2 = cursor.getInt(0);
            // Do something with the score1 value here
        }


        String query3 = "SELECT score FROM level_score WHERE stage=3";

        // Execute the query and get a cursor to the results
        cursor = db.rawQuery(query3, null);

        // Check if the cursor has any results
        if (cursor.moveToFirst()) {
            // Retrieve the score value from the cursor
            score3 = cursor.getInt(0);
            // Do something with the score1 value here
        }

        String query4 = "SELECT score FROM level_score WHERE stage=4";

        // Execute the query and get a cursor to the results
        cursor = db.rawQuery(query4, null);

        // Check if the cursor has any results
        if (cursor.moveToFirst()) {
            // Retrieve the score value from the cursor
            score4 = cursor.getInt(0);
            // Do something with the score1 value here
        }

        String query5 = "SELECT score FROM level_score WHERE stage=5";

        // Execute the query and get a cursor to the results
        cursor = db.rawQuery(query5, null);

        // Check if the cursor has any results
        if (cursor.moveToFirst()) {
            // Retrieve the score value from the cursor
            score5 = cursor.getInt(0);
            // Do something with the score1 value here
        }


        String query6 = "SELECT score FROM level_score WHERE stage=6";

        // Execute the query and get a cursor to the results
        cursor = db.rawQuery(query6, null);

        // Check if the cursor has any results
        if (cursor.moveToFirst()) {
            // Retrieve the score value from the cursor
            score6 = cursor.getInt(0);
            // Do something with the score1 value here
        }

        // Close the cursor and database connection
        cursor.close();
        db.close();
        ImageButton button1 = view.findViewById(R.id.stage1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                categories q1Fragment = new categories();
                fragmentTransaction.replace(R.id.fragment_container, q1Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ImageButton button2 = view.findViewById(R.id.stage2);
        if (score1 < 6) {
            button2.setEnabled(false);
            lockImage.setImageResource(R.drawable.lock);
        } else {
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    categorieStage2 q2Fragment = new categorieStage2();
                    fragmentTransaction.replace(R.id.fragment_container, q2Fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }
        ImageButton button3 = view.findViewById(R.id.stage3);
        if (score2 < 6) {
            button3.setEnabled(false);
            lockImage3.setImageResource(R.drawable.lock);
        }
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                categorieStage3 q3Fragment = new categorieStage3();
                fragmentTransaction.replace(R.id.fragment_container, q3Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ImageButton button4 = view.findViewById(R.id.stage4);
        if (score3 < 6) {
            button4.setEnabled(false);
            lockImage4.setImageResource(R.drawable.lock);
        }
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                categorieStage4 q4Fragment = new categorieStage4();
                fragmentTransaction.replace(R.id.fragment_container, q4Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ImageButton button5 = view.findViewById(R.id.stage5);
        if (score4 < 6) {
            button5.setEnabled(false);
            lockImage5.setImageResource(R.drawable.lock);
        }
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                categorieStage5 q5Fragment = new categorieStage5();
                fragmentTransaction.replace(R.id.fragment_container, q5Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ImageButton button6 = view.findViewById(R.id.stage6);
        if (score5 < 6) {
            button6.setEnabled(false);
            lockImage6.setImageResource(R.drawable.lock);
        }
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                categorieStage6 q6Fragment = new categorieStage6();
                fragmentTransaction.replace(R.id.fragment_container, q6Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ImageButton button7 = view.findViewById(R.id.stage7);
        if (score6 < 6) {
            button7.setEnabled(false);
            lockImage7.setImageResource(R.drawable.lock);
        }
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                categorieStage7 q7Fragment = new categorieStage7();
                fragmentTransaction.replace(R.id.fragment_container, q7Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        // add click listeners to other buttons using switch statement

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_stage, container, false);
    }
}