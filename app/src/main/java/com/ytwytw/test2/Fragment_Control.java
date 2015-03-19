package com.ytwytw.test2;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Fragment_Control extends Fragment {

    public Fragment_Control() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.control, container, false);


        final LinearLayout lm = (LinearLayout) rootView.findViewById(R.id.ll_Control11);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                20

        );
        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                80

        );


        for(int j=1;j<=2;j++)
        {
            // Create LinearLayout
            LinearLayout ll = new LinearLayout(getActivity());
            ll.setOrientation(LinearLayout.HORIZONTAL);

            // Create TextView
            TextView product = new TextView(getActivity());
            product.setTextAppearance(getActivity(), R.style.TextAppearance_AppCompat_Medium);
            if (j==1) {
                product.setText(" Here is the place to control the switches");
            }
            else if (j==2) {
                product.setText(" Long press to change the channel name");
            }
            product.setPadding(15,5,15,5);
            ll.addView(product);


            final int index = j;
            // Set click listener for button

            //Add button to LinearLayout defined in XML
            lm.addView(ll);
        }

        //Create five
        for(int j=1;j<=5;j++)
        {
            // Create LinearLayout
            LinearLayout ll = new LinearLayout(getActivity());
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setWeightSum(100);
            final Context context = getActivity().getApplicationContext();
            final Context context2 = getActivity();
            // Create TextView
            final TextView product = new TextView(getActivity());
            product.setText(" Channel "+j);
            product.setId(j + 200);
            product.setTextAppearance(getActivity(), R.style.TextAppearance_AppCompat_Large);
            product.setPadding(5, 5, 5, 5);
            product.setTypeface(null, 1);
            product.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(context, "Long Click" + v.getId(), Toast.LENGTH_SHORT).show();
                    // BEGIN
                    // get prompts.xml view
                    LayoutInflater li = LayoutInflater.from(context2);
                    View promptsView = li.inflate(R.layout.popup, null);

                    AlertDialog.Builder alertDialogBuilder;
                    alertDialogBuilder = new AlertDialog.Builder(context2);

                    // set prompts.xml to alert dialog builder
                    alertDialogBuilder.setView(promptsView);

                    final EditText userInput = (EditText) promptsView
                            .findViewById(R.id.et_popup);

                    // set dialog message
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            // get user input and set it to result
                                            // edit text
                                            product.setText(" "+userInput.getText());
                                        }
                                    })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            dialog.cancel();
                                        }
                                    });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                    // END
                    return false;
                }
            });
            ll.addView(product,params2);


            // Create ToggleButton
            final ToggleButton btn = new ToggleButton(getActivity());
            // Give button an ID
            btn.setId(j+100);
            // set the layoutParams on the button
            btn.setLayoutParams(params);
            btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(context, "isChecked" + buttonView.getId(), Toast.LENGTH_SHORT).show();
                        product.setTextColor(Color.GREEN);

                    }
                    else {
                        Toast.makeText(context, "notChecked" + buttonView.getId(), Toast.LENGTH_SHORT).show();
                        product.setTextColor(Color.RED);
                    }
                }
            });


            final int index = j;
            // Set click listener for button
            // btn.setOnClickListener();

            //Add button to LinearLayout
            ll.addView(btn,params3);
            //Add button to LinearLayout defined in XML
            lm.addView(ll);
        }

        return rootView;
    }

}
