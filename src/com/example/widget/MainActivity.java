package com.example.widget;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppWidgetProvider{

   @Override
   public void onUpdate(Context context, AppWidgetManager appWidgetManager,
   int[] appWidgetIds) {
      for(int i=0; i<appWidgetIds.length; i++){
      int currentWidgetId = appWidgetIds[i];
      String url = "http://m.flipkart.com";
      String url2 = "http://m.flipkart.com/search";
      String url3 = "http://m.flipkart.com/offers";
      
      
      Intent intent = new Intent(Intent.ACTION_VIEW);
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      intent.setData(Uri.parse(url));
      
      
      Intent intent2 = new Intent(Intent.ACTION_VIEW);
      intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      intent2.setData(Uri.parse(url2));
      
      Intent intent3 = new Intent(Intent.ACTION_VIEW);
      intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      intent3.setData(Uri.parse(url3));
      

      
      PendingIntent pending1 = PendingIntent.getActivity(context, 0,
      intent, 0);
      
      
      PendingIntent pending2 = PendingIntent.getActivity(context, 0,
    	      intent2, 0);
      
      PendingIntent pending3 = PendingIntent.getActivity(context, 0,
    	      intent3, 0);
      
      
      RemoteViews views = new RemoteViews(context.getPackageName(),
      R.layout.activity_main);
      
      
      views.setOnClickPendingIntent(R.id.flipLogo, pending1);
      views.setOnClickPendingIntent(R.id.search, pending2);
      views.setOnClickPendingIntent(R.id.item_button, pending3);
      
      
      
      appWidgetManager.updateAppWidget(currentWidgetId,views);
      
      
      Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();	
      }
   }	
}
