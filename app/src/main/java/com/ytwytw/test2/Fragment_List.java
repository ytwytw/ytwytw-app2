package com.ytwytw.test2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Fragment_List extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_expandlist, container, false);

        ExpandableListView lv = (ExpandableListView) rootView.findViewById(R.id.el_1);

        try{

            SimpleExpandableListAdapter expListAdapter =
                    new SimpleExpandableListAdapter(
                            getActivity(),
                            createGroupList(),              // Creating group List.
                            R.layout.group_row,             // Group item layout XML.
                            new String[] { "Channel" },     // the key of group item.
                            new int[] { R.id.row_name },    // ID of each group item.-Data under the key goes into this TextView.
                            createChildList(),              // childData describes second-level entries.
                            R.layout.child_row,             // Layout for sub-level entries(second level).
                            new String[] {"Sub Item"},      // Keys in childData maps to display.
                            new int[] { R.id.grp_child}     // Data under the keys above go into these TextViews.
                    );
            lv.setAdapter( expListAdapter );       // setting the adapter in the list.

        }catch(Exception e){
            System.out.println("Errrr +++ " + e.getMessage());
        }

        return rootView;

    }



    /* Creating the Hashmap for the row */
    @SuppressWarnings("unchecked")
    private List createGroupList() {
        ArrayList result = new ArrayList();
        for( int i = 0 ; i < 5 ; ++i ) { // 15 groups........
            HashMap m = new HashMap();
            m.put( "Channel","  Channel " + (i+1) ); // the key and it's value.
            result.add( m );
        }
        return (List)result;
    }

    /* Creating the HashMap for the children */
    @SuppressWarnings("unchecked")
    private List createChildList() {

        ArrayList result = new ArrayList();
        for( int i = 0 ; i < 5 ; ++i ) { // this -15 is the number of groups(Here it's fifteen)
          /* each group need each HashMap-Here for each group we have 3 subgroups */
            ArrayList secList = new ArrayList();

            for( int n = 0 ; n < 6 ; n++ ) {
                HashMap child = new HashMap();
                Random random = new Random();
                int rv = random.nextInt(125)%(125-100+1) + 100;
                int rc = random.nextInt(30)%(30-1+1) + 1;
                int p = rv * rc;

                switch (n) {
                    case 0:
                        child.put( "Sub Item", "        Voltage(V):          "+rv);
                        break;
                    case 1:
                        child.put( "Sub Item", "        Current(A):          "+rc);
                        break;
                    case 2:
                        child.put( "Sub Item", "        Power(W):           "+p);
                        break;
                    case 3:
                        child.put( "Sub Item", "        Frequency(HZ):   60");
                        break;
                    case 4:
                        child.put( "Sub Item", "        Duty Cycle:          50");
                        break;
                    case 5:
                        child.put( "Sub Item", "        Status:                 ON");
                        break;

                }


                secList.add( child );
            }



            result.add( secList );
        }
        return result;
    }


    public void  onContentChanged  () {
        System.out.println("onContentChanged");
        super.getActivity().onContentChanged();
    }

    /* This function is called on each child click */
    public boolean onChildClick( ExpandableListView parent, View v, int groupPosition,int childPosition,long id) {
        System.out.println("Inside onChildClick at groupPosition = " + groupPosition +" Child clicked at position " + childPosition);
        return true;
    }


    /* This function is called on expansion of the group */
    public void  onGroupExpand  (int groupPosition) {
        try{
            System.out.println("Group exapanding Listener => groupPosition = " + groupPosition);
        }catch(Exception e){
            System.out.println(" groupPosition Errrr +++ " + e.getMessage());
        }
    }



}
