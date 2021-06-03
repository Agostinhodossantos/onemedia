package one.media;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import one.media.utils.Extenso;

public class PublishActivity extends AppCompatActivity {

    private Button btnPublish;
    private EditText edName, edPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       initUI();

       btnPublish.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference("message");

               myRef.setValue("Hello, World!");

               checkFields();
           }
       });
    }

    private void checkFields() {
        String name = edName.getText().toString().trim();
        String strPrice = edPrice.getText().toString();
        long price = 0;

        if (TextUtils.isEmpty(name)) {
            edName.requestFocus();
            edName.setHintTextColor(Color.RED);
        } else if(TextUtils.isEmpty(strPrice)) {
            edPrice.requestFocus();
            edPrice.setHintTextColor(Color.RED);
        } else {
            price = Long.parseLong(strPrice);

            publish(price, name);
        }
    }

    private void publish(long price, String name) {
        Toast.makeText(this, new Extenso(price).toString(), Toast.LENGTH_SHORT).show();
    }

    private void initUI() {
        btnPublish = (Button) findViewById(R.id.btn_publish);
        edName = (EditText) findViewById(R.id.tv_product_name);
        edPrice = (EditText) findViewById(R.id.tv_product_price);
    }
}