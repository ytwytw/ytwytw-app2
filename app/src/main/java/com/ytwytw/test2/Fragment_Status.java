package com.ytwytw.test2;

import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidplot.pie.PieChart;
import com.androidplot.pie.PieRenderer;
import com.androidplot.pie.Segment;
import com.androidplot.pie.SegmentFormatter;

/**
 * Created by ytwytw on 3/13/15.
 */
public class Fragment_Status extends Fragment {

    public Fragment_Status() {
    }

    public PieChart pie;
    public Segment s1;
    public Segment s2;
    public Segment s3;
    public Segment s4;
    public Segment s5;

    public TextView tv1; int tvA = 0;
    public TextView tv2; int tvB = 0;
    public TextView tv3; int tvC = 0;
    public TextView tv4; int tvD = 0;
    public TextView tv5; int tvE = 0;

    public TextView ch1;
    public TextView ch2;
    public TextView ch3;
    public TextView ch4;
    public TextView ch5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_status, container, false);

//
        // initialize our XYPlot reference:
        pie = (PieChart) rootView.findViewById(R.id.mySimplePieChart);

        // detect segment clicks:
        pie.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                PointF click = new PointF(motionEvent.getX(), motionEvent.getY());
                if(pie.getPieWidget().containsPoint(click)) {
                    Segment segment = pie.getRenderer(PieRenderer.class).getContainingSegment(click);
                    if(segment != null) {
                        // handle the segment click...for now, just print
                        // the clicked segment's title to the console:
                        System.out.println("Clicked Segment: " + segment.getTitle());
                        if (segment.getTitle().equalsIgnoreCase("CH 1")) {
                            Toast.makeText(getActivity(), "Channel 1 used 20kWh Power" , Toast.LENGTH_SHORT).show();
                        }
                        if (segment.getTitle().equalsIgnoreCase("CH 2")) {
                            Toast.makeText(getActivity(), "Channel 2 used 25kWh Power" , Toast.LENGTH_SHORT).show();
                        }
                        if (segment.getTitle().equalsIgnoreCase("CH 3")) {
                            Toast.makeText(getActivity(), "Channel 3 used 30kWh Power" , Toast.LENGTH_SHORT).show();
                        }
                        if (segment.getTitle().equalsIgnoreCase("CH 4")) {
                            Toast.makeText(getActivity(), "Channel 4 used 40kWh Power" , Toast.LENGTH_SHORT).show();
                        }
                        if (segment.getTitle().equalsIgnoreCase("CH 5")) {
                            Toast.makeText(getActivity(), "Channel 5 used 45kWh Power" , Toast.LENGTH_SHORT).show();
                        }

                    }
                }
                return false;
            }
        });




        s1 = new Segment("CH 1", 20);
        s2 = new Segment("CH 2", 25);
        s3 = new Segment("CH 3", 30);
        s4 = new Segment("CH 4", 40);
        s5 = new Segment("CH 5", 45);


        EmbossMaskFilter emf = new EmbossMaskFilter(
                new float[]{1, 1, 1}, 0.4f, 10, 8.2f);

        SegmentFormatter sf1 = new SegmentFormatter();
        sf1.configure(getActivity().getApplicationContext(), R.xml.pie_segment_formatter1);

        sf1.getFillPaint().setMaskFilter(emf);

        SegmentFormatter sf2 = new SegmentFormatter();
        sf2.configure(getActivity().getApplicationContext(), R.xml.pie_segment_formatter2);

        sf2.getFillPaint().setMaskFilter(emf);

        SegmentFormatter sf3 = new SegmentFormatter();
        sf3.configure(getActivity().getApplicationContext(), R.xml.pie_segment_formatter3);

        sf3.getFillPaint().setMaskFilter(emf);

        SegmentFormatter sf4 = new SegmentFormatter();
        sf4.configure(getActivity().getApplicationContext(), R.xml.pie_segment_formatter4);

        sf4.getFillPaint().setMaskFilter(emf);

        SegmentFormatter sf5 = new SegmentFormatter();
        sf5.configure(getActivity().getApplicationContext(), R.xml.pie_segment_formatter5);

        sf5.getFillPaint().setMaskFilter(emf);

        pie.addSeries(s1, sf1);
        pie.addSeries(s2, sf2);
        pie.addSeries(s3, sf3);
        pie.addSeries(s4, sf4);
        pie.addSeries(s5, sf5);

        pie.getBorderPaint().setColor(Color.TRANSPARENT);
        pie.getBackgroundPaint().setColor(Color.TRANSPARENT);

        pie.getRenderer(PieRenderer.class).setDonutSize(0.00f,PieRenderer.DonutMode.PERCENT);
        pie.redraw();


//


        ch1 = (TextView) rootView.findViewById(R.id.tv_ch1);
        ch1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                NotificationManager notificationManager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

                Intent intent = new Intent();

                //use the flag FLAG_UPDATE_CURRENT to override any notification already there
                PendingIntent contentIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new Notification(R.drawable.ic_launcher, "Something happens to your home!", System.currentTimeMillis());
                notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND;

                notification.setLatestEventInfo(getActivity(), "Alert from your home", "Channel 1 is shut off due to " +
                        "Short Circuit", contentIntent);
                //10 is a random number I chose to act as the id for this notification
                notificationManager.notify(10, notification);
                tv1.setText("Warning!");
                tv1.setTextColor(Color.YELLOW);
                return true;
            }
        });

        ch2 = (TextView) rootView.findViewById(R.id.tv_ch2);
        ch2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                NotificationManager notificationManager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

                Intent intent = new Intent();

                //use the flag FLAG_UPDATE_CURRENT to override any notification already there
                PendingIntent contentIntent = PendingIntent.getActivity(getActivity(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification notification = new Notification(R.drawable.ic_launcher, "Something happens to your home!", System.currentTimeMillis());
                notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND;

                notification.setLatestEventInfo(getActivity(), "Alert from your home", "Channel 2 is shut off due to " +
                        "Overload", contentIntent);
                //10 is a random number I chose to act as the id for this notification
                notificationManager.notify(10, notification);
                tv2.setText("Warning!");
                tv2.setTextColor(Color.YELLOW);
                return true;
            }
        });



//


        tv1 = (TextView) rootView.findViewById(R.id.tv_ch1_status);
        tv2 = (TextView) rootView.findViewById(R.id.tv_ch2_status);
        tv3 = (TextView) rootView.findViewById(R.id.tv_ch3_status);
        tv4 = (TextView) rootView.findViewById(R.id.tv_ch4_status);
        tv5 = (TextView) rootView.findViewById(R.id.tv_ch5_status);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvA++;
                switch (tvA) {
                    case 0:
                        tv1.setText("Power ON");
                        tv1.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        tv1.setText("Power OFF");
                        tv1.setTextColor(Color.GRAY);
                        break;
                    case 2:
                        tv1.setText("Error");
                        tv1.setTextColor(Color.RED);
                        break;
                    case 3:
                        tv1.setText("Warning!");
                        tv1.setTextColor(Color.YELLOW);
                        break;
                    case 4:
                        tv1.setText("Offline");
                        tv1.setTextColor(Color.BLACK);
                        tvA=-1;
                        break;

                    default:
                        tvA = 0;
                        break;
                }
            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvB++;
                switch (tvB) {
                    case 0:
                        tv2.setText("Power ON");
                        tv2.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        tv2.setText("Power OFF");
                        tv2.setTextColor(Color.GRAY);
                        break;
                    case 2:
                        tv2.setText("Error");
                        tv2.setTextColor(Color.RED);
                        break;
                    case 3:
                        tv2.setText("Warning!");
                        tv2.setTextColor(Color.YELLOW);
                        break;
                    case 4:
                        tv2.setText("Offline");
                        tv2.setTextColor(Color.BLACK);
                        tvB=-1;
                        break;

                    default:
                        tvB = 0;
                        break;
                }
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvC++;
                switch (tvC) {
                    case 0:
                        tv3.setText("Power ON");
                        tv3.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        tv3.setText("Power OFF");
                        tv3.setTextColor(Color.GRAY);
                        break;
                    case 2:
                        tv3.setText("Error");
                        tv3.setTextColor(Color.RED);
                        break;
                    case 3:
                        tv3.setText("Warning!");
                        tv3.setTextColor(Color.YELLOW);
                        break;
                    case 4:
                        tv3.setText("Offline");
                        tv3.setTextColor(Color.BLACK);
                        tvC=-1;
                        break;

                    default:
                        tvC = 0;
                        break;
                }
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvD++;
                switch (tvD) {
                    case 0:
                        tv4.setText("Power ON");
                        tv4.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        tv4.setText("Power OFF");
                        tv4.setTextColor(Color.GRAY);
                        break;
                    case 2:
                        tv4.setText("Error");
                        tv4.setTextColor(Color.RED);
                        break;
                    case 3:
                        tv4.setText("Warning!");
                        tv4.setTextColor(Color.YELLOW);
                        break;
                    case 4:
                        tv4.setText("Offline");
                        tv4.setTextColor(Color.BLACK);
                        tvD=-1;
                        break;

                    default:
                        tvD = 0;
                        break;
                }
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvE++;
                switch (tvE) {
                    case 0:
                        tv5.setText("Power ON");
                        tv5.setTextColor(Color.GREEN);
                        break;
                    case 1:
                        tv5.setText("Power OFF");
                        tv5.setTextColor(Color.GRAY);
                        break;
                    case 2:
                        tv5.setText("Error");
                        tv5.setTextColor(Color.RED);
                        break;
                    case 3:
                        tv5.setText("Warning!");
                        tv5.setTextColor(Color.YELLOW);
                        break;
                    case 4:
                        tv5.setText("Offline");
                        tv5.setTextColor(Color.BLACK);
                        tvE=-1;
                        break;

                    default:
                        tvE = 0;
                        break;
                }
            }
        });


//



        return rootView;



    }
}
