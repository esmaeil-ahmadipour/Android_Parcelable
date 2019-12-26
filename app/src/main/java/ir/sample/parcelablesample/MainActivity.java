package ir.sample.parcelablesample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import ir.sample.parcelablesample.entities.UserEntity;

public class MainActivity extends AppCompatActivity {
    ArrayList<UserEntity> usersList;
    Button btnIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        sendingDataPackage();
        initializeArrayList();
    }

    private void initializeArrayList() {

        UserEntity userSEO = new UserEntity();
        userSEO.setId(1);
        userSEO.setUsername("Ali");
        userSEO.setEmailAddress("Ali@gmail.com");
        userSEO.setPhoneNumber("+98-987-654-3210");
        userSEO.setJobTitle("SEO Manager");

        UserEntity userBusiness = new UserEntity();
        userBusiness.setId(2);
        userBusiness.setUsername("John");
        userBusiness.setEmailAddress("John@gmail.com");
        userBusiness.setPhoneNumber("+71-987-654-3210");
        userBusiness.setJobTitle("Business Manager");

        UserEntity userProduct = new UserEntity();
        userProduct.setId(3);
        userProduct.setUsername("Jaime");
        userProduct.setEmailAddress("Jaime@gmail.com");
        userProduct.setPhoneNumber("+31-987-654-3210");
        userProduct.setJobTitle("Product Manager");

        usersList = new ArrayList<UserEntity>();
        usersList.add(userSEO);
        usersList.add(userBusiness);
        usersList.add(userProduct);
    }

    private void sendingDataPackage() {
        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Send ArrayList To Another Activity
                Bundle bundleSender=new Bundle();
                bundleSender.putParcelableArrayList("usersList", usersList);
                Intent intent = new Intent(MainActivity.this , SecondaryActivity.class);
                intent.putExtras(bundleSender);
                startActivity(intent);
            }
        });
    }

    private void setupViews() {
        btnIntent = (Button) findViewById(R.id.btn_main_intent);

    }
}
