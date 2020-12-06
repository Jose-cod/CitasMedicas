package com.jose.citasmedicas.view.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.jose.citasmedicas.R;

import com.jose.citasmedicas.view.ui.fragments.activities.MainActivity;

public class AppointmentBookedWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for(int appWidgetId: appWidgetIds){
            Intent intent= new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_appointment);
            views.setOnClickPendingIntent(R.id.lnlWidget, pendingIntent);
            views.setOnClickPendingIntent(R.id.lnlWidget, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
