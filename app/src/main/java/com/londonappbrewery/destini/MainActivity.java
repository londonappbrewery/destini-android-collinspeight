package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button mButtonTop;
    private Button mButtonBottom;
    private TextView mStoryTextView;
    private int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryIndex = 3;
                    changeStory(R.string.T3_Ans1, R.string.T3_Ans2, R.string.T3_Story);
                }
                else
                    changeStory(-1, -1, R.string.T6_End);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 1) {
                    mStoryIndex = 2;
                    changeStory(R.string.T2_Ans1, R.string.T2_Ans2, R.string.T2_Story);
                }
                else if(mStoryIndex == 2)
                    changeStory(-1, -1, R.string.T4_End);
                else
                    changeStory(-1, -1, R.string.T5_End);
            }
        });
    }

    private void changeStory(int Ans1, int Ans2, int Story) {
        if(Ans1 == -1) {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            mStoryTextView.setText(Story);
        }
        else {
            mButtonTop.setText(Ans1);
            mButtonBottom.setText(Ans2);
            mStoryTextView.setText(Story);
        }
    }
}
