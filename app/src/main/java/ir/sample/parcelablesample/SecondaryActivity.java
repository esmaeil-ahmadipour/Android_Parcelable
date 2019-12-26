package ir.sample.parcelablesample;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import ir.sample.parcelablesample.entities.UserEntity;

public class SecondaryActivity extends AppCompatActivity {
    private TextView txtViewer;
    private String extractedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        setupViews();
        extractDataPackage();
        viewExtractedData();
    }

    private void setupViews() {
        txtViewer = (TextView) findViewById(R.id.txt_secondary_viewer);
    }

    private void extractDataPackage() {
        //ArrayList Bundle Receiver type is Parcelable & Filling By Received Data ;
        ArrayList<Parcelable> arrayListBundle = new ArrayList<Parcelable>();
        arrayListBundle = getIntent().getParcelableArrayListExtra("usersList");

        UserEntity userEntity;
        StringBuilder builder = new StringBuilder();

        for (Parcelable bundle : arrayListBundle) {

            //Tracking Data by UserEntity Object ;
            userEntity = (UserEntity) bundle;
            //Set StringBuilder Object ;
            builder.append(userEntity.getId() + " : " + userEntity.getUsername() + " / " + userEntity.getEmailAddress() + " / " + userEntity.getPhoneNumber() + " / " + userEntity.getJobTitle() + "\n\n");
        }
        extractedData = builder.toString();
    }

    private void viewExtractedData() {
        //Set StringBuilder Object To TextView ;
        txtViewer.setText(extractedData);
    }


}
