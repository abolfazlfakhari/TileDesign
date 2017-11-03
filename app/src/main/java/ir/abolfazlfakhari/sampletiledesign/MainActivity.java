package ir.abolfazlfakhari.sampletiledesign;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.abolfazlfakhari.sampletiledesign.QuiltView.QuiltView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuiltView quiltView = (QuiltView) findViewById(R.id.quilt_view);
        quiltView.addPatchView(view_one(), 2, 2);
        quiltView.addPatchView(view_two(), 1, 1);
        quiltView.addPatchView(view_three(), 1, 1);
        quiltView.addPatchView(view_four(), 3, 2);
        quiltView.addPatchView(view_five(), 2, 2);
        quiltView.addPatchView(view_six(), 1, 2);
        quiltView.setChildPadding(2);
    }

    public View view_one() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_one, null, false);
        TextView txt_tile = (TextView) view.findViewById(R.id.txt_tile);
        ImageView img_tile = (ImageView) view.findViewById(R.id.img_tile);
        LinearLayout linear_tile = (LinearLayout) view.findViewById(R.id.linear_tile);
        txt_tile.setText(R.string.tile_one);
        linear_tile.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.orange_color, null));
        img_tile.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.happy, null));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.tile_one, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    public View view_two() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_two, null, false);
        TextView txt_view_two = (TextView) view.findViewById(R.id.txt_view_two);
        LinearLayout linear_view_two = (LinearLayout) view.findViewById(R.id.linear_view_two);
        ImageView img_view_two = (ImageView) view.findViewById(R.id.img_view_two);
        txt_view_two.setText(R.string.tile_two);
        linear_view_two.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.green_dark_color, null));
        img_view_two.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.nerd, null));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.tile_two, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    public View view_three() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_two, null, false);
        TextView txt_type_two = (TextView) view.findViewById(R.id.txt_view_two);
        ImageView img_view_two = (ImageView) view.findViewById(R.id.img_view_two);
        LinearLayout linear_view_two = (LinearLayout) view.findViewById(R.id.linear_view_two);
        txt_type_two.setText(R.string.tile_three);
        linear_view_two.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.blue_color, null));
        img_view_two.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.in_love, null));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.tile_three, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    public View view_four() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_one, null, false);
        TextView txt_tile = (TextView) view.findViewById(R.id.txt_tile);
        ImageView img_tile = (ImageView) view.findViewById(R.id.img_tile);
        LinearLayout linear_tile = (LinearLayout) view.findViewById(R.id.linear_tile);
        txt_tile.setText(R.string.tile_four);
        linear_tile.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.red_color, null));
        img_tile.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.happy_one, null));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.tile_four, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    public View view_five() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_one, null, false);
        TextView txt_tile = (TextView) view.findViewById(R.id.txt_tile);
        ImageView img_tile = (ImageView) view.findViewById(R.id.img_tile);
        LinearLayout linear_tile = (LinearLayout) view.findViewById(R.id.linear_tile);
        txt_tile.setText(R.string.tile_five);
        linear_tile.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.brown_color, null));
        img_tile.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.smart, null));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.tile_five, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    public View view_six() {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.view_one, null, false);
        TextView txt_tile = (TextView) view.findViewById(R.id.txt_tile);
        ImageView img_tile = (ImageView) view.findViewById(R.id.img_tile);
        LinearLayout linear_tile = (LinearLayout) view.findViewById(R.id.linear_tile);
        txt_tile.setText(R.string.tile_six);
        linear_tile.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.yellow_color, null));
        img_tile.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ninja, null));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.tile_six, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.author_action:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                View view_alert=LayoutInflater.from(this).inflate(R.layout.author_dialog,null,false);
                builder.setView(view_alert);
                TextView txt_site_me=(TextView)view_alert.findViewById(R.id.txt_site_me);
                TextView txt_github_me=(TextView)view_alert.findViewById(R.id.txt_github_me);
                Linkify.addLinks(txt_site_me,Linkify.WEB_URLS);
                Linkify.addLinks(txt_github_me,Linkify.WEB_URLS);

                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
