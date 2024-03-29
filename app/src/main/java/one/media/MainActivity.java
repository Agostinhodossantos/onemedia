package one.media;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import one.media.model.ImageAds;
import one.media.model.Product;
import one.media.pager.RvProduct;
import one.media.pager.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 800;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 6000; // time in milliseconds between successive task executions.
    List<ImageAds> imageAdsList = new ArrayList<>();

    private RecyclerView rv_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();
        initAds();
        initRv();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PublishActivity.class );
                startActivity(intent);
            }
        });
    }

    private void initRv() {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("123", "Cebola", "122", 20));
        productList.add(new Product("123", "Cebola", "122", 620));
        productList.add(new Product("123", "Cebola", "122", 730));

        RvProduct rvProduct = new RvProduct(this, productList);
        rv_product.setLayoutManager(new LinearLayoutManager(this));
        rv_product.setAdapter(rvProduct);
    }

    private void initUI() {
        viewPager = findViewById(R.id.vp_ads);
        rv_product = findViewById(R.id.rv_product);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void initAds() {
        imageAdsList.add(new ImageAds(R.drawable.banner_3));

        imageAdsList.add(new ImageAds(R.drawable.banner_1));
        imageAdsList.add(new ImageAds(R.drawable.banner_de_super));
        imageAdsList.add(new ImageAds(R.drawable.banner_3));

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(this , imageAdsList);
        viewPager.setAdapter(pagerAdapter);

        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);

        slider();

    }

    private void slider() {

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {

                if (viewPager.getCurrentItem() == imageAdsList.size() - 1 ) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }
}