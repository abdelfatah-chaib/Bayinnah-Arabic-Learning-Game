package com.example.bayinnah;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AudioRecorder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AudioRecorder extends Fragment {
    private MediaRecorder mMediaRecorder;
    private String mAudioFilePath;
    private boolean mIsRecording = false;
    private MediaPlayer mMediaPlayer;
    private boolean mIsPlaying = false;
    private Button mRecordButton;
    private Button mPlayButton;
    private TextView mDurationTextView;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};
    private boolean permissionToRecordAccepted = false;
    private boolean isRecording = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AudioRecorder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AudioRecorder.
     */
    // TODO: Rename and change types and number of parameters
    public static AudioRecorder newInstance(String param1, String param2) {
        AudioRecorder fragment = new AudioRecorder();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), permissions, REQUEST_RECORD_AUDIO_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted) {
            getActivity().finish();
        }
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_audio_recorder, container, false);

        mRecordButton = view.findViewById(R.id.record_button);
        mRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsRecording) {
                    startRecording();
                } else {
                    stopRecording();
                }
            }
        });

        mPlayButton = view.findViewById(R.id.play_button);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsPlaying) {
                    startPlaying();
                } else {
                    stopPlaying();
                }
            }
        });

        //mDurationTextView = view.findViewById(R.id.duration_text_view);

        return view;
    }

    private void startRecording() {
        mRecordButton.setText("Stop");
        mAudioFilePath = getActivity().getExternalCacheDir().getAbsolutePath() + "/audio_recording.3gp";
        mMediaRecorder = new MediaRecorder();
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mMediaRecorder.setOutputFile(mAudioFilePath);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mMediaRecorder.prepare();
        } catch (IOException e) {
            Log.e("AudioRecorderFragment", "prepare() failed");
        }

        mMediaRecorder.start();
        mIsRecording = true;
    }

    private void stopRecording() {
        mRecordButton.setText("Record");
        mMediaRecorder.stop();
        mMediaRecorder.release();
        mMediaRecorder = null;
        mIsRecording = false;
    }

    private void startPlaying() {
        mPlayButton.setText("Stop");
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(mAudioFilePath);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlaying();
                }
            });
            mMediaPlayer.start();
            mIsPlaying = true;
        } catch (IOException e) {
            Log.e("AudioRecorderFragment", "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayButton.setText("Play");
        mMediaPlayer.release();
        mMediaPlayer = null;
        mIsPlaying = false;
    }
}