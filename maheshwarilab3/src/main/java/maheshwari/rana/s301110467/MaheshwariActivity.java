package maheshwari.rana.s301110467;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import maheshwari.rana.s301110467.fragments.MaheshwariFragment;
import maheshwari.rana.s301110467.fragments.RanaFragment;
import maheshwari.rana.s301110467.fragments.S301110467Fragment;

/**
 * Name: Maheshwari Rana
 * Student ID: 301110467
 * Section: 002
 */

public class MaheshwariActivity extends AppCompatActivity {
    // widgets
    private BottomNavigationView maheshwariBottomNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maheshwari);

        maheshwariBottomNavBar = findViewById(R.id.maheshwariBottomNavBar);
        maheshwariBottomNavBar.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.maheshwariFrame,
                new MaheshwariFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.exit);
        builder.setIcon(R.drawable.ic_alert);
        builder.setMessage(R.string.sure);
        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
               MaheshwariActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton(R.string.decline, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.maheshwariItem1:
                            selectedFragment = new MaheshwariFragment();
                            break;

                        case R.id.maheshwariItem2:
                            selectedFragment = new RanaFragment();
                            break;

                        case R.id.maheshwariItem3:
                            selectedFragment = new S301110467Fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.maheshwariFrame,
                            selectedFragment).commit();
                    return true;
                }
            };
}