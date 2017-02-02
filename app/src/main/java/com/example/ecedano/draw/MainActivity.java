package com.example.ecedano.draw;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.suyati.telvin.drawingboard.DrawingBoard;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bmb) BoomMenuButton bmb;
    @BindView(R.id.drawinboard) DrawingBoard db;
    private int[] arrayColors= new int[] {
            R.color.colorAccent,
            R.color.colorBlack,
            R.color.colorBlue,
            R.color.colorGreen,
            R.color.colorPurple,
            R.color.colorRed,
            R.color.colorPrimaryDark,
            R.color.colorPrimary,
            R.color.colorGray};
    private int count = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {

            count = i;
            TextInsideCircleButton.Builder builder = new TextInsideCircleButton.Builder()
                    .normalColor(arrayColors[i])
                    .listener(new OnBMClickListener() {
                        @Override
                        public void onBoomButtonClick(int index) {
                           db.setPenColor(arrayColors[index]);
                           // db.setPenColor(Color.rgb(rcolor));
                        }
                    })
                    .normalText("");
            bmb.addBuilder(builder);
        }
    }
}
