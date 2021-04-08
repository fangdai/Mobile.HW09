package com.mobile.hw09;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class ShowHeadlines extends Activity {
    ArrayList<SingleItem> newsList = new ArrayList<SingleItem>();
    ListView myListView; String urlAddress = "", urlCaption = ""; SingleItem selectedNewsItem;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
// find out which intent is calling us & grab data bundle holding selected url & caption sent to us
        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        urlAddress = myBundle.getString("urlAddress"); urlCaption = myBundle.getString("urlCaption");
// update app’s top ‘TitleBar’ (eg. ‘NPR - Business Wed April 09, 2014’)
//        this.setTitle("NPR – " + urlCaption + " \t" + MainActivity.niceDate());
        myListView = (ListView)this.findViewById(R.id.channel_list);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View v, int index, long id) {
                selectedNewsItem = newsList.get(index);
                showNiceDialogBox(selectedNewsItem, getApplicationContext());
            }});
        DownloadRssFeed downloader = new DownloadRssFeed(ShowHeadlines.this);
        downloader.execute(urlAddress, urlCaption);
    }
    public void showNiceDialogBox(SingleItem selectedStoryItem, Context context){
        String title = selectedStoryItem.getTitle();
        String description = selectedStoryItem.getDescription();
        if (title.toLowerCase().equals(description.toLowerCase())){ description = ""; }
        try {
//CAUTION: sometimes TITLE and DESCRIPTION include HTML markers
            final Uri storyLink = Uri.parse(selectedStoryItem.getLink());
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
            myBuilder.setIcon(R.drawable.logo_npr_foreground)
                    .setTitle(Html.fromHtml(urlCaption) )
                    .setMessage(title + "\n\n" + Html.fromHtml(description) + "\n")
.setPositiveButton("Close", null)
                    .setNegativeButton("More", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichOne) {
                            Intent browser = new Intent(Intent.ACTION_VIEW, storyLink);
                            startActivity(browser);
                        }}) //setNegativeButton
                    .show();
        }
        catch (Exception e) { Log.e("Error DialogBox", e.getMessage() ); }
    }//showNiceDialogBox
}//ShowHeadlines